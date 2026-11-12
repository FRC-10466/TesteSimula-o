package frc.robot.Kinematics;

import frc.robot.Constantes.ConstantesIntakeFloor;

public class KinematicsIntakeFloor {

   public static double rotacoesParaRadPivot(double rotacoes) {
    return -rotacoes * (2.0 * Math.PI / ConstantesIntakeFloor.REDUCAO_PIVOT);
}

public static double radParaRotacoesPivot(double rad) {
    return -rad / (2.0 * Math.PI) * ConstantesIntakeFloor.REDUCAO_PIVOT;
}
}
