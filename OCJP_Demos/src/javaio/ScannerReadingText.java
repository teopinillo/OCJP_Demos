package javaio;
import static javaio.Parameters.param1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScannerReadingText {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader (param1);
		Scanner scanner = new Scanner (fr);
		while ( scanner.hasNext()){
			System.out.println (scanner.nextLine());
		}
		scanner.close();
		fr.close();
	}

}
