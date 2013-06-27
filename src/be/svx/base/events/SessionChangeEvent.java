package be.svx.base.events;

import be.svx.base.Event;
import be.svx.base.Session;

public class SessionChangeEvent extends Event {

	private Session session;
	private String variableName;
	private Object variableValue;
	
	public SessionChangeEvent(Session session, String variableName, Object variableValue) {
		super("SessionChangeEvent");
		this.session = session;
		this.variableName = variableName;
		this.variableValue = variableValue;
	}

	public Session getSession() {
		return session;
	}

	public String getVariableName() {
		return variableName;
	}

	public Object getVariableValue() {
		return variableValue;
	}
	
	

}
