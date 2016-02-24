import java.net.*;
import java.io.*;
public class part2testclient {
	public static void main(String[] args){
		try{
			Socket sock = new Socket("127.0.0.1", 5575);
			InputStream in = sock.getInputStream();
			BufferedReader bin = new BufferedReader(new InputStreamReader(in));
			
			String line = "test echo me";
			PrintWriter pout = new PrintWriter(sock.getOutputStream(), true);
			pout.println(line);
			String received;
			while( (received = bin.readLine()) != null ){
				System.out.println("reeeceived: " + received);
			}
			sock.close();
		}
		catch (IOException ioe) {
			System.err.println(ioe);
		}
	}
}
