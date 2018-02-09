package JavaNIO;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
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

public class Question10 {

	public static void main(String[] args) {
		Path dir = Paths.get("F:\\my Apps");
		
		try {
			WatchService watch = dir.getFileSystem().newWatchService();
			dir.register(watch);
			
			WatchKey key = watch.take();
			List<WatchEvent<?>> events = key.pollEvents();
			
			for (WatchEvent<?> event:events){
				if (event.kind() == ENTRY_CREATE){
					System.out.println("A File Created");
				}
				if (event.kind() == ENTRY_MODIFY){
					System.out.println("A File Modified");
				}					
			}
			
		}catch (InterruptedException e){
			System.out.println("Interrupted");
			
		}catch (IOException e){
			System.out.println("IOE");
		}


	}

}

//Note: asume that the path actually exists and contain files and directories
//and you have enough permission.

/*
Which is true?

A- If we delete a file or directory in the dir path when the program is running, "A File Delete" will be printed
as the outuput.

B- If we modify a file or directory in the dir path when the program is running, "A File Modify" will be printed
as the outuput.

C-Interrupted is printed as the output

D- An uncaught exception is thrown at the runtime

E-Compilation fails.
*/