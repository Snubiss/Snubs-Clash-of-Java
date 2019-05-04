/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClashOfJava;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author SchoolBox
 */
public class LeagueWarMember {
    
    String tag;
    String name;
    String team;
    int townHallLevel;
    int mapPosition;
    ArrayList<Attack> attacks = new ArrayList();
    int opponentAttacks;
    Attack bestOpponentAttacks;
    
    
    // This will be initiated automatically when creating a LeagueWar or LeagueGame
    // This can only be created useing a JSONObject from the 'members' array in the clash api.
    public LeagueWarMember(JSONObject data, int side){
        try{
        tag = data.getString("tag");
        }
        catch(JSONException ex){
            tag = "null";
        }
        
        name = data.getString("name");
        townHallLevel = data.getInt("townhallLevel");
        mapPosition = data.getInt("mapPosition");
        opponentAttacks = data.getInt("opponentAttacks");
        
        for (int i = 0; i < 2; i++){
            try{
                //System.out.println(data.getJSONArray("attacks").getJSONObject(i));
                attacks.add(new Attack(data.getJSONArray("attacks").getJSONObject(i)));
            }
            catch(JSONException ex){
                //System.out.println("SHIT");
                attacks.add(new Attack());
            }
        }
        for (int i = 0; i < 1; i++){
            try{
                bestOpponentAttacks = new Attack(data.getJSONObject("bestOpponentAttack"));
            }
            catch(JSONException ex){
                bestOpponentAttacks = new Attack();
            }
        }
        
        if (side == 1){
            team = "Home";
        }
        else{
            team = "Away";
        }
        
        
        
    }
    
    public String toString(){
        String temp =
        "Tag: " + tag + "\n" +
        "Name: " + name + "\n" +
        "Team: " + team + "\n" +
        "Town Hall Level: " + townHallLevel + "\n" +
        "Map Position: " + mapPosition + "\n\n" +
        "Attack 1: " + attacks.get(0).toString() + "\n\n" +
        "Opponent Attacks: " + opponentAttacks + "\n\n" +
        "Best Opponent Attack: \n" + bestOpponentAttacks.toString() + "\n";

        return temp;
    }
}
