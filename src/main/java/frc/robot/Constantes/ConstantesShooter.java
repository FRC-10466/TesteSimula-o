package frc.robot.Constantes;

public class ConstantesShooter {

    public enum Velocidade {
        NORMAL(2350),
        MEDIA(2500),
        ALTA(2700),
        AUTORIGHT(2550),
        AUTOMEIO(2125),
        AUTOLEFT(2390),
        TURBO(2500);

        

        public final double rpm;

        Velocidade(double rpm) {
            this.rpm = rpm;
        }
    }
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
  public static class Shooter{
   public static final int ShooterArlindo =6;
   public static final int ShooterArlindoFollower = 12;
  }
  public static class EncoderShooter{
    public static final int ArlindoEncoder = 18;
  }
    public static final double TOLERANCIA_RPM = 120;
    public static final double TOLERANCIA_RPM_SAIDA = 180;
    public static final double TEMPO_ESTABILIZACAO_S = 0.20;

    public static final double RAMP_RATE_S = 0.10;
    public static final double RPM_MAXIMO_CONTROLE = 4000.0;
    public static final int CORRENTE_MAXIMA_A = 60;

    public static final double PID_IZONE_RPM = 300.0;

    public static final double kS = 0.045;
    public static final double kV = 0.158;

    public static final double RPM_ANTI_DROP = 80.0;
    public static final double TAXA_RAMPA_SETPOINT_RPM_POR_S = 3000.0;
    public static final double FILTRO_RPM_TAU_S = 0.08;
    private ConstantesShooter() {}
}
