package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class PararShooter extends Command {

    private final Shooter shooter;

    public PararShooter(Shooter shooter) {
        this.shooter = shooter;
        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        shooter.parar();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
