import java.io.*;
import java.net.*;

import java.util.*;

import javafx.application.*;

public class HaikuServer extends Thread  {
	static Map<Integer, String> haikuList = new HashMap<Integer, String>();
	static int count;

	public static void main(String argv[]) throws FileNotFoundException {
		renderHaikuList();
		Thread thread = new Thread() { 
			@Override
			public void run(){ 
			try {
				ServerSocket serverSocket = new ServerSocket(5575);
				System.out.println(new Date() + ": Server started at socket 5575");
				
				//listen for connection
				while (true) {
					Socket haikuRequest = serverSocket.accept();
					
					PrintWriter pout = new PrintWriter((haikuRequest).getOutputStream(), true);//writeInt was documented)
					String haiku = returnHaiku();
					pout.println(haiku);//prints a haiku
					System.out.println(new Date() + ": Server provided\n" + haiku + "to client. Resetting for new connection.");
					
					haikuRequest.close();
				}
				
			} catch (IOException ex) {
				System.out.println("testttt");
					ex.printStackTrace();
				
			}
				
				
			}
		};
		thread.start();
	}
	
	public static void renderHaikuList() throws FileNotFoundException{
		Scanner haikusIn = new Scanner(new FileReader("haikus.txt"));
		count = 0;
		while(haikusIn.hasNextLine()){
			String haiku = "\t" + haikusIn.nextLine() + "\n\t" + haikusIn.nextLine() + "\n\t" + haikusIn.nextLine() + "\n";
			haikuList.put(count, haiku);

			count++;
		}
		haikusIn.close();
	}
	public static String returnHaiku(){
		int range = count;
		int selectedHaiku = (int) ((Math.random()) * count);
		return haikuList.get(selectedHaiku);
		
	}
	
}
