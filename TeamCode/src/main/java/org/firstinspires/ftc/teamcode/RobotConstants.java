package org.firstinspires.ftc.teamcode;

import com.pedropathing.math.Pose;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


public class RobotConstants {
    public final DcMotor.Direction lf_direction, lb_direction, rf_direction, rb_direction, launcher_direction, intake_direction, transfer_direction, turret_direction;
    public final int SHOOT_VELOCITY = 1100;



    public RobotConstants() {
        // the current robot requires all motors to be reversed
        lf_direction = DcMotorSimple.Direction.FORWARD;
        lb_direction = DcMotorSimple.Direction.FORWARD;
        rf_direction = DcMotorSimple.Direction.REVERSE;
        rb_direction = DcMotorSimple.Direction.FORWARD;
        launcher_direction = DcMotorSimple.Direction.FORWARD;
        intake_direction = DcMotorSimple.Direction.FORWARD;
        transfer_direction = DcMotorSimple.Direction.REVERSE;
        turret_direction = DcMotorSimple.Direction.FORWARD;

    }

}
