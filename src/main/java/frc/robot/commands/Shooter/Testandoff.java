package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class Testandoff extends Command {

    private final Shooter shooter;

    public Testandoff(Shooter shooter){
        this.shooter = shooter;
        addRequirements(shooter);
    }
    @Override
    public void initialize(){
        shooter.proximoDuty();;
    }

}
