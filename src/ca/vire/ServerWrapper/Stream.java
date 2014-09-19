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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Stream {
   private static InputStream InStream = null;
   private static OutputStream OutStream = null;   
   private static BufferedWriter writer = null;
   private static BufferedReader reader = null;

   public static void SetStreams(InputStream in, OutputStream out) {
      InStream = in;
      OutStream = out;
      writer = new BufferedWriter(new OutputStreamWriter(OutStream));
      reader = new BufferedReader(new InputStreamReader(InStream));
   }
   
   public static String GetString() {
      String Result = null;      
      try {
         Result = reader.readLine();
      } catch (IOException e) {
         e.printStackTrace();
      }            
      return Result;
   }
   
   public static void PutString(String s) {
      if (Util.ServerRunning && s != null) {
         try {
            Logger.Info("Injecting \"" + s + "\"");
            writer.write(s + "\n");
            writer.flush();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }      
   }   
}
