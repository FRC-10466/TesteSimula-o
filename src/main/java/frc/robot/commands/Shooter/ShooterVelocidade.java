package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constantes.ConstantesShooter;
import frc.robot.subsystems.Shooter;

public class ShooterVelocidade extends Command {

    private final Shooter shooter;
    private final ConstantesShooter.Velocidade alvo;

    public ShooterVelocidade(
        Shooter shooter,
        ConstantesShooter.Velocidade alvo
    ) {
        this.shooter = shooter;
        this.alvo = alvo;
        addRequirements(shooter);
    }

    @Override
    public void initialize() {

        if (shooter.getVelocidade() == alvo) {
            shooter.setVelocidade(ConstantesShooter.Velocidade.NORMAL);
        } else {
            shooter.setVelocidade(alvo);
        }
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
