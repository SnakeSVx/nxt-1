package be.svx.nx4.triggers;

import be.svx.base.Event;
import be.svx.base.StateMachine;
import be.svx.nx4.controls.Sensors;
import be.svx.nx4.events.AproachingObstacleEvent;

public class ObjectDetectedTrigger extends Thread {

	private StateMachine stateMachine;
    private int timeout;

    public ObjectDetectedTrigger(StateMachine stateMachine){
        this(stateMachine, 100);
    }
	
	public ObjectDetectedTrigger(StateMachine stateMachine, int timeout){
		this.stateMachine = stateMachine;
		this.start();
	}

	public void run()
    {
      while (stateMachine.isActive())
      {
        //FIND HIGHEST PRIORITY BEHAVIOR THAT WANTS CONTROL
        synchronized (this)
        {
        	int distance = Sensors.getInstance().getUltrasonicSensor().getDistance();
        	if(distance < 255){
        		Event event = new AproachingObstacleEvent(distance);
				stateMachine.event(event);	
        	}
        }// end synchronize block - main thread can run now
        try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			//TODO do something
		}
      }
    }

}
