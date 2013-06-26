package be.svx.nx4.transitions;

import be.svx.base.Event;
import be.svx.base.State;
import be.svx.base.Transition;
import be.svx.nx4.events.AproachingObstacleEvent;

public class ObjectDetectedTransition extends Transition {

	private int distance;
	
	public ObjectDetectedTransition(int distance, State source, State target) {
		super("ObjectDetectedTransition", source, target);
		this.distance = distance;
	}

	@Override
	public boolean isApplicable(Event event) {
		if(event instanceof AproachingObstacleEvent){
			AproachingObstacleEvent ev = (AproachingObstacleEvent)event;
			return ev.getDistance() <= distance;
		}
		return false;
	}

}
