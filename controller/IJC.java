package controller;

import java.io.IOException;

import model.interfaces.ICommand;

public class IJC {
	
	public void process(ICommand command) {
		command.run();
	}

}