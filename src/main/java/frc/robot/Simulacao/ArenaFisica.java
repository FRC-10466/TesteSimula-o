package frc.robot.Simulacao;

import java.util.List;


import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Pose2d;


public class ArenaFisica {
    
    private static final double RAIO_ROBO = 0.45;
    
    
    

    private record Caixa (String nome, double xMin, double yMin, double xMax, double yMax) {}
    

    private final List<Caixa> solidos;
    

    private final double comprimento;
    private final double largura;
    
    

    public ArenaFisica(){
        
        comprimento = 4.0;
        largura = 3.0;

        Caixa mesaAzul = new Caixa("MESA Azul", 0.0, 0.77, 0.61, 1.97);
        Caixa docaAzul = new Caixa("DOCA Azul", 0.44, 0.0, 1.64, 0.40);
         
        solidos = List.of(
            mesaAzul, espelhar(mesaAzul, "MESA Vermelha"),
            docaAzul, espelhar(docaAzul, "DOCA Vermelha")
        );
    }

    


    private Caixa espelhar(Caixa c, String nome){
        return new Caixa(nome, comprimento - c.xMax(), c.yMin(), comprimento - c.xMin(), c.yMax());
    }


    


    public Pose2d corrigir(Pose2d pose){
        double x = pose.getX();
        double y = pose.getY();

        x = MathUtil.clamp(x, RAIO_ROBO, comprimento - RAIO_ROBO);
        y = MathUtil.clamp(y, RAIO_ROBO, largura - RAIO_ROBO);

        for (Caixa c : solidos) {
            double px = MathUtil.clamp(x, c.xMin(), c.xMax());
            double py = MathUtil.clamp(y, c.yMin(), c.yMax());
            double dx = x - px;
            double dy = y - py;
            double d = Math.hypot(dx, dy);

            if (d < RAIO_ROBO && d > 1e-6){
                double empurrao = RAIO_ROBO -d;
                x += dx / d * empurrao;
                y += dy / d * empurrao;
            }
        }
        return new Pose2d(x,y, pose.getRotation());
    }

}
