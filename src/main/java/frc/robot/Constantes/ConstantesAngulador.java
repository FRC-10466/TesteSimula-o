package frc.robot.Constantes;

import frc.robot.subsystems.Angulador;

@SuppressWarnings("unused")
public final class ConstantesAngulador {

    public static class Alinhador{
      public static final int AlinhadorMotor =8;
}
    public static class FFAlinhador{
      public static final double kS = 0.13;
      public static final double kG = 0.40;
      public static final double kV = 1.0;
}
    public static class EncoderAlinhador{
      public static final int AnguladorEncoder = 26;
}

    public static final double LIMITE_SUPERIOR = 160.0;
    public static final double LIMITE_INFERIOR = 0.0;

    public static final double REDUCAO = 25.0;

    public static final double DT = 0.02;
    public static final double MARGEM_ERRO_BASE = 1.65;

    public static final double MAX_VEL = 90.0;
    public static final double MAX_ACC = 180.0;

    public static final double VELOCIDADE_MIN = 0.01;
    public static final double TEMPO_MAX_TRAVADO = 0.8;
    public static final double ERRO_TOLERANCIA = 2.0;

    private ConstantesAngulador() {}
}