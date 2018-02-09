package javaio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadWriteTextFile {
	
	private static String description=""
			+ "Read a text file, show it in console, and write it back with\n"
			+ " another name";
	
	private String source, dest;

	public static void main(String[] args) {
		ReadWriteTextFile myApp = new ReadWriteTextFile();
		myApp.introduction();
		myApp.readParameters();
		myApp.ReadAndWrite(myApp.source, myApp.dest);
	}
	
	private void introduction() {
		System.out.println(description);
	}

	public void readParameters() {
		Scanner scanner = new Scanner (System.in);
		System.out.print ("Source file: ");
		source = scanner.nextLine();		
		System.out.print("\nDestination file:");
		dest = scanner.nextLine();
		scanner.close();
	}
	
	public void ReadAndWrite (String i, String o){
		FileReader fr=null;
		BufferedReader br=null;
		
		FileWriter fw=null;
		BufferedWriter bw=null;
		
		try {
		File iFile = new File (i);
		File oFile = new File (o);
		 fr = new FileReader (iFile);
		 br = new BufferedReader(fr);
		 
		 fw = new FileWriter (oFile);
		 bw = new BufferedWriter (fw);	
		 
		 PrintWriter printWriter = new PrintWriter (bw);
		 
		 String line;
		 while ( (line=br.readLine()) != null){
			 System.out.println(line);			 
			 printWriter.println(line);
		 }
		 
		 if (fr!=null) fr.close();
		 if (fw!=null) fw.close();
		 if (br!=null) br.close();		
		 
		} catch (IOException e){
			e.printStackTrace();
		} finally {
		  
		  
		}
	}
	
	public void ReadAndWrite_v2 () {
	}
	
}
