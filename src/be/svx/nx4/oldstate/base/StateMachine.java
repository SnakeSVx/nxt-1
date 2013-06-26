package be.svx.nx4.oldstate.base;

import java.util.List;

import be.svx.base.Event;
import be.svx.nx4.controls.Sensors;
import be.svx.nx4.events.StartEvent;
import be.svx.nx4.events.TransitionEvent;

public class StateMachine {
	
	private List<State> states;
	private State startState;
	private List<State> endStates;
	
	private State currentState;
	private boolean started;
	
	public StateMachine(List<State> states, State startState, List<State> endStates){
		this.states = states;
		this.startState = startState;
		this.endStates = endStates;
		
		this.currentState = this.startState;
		this.started = false;
	}
	
	public void start(){
		if(!this.started){
			Sensors.getInstance().getDebug().echo("START " + this.currentState.getName());
			this.currentState.startState(new StartEvent());
			this.started = true;
		}
	}
	
	public void gotoState(State state){
		if(isActive() && started){
			Event event = new TransitionEvent();
			gotoState(state, event);
		}
	}
	
	private void gotoState(State state, Event event){
		if(isActive() && started){
			if(!this.currentState.equals(state)){
				Sensors.getInstance().getDebug().echo("END " + this.currentState.getName());
				this.currentState.endState(event);
				this.currentState = state;
			}
			Sensors.getInstance().getDebug().echo("START " + this.currentState.getName());
			this.currentState.startState(event);
		}
	}
	
	public void event(Event event){
		if(isActive() && started){
			boolean foundState = false;
			Sensors.getInstance().getDebug().echo("EVENT " + event.getName());
			for(State state : states){
				if(state.isAcceptableEvent(event)){
					gotoState(state, event);
					foundState = true;
					if(endStates.contains(state)){
						this.currentState = null;
					}
					break;
				}
			}
			if(!foundState){
				gotoState(this.startState, null);
			}
		}
	}
	
	public boolean isActive(){
		return this.currentState != null;
	}

}
