package ca.vire.ServerWrapper;

import java.io.IOException;

//@SuppressWarnings("unused")
public class Application {

   public static void main(String[] args) throws InterruptedException, IOException {

   Runtime rt;
   Process proc;
   InputStreamBuffer serverOutput;
   WriteServerCommand serverInput;
		
   try {            
      System.out.println("Launching minecraft server...");
      rt = Runtime.getRuntime();
      proc = rt.exec("java -jar c:\\mc\\minecraft_server.1.8.jar nogui");

      // Attach server's output as an input stream for us to use.
      serverOutput = new InputStreamBuffer(proc.getInputStream());
      // And one for input as our output. (to give commands)
      serverInput = new WriteServerCommand(proc.getOutputStream()); 
 
      // Start the io threads
      serverOutput.start();
      serverInput.start();
                        
      // The streams are setup for the process, wrapper blocks here until server terminates.
      int exitVal = proc.waitFor();

      // Server has stopped
      System.out.println("ExitValue: " + exitVal);        
   } catch (Throwable t) {
      t.printStackTrace();
   }
   }
}
