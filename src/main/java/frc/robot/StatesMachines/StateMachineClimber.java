package frc.robot.StatesMachines;

public class StateMachineClimber {
    
    public enum Estado {
        IDLE,
        MOVENDO,
        MANUAL,
        HOLD,
        FALHA
    }

    private Estado estado = Estado.IDLE;

    public Estado get(){           
         return estado;
        }
        
    public boolean is(Estado E){
        return estado == E;
    }

    public void set(Estado novo){
        estado = novo;
    }
}


