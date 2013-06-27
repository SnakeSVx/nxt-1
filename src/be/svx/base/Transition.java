package be.svx.base;

import lejos.util.DebugMessages;
import be.svx.nx4.controls.Sensors;

public abstract class Transition extends BaseInfo {

	private State target;
	private State source;
	private DebugMessages debug;
	
	public Transition(String name, State source, State target) {
		this(name, "", source, target);
	}
	
	public Transition(String name, String description, State source, State target) {
		super(name, description);
		this.target = target;
		this.source = source;
		this.debug = Sensors.getInstance().getDebug();
	}
	
	public abstract boolean isApplicable(Event event);
	
	public State perform(Event event, Session session){
		if(source != null){
			source.exit(event, session);
		}
		this.target.enter(event, session);
		return this.target;
	}

	protected State getTarget() {
		return target;
	}

	protected DebugMessages getDebug() {
		return debug;
	}

	protected State getSource() {
		return source;
	}
	
	
	
	
	

}
