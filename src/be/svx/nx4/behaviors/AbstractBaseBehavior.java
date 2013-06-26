/**
 * 
 */
package be.svx.nx4.behaviors;

import be.svx.nx4.controls.App;
import lejos.robotics.subsumption.Behavior;

/**
 * @author Stijn
 *
 */
public abstract class AbstractBaseBehavior implements Behavior {
	
	private boolean active = false;

	/* (non-Javadoc)
	 * @see lejos.robotics.subsumption.Behavior#takeControl()
	 */
	@Override
	public boolean takeControl() {
		return App.isActive();
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
