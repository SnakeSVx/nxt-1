/**
 * 
 */
package be.svx.nx4.behaviors;

import be.svx.nx4.controls.Sensors;
import lejos.nxt.LCD;
import lejos.nxt.Sound;
import lejos.robotics.Color;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * @author Stijn
 *
 */
public class DetectWall extends AbstractBaseBehavior{
	
	private DifferentialPilot pilot;
	
	public DetectWall(){
		 pilot = Sensors.getInstance().getPilot();
	}

	@Override
	public boolean takeControl() {
		return super.takeControl() && Sensors.getInstance().getUltrasonicSensor().getDistance() <= 10;
	}

	@Override
	public void action() {
		if(!isActive()){
			setActive(true);
			Sensors.getInstance().getDebug().echo("Detected wall");
			Sound.beep();
			//pilot.rotate(180);
			Sound.beep();
			Sensors.getInstance().getLightSensor().setFloodlight(Color.RED);
			try{Thread.sleep(1000);}catch(Exception e) {}
		}
	}

	@Override
	public void suppress() {
		if(isActive()){
			setActive(false);
			Sensors.getInstance().getDebug().echo("No wall left");
			pilot.stop();
		}
	}

}
