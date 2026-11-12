package frc.robot.Extras;

public enum AnguloPreset {
    //Utilizado para que todos os angulos fiquem pre-set e não precisem ser alterados funcionando para o angulador.
    BAIXO(0.0),
    CENTRAL(75.0),
    ALTO(140.0);

    public final double graus;

    AnguloPreset(double graus) {
        this.graus = graus;

    }
}