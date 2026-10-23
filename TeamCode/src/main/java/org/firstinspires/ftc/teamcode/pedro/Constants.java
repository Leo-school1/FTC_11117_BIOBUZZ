package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.algorithm.ForesightConfig;
import com.pedropathing.controllers.Controller;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Matrix;
import com.pedropathing.math.Vector2D;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.PinpointConfig;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Constants {
    public static Follower create(HardwareMap h) {
        // return new Follower(Drivetrain, Localizer, Foresight);
        return null;
    }
    public static MecanumConfig drivetrainConfig = new MecanumConfig(c -> {
        c.frontLeftName.set("lf");
        c.frontRightName.set("rf");
        c.backLeftName.set("lb");
        c.backRightName.set("rb");
        c.frontLeftDirection.set(DcMotorSimple.Direction.FORWARD);
        c.frontRightDirection.set(DcMotorSimple.Direction.REVERSE);
        c.backLeftDirection.set(DcMotorSimple.Direction.FORWARD);
        c.backRightDirection.set(DcMotorSimple.Direction.FORWARD);
    });

    public static PinpointConfig localizerConfig = new PinpointConfig(c -> {
        c.name.set("pinpoint");
        c.podType.set(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_SWINGARM_POD);
        c.xPodOffset.set(4.151948643481638);
        c.yPodOffset.set(-5.566945714274729);
        c.xPodDirection.set(GoBildaPinpointDriver.EncoderDirection.REVERSED);
        c.yPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.globalDistanceUnit.set(DistanceUnit.INCH);
        c.offsetUnits.set(DistanceUnit.INCH);
    });

    public static ForesightConfig foresightConfig = new ForesightConfig(
            c -> {
                Controller primaryTranslationalForward = Controller.proportional(0.24543238362204212);
                Controller secondaryTranslationalForward = Controller.proportional(0.0906807076742724);
                Controller primaryTranslationalLateral = Controller.proportional(0.3081027906021292);
                Controller secondaryTranslationalLateral = Controller.proportional(0.11383574846929884);

                c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
                c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));

                c.coast.set(Controller.proportionalFeedforward(0.018962377813560638));
                c.brake.set(Controller.proportionalFeedforward(0.01611802114152654));

                c.headingFeedback.set(Controller.proportional(4.257714819212034));
                c.headingBrakeCoefficients.set(Vector2D.cartesian(0.03975855577444153, 0.008624223473074824));

                c.linearBrakeCoefficients.set(Matrix.diag(0.04415679370829983, 0.024462667781673917));
                c.quadraticBrakeCoefficients.set(Matrix.diag(0.0022013564762298535, 0.0023945205214313293));

                c.maxAchievableForwardVelocity.set(55.260188548546196);
                c.maxAchievableStrafeVelocity.set(44.29667928416218);
                c.naturalForwardDeceleration.set(44.869804437940765);
                c.naturalStrafeDeceleration.set(70.75800250213577);
            }
    );
}