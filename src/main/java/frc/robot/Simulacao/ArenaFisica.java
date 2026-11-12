package frc.robot.Simulacao;

import java.util.List;

import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.apriltag.AprilTagFields;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.system.plant.DCMotor;

public class ArenaFisica {
    
    private static final double RAIO_ROBO = 0.45;

    private record Caixa (String nome, double xMin, double yMin, double xMax, double yMax) {}
    private record Rampa(String nome, double xMin, double yMin, double xMax, double yMax, double direcaoSubidaGraus, double inclinacaoGraus){}

    private final List<Caixa> solidos;
    private final List<Rampa> rampas;

    private final double comprimento;
    private final double largura;
    private static final DCMotor MOTORES_LADO = DCMotor.getCIM(2);
    private static final double MASSA_ROBO_KG = 55.0;
    private static final double RAIO_RODA_M = 0.0762;
    private static final double REDUCAO = 10.71;

    public ArenaFisica(){
        AprilTagFieldLayout layout = AprilTagFieldLayout.loadField(AprilTagFields.kDefaultField);
        comprimento =  layout.getFieldLength();
        largura = layout.getFieldWidth();

        Caixa hubAzul = new Caixa("HUB Azul", 4.1, 3.51, 5.2, 4.6);
        Caixa poste1Azul =  poste("TOWER Azul - poste 1", 1.080, 4.219, 0.06);
        Caixa poste2Azul =  poste("TOWER Azul - poste 2", 1.080, 3.305, 0.06);
        Caixa poste1Vermelho =  poste("TOWER Vermelho - poste 1", 15.458, 3.870, 0.06);
        Caixa poste2Vermelho =  poste("TOWER Vermelho - poste 2", 15.458, 4.770, 0.06);  
        
        solidos = List.of(
            hubAzul, 
            espelhar(hubAzul, "HUB Vermelho"),
            poste1Azul,
            poste2Azul,
            poste1Vermelho,
            poste2Vermelho
            );

        rampas = List.of(

        );    
    }

    private static Caixa poste(String nome, double xCentro, double yCentro, double lado){
        double meio = lado / 2.0;
        return new Caixa(nome, xCentro - meio, yCentro - meio, xCentro + meio, yCentro + meio);
    } 


    private Caixa espelhar(Caixa c, String nome){
        return new Caixa(nome, comprimento - c.xMax(), c.yMin(), comprimento - c.xMin(), c.yMax());
    }


    public double tensaoGravidade(Pode2d pose){
        for (Rampa r : rampas){
            boolean dentro = pose.getX() >= r.xMin() && pose.getX() <= r.xMax() && pose.getY() >= r.yMin() && pose.getY() <= r.yMax();
            if(!dentro) continue;

            double forcaPorLado = 
        }
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
