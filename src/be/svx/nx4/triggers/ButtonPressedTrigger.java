package be.svx.nx4.triggers;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import be.svx.base.Event;
import be.svx.base.StateMachine;
import be.svx.nx4.events.ButtonPressedEvent;

public class ButtonPressedTrigger {

	public ButtonPressedTrigger(Button pressed, final StateMachine stateMachine) {
		pressed.addButtonListener(new ButtonListener(){

			@Override
			public void buttonPressed(Button b) {
				Event event = new ButtonPressedEvent(b);
				stateMachine.event(event);				
			}

			@Override
			public void buttonReleased(Button b) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

}
