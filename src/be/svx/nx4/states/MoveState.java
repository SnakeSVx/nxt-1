package be.svx.nx4.states;

import lejos.robotics.Color;
import be.svx.base.Event;
import be.svx.base.State;
import be.svx.nx4.controls.Sensors;

public class MoveState extends State {

	public MoveState() {
		super("MoveState");
	}

	@Override
	public void enter(Event event) {
		this.setActive(true);
		Sensors.getInstance().getLightSensor().setFloodlight(Color.GREEN);
		Sensors.getInstance().getPilot().forward();	
	}

	@Override
	public void exit(Event event) {
		Sensors.getInstance().getPilot().stop();	
		this.setActive(false);
	}

}
