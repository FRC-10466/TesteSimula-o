package frc.robot.commands.Shooter;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constantes.ConstantesAngulador;
import frc.robot.Constantes.ConstantesLimelight.LimelightConstants;
import frc.robot.subsystems.Angulador;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class AutoAimShooter extends Command {

    private final Angulador angulador;
    private final Shooter shooter;
    private final Limelight limelight;

    private static final double DIST_MIN = 1.55;
    private static final double DIST_MAX = 9.45;

    private static final double RPM_MIN  = 2150.0; // ajustar se for muito fraco, aumente
    private static final double RPM_MAX  = 3350.0; // ajustar se for muito forte, abaixe

    private static final double OFFSET_PROFUNDIDADE_HUB = 0.12; // 10 cm pra dentro
    private static final double OFFSET_ALTURA_HUB = 1.03;       // 73 cm acima da tag

    public AutoAimShooter(
        Angulador angulador,
        Shooter shooter,
        Limelight limelight
    ) {
        this.angulador = angulador;
        this.shooter = shooter;
        this.limelight = limelight;
        addRequirements(angulador, shooter);
    }

    @Override
    public void initialize() {
        limelight.ligarLED();
    }

    @Override
public void execute() {

    if (!limelight.temAlvo()) {
        shooter.parar();
        return;
    }

    if (!limelight.alinhadoComShooter()) {
        shooter.parar();
        return;
    }

    double distancia =
        limelight.getDistanciaFiltrada()
        + OFFSET_PROFUNDIDADE_HUB;

    distancia = MathUtil.clamp(distancia, DIST_MIN, DIST_MAX);

    double rpm =
        RPM_MIN +
        (distancia - DIST_MIN) *
        (RPM_MAX - RPM_MIN) /
        (DIST_MAX - DIST_MIN);

    shooter.setRpmDireto(rpm);

    double alturaAlvo =
        LimelightConstants.ALTURA_TAG_METROS
        + OFFSET_ALTURA_HUB
        - LimelightConstants.ALTURA_CAMERA_METROS;

    double anguloRad = Math.atan2(alturaAlvo, distancia);
    double anguloGraus = Math.toDegrees(anguloRad);

    anguloGraus = MathUtil.clamp(
        anguloGraus,
        ConstantesAngulador.LIMITE_INFERIOR,
        ConstantesAngulador.LIMITE_SUPERIOR
    );

    angulador.moverParaAngulo(anguloGraus);
}
    @Override
    public void end(boolean interrupted) {
        shooter.parar();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}