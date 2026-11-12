package frc.robot.commands.Angulador;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constantes.ConstantesAngulador;
import frc.robot.Constantes.ConstantesLimelight.LimelightConstants;
import frc.robot.subsystems.Angulador;
import frc.robot.subsystems.Limelight;

public class AnguladorAutoPorLimelight extends Command {

    private final Angulador angulador;
    private final Limelight limelight;

    public AnguladorAutoPorLimelight(Angulador angulador, Limelight limelight) {
        this.angulador = angulador;
        this.limelight = limelight;
        addRequirements(angulador);
    }

    @Override
    public void initialize() {
     
    }

    @Override
    public void execute() {

        if (!limelight.temAlvo()) {
            return;
        }

        double distancia = limelight.getDistanciaFiltrada();

        double deltaAltura =
            LimelightConstants.ALTURA_TAG_METROS
          - LimelightConstants.ALTURA_CAMERA_METROS;

        double anguloRad = Math.atan(deltaAltura / distancia);
        double anguloGraus = Math.toDegrees(anguloRad)
                + LimelightConstants.ANGULO_CAMERA_EFETIVO_GRAUS;

        anguloGraus = Math.max(
            ConstantesAngulador.LIMITE_INFERIOR,
            Math.min(ConstantesAngulador.LIMITE_SUPERIOR, anguloGraus)
        );

        angulador.moverParaAngulo(anguloGraus);
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return false; 
    }
}