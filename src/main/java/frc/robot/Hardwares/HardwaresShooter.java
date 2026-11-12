package frc.robot.Hardwares;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.*;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import frc.robot.Constantes.ConstantesShooter;

@SuppressWarnings("unused")
public class HardwaresShooter {

    public final SparkMax arlindo;

    public final RelativeEncoder arlindoEncoder;

    public final SparkClosedLoopController arlindopid;

    public final SparkMax arlindoFollower;

    @SuppressWarnings("removal" )
    public HardwaresShooter() {

        arlindo = new SparkMax(
            ConstantesShooter.Shooter.ShooterArlindo,
            SparkLowLevel.MotorType.kBrushless
        );

        arlindoFollower = new SparkMax(
            ConstantesShooter.Shooter.ShooterArlindoFollower,
            SparkLowLevel.MotorType.kBrushless);

        arlindoEncoder = arlindo.getEncoder();

        arlindopid = arlindo.getClosedLoopController();

        SparkMaxConfig cfg = new SparkMaxConfig();
        cfg.idleMode(IdleMode.kCoast)
           .smartCurrentLimit(45)
           .inverted(true);
        cfg.encoder
           .velocityConversionFactor(1.0 )
           .positionConversionFactor(1.0 );

        cfg.closedLoop
        .p(0.000385) //anterior 450, proximo 350
        .i(0.0)
        .d(0.00001)
        .iZone(ConstantesShooter.PID_IZONE_RPM)
        .outputRange(-1.0, 1.0);
        cfg.closedLoopRampRate(0.0);

        SparkMaxConfig followercfg = new SparkMaxConfig();

        followercfg.idleMode(IdleMode.kCoast)
                   .follow(arlindo, true)
                   .smartCurrentLimit(45);

        arlindo.configure(cfg,
            SparkBase.ResetMode.kNoResetSafeParameters,
            SparkBase.PersistMode.kNoPersistParameters
        );

        arlindoFollower.configure(followercfg,
            SparkBase.ResetMode.kNoResetSafeParameters,
            SparkBase.PersistMode.kNoPersistParameters
        );
    }
}
