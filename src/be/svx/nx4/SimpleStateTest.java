package be.svx.nx4;

import java.util.ArrayList;
import java.util.List;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;

import be.svx.base.Event;
import be.svx.nx4.controls.Sensors;
import be.svx.nx4.events.AproachingObstacleEvent;
import be.svx.nx4.events.ButtonPressedEvent;
import be.svx.nx4.oldstate.base.State;
import be.svx.nx4.oldstate.base.StateMachine;
import be.svx.nx4.oldstate.states.DoNothingState;
import be.svx.nx4.oldstate.states.MoveForwardState;
import be.svx.nx4.oldstate.states.NearCollisionState;
import be.svx.nx4.oldstate.states.TerminatingState;

public class SimpleStateTest {
	
	public SimpleStateTest(){
		List<State> states = new ArrayList<State>();
		states.add(new DoNothingState());
		states.add(new MoveForwardState());
		states.add(new NearCollisionState());
		states.add(new TerminatingState());
		
		List<State> terminatingStates = new ArrayList<State>();
		terminatingStates.add(states.get(3));
		
		final StateMachine stateMachine = new StateMachine(states, states.get(1), terminatingStates);
		stateMachine.start();
		
		Button.ENTER.addButtonListener(new ButtonListener(){

			@Override
			public void buttonPressed(Button b) {
				Event event = new ButtonPressedEvent(b);
				stateMachine.event(event);				
			}

			@Override
			public void buttonReleased(Button b) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		Thread thread = new Thread(){
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
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      }
		    }
		};
		thread.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
