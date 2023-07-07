package controller;

public class undo implements IJCommand {
	
	@Override
	public void execute() {
		CommandHistory.undo();
	}

}
