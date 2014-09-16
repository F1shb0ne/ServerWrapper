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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Storage {
  
   static File fSpawnFile = null;
   static boolean IsSpawnDefined = false;
   static String SpawnCoords = null;
   
   

   public static void LoadSpawn() {
      fSpawnFile = new File("spawn.dat");
      String line;

      BufferedReader br;
      try {
         br = new BufferedReader(new FileReader(fSpawnFile));

         try {
            // Read in spawn coordinates, only 3 numbers separated by spaces
            line = br.readLine();
            if (line == null) {
               System.out.println("Err: Could not read spawn data coordinate data");               
            } else {
               // Spawn coordinates should now be in field line
               System.out.println("Info: Read in \"" + line + "\"");
               SpawnCoords = line;
               IsSpawnDefined = true;
            }

            try {
               br.close();
            } catch (IOException e) {
               System.out.println("Err: Could not close file??");               
               e.printStackTrace();
            }    
         } catch (IOException e) {
            System.out.println("Err: Could not read from spawn.dat.");               
            e.printStackTrace();
         }

      } catch (FileNotFoundException e) {
         System.out.println("Err: Could not open spawn.dat");
         e.printStackTrace();
      }

   }
   
   public static void SetSpawn(String NewSpawn) {
      
   }
   
   public static String GetSpawn() {
      if (IsSpawnDefined) {
         return SpawnCoords;
      }      
      return null;
   }
}
