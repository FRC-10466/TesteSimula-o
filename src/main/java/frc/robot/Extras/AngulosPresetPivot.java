package frc.robot.Extras;

public enum AngulosPresetPivot {

    BAIXO(Math.toRadians(10.0)),
        AUTO(Math.toRadians(80.0)),
        MEDIO(Math.toRadians(112.50)),
        ALTO(Math.toRadians(205.0)); // 198.50

    public final double rad;

    AngulosPresetPivot(double rad) {
        this.rad = rad;
    }
}