package javaio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class InputOutputStream {

	public static void main(String[] args) {
		File iF = new File ("f:\\temp\\text_files\\thewaysoflifebook.txt");
		File oF = new File ("f:\\temp\\stream_files\\thewaysoflifebook.txt");
		
		try {
		FileInputStream istream = new FileInputStream (iF);
		FileOutputStream ostream = new FileOutputStream (oF);
		
		int i;
		int c=0;
		
		while ((i=istream.read()) !=-1 ){
			byte [] bytes = ByteBuffer.allocate(4).putInt(i).array();
			for (Byte b: bytes){
				System.out.printf("%02X ", b);
			}	
			if (++c>8){
				c=0;
				System.out.println();
			}
		}
		
		istream.close();
		ostream.close();
		
		}catch (IOException e){
			e.printStackTrace();
		}
		
		System.out.println("Program ends");
	}

}
