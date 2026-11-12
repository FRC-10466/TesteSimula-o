package frc.robot.Hardwares;

import frc.robot.Constantes.ConstantesIntakeFloor;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

@SuppressWarnings ("removal")
public class HardwaresIntake {

    
    public final SparkMax IntakeMotor;
    public final SparkMax PivotMotor;

    public final SparkClosedLoopController pid;
    public final RelativeEncoder encoder_pivot;

    public HardwaresIntake() {
        IntakeMotor = new SparkMax(
            ConstantesIntakeFloor.IntakeFloorMotor.IntakeMotor,
            MotorType.kBrushless
        );
        PivotMotor = new SparkMax(
            ConstantesIntakeFloor.PivotMotor.PivotMotor,
            MotorType.kBrushless
        );
        encoder_pivot = PivotMotor.getEncoder();
        pid = PivotMotor.getClosedLoopController();

        SparkMaxConfig config = new SparkMaxConfig();

        config.idleMode(IdleMode.kBrake);

        config.smartCurrentLimit(60);


        SparkMaxConfig cfg = new SparkMaxConfig();
        cfg.idleMode(IdleMode.kBrake)
           .smartCurrentLimit(55)
           .inverted(false);
        cfg.closedLoop
        .p(0.4)
        .i(0.0)
        .d(0.10);

        SparkMaxConfig cfgPivot = new SparkMaxConfig();
         cfgPivot.idleMode(IdleMode.kBrake)
           .smartCurrentLimit(45)
           .inverted(false);
        cfgPivot.closedLoop
        .p(0.4)
        .i(0.0)
        .d(0.10);       
        
        IntakeMotor.configure(
            cfg,
            ResetMode.kNoResetSafeParameters,
            PersistMode.kNoPersistParameters
        ); 
        PivotMotor.configure(
            cfgPivot,
            ResetMode.kNoResetSafeParameters,
            PersistMode.kNoPersistParameters);
    } 
}