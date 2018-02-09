package JavaNIO;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
// static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
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

public class Question09 {

	public static void main(String[] args) {
		Path dir = Paths.get("F:\\my Apps");
		
			try {
				WatchService watch = dir.getFileSystem().newWatchService();
				dir.register(watch,ENTRY_MODIFY, ENTRY_CREATE);
				
				WatchKey key = watch.poll(10000, TimeUnit.MILLISECONDS);
				List<WatchEvent<?>> events = key.pollEvents();
				
				for (WatchEvent<?> event:events){
					if (event.kind() == ENTRY_CREATE){
						System.out.println("A File Created");
					}
					if (event.kind() == ENTRY_MODIFY){
						System.out.println("A File Modified");
					}					
				}
				
			}catch (ClosedWatchServiceException e){
				System.out.println("Error");
				
			}catch (IOException e){
				System.out.println("Error");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
	}
}

/*
 * Note: assume that the I:\whizlabs actually exists and contain files and
 * directories and you have enough permission
 *
 * Which is true?
 * 
 * 
 */


