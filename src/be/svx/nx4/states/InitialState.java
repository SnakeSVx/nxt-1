package be.svx.nx4.states;

import lejos.robotics.Color;
import be.svx.base.Event;
import be.svx.base.State;
import be.svx.nx4.controls.Sensors;

public class InitialState extends State {

	public InitialState() {
		super("InitialState");
	}

	@Override
	public void enter(Event event) {
		this.setActive(true);
		Sensors.getInstance().getLightSensor().setFloodlight(Color.BLUE);
	}

	@Override
	public void exit(Event event) {
		this.setActive(false);		
	}

}
