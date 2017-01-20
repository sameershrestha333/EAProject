/*package mum.edu.cs544.logging;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Handler;
import java.util.logging.LogManager;

import org.springframework.stereotype.Component;

@Component
public class Logger implements ILogger {
	private boolean anonymous;
	private volatile LogManager manager;
	private final CopyOnWriteArrayList<Handler> handlers = new CopyOnWriteArrayList<>();

	@Override
	public void log(String logstring) throws IOException {
		java.util.logging.Logger log = java.util.logging.Logger.getLogger("Shoping Store");
		log.info(logstring);
		// String path = "C:/Logger.txt";
		File file = new File("F:/Logger.txt");

		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}
 try {
	 FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(logstring);
			bw.close();
			System.out.println("################################################################################");
		} catch (Exception e) {
			System.out.println("exec cut");
}
		
		

		System.out.println("Done");
	}

	
	 * 
	 * public void addHandler(Handler handler) throws SecurityException { //
	 * Check for null handler handler.getClass(); checkPermission();
	 * handlers.add(handler); }
	 * 
	 * private void checkPermission() throws SecurityException { if (!anonymous)
	 * { if (manager == null) { // Complete initialization of the global Logger.
	 * manager = LogManager.getLogManager(); } manager.checkPermission(); } }
	 

}
*/