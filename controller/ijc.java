package controller;

import java.io.IOException;

public class IJC {
	
	public void process(IJCommand command) {
		command.execute();
	}

}
