package frc.robot.commands.Index;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Index;
import frc.robot.subsystems.Shooter;

public class ToggleSequencialShooterIndex extends Command {

    private final Shooter shooter;
    private final Index index;
    private final Timer timer = new Timer();
    private boolean transporteLigado = false;

    public ToggleSequencialShooterIndex(Shooter shooter, Index index) {
        this.shooter = shooter;
        this.index = index;
        addRequirements(shooter, index);
    }

    @Override
    public void initialize() {
        shooter.atirarFrente();
        timer.reset();
        timer.start();
        transporteLigado = false;
    }

    @Override
    public void execute() {
        if (!transporteLigado && timer.hasElapsed(1.25)) {
            index.ligar();         
            transporteLigado = true;
        }
    }

    @Override
    public boolean isFinished() {
        return transporteLigado;
    }

    @Override
    public void end(boolean interrupted) {
        timer.stop();
        if (interrupted) {
            index.desligar();
            shooter.parar();
        }
    }
}