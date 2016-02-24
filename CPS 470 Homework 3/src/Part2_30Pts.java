//Part2_30Pts, John deGuise/Jon Ragon, CPS 470, 2-3:15 T/TH, Due 2/29 by 11:59PM

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

//Design an echo server using Java threading API
// server is single threaded
//		meaning that server cannot respond to concurrent echo clients until the current exits
//	Modify solution to Exercise 3.25 so that the echo server services each client
//  in separate requests

//Part2_30Pts.java, John deGuise/Jon Ragon, CPS 470 2-3:15 T/TH, Due 2/25 by 11:59PM
public class Part2_30Pts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread thread = new Thread() { 
			@Override
			public void run(){ 
				try {
					@SuppressWarnings("resource")
					ServerSocket sock = new ServerSocket(5575);
					System.out.println(new Date() + ": Server started at socket 5575");
					
					//listen for connection
					while (true) {
						Socket client = sock.accept();
						BufferedReader pin = new BufferedReader(new InputStreamReader(client.getInputStream()));
						//fetches the output stream for the client
						PrintWriter pout = new PrintWriter((client).getOutputStream(), true);
						String strToEcho = pin.readLine();
						
						
						pout.println(strToEcho);
						System.out.println(new Date() + ": Echoed --- " + strToEcho);
						client.close();
					}
					
				} catch (IOException ex) {
					ex.printStackTrace();	
				}	
			}
		};
		thread.start();

//		Thread thread = new Thread() { 
//			@Override
//			public void run(){ 
//				try {
//					@SuppressWarnings("resource")
//					ServerSocket serverSocket = new ServerSocket(5575);
//					System.out.println(new Date() + ": Server started at socket 5575");
//					
//					//listen for connection
//					while (true) {
//						Socket haikuRequest = serverSocket.accept();
//						
//						//fetches the output stream for the client
//						PrintWriter pout = new PrintWriter((haikuRequest).getOutputStream(), true);
//						String haiku = returnHaiku();
//						pout.println(haiku);//prints a randomly selected haiku
//						System.out.println(new Date() + ": Server provided\n" + haiku + "to client. Resetting for new connection.");
//						
//						haikuRequest.close();
//					}
//					
//				} catch (IOException ex) {
//					ex.printStackTrace();	
//				}	
//			}
//		};
//		thread.start();
	}



}
