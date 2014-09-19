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
      
      // Result may contain a response based on the input
      // A null is returned if no response is to be sent.
      String Result = null;

      Matcher m = null;
      String Command = null;      
      String User = null;
      String Coords = null;
      String CmdPatternSingle = "\\[\\d+:\\d+:\\d+\\] \\[Server thread/INFO\\]: <([a-zA-Z0-9_]+)> ([\\a-zA-Z0-9_]+)";
      //String CmdPatternDouble = "\\[\\d+:\\d+:\\d+\\] \\[Server thread/INFO\\]: <([a-zA-Z0-9_]+)> ([\\a-zA-Z0-9_]+) ([a-zA-Z0-9_]+)";
      
//      Pattern p_tp = Pattern.compile("\\[\\d+:\\d+:\\d+\\] \\[Server thread/INFO\\]: Teleported \\w+ to ([\\d\\.]+), ([\\d\\.]+), ([\\d\\.]+)");
      Pattern p_login = Pattern.compile("\\[\\d+:\\d+:\\d+\\] \\[Server thread/INFO\\]: ([a-zA-Z0-9_]+)\\[\\/[\\d\\.:]+\\] logged in with entity id \\d+ at \\(([\\d\\.]+), ([\\d\\.]+), ([\\d\\.]+)\\)");
      // [19:49:32] [Server thread/INFO]: F1shb0ne[/192.168.0.5:14944] logged in with entity id 5059 at (35.89168997589075, 75.0, 232.57246147545797)
      
      Pattern p1 = Pattern.compile(CmdPatternSingle);
      //Pattern p2 = Pattern.compile(CmdPatternDouble);
      
      m = p_login.matcher(input);
      if (m.find()) {
         User = m.group(1);
         Coords = m.group(2) + " " + m.group(3) + " " + m.group(4);
         Logger.Info("Detected player " + User + " log in at " + Coords);
         Player.SetPlayerCoords(User, Coords);
         return null; // stop processing
      }
      
      m = p1.matcher(input);
      if (m.find()) {
         User = m.group(1);
         Command = m.group(2);
         
         if (Command.equals("\\spawn")) {
            Coords = Storage.GetSpawn();
            if (Coords != null) {
               Result = "tp " + User + " " + Coords;               
            } else {
               Result = "msg " + User + " Spawn not defined.";
            }
         }
         if (Command.equals("\\setspawn")) {
            if (Permissions.Check(User, Command)) {
               Coords = Player.GetPlayerCoords(User);               
               Storage.SetSpawn(Coords);
               Logger.Info("New spawnpoint set at " + Coords);
               Result = "msg " + User + " Spawn point set at last login location.";               
            } else {
               Result = "msg " + User + " Permission denied.";
            }
         }

         if (Command.equals("\\sethome")) {
            Coords = Player.GetPlayerCoords(User);               
            Logger.Info("Saving \"" + Coords + "\" as new home for player " + User);
            Storage.SetHome(User, Coords);
            Result = "msg " + User + " Home set at last login location.";               
         }         

         if (Command.equals("\\home")) {
            Coords = Player.GetPlayerCoords(User);               
            Coords = Storage.GetHome(User);
            if (Coords == null) {
               Result = "msg " + User + " Home not set.";
            } else {               
               Result = "tp " + User + " " + Coords;               
            }
         }         
         
         if (Command.equals("\\tpa")) {
            Result = "msg " + User + " Command not implemented yet.";               
         }
         if (Command.equals("\\tpahere")) {
            Result = "msg " + User + " Command not implemented yet.";               
         }
         if (Command.equals("\\tpaccept")) {
            Result = "msg " + User + " Command not implemented yet.";               
         }
      }

      return Result;     
   }
}

