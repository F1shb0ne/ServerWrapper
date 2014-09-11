package ca.vire.ServerWrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class WriteServerCommand extends Thread {

   OutputStream OutStream = null;
   BufferedReader br;
   String buffer;
   String Prefix = "";
   boolean usePrefix = false;
   
   WriteServerCommand(OutputStream stream) {
      this.OutStream = stream;
   }
   WriteServerCommand(OutputStream stream, String p)
   {
      this.OutStream = stream;
      this.Prefix = p;
      this.usePrefix = true;
   }

   public void Run() throws IOException
   {
      br = new BufferedReader(new InputStreamReader(System.in));      

      while((this.buffer = br.readLine())!=null) {
         OutStream.write(this.buffer.getBytes());
      }
   }
}

