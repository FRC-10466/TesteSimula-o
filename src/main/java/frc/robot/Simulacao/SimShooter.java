package frc.robot.Simulacao;

import com.revrobotics.sim.SparkMaxSim;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;

import frc.robot.Hardwares.HardwaresShooter;

public class SimShooter {
    private static final DCMotor Motores = DCMotor.getNEO(2);

    private static final double InerciaKgM2 = 0.004;
    private static final double Reducao = 1.0;

    private final SparkMaxSim arlindoSim;
    private final FlywheelSim volante;

    public SimShooter(HardwaresShooter io){
        arlindoSim = new SparkMaxSim(io.arlindo, Motores);
        volante = new FlywheelSim(LinearSystemId.createFlywheelSystem(Motores, InerciaKgM2, Reducao), Motores);
    }

    public void atualizar(){
        double bateria = RobotController.getBatteryVoltage();

        volante.setInputVoltage(arlindoSim.getAppliedOutput() * bateria);

        volante.update(0.02);

        double rpmMotor = volante.getAngularVelocityRPM() * Reducao;
        arlindoSim.iterate(rpmMotor, bateria, 0.02);
    }

    



}