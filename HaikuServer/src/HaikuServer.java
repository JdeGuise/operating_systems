import java.io.*;
import java.net.*;
import java.util.*;

public class HaikuServer extends Thread  {
	
	static Map<Integer, String> haikuList = new HashMap<Integer, String>();
	static int count;

	public static void main(String argv[]) throws FileNotFoundException {
		//Server asks for filepath. 
		Scanner in = new Scanner(System.in);
		System.out.println("Please provide the full path to the haiku storage:\n");
		String path = in.next();
		
		//Generates the list of possible haikus to output from designated file. Does not check if haiku is valid
		renderHaikuList(path);
		
		
		Thread thread = new Thread() { 
			@Override
			public void run(){ 
				try {
					@SuppressWarnings("resource")
					ServerSocket serverSocket = new ServerSocket(5575);
					System.out.println(new Date() + ": Server started at socket 5575");
					
					//listen for connection
					while (true) {
						Socket haikuRequest = serverSocket.accept();
						
						//fetches the output stream for the client
						PrintWriter pout = new PrintWriter((haikuRequest).getOutputStream(), true);
						String haiku = returnHaiku();
						pout.println(haiku);//prints a randomly selected haiku
						System.out.println(new Date() + ": Server provided\n" + haiku + "to client. Resetting for new connection.");
						
						haikuRequest.close();
					}
					
				} catch (IOException ex) {
					ex.printStackTrace();	
				}	
			}
		};
		thread.start();
	}
	
	//method to generate the haiku list from a text file provided by the server on launch
	public static void renderHaikuList(String filePath) throws FileNotFoundException{
		
		
		Scanner haikusIn = new Scanner(new FileReader(filePath));
		count = 0;
		while(haikusIn.hasNextLine()){
			String haiku = "\t" + haikusIn.nextLine() + "\n\t" + haikusIn.nextLine() + "\n\t" + haikusIn.nextLine() + "\n";
			haikuList.put(count, haiku);

			count++;
		}
		haikusIn.close();
	}
	
	//method to return a random haiku string from the global list of haikus
	public static String returnHaiku(){
		int selectedHaiku = (int) ((Math.random()) * count);
		return haikuList.get(selectedHaiku);
		
	}
	
}
