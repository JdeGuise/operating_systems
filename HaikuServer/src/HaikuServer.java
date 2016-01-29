import java.io.*;
import java.net.*;
import java.util.Date;

import javafx.application.*;

public class HaikuServer extends Thread  {
	
	public void start(){
		Thread thread = new Thread() { 
			@Override
			public void run(){ 
			try {
				ServerSocket serverSocket = new ServerSocket(5575);
				Platform.runLater(() -> System.out.println(new Date() + ": Server started at socket 5575"));
				
				//listen for connection
				while (true) {
					
				}
				
			} catch (IOException ex) {
					ex.printStackTrace();
				
			}
				
				
			}
		};
		thread.start();
	}
	
}
