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
	
	public void perform(Event event){
		perform(event, null);
	}
	
	public State perform(Event event, State previousState){
		if(previousState != null){
			previousState.exit(event);
		}
		this.target.enter(event);
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
