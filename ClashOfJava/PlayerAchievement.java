/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClashOfJava;

import org.json.JSONObject;


public class PlayerAchievement {
    
    private final String name;
    private final int stars;
    private final int value;
    private final int target;
    private final String info;
    private String completionInfo = null;
    private final String village;
    
    PlayerAchievement(JSONObject data){
        
        //System.out.println(data);
        name = data.optString("name", "None");
        stars = data.optInt("stars", 0);
        value = data.optInt("value", 0);
        target = data.optInt("target", 0);
        info = data.optString("info", "None");
        completionInfo = data.optString("completionInfo", "None");
        village = data.optString("village", "None");
    }
    
    public String getName() {
        return name;
    }

    public int getStars() {
        return stars;
    }

    public int getValue() {
        return value;
    }

    public int getTarget() {
        return target;
    }

    public String getInfo() {
        return info;
    }

    public String getCompletionInfo() {
        return completionInfo;
    }

    public String getVillage() {
        return village;
    }
    
    public String toString(){
        
        String temp =
        "Name: " + name + "\n" +
        "Village: " + village + "\n" +
        "Stars: " + stars + "\n" +
        "Value: " + value + "\n" +
        "Target: " + target + "\n" +
        "Info: " + info + "\n" +
        "Completion Info: " + completionInfo + "\n";
        
        return temp;
    }
}
