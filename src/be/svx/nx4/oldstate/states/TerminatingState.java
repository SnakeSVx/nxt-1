package be.svx.nx4.oldstate.states;

import be.svx.base.Event;
import be.svx.nx4.events.ButtonPressedEvent;
import be.svx.nx4.oldstate.base.State;
import lejos.nxt.Button;

public class TerminatingState extends State {

	public TerminatingState() {
		super("TerminatingState");
		
	}

	@Override
	protected boolean isAcceptableEvent(Event event) {
		if(event instanceof ButtonPressedEvent){
			ButtonPressedEvent ev = (ButtonPressedEvent)event;
			if(Button.ENTER.equals(ev.getButton())){
				return true;
			}
		}
		return false;
	}

	@Override
	protected void startState(Event event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void endState(Event event) {
		// TODO Auto-generated method stub
		
	}

}
