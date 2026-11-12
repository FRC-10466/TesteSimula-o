package frc.robot.Hardwares;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import frc.robot.Constantes.ConstantesAngulador;

@SuppressWarnings ("unused")
public class HardwaresAngulador {

    public final SparkMax motor;
    public final  RelativeEncoder encoder;
    public final SparkClosedLoopController pid;

    @SuppressWarnings("removal")
    public HardwaresAngulador(){
        motor = new SparkMax(
            ConstantesAngulador.Alinhador.AlinhadorMotor,
            SparkLowLevel.MotorType.kBrushless
        );

        encoder = motor.getEncoder();
        pid = motor.getClosedLoopController();

        SparkMaxConfig cfg = new SparkMaxConfig();
        cfg.idleMode(IdleMode.kBrake)
           .smartCurrentLimit(20);

        cfg.closedLoop.p(0.8).i(0.0).d(0.02);

        motor.configure(
            cfg,
            SparkBase.ResetMode.kNoResetSafeParameters,
            SparkBase.PersistMode.kPersistParameters
        );
    }
}
