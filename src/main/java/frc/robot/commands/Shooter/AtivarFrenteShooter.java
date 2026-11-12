package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class AtivarFrenteShooter extends Command {

    private final Shooter shooter;

    public AtivarFrenteShooter(Shooter shooter) {
        this.shooter = shooter;
        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        shooter.atirarFrente();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
