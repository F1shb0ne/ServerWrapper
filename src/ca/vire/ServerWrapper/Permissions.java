/*
Copyright (c) 2014 f1shb0nes80@gmail.com

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

public class Permissions {

   public static boolean Check(String User, String Command) {
      
      boolean Grant = false;
      
      if (Command.equals(new String("\\setspawn"))) {
         if (User.equals(new String("F1shb0ne"))) {
            Grant = true;
         }
      }
      
      if (Command == "\\spawn") {
         Grant = true;
      }
      
      if (Command == "\\home") {
         Grant = true;
      }

      if (Command == "\\sethome") {
         Grant = true;
      }
      
      if (Command == "\\tpa") {
         Grant = true;
      }

      if (Command == "\\tpahere") {
         Grant = true;
      }

      if (Command == "\\tpaccept") {
         Grant = true;
      }

      return Grant;
   }
}
