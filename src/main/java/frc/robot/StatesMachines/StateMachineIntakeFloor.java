package frc.robot.StatesMachines;

public class StateMachineIntakeFloor {
    public enum EstadoPivot {
        DESABILITADO,
        MANUAL,
        TESTE,
        PERFIL,
        HOLD,
        FALHA
    }   

    private EstadoPivot estadoPivot = EstadoPivot.DESABILITADO;

    public EstadoPivot get(){
        return estadoPivot;
    }

    public boolean is(EstadoPivot Us){
        return estadoPivot == Us;
    }

    public void set(EstadoPivot novo){
        estadoPivot = novo;
    }
}
