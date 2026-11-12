package frc.robot.Kinematics;

import frc.robot.Constantes.ConstantesAngulador;

public class KInematicsAngulador {
    
    public static double grausParaRotacoes(double graus) {
        return (graus / 360.0) * ConstantesAngulador.REDUCAO;
    }

    public static double rotacoesParaGraus(double rotacoes) {
        return rotacoes * (360.0 / ConstantesAngulador.REDUCAO);
    }

    private KInematicsAngulador() {}
}
