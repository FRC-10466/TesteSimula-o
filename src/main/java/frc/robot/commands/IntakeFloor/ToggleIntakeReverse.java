package frc.robot.commands.IntakeFloor;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeFloor;

public class ToggleIntakeReverse extends Command {

    private final IntakeFloor intakeFloor;

    // estado do toggle
    private boolean ativo = false;

    public ToggleIntakeReverse(IntakeFloor intakeFloor) {
        this.intakeFloor = intakeFloor;
        addRequirements(intakeFloor);
    }

    @Override
    public void initialize() {
        ativo = !ativo;

        if (ativo) {
            intakeFloor.IntakeReverse();
        } else {
            intakeFloor.PararIntake();
        }
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}