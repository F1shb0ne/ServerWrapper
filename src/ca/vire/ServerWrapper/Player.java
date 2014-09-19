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
