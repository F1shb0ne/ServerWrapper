package ca.vire.ServerWrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleThread extends Thread {

   public ConsoleThread() {
      
   }
   
   public void run() {
      try{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
         String input;
    
         while(Util.ServerRunning && (input=br.readLine())!=null){
            Stream.PutString(input);
         }
         
         br.close();

      }catch(IOException io){
         io.printStackTrace();
      }
   }
}
