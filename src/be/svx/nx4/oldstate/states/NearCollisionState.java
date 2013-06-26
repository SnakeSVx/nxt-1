package be.svx.nx4.oldstate.states;

import lejos.nxt.Sound;
import lejos.robotics.Color;
import be.svx.base.Event;
import be.svx.nx4.controls.Sensors;
import be.svx.nx4.events.AproachingObstacleEvent;
import be.svx.nx4.oldstate.base.State;

public class NearCollisionState extends State {

	public NearCollisionState() {
		super("NearCollisionState");
	}

	@Override
	protected boolean isAcceptableEvent(Event event) {
		if(event instanceof AproachingObstacleEvent){
			AproachingObstacleEvent ev = (AproachingObstacleEvent)event;
			return ev.getDistance() < 10;
		}
		return false;
	}

	@Override
	protected void startState(Event event) {
		Sound.beep();
		Sensors.getInstance().getPilot().rotate(45);
		Sensors.getInstance().getLightSensor().setFloodlight(Color.RED);	
	}

	@Override
	protected void endState(Event event) {
		Sensors.getInstance().getPilot().stop();
	}

}
