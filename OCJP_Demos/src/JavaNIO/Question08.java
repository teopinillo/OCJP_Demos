package JavaNIO;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.IOException;
import java.nio.file.ClosedWatchServiceException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Question08 {

	public static void main(String[] args) {
		Path dir = Paths.get("F:\\my Apps");
		for (;;){
			try {
				WatchService watch = dir.getFileSystem().newWatchService();
				dir.register(watch, ENTRY_DELETE, ENTRY_MODIFY, ENTRY_CREATE);
				WatchKey key = watch.poll(10000, TimeUnit.MILLISECONDS);
				List<WatchEvent<?>> events = key.pollEvents();
				
				for (WatchEvent<?> event:events){
					if (event.kind() == ENTRY_CREATE){
						System.out.println("A File Created");
					}
					if (event.kind() == ENTRY_DELETE){
						System.out.println("A File Deleted");
					}
					if (event.kind() == ENTRY_MODIFY){
						System.out.println("A File Modified");
					}
					
				}
			}catch (ClosedWatchServiceException e){
				System.out.println("error 1");
				
			}catch (InterruptedException e){
				System.out.println("error 2");
			}
			catch (IOException e){
				System.out.println("error 3");
			}
			
		}
	}

}

/*
 * Note: assume that the F:\my Apps actually exists and contain files and directories and you have enough permission.
 * 
 * Which will be the result, if we didn't apply any change on the directory or its's files and sub directories, after the 
 * above program start to run?
 * 
 * Please select:
 * 
 * A. No output will be provided and program keeps running.
 * B. After 10 seconds the program will print "Error 1" as the output and it will be printed continuously with 10 seconds interval.
 * C. After 10 seconds the program will print "Error 2" as the output and it will be printed continuously with 10 seconds interval.
 * D. After 10 seconds the program will print "Error 3" as the output and it will be printed continuously with 10 seconds interval.
 * E. After 10 seconds the program will throw an uncaught exception and program will exit;
 * 
 * 
*/
