package frc.robot.commands.Limelight;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Traction;

@SuppressWarnings("unused")
public class AlinhadorVerticalAprilTag extends Command {

    private final Limelight limelight;
    private final Traction traction;

    // ===== AJUSTES PRINCIPAIS =====
    private static final double KP_DIST = 0.50;
    private static final double DIST_DESEJADA = 2.400; // metros
    private static final double DIST_OK = 0.02;       // 2,5 cm
    private static final double AVANCO_BIAS = 0.08;
    private static final double VEL_MAX = 0.6;

    public AlinhadorVerticalAprilTag(Limelight limelight, Traction traction) {
        this.limelight = limelight;
        this.traction = traction;
        addRequirements(traction);
    }

    @Override
    public void initialize() {
        limelight.setPipeline(0);
        limelight.ligarLED();
    }

    @Override
    public void execute() {

        if (!limelight.temAlvo()) {
            traction.stop();
            return;
        }

        // 🔹 distância FILTRADA
        double distanciaAtual = limelight.getDistanciaFiltrada();
        double erro = distanciaAtual - DIST_DESEJADA;
        double erroAbs = Math.abs(erro);

        double avanco = 0.0;

        if (erroAbs > DIST_OK) {

            // Controle proporcional
            avanco = erro * KP_DIST;

            // ===== VEL_MIN DINÂMICA =====
            double velMin;

            if (erroAbs > DIST_OK) {

    avanco = erro * KP_DIST;

    // 🔹 BIAS para vencer atrito
    avanco += Math.copySign(AVANCO_BIAS, erro);

    // Desaceleração progressiva
    double fator = MathUtil.clamp(
        erroAbs / 0.40,
        0.2,
        1.0
    );

    avanco *= fator;
}


            // ===== DESACELERAÇÃO FINAL =====
            double fator = MathUtil.clamp(
                erroAbs / 0.25,
                0.25,
                1.0
            );

            avanco *= fator;
        }

        // Clamp final de segurança
        avanco = MathUtil.clamp(avanco, -VEL_MAX, VEL_MAX);

        traction.arcadeMode(avanco, 0.0);
    }

    @Override
    public void end(boolean interrupted) {
        traction.stop();
        limelight.desligarLED();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
