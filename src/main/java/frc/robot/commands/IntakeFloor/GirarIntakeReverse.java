package frc.robot.commands.IntakeFloor;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeFloor;


public class GirarIntakeReverse extends Command {

    private final IntakeFloor intakeFloor;

    public GirarIntakeReverse (IntakeFloor intakeFloor){
        this.intakeFloor = intakeFloor;
        addRequirements(intakeFloor);
    }  
    @Override
    public void initialize(){
        intakeFloor.IntakeReverse();
    }
    @Override
    public boolean isFinished(){
        return false;
    }
}
    
