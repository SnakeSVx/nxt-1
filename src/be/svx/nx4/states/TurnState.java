package be.svx.nx4.states;

import lejos.nxt.Sound;
import lejos.robotics.Color;
import be.svx.base.Event;
import be.svx.base.Session;
import be.svx.base.State;
import be.svx.nx4.controls.Sensors;

public class TurnState extends State {

	private int angle;
	
	public TurnState(int angle) {
		super("NearCollisionState");
		this.angle = angle;
	}

	@Override
	public void enter(Event event, Session session) {
		this.setActive(true);
		Sensors.getInstance().getLightSensor().setFloodlight(Color.RED);
		Sound.beep();
		Sensors.getInstance().getPilot().rotate(angle);	
		this.setActive(false);
	}

	@Override
	public void exit(Event event, Session session) {
		Sensors.getInstance().getPilot().stop();
		this.setActive(false);
	}

}
