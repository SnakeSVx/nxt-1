package be.svx.nx4;

import java.util.ArrayList;
import java.util.List;

import lejos.nxt.Button;

import be.svx.base.Event;
import be.svx.base.State;
import be.svx.base.StateMachine;
import be.svx.nx4.states.ExitState;
import be.svx.nx4.states.InitialState;
import be.svx.nx4.states.MoveState;
import be.svx.nx4.states.TurnState;
import be.svx.nx4.transitions.ButtonPressedTransition;
import be.svx.nx4.transitions.ObjectDetectedTransition;
import be.svx.nx4.transitions.ObjectFurtherThenTransition;
import be.svx.nx4.triggers.ButtonPressedTrigger;
import be.svx.nx4.triggers.ObjectDetectedTrigger;

public class NewStateTest {
	
	public NewStateTest(){
		//Setup States
		State initialState = new InitialState();
		State moveState = new MoveState();
		State turnRightState = new TurnState(90);
		State exitState = new ExitState();
		
		//Setup Transitions
		
		initialState.addTransition(new ButtonPressedTransition(Button.ENTER, initialState, moveState));
		initialState.addTransition(new ButtonPressedTransition(Button.ESCAPE, initialState, exitState));
		
		moveState.addTransition(new ObjectDetectedTransition(20, moveState, turnRightState));
		moveState.addTransition(new ButtonPressedTransition(Button.ESCAPE, moveState, exitState));
		
		turnRightState.addTransition(new ObjectDetectedTransition(20, turnRightState, turnRightState){

			@Override
			public boolean isApplicable(Event event) {
				return !getTarget().isActive() && super.isApplicable(event);
			}
			
		});
		turnRightState.addTransition(new ObjectFurtherThenTransition(20, turnRightState, moveState){
			@Override
			public boolean isApplicable(Event event) {
				return !getSource().isActive() && super.isApplicable(event);
			}
		});
		turnRightState.addTransition(new ButtonPressedTransition(Button.ESCAPE, turnRightState, exitState));
				
		//Setup StateMachine
		List<State> validStates = new ArrayList<State>();
		validStates.add(initialState);
		validStates.add(moveState);
		validStates.add(turnRightState);
		validStates.add(exitState);
		
		StateMachine stateMachine = new StateMachine(validStates, initialState);
		
		//Setup triggers
		new ButtonPressedTrigger(Button.ESCAPE, stateMachine);
		new ButtonPressedTrigger(Button.ENTER, stateMachine);
		new ObjectDetectedTrigger(stateMachine);
	}
}
