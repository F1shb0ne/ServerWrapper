/*
Copyright (c) 2014 F1shb0ne

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/

package ca.vire.ServerWrapper;

import java.io.IOException;

//@SuppressWarnings("unused")
public class Application {

   public static void main(String[] args) throws InterruptedException, IOException {

   Runtime rt;
   Process proc;
   StreamHandler sHandler;
		
   try {            
      System.out.println("Launching minecraft server...");
      rt = Runtime.getRuntime();
      //proc = rt.exec("java -jar c:\\mc\\minecraft_server.1.8.jar nogui");
      proc = rt.exec("java -jar minecraft_server.1.8.jar nogui");

      // Attach server's output as an input stream for us to use.
      sHandler = new StreamHandler(proc.getInputStream(), proc.getOutputStream());
 
      // Start the i/o threads
      sHandler.start();
                        
      // The streams are setup for the process, wrapper blocks here until server terminates.
      int exitVal = proc.waitFor();

      // Server has stopped
      System.out.println("ExitValue: " + exitVal);        
   } catch (Throwable t) {
      t.printStackTrace();
   }
   }
}
