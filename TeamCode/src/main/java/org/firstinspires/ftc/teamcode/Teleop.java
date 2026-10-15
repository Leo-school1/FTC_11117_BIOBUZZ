
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;


@TeleOp(name="Teleop", group="Teleop")
public class Teleop extends OpMode
{

    private Hardware hardware;
    private Gamepad PrevGamepad1 = new Gamepad();
    private boolean LauncherActive = false;

    @Override
    public void init() {
        hardware = new Hardware(hardwareMap, telemetry);
        telemetry.addLine("Status: Initialized");
        telemetry.update();
    }

    @Override
    public void loop() {
        hardware.mecanumDrive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
        Intake();
        Transfer();
        Launcher();

        PrevGamepad1.copy(gamepad1);
        hardware.updateTelemetry();
        telemetry.update();
    }

    public void Intake() {
        if (gamepad1.x) {
            hardware.intake.setPower(1);
        } else if (gamepad1.b) {
            hardware.intake.setPower(-1);
        } else {
            hardware.intake.setPower(0);
        }
    }

    public void Transfer() {
        if (gamepad1.y) {
            hardware.transfer.setPower(1);
        } else if (gamepad1.b) {
            hardware.transfer.setPower(-1);
        } else {
            hardware.transfer.setPower(0);
        }
    }

    public void Launcher() {
        if (gamepad1.a && !PrevGamepad1.a) {
            LauncherActive = !LauncherActive;
        }
        if (LauncherActive) {
            hardware.launcher.setVelocity(1100);
        } else {
            hardware.launcher.setVelocity(0);
        }
    }


}
