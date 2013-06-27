package be.svx.base;

import java.util.ArrayList;
import java.util.List;

import be.svx.nx4.controls.Sensors;

import lejos.util.DebugMessages;

public abstract class State extends BaseInfo {
	
	private List<Transition> transitions;
	private DebugMessages debug;
	private boolean endState;
	private boolean active;
	
	public State(String name) {
		this(name, "");		
	}
	
	public State(String name, boolean endState) {
		this(name, "", endState);
		
	}
	
	public State(String name, String description) {
		this(name, description, false);
	}
	
	public State(String name, String description, boolean endState) {
		super(name, description);
		transitions = new ArrayList<Transition>();
		this.debug = Sensors.getInstance().getDebug();
		this.endState = endState;
		this.active = false;
	}
	
	public abstract void enter(Event event, Session session);
	public abstract void exit(Event event, Session session);
	
	public void addTransition(Transition transition){
		transitions.add(transition);
	}
	
	public Transition findTransition(Event event){
		Transition transition = null;
		for(Transition t : transitions){
			if(t.isApplicable(event)){
				transition = t;
				break;
			}
		}
		return transition;
	}

	protected List<Transition> getTransitions() {
		return transitions;
	}

	protected DebugMessages getDebug() {
		return debug;
	}

	public boolean isEndState() {
		return endState;
	}

	protected void setActive(boolean active) {
		this.active = active;
	}

	public boolean isActive() {
		return active;
	}	

}
