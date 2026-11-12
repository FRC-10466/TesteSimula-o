package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class AtivarAtrasShooter extends Command {

    private final Shooter shooter;

    public AtivarAtrasShooter(Shooter shooter) {
        this.shooter = shooter;
        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        shooter.atirarTras();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
