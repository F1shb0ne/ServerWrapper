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

import java.io.*;
class StreamHandler extends Thread
{
   InputStream inStream;
   OutputStream outStream;
   
   BufferedWriter writer;
   
   StreamHandler(InputStream is, OutputStream os)
   {
      this.inStream = is;
      this.outStream = os;
      this.writer = new BufferedWriter(new OutputStreamWriter(os));
   }

   public void run()
   {
      InputStreamReader isr;
      BufferedReader br;
      String line = null;
      String PString = null;
      
      try {
         isr = new InputStreamReader(inStream);
         br = new BufferedReader(isr);
         
         while ((line = br.readLine()) != null) {
            PString = CommandHandler.Process(line);
           
            System.out.println(line);

            if (PString != null) {
               System.out.println("Executing: " + PString);
               writer.write(PString + "\n");
               writer.flush();
            }
         }
      } catch (IOException ioe) {
         ioe.printStackTrace();  
      }
   }
}
