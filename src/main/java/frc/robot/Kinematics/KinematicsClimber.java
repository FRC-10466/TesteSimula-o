package frc.robot.Kinematics;

import frc.robot.Constantes.ConstantesClimber;

public class KinematicsClimber {
    
    public static double alturaParaRotacoesMotor(double alturaMetros) {
        double rotacoesTambor =
            alturaMetros / ConstantesClimber.CIRCUNFERENCIA;
        return rotacoesTambor * ConstantesClimber.REDUCAO;
    }

    public static double rotacoesMotorParaAltura(double rotacoesMotor) {
        double rotacoesTambor =
            rotacoesMotor / ConstantesClimber.REDUCAO;
        return rotacoesTambor * ConstantesClimber.CIRCUNFERENCIA;
    }

    private KinematicsClimber() {}
}
