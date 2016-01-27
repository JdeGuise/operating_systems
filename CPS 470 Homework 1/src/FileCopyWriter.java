

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileCopyWriter {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		// Acquire Input File Name
		Scanner sc = new Scanner(System.in);
		
		String input0;
		String input1;
		
		// Write Prompt to Screen: src
		System.out.println("Enter src: ");
		
		// Accept src input
		input0 = sc.nextLine();
		
		// Initialize File for srcFile
		File srcFile = new File(input0);
		Scanner src = new Scanner(srcFile);

		// Write Prompt to Screen: dst
		System.out.println("Enter dst: ");
		
		// Accept dst input
		input1 = sc.nextLine();
		
		// If file doesn't exist, abort
		if(!srcFile.exists()){
			System.out.println("Source file does not exist.  Aborting.");
			System.exit(0);
		}

		// Create output file
		File dstFile = new File(input1);
		
		//throws IOException if file already exists (if exists abort)
		dstFile.createNewFile();
		PrintWriter pw = new PrintWriter(dstFile);

		// Loop
		while(src.hasNextLine()){
			pw.write(src.nextLine() + "\n");
		}
		pw.close();
		sc.close();
		src.close();
		
		System.out.println("Copy completed.  Terminating.");
	}

}
