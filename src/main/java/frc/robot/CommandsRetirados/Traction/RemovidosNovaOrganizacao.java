package frc.robot.CommandsRetirados.Traction;

public class RemovidosNovaOrganizacao {
    /* 
// Imports da REV (Spark MAX)
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Constants;
     */
 // Motores
   /* private SparkMax rightMotorFront =
            new SparkMax(Constants.TractionConstants.rightFrontMotorID, MotorType.kBrushed);

    private SparkMax rightMotorBack =
            new SparkMax(Constants.TractionConstants.rightBackMotorID, MotorType.kBrushed);

    private SparkMax leftMotorFront =
            new SparkMax(Constants.TractionConstants.leftFrontMotorID, MotorType.kBrushed);

    private SparkMax leftMotorBack =
            new SparkMax(Constants.TractionConstants.leftBackMotorID, MotorType.kBrushed); 

    // Encoders do Spark
    private RelativeEncoder leftEncoder;
    private RelativeEncoder rightEncoder;

    // Gyro
    private final Pigeon2 pigeon = new Pigeon2(22); // id 22 can

    // Configurações
    private SparkMaxConfig configSparkMotorEsquerda = new SparkMaxConfig();
    private SparkMaxConfig configSparkMotorDireita = new SparkMaxConfig();

    // Grupos de motores
    @SuppressWarnings("removal")
    private MotorControllerGroup leftMotorControllerGroup =
            new MotorControllerGroup(leftMotorFront, leftMotorBack);

    @SuppressWarnings("removal")
    private MotorControllerGroup rightMotorControllerGroup =
            new MotorControllerGroup(rightMotorFront, rightMotorBack);*/
    
    
    // CONSTRUTOR
   /* public Traction() {

        pigeon.reset();

        // Configuração motores da direita
        configSparkMotorDireita
                .idleMode(IdleMode.kBrake)
                .smartCurrentLimit(60);

        rightMotorFront.configure(
                configSparkMotorDireita,
                ResetMode.kResetSafeParameters,
                PersistMode.kPersistParameters);

        rightMotorBack.configure(
                configSparkMotorDireita,
                ResetMode.kResetSafeParameters,
                PersistMode.kPersistParameters);

        // Configuração motores da esquerda
        configSparkMotorEsquerda
                .idleMode(IdleMode.kBrake)
                .smartCurrentLimit(60);

        leftMotorFront.configure(
                configSparkMotorEsquerda,
                ResetMode.kResetSafeParameters,
                PersistMode.kPersistParameters);

        leftMotorBack.configure(
                configSparkMotorEsquerda,
                ResetMode.kResetSafeParameters,
                PersistMode.kPersistParameters);

        // Inicializa encoders do Spark
        leftEncoder = leftMotorFront.getEncoder();
        rightEncoder = rightMotorFront.getEncoder();

        leftMotorControllerGroup.setInverted(false);
        rightMotorControllerGroup.setInverted(true);
    }*/
}
