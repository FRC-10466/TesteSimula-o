package frc.robot.commands.IntakeFloor;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeFloor;

public class PararIntake extends Command{
 private final IntakeFloor intakeFloor;
 
 public PararIntake (IntakeFloor intakeFloor) {
    this.intakeFloor = intakeFloor;
    addRequirements(intakeFloor);
 }
 @Override
 public void initialize(){
    intakeFloor.PararIntake();
 }
 @Override
 public boolean isFinished(){
    return true;
 }
}
