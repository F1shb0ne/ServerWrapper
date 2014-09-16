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

import java.util.regex.*;

public class CommandHandler {
   
   public static String Process(String input) {
      
      String result = null;      
      String Command = null;
      String User = null;
      String Coords = null;
      String CmdPatternSingle = "\\[\\d+:\\d+:\\d+\\] \\[Server thread/INFO\\]: <([a-zA-Z0-9_]+)> ([\\a-zA-Z0-9_]+)";
      //String CmdPatternDouble = "\\[\\d+:\\d+:\\d+\\] \\[Server thread/INFO\\]: <([a-zA-Z0-9_]+)> ([\\a-zA-Z0-9_]+) ([a-zA-Z0-9_]+)";
      
      Pattern p1 = Pattern.compile(CmdPatternSingle);
      //Pattern p2 = Pattern.compile(CmdPatternDouble);
      
      input = Util.FilterColor(input);
      
      Matcher m = p1.matcher(input);
      
      if (m.find()) {
         User = m.group(1);
         Command = m.group(2);
         
         if (Command.equals("\\spawn")) {
            Coords = Storage.GetSpawn();
            if (Coords != null) {
               result = "tp " + User + " " + Coords;               
            } else {
               result = "msg " + User + " Spawn not defined.";
            }
         }
         if (Command.equals("\\setspawn")) {
            if (Permissions.Check(User, Command)) {
               result = "msg " + User + " Command not implemented yet.";               
            } else 
               result = "msg " + User + " Permission denied.";
         }

         if (Command.equals("\\home")) {
            result = "msg " + User + " Command not implemented yet.";               
         }
         if (Command.equals("\\sethome")) {
            result = "msg " + User + " Command not implemented yet.";               
         }
         if (Command.equals("\\tpa")) {
            result = "msg " + User + " Command not implemented yet.";               
         }
         if (Command.equals("\\tpahere")) {
            result = "msg " + User + " Command not implemented yet.";               
         }
         if (Command.equals("\\tpaccept")) {
            result = "msg " + User + " Command not implemented yet.";               
         }
      }

      return result;     
   }
}

