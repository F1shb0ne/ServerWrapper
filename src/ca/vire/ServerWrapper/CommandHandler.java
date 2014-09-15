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

import java.util.regex.*;

public class CommandHandler {
  
   
   private static String FilterColor(String src) {
      String result = null;
      char buf[] = new char [256];
      char c;
      int i, j, length = 0;

      i = 0;
      j = 0;
      
      length = src.length();
      
      do {
         c = src.charAt(i);
         if (c != 0xa7) {
            buf[j] = c;
            ++i;
            ++j;            
         } else {
            i = i + 2;
         }
      } while (i < length);
      
      result = new String(buf);      
      
      return result;
   }
   
   public static String Process(String input) {
      
      String result = null;      
      String Command = null;
      String User = null;
      String CmdPatternSingle = "\\[\\d+:\\d+:\\d+\\] \\[Server thread/INFO\\]: <([a-zA-Z0-9_]+)> ([\\a-zA-Z0-9_]+)";
      //String CmdPatternDouble = "\\[\\d+:\\d+:\\d+\\] \\[Server thread/INFO\\]: <([a-zA-Z0-9_]+)> ([\\a-zA-Z0-9_]+) ([a-zA-Z0-9_]+)";
      
      Pattern p1 = Pattern.compile(CmdPatternSingle);
      //Pattern p2 = Pattern.compile(CmdPatternDouble);
      
      input = FilterColor(input);
      
      Matcher m = p1.matcher(input);
      
      if (m.find()) {
         User = m.group(1);
         Command = m.group(2);
         
         if (Command.equals("\\spawn")) {
            result = "tp " + User + " 112 72 66";
         }
      }

      return result;     
   }
   
}

