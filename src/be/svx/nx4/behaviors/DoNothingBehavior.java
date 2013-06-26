/**
 * 
 */
package be.svx.nx4.behaviors;

import be.svx.nx4.controls.App;
import be.svx.nx4.controls.Sensors;
import lejos.nxt.LCD;
import lejos.robotics.Color;
import lejos.robotics.subsumption.Behavior;

/**
 * @author Stijn
 *
 */
public class DoNothingBehavior extends AbstractBaseBehavior {

	/* (non-Javadoc)
	 * @see lejos.robotics.subsumption.Behavior#action()
	 */
	@Override
	public void action() {
		if(!isActive()){
			setActive(true);
			Sensors.getInstance().getDebug().echo("Start do nothing behavior");
			Sensors.getInstance().getLightSensor().setFloodlight(Color.BLUE);
		}
	}

	/* (non-Javadoc)
	 * @see lejos.robotics.subsumption.Behavior#suppress()
	 */
	@Override
	public void suppress() {
		if(isActive()){
			setActive(false);
			Sensors.getInstance().getDebug().echo("End do nothing behavior");
		}
	}

}
