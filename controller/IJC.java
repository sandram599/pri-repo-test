package controller;

import java.io.IOException;

public class IJC {
	
	public void process(ICommand command) {
		command.run();
	}

}
