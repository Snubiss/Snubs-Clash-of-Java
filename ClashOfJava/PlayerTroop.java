/********************************************************************
//  PlayerTroop.java       Author: Snubiss
//
//  Date: April 28, 2019
//  Modified: May 8, 2019
//
//  The PlayerTroop class is used to define instance data for a player's
//  achievements. This class is called directly from the Player class. This
//  class should not be instantiated directly.
//
//********************************************************************/

package ClashOfJava;

import org.json.JSONObject;


public class PlayerTroop {
    
    private final String name;
    private final String village;
    private final int level;
    private final int maxLevel;
    
    
    PlayerTroop(JSONObject data){
        name = data.optString("name", "None");
        village = data.optString("village", "None");
        level = data.optInt("level", 0);
        maxLevel = data.optInt("maxLevel", 0);
    }

    public String getName() {
        return name;
    }

    public String getVillage() {
        return village;
    }

    public int getLevel() {
        return level;
    }

    public int getMaxLevel() {
        return maxLevel;
    }
    
    @Override
    public String toString(){
        
        String temp =
        "Village: " + village + "\n" +
        "Name: " + name + "\n" +
        "Level: " + level + "\n" +
        "Max Level: " + maxLevel + "\n";
        
        return temp;
    }
}
