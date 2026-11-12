package frc.robot.commands.Climber;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Climber;
import frc.robot.StatesMachines.StateMachineClimber;

public class ClimberStep extends Command {

    private final Climber climber;
    private final double step;

    public ClimberStep(Climber climber, double step) {
        this.climber = climber;
        this.step = step;
        addRequirements(climber);
    }

    @Override
    public void initialize() {
     double alturaAtual = climber.getAltura();
     climber.irParaAltura(alturaAtual + step);
    }

    @Override
    public boolean isFinished() {
         return climber.getEstado() == StateMachineClimber.Estado.HOLD
            || climber.getEstado() == StateMachineClimber.Estado.FALHA;
    }
}