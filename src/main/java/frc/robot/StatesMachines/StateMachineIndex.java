package frc.robot.StatesMachines;

public class StateMachineIndex {
    public enum Estado {
        SOSSEGADO,
        DIRECIONAR,
        
    }

    private Estado estado = Estado.SOSSEGADO;

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
