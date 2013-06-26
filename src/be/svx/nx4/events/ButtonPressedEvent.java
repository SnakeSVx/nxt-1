package be.svx.nx4.events;

import be.svx.base.Event;
import lejos.nxt.Button;

public class ButtonPressedEvent extends Event {
	
	private Button button;

	public ButtonPressedEvent(Button b) {
		super("ButtonPressedEvent");
		this.button = b;
	}

	public Button getButton() {
		return button;
	}

}
