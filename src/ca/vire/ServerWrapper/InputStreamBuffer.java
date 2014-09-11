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
THE SOFTWARE.package ca.vire.ServerWrapper;
*/

package ca.vire.ServerWrapper;

import java.io.*;
class InputStreamBuffer extends Thread
{
   InputStream inStream;
   String prefix;
   boolean usePrefix = false;
    
   InputStreamBuffer(InputStream stream)
   {
      this.inStream = stream;
   }

   InputStreamBuffer(InputStream stream, String prefix)
   {
      this.inStream = stream;
      this.prefix = prefix;
      this.usePrefix = true;
   }

   public void run()
   {
      InputStreamReader isr;
      BufferedReader br;
      String line = null;
      
      try {
         isr = new InputStreamReader(inStream);
         br = new BufferedReader(isr);
         
         while ((line = br.readLine()) != null) {
            if (this.usePrefix) {
               System.out.println(prefix + "> " + line);
            }
            else {
               System.out.println(line);
            }
         }
      } catch (IOException ioe) {
         ioe.printStackTrace();  
      }
   }
}
