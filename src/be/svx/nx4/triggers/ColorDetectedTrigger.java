package be.svx.nx4.triggers;

import lejos.nxt.ColorSensor;
import lejos.nxt.ColorSensor.Color;
import be.svx.base.Event;
import be.svx.base.StateMachine;
import be.svx.nx4.controls.Sensors;
import be.svx.nx4.events.ColorDetectedEvent;

public class ColorDetectedTrigger extends Thread {

	private StateMachine stateMachine;
    private int timeout;
    private ColorSensor.Color color;

    public ColorDetectedTrigger(StateMachine stateMachine){
        this(stateMachine, 100);
    }
	
	public ColorDetectedTrigger(StateMachine stateMachine, int timeout){
		this.stateMachine = stateMachine;
		this.start();
	}
	
	//TODO equals check in base class of lejos?
	private boolean sameColor(Color color1, Color color2){		
		return color1 != null 
				&& color2 != null 
				&& color1.getRed() == color2.getRed() 
				&& color1.getGreen() == color2.getGreen()
				&& color1.getBlue() == color2.getBlue();
	}
	

	public void run()
    {
      while (stateMachine.isActive())
      {
        //FIND HIGHEST PRIORITY BEHAVIOR THAT WANTS CONTROL
        synchronized (this)
        {
        	Color c1 = Sensors.getInstance().getLightSensor().getColor();
        	if(!sameColor(c1, this.color)){
        		this.color = c1;
        		Event event = new ColorDetectedEvent(this.color);
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
