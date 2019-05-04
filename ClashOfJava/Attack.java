/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClashOfJava;

import org.json.JSONObject;

/**
 *
 * @author SchoolBox
 */
public class Attack {
    String attackerTag;
    String defenderTag;
    int stars;
    int destructionPercentage;
    int order;
    
    
    Attack(){
        
        attackerTag = null;
        defenderTag = null;
        stars = 0;
        destructionPercentage = 0;
        order = 0;
    }
    
    Attack(JSONObject data){
        
        attackerTag = data.getString("attackerTag");
        defenderTag = data.getString("defenderTag");
        stars = data.getInt("stars");
        destructionPercentage = data.getInt("destructionPercentage");
        order = data.getInt("order");
        
    }
    
    @Override
    public String toString(){
        
        String temp =
        "\nAttacker Tag: " + attackerTag + "\n" +
        "Defender Tag: " + defenderTag + "\n" +
        "Stars: " + stars + "\n" +
        "Destruction Percentage: " + destructionPercentage + "%" + "\n" +
        "Order: " + order + "\n";
        
        return temp;
    }
}
