package controller;

import model.interfaces.ICommand;

public class redoCommand implements ICommand {

	@Override
	public void run() {
		CommandHistory.redo();
		
	}

}
