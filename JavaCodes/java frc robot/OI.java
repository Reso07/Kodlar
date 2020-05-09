package frc.robot;
import frc.robot.commands.MOve;
import frc.robot.commands.MoveSequence;
/**
 * Add your docs here.
 */
public class OI {
    
    private Joystick stick = new Joystick(RobotMap.stick);
    Button button = new JoystickButton(stick, RobotMap.buttonX);

    public double getDriverRawAxis(int axis) {
        return stick.getDriverRawAxis(axis);
    }

    public OI() {
        button.whenPressed(new MoveSequence());
    }
}