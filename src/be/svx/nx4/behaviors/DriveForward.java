/**
 * 
 */
package be.svx.nx4.behaviors;

import be.svx.nx4.controls.Sensors;
import lejos.nxt.LCD;
import lejos.robotics.Color;
import lejos.robotics.subsumption.Behavior;

/**
 * @author Stijn
 *
 */
public class DriveForward extends AbstractBaseBehavior {

	@Override
	public boolean takeControl() {
		return super.takeControl() && Sensors.getInstance().getUltrasonicSensor().getDistance() > 10;
	}

	@Override
	public void action() {
		if(!isActive()){
			setActive(true);
			Sensors.getInstance().getDebug().echo("Start driving forward");
			Sensors.getInstance().getLightSensor().setFloodlight(Color.GREEN);
			//Sensors.getInstance().getPilot().forward();
		}
	}

	@Override
	public void suppress() {
		if(isActive()){
			setActive(false);
			Sensors.getInstance().getDebug().echo("End driving forward");
			Sensors.getInstance().getPilot().stop();
		}
	}

}
