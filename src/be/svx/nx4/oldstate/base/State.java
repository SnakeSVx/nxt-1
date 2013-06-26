package be.svx.nx4.oldstate.base;

import be.svx.base.Event;

public abstract class State {
	

	private String name;
	private StateMachine machine;
	
	public State(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public StateMachine getMachine() {
		return machine;
	}

	public void setMachine(StateMachine machine) {
		this.machine = machine;
	}

	protected abstract boolean isAcceptableEvent(Event event);
	protected abstract void startState(Event event);
	protected abstract void endState(Event event);
	
	
	

}
