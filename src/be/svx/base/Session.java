package be.svx.base;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import be.svx.base.events.SessionChangeEvent;

public class Session {
	
	private List<StateMachine> stateMachines;
	private Hashtable<String, Object> values;
	
	public Session(StateMachine stateMachine){
		stateMachines = new ArrayList<StateMachine>();
		stateMachines.add(stateMachine);
		values = new Hashtable<String, Object>();
	}
	
	public Session(List<StateMachine> stateMachines){
		this.stateMachines = stateMachines;
		values = new Hashtable<String, Object>();
	}
	
	public void setVar(String name, Object value){
		values.put(name, value);
		Event event = new SessionChangeEvent(this, name, value);
		for(StateMachine machine : stateMachines){
			machine.event(event);
		}
	}
	
	public Object getVar(String name){
		return values.get(name);
	}

}
