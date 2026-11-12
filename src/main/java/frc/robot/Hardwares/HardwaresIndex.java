package frc.robot.Hardwares;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import frc.robot.Constantes.ConstantesIndex;

@SuppressWarnings("removal" )
public class HardwaresIndex {

    public final SparkMax boquinha;
    public final SparkMax index;

    public HardwaresIndex() {

        boquinha = new SparkMax(
            ConstantesIndex.Index.ShooterBoquinha,
            SparkLowLevel.MotorType.kBrushless
        );

        index = new SparkMax(
            ConstantesIndex.Index.IndexMotor,
            SparkLowLevel.MotorType.kBrushless
        );

        SparkMaxConfig cfgBoquinha = new SparkMaxConfig();
        cfgBoquinha
            .idleMode(IdleMode.kBrake)
            .smartCurrentLimit(40)
            .inverted(false);

        boquinha.configure(
            cfgBoquinha,
            SparkBase.ResetMode.kNoResetSafeParameters,
            SparkBase.PersistMode.kNoPersistParameters
        );

        SparkMaxConfig cfgIndex = new SparkMaxConfig();
        cfgIndex
            .idleMode(IdleMode.kBrake)
            .smartCurrentLimit(40)
            .inverted(false);

        index.configure(
            cfgIndex,
            SparkBase.ResetMode.kNoResetSafeParameters,
            SparkBase.PersistMode.kNoPersistParameters
        );
    }
}