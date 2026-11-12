package frc.robot.StatesMachines;

public class StateMachineShooter {

    public enum Estado {
        PARADO,
        ATIRANDO_FRENTE,
        ATIRANDO_TRAS,
        
    }

    private Estado estado = Estado.PARADO;

    public Estado get() {
        return estado;
    }

    public boolean is(Estado e) {
        return estado == e;
    }

    public void set(Estado novo) {
        estado = novo;
    }
}
