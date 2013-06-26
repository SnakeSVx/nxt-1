package be.svx.nx4.transitions;

import lejos.nxt.Button;
import be.svx.base.Event;
import be.svx.base.State;
import be.svx.base.Transition;
import be.svx.nx4.events.ButtonPressedEvent;

public class ButtonPressedTransition extends Transition {

	private Button button;
	
	public ButtonPressedTransition(Button button, State source, State target) {
		super("ButtonPressedTransition", source, target);
		this.button = button;
	}

	@Override
	public boolean isApplicable(Event event) {
		if(event instanceof ButtonPressedEvent){
			ButtonPressedEvent ev = (ButtonPressedEvent)event;
			if(this.button.equals(ev.getButton())){
				return true;
			}
		}
		return false;
	}

}
