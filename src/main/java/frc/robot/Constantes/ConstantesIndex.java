package frc.robot.Constantes;

public class ConstantesIndex {
     public enum VelocidadeIndex {
    NORMAL(1200, 0.35),
    ALTA(2100, 0.85);

    public final double rpm;
    public final double percentual;

    VelocidadeIndex(double rpm, double percentual) {
        this.rpm = rpm;
        this.percentual = percentual;
    }
  }
  public static class OperatorConstants {
    public static final int kDriverControllerPort_01 = 0;
  } 
  public static class Index{
    public static final int IndexMotor = 7;
    public static final int ShooterBoquinha =5;
  }
  public static class EncoderShooter{
    public static final int IndexEncoder = 29;
    public static final int BoquinhaEncoder = 30;
  }
    public static final double boquinhaReducao = 25.0;
    public static final double indexReducao = 9.0;

  public static final double TOLERANCIA_RPM_01 = 120;
    public static final double TOLERANCIA_RPM_SAIDA_01 = 180;
    public static final double TEMPO_ESTABILIZACAO_S_01 = 0.20;

    public static final double RAMP_RATE_S_01 = 0.10;
    public static final double RPM_MAXIMO_CONTROLE_01 = 5700.0;
    public static final int CORRENTE_MAXIMA_A_01 = 60;

    public static final double PID_P_01 = 0.0004;
    public static final double PID_I_01 = 0.0;
    public static final double PID_D_01 = 0.0;
    public static final double PID_IZONE_RPM_01 = 250.0;
    public static final double FF_VELOCIDADE_01 = 1.0 / 5700.0;

    public static final double TAXA_RAMPA_SETPOINT_RPM_POR_S_01 = 3000.0;
    public static final double FILTRO_RPM_TAU_S_01 = 0.08;
    public static final double ATRASO_INDEX_S = 0.5;


    private ConstantesIndex() {}
}