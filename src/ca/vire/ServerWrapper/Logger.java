package ca.vire.ServerWrapper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

   public static boolean toFile = false;
   private static boolean isDefined = false;   
   private static PrintWriter out = null;

   private static void InitLog() {
      try {
         out = new PrintWriter(new BufferedWriter(new FileWriter("wrapper.log", true)));
         isDefined = true;
      } catch (IOException e) {
         e.printStackTrace();
      }      
   }
   
   public static void Info(String msg) {
      Log("Info: " + msg);
   }

   public static void Warn(String msg) {
      Log("Warn: " + msg);
   }
   
   public static void Error(String msg) {
      Log("Error: " + msg);
   }
   
   private static void Log(String msg) {
      if (toFile) {         
         if (isDefined) {
            out.println(msg);
         } else {
            InitLog();
            out.println(msg);
         }            
      } else {
         System.out.println(msg);
      }
   }
}
