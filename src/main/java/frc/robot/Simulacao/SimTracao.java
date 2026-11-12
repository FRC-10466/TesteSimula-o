package frc.robot.Simulacao;

import com.ctre.phoenix6.hardware.Pigeon2;
import com.ctre.phoenix6.sim.Pigeon2SimState;
import com.revrobotics.sim.SparkMaxSim;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.StructPublisher;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotGearing;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotMotor;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotWheelSize;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Hardwares.HardwaresTraction;

public class SimTracao {

    
    private static final double REDUCAO = 10.71;
    private static final double METROS_POR_VOLTA = Math.PI * 0.1524; 

    
    private static final double FRENTE = -1.0;

    private final SparkMaxSim esquerdoSim;
    private final SparkMaxSim direitoSim;
    private final Pigeon2SimState pigeonSim;
    private final DifferentialDrivetrainSim chassi;
    private final Field2d campo = new Field2d();
    private static final double FATOR_GIRO = 0.4;
    private final StructPublisher<Pose2d> posePub = NetworkTableInstance.getDefault().getStructTopic("Simulacao/PoseReal", Pose2d.struct).publish();
    private final ArenaFisica arena = new ArenaFisica();

    public SimTracao(HardwaresTraction io, Pigeon2 pigeon) {
     
        esquerdoSim = new SparkMaxSim(io.leftMotorFront, DCMotor.getCIM(2));
        direitoSim  = new SparkMaxSim(io.rightMotorFront, DCMotor.getCIM(2));
        pigeonSim   = pigeon.getSimState();
        chassi = DifferentialDrivetrainSim.createKitbotSim(
            KitbotMotor.kDualCIMPerSide,
            KitbotGearing.k10p71,
            KitbotWheelSize.kSixInch,
            null 
        );
        chassi.setPose(new Pose2d(3.0, 4.0, new Rotation2d())); 
        SmartDashboard.putData("Campo Simulado", campo);
    }

    public void atualizar() {
        double bateria = RobotController.getBatteryVoltage();

        
        double voltsEsquerda =  FRENTE * esquerdoSim.getAppliedOutput() * bateria;
        double voltsDireita  = -FRENTE * direitoSim.getAppliedOutput()  * bateria; 
        double media = (voltsEsquerda + voltsDireita) / 2.0;
        double giro  = (voltsDireita - voltsEsquerda) / 2.0;
        chassi.setInputs(media - FATOR_GIRO * giro, media + FATOR_GIRO * giro);

        
        chassi.update(0.02);
        Pose2d desejada = chassi.getPose();
        Pose2d permitida = arena.corrigir(desejada);
        if (!permitida.equals(desejada)) {
            chassi.setPose(permitida); 
        }

        
        double rpmEsquerda =  FRENTE * paraRpmMotor(chassi.getLeftVelocityMetersPerSecond());
        double rpmDireita  = -FRENTE * paraRpmMotor(chassi.getRightVelocityMetersPerSecond());
        esquerdoSim.iterate(rpmEsquerda, bateria, 0.02);
        direitoSim.iterate(rpmDireita, bateria, 0.02);

        
        pigeonSim.setSupplyVoltage(bateria);
        pigeonSim.setRawYaw(chassi.getHeading().getDegrees());

        
        campo.setRobotPose(chassi.getPose());
        posePub.set(chassi.getPose());
    }

    private double paraRpmMotor(double metrosPorSegundo) {
        double voltasDaRodaPorSegundo = metrosPorSegundo / METROS_POR_VOLTA;
        return voltasDaRodaPorSegundo * REDUCAO * 60.0;
    }
}