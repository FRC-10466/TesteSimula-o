/*package frc.robot.commands.Limelight;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Limelight;


public class AlinhandoComId extends Command {

    private final Limelight limelight;

    private static final double OFFSET_METROS = 0.10;
    private static final double OFFSET_METROS1 = 0.05;
    private static final double OFFSET_METROS2 = 0.20;
    private static final double OFFSET_METROS3 = 0.40;

    public AlinhandoComId(Limelight limelight) {
        this.limelight = limelight;
        addRequirements(limelight);
    }

    @Override
    public void execute() {

        if (!limelight.temAlvo()) {
            return;
        }

        int id = limelight.getAprilTagID();
        double tx = limelight.getTx();
        double distancia = limelight.getDistanciaFiltrada();

        if (distancia <= 0.05 || Double.isNaN(distancia)) {
            return;
        }

        double offsetGraus = 0.0;

        if (id == 11) {
            offsetGraus =
                Math.toDegrees(
                    Math.atan(OFFSET_METROS / distancia)
                ) * 1.0;
        }
        if (id == 2) {
            offsetGraus =
                Math.toDegrees(
                    Math.atan(OFFSET_METROS1 / distancia)
                ) * -1.0;
        }
        if (id == 3) {
            offsetGraus =
                Math.toDegrees(
                    Math.atan(OFFSET_METROS2 / distancia)
                ) * -1.0;
        }
        if (id == 4) {
            offsetGraus =
                Math.toDegrees(
                    Math.atan(OFFSET_METROS3 / distancia)
                ) * -1.0;
        }
        if (id == 8) {
            offsetGraus =
                Math.toDegrees(
                    Math.atan(OFFSET_METROS1 / distancia)
                ) * 1.0;
        }
        if (id == 5) {
            offsetGraus =
                Math.toDegrees(
                    Math.atan(OFFSET_METROS / distancia)
                ) * 1.0;
        }
        if (id == 9) {
            offsetGraus =
                Math.toDegrees(
                    Math.atan(OFFSET_METROS / distancia)
                ) * 1.0;
        }


        double erroFinal = tx + offsetGraus;

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}*/