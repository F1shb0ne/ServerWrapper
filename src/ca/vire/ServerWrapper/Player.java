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

import java.util.HashMap;
import java.util.Map;

// This object keeps track of player login locations so it can be later used by \setspawn or \sethome

public class Player {
   
   private static Map<String, String> PCoords = new HashMap<String, String>();
   private static Map<String, String> tpaRequestor = new HashMap<String, String>();
   
   public static void SetPlayerCoords(String Player, String Coords) {
      PCoords.put(Player, Coords);      
   }
   
   public static String GetPlayerCoords(String Player) {
      return PCoords.get(Player);
   }

   public static void SetPlayerRequestor(String Player, String Requestor) {
      tpaRequestor.put(Player, Requestor);      
   }

   public static String GetPlayerRequestor(String Player) {
      return tpaRequestor.get(Player);
   }
}
