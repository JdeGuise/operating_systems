import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.util.Scanner;

public class Piping {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		File initial_input = new File("input.txt");
		String input = "";			

		try {
			PrintWriter pw = new PrintWriter(initial_input);

			System.out.println("Enter phrase to be reverse cased");
						
			input = sc.nextLine();
			
			//writing argument to a file
			pw.write(input);
			pw.close();
			
			//building process command based on bash shell, string flag, file type
			//piped catted input goes to translate modifiers to swap case
			String[] cmd = {"/bin/sh", "-c", "cat " + initial_input + " | tr 'a-zA-Z' 'A-Za-z'"};

			
			ProcessBuilder pb = new ProcessBuilder(cmd);
			
			//Requires Java7+
			pb.redirectOutput(Redirect.INHERIT);
			pb.redirectError(Redirect.INHERIT);

			Process p = pb.start();
			sc.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
