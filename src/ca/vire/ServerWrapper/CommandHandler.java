package ca.vire.ServerWrapper;

import java.util.regex.*;

public class CommandHandler {
  
   
   public static String Process(String input) {
      
      String result = null;      
      String Command = null;
      String User = null;
      String CmdPatternSingle = "\\[\\d+:\\d+:\\d+\\] \\[Server thread/INFO\\]: <([a-zA-Z0-9_]+)> ([\\a-zA-Z0-9_]+)";
      //String CmdPatternDouble = "\\[\\d+:\\d+:\\d+\\] \\[Server thread/INFO\\]: <([a-zA-Z0-9_]+)> ([\\a-zA-Z0-9_]+) ([a-zA-Z0-9_]+)";
      
      Pattern p1 = Pattern.compile(CmdPatternSingle);
      //Pattern p2 = Pattern.compile(CmdPatternDouble);
      
      Matcher m = p1.matcher(input);
      
      if (m.find()) {
         User = m.group(1);
         Command = m.group(2);
         
         if (Command.equals("\\spawn")) {
            result = "tp " + User + " 112 72 66";  // normal temp map
            //result = "tp " + User + " 188 63 369\n";   // local experimental map            
         }
      }

      return result;     
   }
   
}

