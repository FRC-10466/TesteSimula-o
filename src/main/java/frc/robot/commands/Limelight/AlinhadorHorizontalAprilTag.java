package frc.robot.commands.Limelight;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Traction;
import frc.robot.Constantes.ConstantesLimelight.LimelightConstants;

public class AlinhadorHorizontalAprilTag extends Command {

    private final Limelight limelight;
    private final Traction traction;

    private static final double KP_ROT = 0.035;
    private static final double MAX_ROT = 0.6;
    

    public AlinhadorHorizontalAprilTag(
        Limelight limelight,
        Traction traction
    ) {
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

        double erroX = limelight.getTxShooter();

        if (Math.abs(erroX) < LimelightConstants.DEADZONE_TX_GRAUS) {
            traction.stop();
            return;
        }

        double rot = erroX * KP_ROT;
        rot = Math.max(Math.min(rot, MAX_ROT), -MAX_ROT);

        traction.arcadeMode(0.0, rot);
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