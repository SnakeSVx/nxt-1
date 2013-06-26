/**
 * 
 */
package be.svx.nx4.controls;

import lejos.nxt.ColorSensor;
import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.DebugMessages;

/**
 * @author Stijn
 * 
 */
public class Sensors {
	/*
	 * Static methods
	 */
	private static Sensors instance;

	public static Sensors getInstance() {
		if (instance == null) {
			instance = new Sensors();
		}
		return instance;
	}

	/*
	 * Instance methods
	 */

	private NXTRegulatedMotor leftTrack;
	private NXTRegulatedMotor rightTrack;
	private NXTRegulatedMotor middleMotor;
	private ColorSensor lightSensor;
	private UltrasonicSensor ultrasonicSensor;
	private TouchSensor leftTouchSensor;
	private TouchSensor rightTouchSensor;

	private DifferentialPilot pilot;
	private DebugMessages debug;

	private Sensors() {
		leftTrack = Motor.C;
		rightTrack = Motor.A;
		middleMotor = Motor.B;
		pilot = new DifferentialPilot(43.2/2, 160, leftTrack, rightTrack, true);
		lightSensor = new ColorSensor(SensorPort.S2);
		ultrasonicSensor = new UltrasonicSensor(SensorPort.S1);
		leftTouchSensor = new TouchSensor(SensorPort.S4);
		rightTouchSensor = new TouchSensor(SensorPort.S3);
		debug = new DebugMessages();
		//Set default speed
		pilot.setTravelSpeed(0.6f * pilot.getMaxTravelSpeed());
	}

	public NXTRegulatedMotor getLeftTrack() {
		return leftTrack;
	}

	public NXTRegulatedMotor getRightTrack() {
		return rightTrack;
	}

	public NXTRegulatedMotor getMiddleMotor() {
		return middleMotor;
	}

	public DifferentialPilot getPilot() {
		return pilot;
	}

	public ColorSensor getLightSensor() {
		return lightSensor;
	}

	public UltrasonicSensor getUltrasonicSensor() {
		return ultrasonicSensor;
	}

	public TouchSensor getLeftTouchSensor() {
		return leftTouchSensor;
	}

	public TouchSensor getRightTouchSensor() {
		return rightTouchSensor;
	}

	public DebugMessages getDebug() {
		return debug;
	}	

}
