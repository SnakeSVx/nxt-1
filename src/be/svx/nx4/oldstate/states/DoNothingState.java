package be.svx.nx4.oldstate.states;

import lejos.robotics.Color;
import be.svx.base.Event;
import be.svx.nx4.controls.Sensors;
import be.svx.nx4.oldstate.base.State;

public class DoNothingState extends State {

	public DoNothingState() {
		super("DoNothingState");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean isAcceptableEvent(Event event) {
		return false;
	}

	@Override
	protected void startState(Event event) {
		Sensors.getInstance().getLightSensor().setFloodlight(Color.BLUE);
		
	}

	@Override
	protected void endState(Event event) {
		
	}

}
