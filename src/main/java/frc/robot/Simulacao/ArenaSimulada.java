package frc.robot.Simulacao;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.StructArrayPublisher;

public class ArenaSimulada {

    private static final double COMPRIMENTO  = 4.0;    
    private static final double ALTURA_BLOCO = 0.127;  

    private final List<Pose3d> blocos = new ArrayList<>();

    private final StructArrayPublisher<Pose3d> blocosPub = NetworkTableInstance.getDefault()
        .getStructArrayTopic("Simulacao/Blocos", Pose3d.struct).publish();

    public ArenaSimulada() {
        
        for (int k = 0; k < 8; k++) {
            noChao(COMPRIMENTO / 2, 0.275 + 0.35 * k, Math.PI / 2);
        }
        
        for (double x : new double[] {1.34, 1.61}) {
            for (double y : new double[] {0.99, 1.37, 1.75}) {
                noChao(x, y, 0.0);                 
                noChao(COMPRIMENTO - x, y, 0.0);   
            }
        }
    }

    
    private void noChao(double x, double y, double yaw) {
        blocos.add(new Pose3d(x, y, ALTURA_BLOCO / 2, new Rotation3d(0, 0, yaw)));
    }

    public void atualizar() {
        blocosPub.set(blocos.toArray(new Pose3d[0]));
    }
}