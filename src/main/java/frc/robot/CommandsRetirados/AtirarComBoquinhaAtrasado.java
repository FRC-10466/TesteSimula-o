/*package frc.robot.CommandsRetirados;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Index;
import frc.robot.Constantes.ConstantesShooter;
import frc.robot.Constantes.ConstantesIndex;

public class AtirarComBoquinhaAtrasado extends Command {

    private final Shooter shooter;
    private final Index boquinha;

    private double tempoInicio;
    private boolean boquinhaLigada;

    private static final double ATRASO_BOQUINHA_S = 1.0;

    public AtirarComBoquinhaAtrasado(Shooter shooter, Index boquinha) {
        this.shooter = shooter;
        this.boquinha = boquinha;
        addRequirements(shooter, boquinha);
    }

    @Override
    public void initialize() {
        shooter.setVelocidade(ConstantesShooter.Velocidade.NORMAL);
        shooter.atirarFrente();

        tempoInicio = Timer.getFPGATimestamp();
        boquinhaLigada = false;
    }

    @Override
    public void execute() {
        double agora = Timer.getFPGATimestamp();

        if (!boquinhaLigada && (agora - tempoInicio) >= ATRASO_BOQUINHA_S) {
            boquinha.setVelocidade(ConstantesIndex.VelocidadeIndex.NORMAL);
            boquinha.ligarBoquinha(
                ConstantesIndex.VelocidadeIndex.NORMAL.rpm
            );
            boquinhaLigada = true;
        }
    }

    @Override
    public boolean isFinished() {
        return false; 
    }
}
*/