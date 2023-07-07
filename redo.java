package controller;

public class redo implements IJCommand {

	@Override
	public void execute() {
		CommandHistory.redo();
		
	}

}
