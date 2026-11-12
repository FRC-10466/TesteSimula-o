package frc.robot.commands.Pivot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeFloor;
import frc.robot.Extras.AngulosPresetPivot;
import frc.robot.StatesMachines.StateMachineIntakeFloor;

public class MoverPivotPreset extends Command {
    
    private final IntakeFloor intakeFloor;
    private final AngulosPresetPivot preset;

    public MoverPivotPreset(IntakeFloor intakeFloor, AngulosPresetPivot preset) {
        this.intakeFloor = intakeFloor;
        this.preset = preset;
        addRequirements(intakeFloor);
    }

    @Override
    public void initialize() {
        intakeFloor.moverParaPreset(preset);
    }
    @Override
    public boolean isFinished(){
        var estadoPivot = intakeFloor.getEstadoPivot();
        return estadoPivot == StateMachineIntakeFloor.EstadoPivot.HOLD
        || estadoPivot == StateMachineIntakeFloor.EstadoPivot.FALHA;
    }
    @Override
    public void end (boolean interrupted) {
    }   
}
