/*package frc.robot.commands.Angulador;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Angulador;
import frc.robot.subsystems.Limelight;

public class AngularAuto extends Command {

    private final Angulador angulador;
    private final Limelight limelight;

    private enum Estado {
        INFERIOR,
        CENTRAL,
        SUPERIOR
    }

    private Estado estadoAtual;
    private Estado ultimoEstado;

    private static final double HISTERESIS = 0.07;

    public AngularAuto(Angulador angulador, Limelight limelight) {
        this.angulador = angulador;
        this.limelight = limelight;
        addRequirements(angulador);
    }

    @Override
    public void initialize() {

        double ang = angulador.getAngulo();

        if (ang >= Angulador.LIMITE_SUPERIOR - Angulador.MargenErro)
            estadoAtual = Estado.SUPERIOR;
        else if (ang <= Angulador.LIMITE_INFERIOR + Angulador.MargenErro)
            estadoAtual = Estado.INFERIOR;
        else
            estadoAtual = Estado.CENTRAL;

        ultimoEstado = estadoAtual;
    }

    @Override
    public void execute() {

        if (!limelight.temAlvo()) return;

        double d = limelight.getDistanciaFiltrada();

        if (estadoAtual == Estado.CENTRAL && d > 2.30 + HISTERESIS)
            estadoAtual = Estado.SUPERIOR;

        else if (estadoAtual == Estado.SUPERIOR && d < 2.30 - HISTERESIS)
            estadoAtual = Estado.CENTRAL;

        else if (estadoAtual == Estado.INFERIOR && d > 1.55 + HISTERESIS)
            estadoAtual = Estado.CENTRAL;

        else if (estadoAtual == Estado.CENTRAL && d < 1.55 - HISTERESIS)
            estadoAtual = Estado.INFERIOR;

        if (estadoAtual != ultimoEstado) {

            switch (estadoAtual) {
                case SUPERIOR ->
                    angulador.moverParaAngulo(Angulador.LIMITE_SUPERIOR);

                case CENTRAL ->
                    angulador.moverParaAngulo(Angulador.LIMITE_CENTRAL);

                case INFERIOR ->
                    angulador.moverParaAngulo(Angulador.LIMITE_INFERIOR);
            }

            ultimoEstado = estadoAtual;
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        angulador.iniciarHold();
    }
}*/