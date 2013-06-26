package be.svx.base;

import java.util.List;

import be.svx.nx4.controls.Sensors;

import lejos.util.DebugMessages;

public final class StateMachine {
	
	private List<State> states;
	private State currentState;
	private DebugMessages debug;
	
	public StateMachine(List<State> states, State initialState) {
		super();
		this.states = states;
		this.currentState = initialState;
		this.debug = Sensors.getInstance().getDebug();
	}
	
	public void event(Event event){
		if(isActive()){			
			debug.echo("[EVENT] " + event.getName());
			Transition t = this.currentState.findTransition(event);
			if(t != null && states.contains(t.getTarget())){
				this.currentState = t.perform(event, this.currentState);
			}
		}
	}
	
	public boolean isActive(){
		return this.currentState != null && !this.currentState.isEndState();
	}
	
}
