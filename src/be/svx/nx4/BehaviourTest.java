package be.svx.nx4;

import lejos.nxt.LCD;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import be.svx.nx4.behaviors.DetectWall;
import be.svx.nx4.behaviors.DoNothingBehavior;
import be.svx.nx4.behaviors.DriveForward;
import be.svx.nx4.behaviors.ShutdownBehavior;
import be.svx.nx4.controls.Sensors;

public class BehaviourTest {
	
	public BehaviourTest(){
		Behavior b1 = new DoNothingBehavior();
		Behavior b2 = new DriveForward();
        Behavior b3 = new DetectWall();
        Behavior b4 = new ShutdownBehavior();
        Behavior [] bArray = {b1, b2, b3, b4};
        Arbitrator arby = new Arbitrator(bArray, true);
        arby.start();
        Sensors.getInstance().getPilot().stop();
        LCD.drawString("Shutting", 0, 0);
	}

}
