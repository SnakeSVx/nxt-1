package be.svx.nx4.oldstate.states;

import lejos.robotics.Color;
import be.svx.base.Event;
import be.svx.nx4.controls.Sensors;
import be.svx.nx4.events.AproachingObstacleEvent;
import be.svx.nx4.oldstate.base.State;

public class MoveForwardState extends State {

	private boolean active;
	
	public MoveForwardState() {
		super("ForwardState");
		active = false;
	}

	@Override
	protected boolean isAcceptableEvent(Event event) {
		if(event instanceof AproachingObstacleEvent){
			AproachingObstacleEvent ev = (AproachingObstacleEvent)event;
			return ev.getDistance() > 10;
		}
		return false;
	}

	@Override
	protected void startState(Event event) {
		if(!active){
			active = true;
			Sensors.getInstance().getLightSensor().setFloodlight(Color.GREEN);
			Sensors.getInstance().getPilot().forward();	
		}
			
	}

	@Override
	protected void endState(Event event) {
		if(active){
			Sensors.getInstance().getPilot().stop();	
			active = false;
		}
	}
	
	

}
