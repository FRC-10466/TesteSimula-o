package frc.robot.commands.Limelight;
/*package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Traction;

public class AlinharAprilTag extends Command {

    private final Limelight limelight;
    private final Traction traction;

    private static final double KP_ROT  = 0.035;
    private static final double KP_DIST = 0.35;

    private static final double ANGULO_OK = 0.6;   // graus
    private static final double DIST_OK   = 0.5;  // metros

// Distância desejada até a AprilTag
private static final double DIST_DESEJADA = 2.00; 


    public AlinharAprilTag(Limelight limelight, Traction traction) {
        this.limelight = limelight;
        this.traction = traction;
        addRequirements(traction);
    }

    @Override
    public void initialize() {
        limelight.setPipeline(0);
        limelight.ligarLED();
    }
 
    @Override
public void execute() {

    if (!limelight.temAlvo()) {
        traction.stop();
        return;
    }

    double erroX = limelight.getTx();
    double distanciaAtual = limelight.getDistanciaAprilTag();
    double erroDist = distanciaAtual - DIST_DESEJADA;

    double rot = 0.0;
    double avanco = 0.0;


    if (Math.abs(erroX) > ANGULO_OK) {

        rot = erroX * KP_ROT;
        rot = Math.max(Math.min(rot, 0.7), -0.7);
        avanco = 0.0;

    }
    else if (Math.abs(erroDist) > DIST_OK) {

        avanco = erroDist * KP_DIST;
        avanco = Math.max(Math.min(avanco, 0.7), -0.7);

        rot = 0.0;
    }
    else {
        avanco = 0.0;
        rot = 0.0;
    }

    traction.arcadeMode(avanco, rot);
}
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        traction.stop();
        limelight.desligarLED();
    }
}
*/