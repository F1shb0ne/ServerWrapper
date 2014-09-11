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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class WriteServerCommand extends Thread {

   OutputStream OutStream = null;
   BufferedReader br;
   String buffer;
   String Prefix = "";
   boolean usePrefix = false;
   
   WriteServerCommand(OutputStream stream) {
      this.OutStream = stream;
   }
   WriteServerCommand(OutputStream stream, String p)
   {
      this.OutStream = stream;
      this.Prefix = p;
      this.usePrefix = true;
   }

   public void Run() throws IOException
   {
      br = new BufferedReader(new InputStreamReader(System.in));      

      while((this.buffer = br.readLine())!=null) {
         OutStream.write(this.buffer.getBytes());
      }
   }
}

