package be.svx.nx4.states;

import be.svx.base.Event;
import be.svx.base.State;

public class ExitState extends State {

	public ExitState() {
		super("ExitState", true);
	}

	@Override
	public void enter(Event event) {}

	@Override
	public void exit(Event event) {}

}
