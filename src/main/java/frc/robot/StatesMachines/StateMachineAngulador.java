package frc.robot.StatesMachines;

public class StateMachineAngulador {
    public enum Estado {
        DESABILITADO,
        MANUAL,
        TESTE,
        PERFIL,
        HOLD,
        FALHA
    }

    private Estado estado = Estado.DESABILITADO;

    public Estado get() {
        return estado;
    }

    public boolean is(Estado Es) {
        return estado == Es;
    }

    public void set(Estado novo) {
        estado = novo;
    }
}
