package ca.vire.ServerWrapper;

import java.io.*;
class InputStreamBuffer extends Thread
{
   InputStream inStream;
   String prefix;
   boolean usePrefix = false;
    
   InputStreamBuffer(InputStream stream)
   {
      this.inStream = stream;
   }

   InputStreamBuffer(InputStream stream, String prefix)
   {
      this.inStream = stream;
      this.prefix = prefix;
      this.usePrefix = true;
   }

   public void run()
   {
      InputStreamReader isr;
      BufferedReader br;
      String line = null;
      
      try {
         isr = new InputStreamReader(inStream);
         br = new BufferedReader(isr);
         
         while ((line = br.readLine()) != null) {
            if (this.usePrefix) {
               System.out.println(prefix + "> " + line);
            }
            else {
               System.out.println(line);
            }
         }
      } catch (IOException ioe) {
         ioe.printStackTrace();  
      }
   }
}
