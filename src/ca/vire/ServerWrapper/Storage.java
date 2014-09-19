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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Storage {
  
   static File localFile = null;
   static boolean IsSpawnDefined = false;
   static String SpawnCoords = null;

   public static void LoadSpawn() {
      localFile = new File("spawn.dat");
      String line;

      BufferedReader br;
      try {
         br = new BufferedReader(new FileReader(localFile));
         try {
            // Read in spawn coordinates, only 3 numbers separated by spaces
            line = br.readLine();
            if (line == null) {
               Logger.Error("Could not read spawn data coordinate data");               
            } else {
               // Spawn coordinates should now be in field line
               Logger.Info("Read in \"" + line + "\"");
               SpawnCoords = line;
               IsSpawnDefined = true;
            }
            try {
               br.close();
            } catch (IOException e) {
               Logger.Error("Could not close file??");               
               e.printStackTrace();
            }    
         } catch (IOException e) {
            Logger.Error("Could not read from spawn.dat.");               
            e.printStackTrace();
         }
      } catch (FileNotFoundException e) {
         Logger.Error("Could not open spawn.dat");         
         e.printStackTrace();
      }
   }
   
   //Storage.SetHome(User, Coords);
   //Coords = Storage.GetHome(User);
   
   public static void SetHome(String User, String Coords) {
      localFile = new File(User + ".dat");      
      BufferedWriter bw;      
      try {
         bw = new BufferedWriter(new FileWriter(localFile));         
         bw.write(Coords);
         bw.close();
      } catch (IOException e) {
         Logger.Error("Could not write to " + User + ".dat");
         e.printStackTrace();
      }      
   }   

   public static String GetHome(String User) {
      localFile = new File(User + ".dat");
      String line;
      String Result = null;

      BufferedReader br;
      try {
         br = new BufferedReader(new FileReader(localFile));
         try {
            // Read in home coordinates, only 3 numbers separated by spaces
            line = br.readLine();
            if (line == null) {
               Logger.Error("Could not read coord data coordinate data for player " + User);               
            } else {
               // Spawn coordinates should now be in field line
               Logger.Info("Read in \"" + line + "\"");
               Result = Player.GetPlayerCoords(User);
               SpawnCoords = line;
               IsSpawnDefined = true;
            }
            try {
               br.close();
            } catch (IOException e) {
               Logger.Error("Could not close file??");               
               e.printStackTrace();
            }    
         } catch (IOException e) {
            Logger.Error("Could not read from " + User + ".dat.");               
            e.printStackTrace();
         }
      } catch (FileNotFoundException e) {
         Logger.Error("Home data not found for player " + User);         
         e.printStackTrace();
      }
      
      return Result;
   }

   
   public static void SetSpawn(String NewSpawn) {
      localFile = new File("spawn.dat");      
      BufferedWriter bw;      
      try {
         bw = new BufferedWriter(new FileWriter(localFile));         
         bw.write(NewSpawn);
         SpawnCoords = NewSpawn;
         bw.close();
      } catch (IOException e) {
         Logger.Error("Could not write to spawn.dat");
         e.printStackTrace();
      }
   }
   
   public static String GetSpawn() {
      String Result = null;
      if (IsSpawnDefined) {
         Result = SpawnCoords;
      } else {
         LoadSpawn();
         if (IsSpawnDefined) {
            Result = SpawnCoords;
         } else {
            Result = null;
         }
      }
      return Result;
   }
}
