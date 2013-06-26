package be.svx.nx4.events;

import be.svx.base.Event;


public class AproachingObstacleEvent extends Event {
	
	private int distance;

	public AproachingObstacleEvent(int distance){
		super("AproachingObstacleEvent");
		this.distance = distance;
	}
	
	public int getDistance(){
		return this.distance;
	}
}
