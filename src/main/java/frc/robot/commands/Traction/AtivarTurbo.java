package frc.robot.commands.Traction; 
// Define o pacote onde este comando está localizado

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; 
// Importa a classe que permite enviar dados para o SmartDashboard

import edu.wpi.first.wpilibj2.command.Command; 
// Importa a classe base para criação de comandos no modelo Command-Based

import frc.robot.subsystems.Traction; 
// Importa o subsistema de tração do robô

public class AtivarTurbo extends Command { 
// Declara a classe AtivarTurbo, que é um comando

    public Traction traction; 
    // Referência ao subsistema Traction, usada para acessar e alterar o estado do turbo

    public AtivarTurbo(Traction traction) { 
    // Construtor do comando, recebe o subsistema Traction

        this.traction = traction; 
        // Armazena o subsistema recebido na variável da classe

        addRequirements(traction); 
        // Informa ao scheduler que este comando utiliza o subsistema Traction
    }

    @Override
    public void initialize() { 
    // Método executado uma única vez quando o comando é iniciado

        if (traction.turbo == false) { 
        // Verifica se o turbo está desligado

            traction.ativarTurbo(true); 
            // Ativa o modo turbo

        } else { 
        // Caso o turbo já esteja ligado

            traction.ativarTurbo(false); 
            // Desativa o modo turbo
        }

        SmartDashboard.putBoolean("Turbo: ", traction.turbo); 
        // Envia o estado atual do turbo para o SmartDashboard
    }

    @Override
    public void execute() { 
    // Método chamado repetidamente enquanto o comando estiver ativo
    }

    @Override
    public void end(boolean interrupted) { 
    // Método chamado quando o comando termina ou é interrompido
    }

    @Override
    public boolean isFinished() { 
    // Define quando o comando deve finalizar

        return true; 
        // Retorna true para encerrar o comando imediatamente após a execução
    }
}
