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

class WrapperThread extends Thread
{
   public void run()
   {
      String line = null;
      String Filtered = null;
      String Response = null;
      
      while (Util.ServerRunning && (line = Stream.GetString()) != null) {
         // Print line for console to see
         Logger.Common(line);
         
         // Filter for color codes
         Filtered = Util.FilterColor(line);         
         
         // Determine if a response command is needed (receive a null if not)
         Response = CommandHandler.Process(Filtered);

         // Inject command 
         if (Response != null) {
            Logger.Info("Injecting \"" + Response + "\"");
            Stream.PutString(Response);
         }         
      }
   }
}
