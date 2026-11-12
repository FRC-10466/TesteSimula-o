package frc.robot.commands.IntakeFloor;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeFloor;

public class ToggleIntake extends Command{
    private final IntakeFloor intakeFloor;


    private boolean ativo = false;

    public ToggleIntake(IntakeFloor intakeFloor){
        this.intakeFloor = intakeFloor;
        addRequirements(intakeFloor);
    }
    @Override
    public void initialize() {
        ativo = !ativo;

        if (ativo) {
            intakeFloor.IntakeOn();
        } else {
            intakeFloor.PararIntake();
        }
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
