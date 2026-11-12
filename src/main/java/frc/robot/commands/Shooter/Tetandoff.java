package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Index;

public class Tetandoff extends Command {

    private final Shooter shooter;

    private final Index index;

    public Tetandoff(Shooter shooter, Index index){
        this.shooter = shooter;
        this.index = index;
        addRequirements(shooter, index);
    }
    @Override
    public void initialize(){
        shooter.testandoTiro();
        index.ligar();
    }

    @Override
    public boolean isFinished(){
        return false;
    }

    @Override
    public void end(boolean interrupted){
        shooter.parar();
    }
}

