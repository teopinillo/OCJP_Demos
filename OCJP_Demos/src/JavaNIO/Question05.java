package JavaNIO;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;



public class Question05 {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("F:\\my Apps");
		FileVisitor<Path> searcher = new Search();
		Files.walkFileTree(path, searcher);
		
		Map <String,Object> m;
		 m = Files.readAttributes (path, "*");
		 long size = (long) m.get("size");
		 
	}

	private static final class Search extends SimpleFileVisitor<Path>
	{
		
		public FileVisitResult visitFile (Path file, BasicFileAttributes bfa) throws IOException {
			PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*");
		    if (matcher.matches(file.getFileName()))
		    	System.out.println(file);		    
		    return FileVisitResult.CONTINUE;
		}
	
	}

}

/*
 * Note: assume that the I:\whizlabs actually exists and contain files and
 * directories and you have enough permission.
 * 
 * What is the result
 * 
 * Please select:
 * 
 * A-Completation succeeds and prints the paths of all the files and the subdirectories
 *   which are located in the whizlabs directory.
 * 
 *B-Completation succeds and prints only the path of the files and sub directories of the "whizlabas: directory
 *
 *C-Completation succeeds and prints only the paths of all the files which are located in the "whizlabs" directory and its
 *  sub directories.
 *  
 *D- AN exception  will be throwsn at runtime
 *
 *E-Compilation Fails
 */
