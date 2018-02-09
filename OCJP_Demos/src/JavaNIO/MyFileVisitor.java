package JavaNIO;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileVisitor <Path> extends SimpleFileVisitor<Path> {
		
	private String message;
	
	MyFileVisitor (){				
		message="";
	}
	
	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exx){
		message+="\n[]--> "+dir.toString();		
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs){
		message+="\n-->[] "+dir.toString();		
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFile (Path file, BasicFileAttributes attrs){		
		message+="\n--><> "+file.toString();	
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFileFailed (Path file, IOException ex){		
		message+="\nERROR: "+file.toString()+" "+ex.getMessage();
		return FileVisitResult.CONTINUE;
	}
	
	public String getVisitorMessage(){
		return message;
	}
}
