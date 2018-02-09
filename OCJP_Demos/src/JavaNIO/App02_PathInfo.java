package JavaNIO;

import java.io.IOException;
import java.nio.file.*;

//To ilustrate important methods such as normalize(), toAbsolutePath(), and toRelativePath()
public class App02_PathInfo {

	public static void main(String[] args) throws IOException {
		//get a path object with relative path
		Path testFilePath = Paths.get(".\\Test");
		System.out.println("The file name is: "+testFilePath.getFileName());
		System.out.println("It's URI is: "+testFilePath.toUri());
		System.out.println("TIt's absolute path is: "+testFilePath.toAbsolutePath());
		System.out.println("It's normalize path is: "+testFilePath.normalize());
		
		//get another path object with normalized relative path
		Path testPathNormalized = Paths.get(testFilePath.normalize().toString());
		System.out.println("It's normalized absolute path is: \t"+ testPathNormalized.toAbsolutePath());
		System.out.println("It's normalized real path is: \t\t" +
		testFilePath.toRealPath(LinkOption.NOFOLLOW_LINKS));
		
		Path dirName = Paths.get("F:\\my Apps\\Java\\OCJP_Examples");
		Path resolvedPath = dirName.resolve("Test");
		System.out.println("Resolved Path: "+ resolvedPath);
	}

}
