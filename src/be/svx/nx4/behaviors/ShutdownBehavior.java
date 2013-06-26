/**
 * 
 */
package be.svx.nx4.behaviors;

import be.svx.nx4.controls.App;
import be.svx.nx4.controls.Sensors;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.robotics.Color;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

/**
 * @author Stijn
 *
 */
public class ShutdownBehavior extends AbstractBaseBehavior {
	
	@Override
	public boolean takeControl() {
		return super.takeControl() && Button.ENTER.isDown();
	}

	@Override
	public void action() {
		if(!isActive()){
			setActive(true);
			Sensors.getInstance().getDebug().echo("Start exit behavior");
			App.setActive(false);	
			Sensors.getInstance().getLightSensor().setFloodlight(Color.WHITE);
			try{Thread.sleep(1000);}catch(Exception e) {}
		}
	}

	@Override
	public void suppress() {
		if(isActive()){
			setActive(false);
			Sensors.getInstance().getDebug().echo("End exit behavior");	
		}
	}
	
	

}
