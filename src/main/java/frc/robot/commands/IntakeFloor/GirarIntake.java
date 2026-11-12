package frc.robot.commands.IntakeFloor;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeFloor;

public class GirarIntake extends Command {

    private final IntakeFloor intakeFloor;

    public GirarIntake(IntakeFloor intakeFloor){
        this.intakeFloor = intakeFloor;
        addRequirements(intakeFloor);
    }

    @Override
    public void initialize() {
        intakeFloor.IntakeOn();
    }
    @Override
    public boolean isFinished(){
        return false;
    }
}