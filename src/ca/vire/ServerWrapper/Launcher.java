/*
Copyright (c) 2014 "Fish" f1shb0nes80@gmail.com

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

public class Launcher {

   public static void main(String[] args) throws InterruptedException, IOException {
      Runtime rt;
      Process proc;
      WrapperThread wrapper;
      ConsoleThread console;
   	
      try {            
         System.out.println("Launching minecraft server...");
         rt = Runtime.getRuntime();
         proc = rt.exec("java -jar minecraft_server.1.8.jar nogui");
   
         // Capture i/o streams
         Stream.SetStreams(proc.getInputStream(), proc.getOutputStream());
         wrapper = new WrapperThread();
         console = new ConsoleThread();
    
         // Start the i/o threads
         wrapper.start();
         console.start();
                           
         // Wrapper threads are running, run until it terminates.
         proc.waitFor();
   
         // Server has stopped
         Logger.Info("Server Terminated; press enter to exit.");
         
         Util.ServerRunning = false;
         
      } catch (Throwable t) {
         t.printStackTrace();
      }
   }
}
