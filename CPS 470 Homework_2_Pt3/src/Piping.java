//Piping.java, Authors: John deGuise/Jon Ragon, Prof: Dr. Dharam, CPS 470 Spring 2016, 2/8/16

//program prompts for input, writes input to a text file, which is used as an argument in the processbuilder
//processbuilder builds a command as a child process to pipe output with reversed casing

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
			
			//writing argument to a file to use as a filearg
			pw.write(input);
			pw.close();
			
			//building process command based on bash shell, string flag, file type
			//piped catted input goes to translate modifiers to swap case
			String[] cmd = {"/bin/sh", "-c", "cat " + initial_input + " | tr 'a-zA-Z' 'A-Za-z'"};

			
			ProcessBuilder pb2 = new ProcessBuilder(cmd);

			//Requires Java7+, ProcessBuilder has an API for redirecting output/error
			pb2.redirectOutput(Redirect.INHERIT);
			pb2.redirectError(Redirect.INHERIT);

			//create second process (child) that will comp the proper case swaps, and print the result
			Process p = pb2.start();
			sc.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
