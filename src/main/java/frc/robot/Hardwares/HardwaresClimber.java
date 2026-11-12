package frc.robot.Hardwares;

import com.revrobotics.RelativeEncoder;
//import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkClosedLoopController;
//import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import frc.robot.Constantes.ConstantesClimber;

@SuppressWarnings ("unused")
public class HardwaresClimber {

    public final SparkMax motor;
    public final RelativeEncoder encoder;
    public final SparkClosedLoopController pid;

    @SuppressWarnings("removal")
    public HardwaresClimber() {

        motor = new SparkMax(
            ConstantesClimber.ClimberConstants.ClimberMotor,
            MotorType.kBrushless
        );

        @SuppressWarnings("resource")
        SparkMax follower = new SparkMax(
            ConstantesClimber.ClimberConstants.ClimberMotor2,
            MotorType.kBrushless
        );

        encoder = motor.getEncoder();
        pid = motor.getClosedLoopController();

        SparkMaxConfig masterCfg = new SparkMaxConfig();
        masterCfg
            .idleMode(IdleMode.kBrake)
            .smartCurrentLimit(40);

        masterCfg.closedLoop
            .p(0.4)
            .i(0.0)
            .d(0.02)
            .outputRange(-1.0, 1.0);

        SparkMaxConfig followerCfg = new SparkMaxConfig();
        followerCfg
            .follow(motor, false)
            .idleMode(IdleMode.kBrake)
            .smartCurrentLimit(40);

        motor.configure(
            masterCfg,
            ResetMode.kNoResetSafeParameters,
            PersistMode.kNoPersistParameters
        );

        follower.configure(
            followerCfg,
            ResetMode.kNoResetSafeParameters,
            PersistMode.kNoPersistParameters
        );
    }
}
