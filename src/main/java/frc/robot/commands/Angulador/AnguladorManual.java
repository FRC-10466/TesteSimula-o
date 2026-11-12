package frc.robot.commands.Angulador;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Angulador;

public class AnguladorManual extends Command {

    private final Angulador angulador;
    private final DoubleSupplier eixo;

    public AnguladorManual(Angulador angulador, DoubleSupplier eixo) {
        this.angulador = angulador;
        this.eixo = eixo;
        addRequirements(angulador);
    }

    @Override
    public void execute() {
        angulador.controleManual(eixo.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        angulador.controleManual(0.0);
    }
}