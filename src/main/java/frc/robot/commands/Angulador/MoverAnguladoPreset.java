package frc.robot.commands.Angulador;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Angulador;
import frc.robot.Extras.AnguloPreset;
import frc.robot.StatesMachines.StateMachineAngulador;

public class MoverAnguladoPreset extends Command {

    private final Angulador angulador;
    private final AnguloPreset preset;

    public MoverAnguladoPreset(Angulador angulador, AnguloPreset preset) {
        this.angulador = angulador;
        this.preset = preset;
        addRequirements(angulador);
    }

    @Override
    public void initialize() {
        angulador.moverParaPreset(preset);
    }

    @Override
public boolean isFinished() {
    var estado = angulador.getEstado();
    return estado == StateMachineAngulador.Estado.HOLD
        || estado == StateMachineAngulador.Estado.FALHA;
}
    @Override
    public void end(boolean interrupted) {
    }
}
