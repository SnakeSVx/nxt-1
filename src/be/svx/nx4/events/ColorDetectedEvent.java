package be.svx.nx4.events;

import lejos.nxt.ColorSensor;
import be.svx.base.Event;

public class ColorDetectedEvent extends Event {

	private ColorSensor.Color color;
	
	public ColorDetectedEvent(ColorSensor.Color color) {
		super("ColorDetectedEvent");
		this.color = color;
	}

	public ColorSensor.Color getColor() {
		return color;
	}

}
