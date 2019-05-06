/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClashOfJava;

import org.json.JSONObject;


public class PlayerHero {
    
    private final String name;
    private final String village;
    private final int level;
    private final int maxLevel;
    
    
    PlayerHero(JSONObject data){
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
