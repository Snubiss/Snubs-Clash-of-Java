/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClashOfJava;

import Exceptions.ClashException;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONObject;


public class LeagueWar {
    
    JSONObject data;
    String state;
    int teamSize;
    String preparationStartTime;
    String startTime;
    String endTime;
    String clan1Tag;
    String clan1Name;
    int clan1Level;
    int clan1Attacks;
    int clan1Stars;
    int clan1Destruction;
    ArrayList<LeagueWarMember> clan1Members = new ArrayList();
    String clan2Tag;
    String clan2Name;
    int clan2Level;
    int clan2Attacks;
    int clan2Stars;
    int clan2Destruction;
    ArrayList<LeagueWarMember> clan2Members = new ArrayList();
    
    LeagueWar(){
        
    }
    
    LeagueWar(String warTag) throws IOException, ClashException{
        
        data = API.performAPIRequest("clanwarleagues/wars/%s", warTag);
        state = data.getString("state");
        teamSize = data.getInt("teamSize");
        preparationStartTime = data.getString("preparationStartTime");
        startTime = data.getString("startTime");
        endTime = data.getString("endTime");
        clan1Tag = data.getJSONObject("clan").getString("tag");
        clan1Name = data.getJSONObject("clan").getString("name");
        clan1Level = data.getJSONObject("clan").getInt("clanLevel");
        clan1Attacks = data.getJSONObject("clan").getInt("attacks");
        clan1Stars = data.getJSONObject("clan").getInt("stars");
        clan1Destruction = data.getJSONObject("clan").getInt("destructionPercentage");
        clan2Tag = data.getJSONObject("opponent").getString("tag");
        clan2Name = data.getJSONObject("opponent").getString("name");
        clan2Level = data.getJSONObject("opponent").getInt("clanLevel");
        clan2Attacks = data.getJSONObject("opponent").getInt("attacks");
        clan2Stars = data.getJSONObject("opponent").getInt("stars");
        clan2Destruction = data.getJSONObject("opponent").getInt("destructionPercentage");
        
        for (int i = 0; i < data.getJSONObject("clan").getJSONArray("members").length(); i++){
            clan1Members.add(new LeagueWarMember(data.getJSONObject("clan").getJSONArray("members").getJSONObject(i),1));
        }
        
        for (int i = 0; i < data.getJSONObject("opponent").getJSONArray("members").length(); i++){
            clan2Members.add(new LeagueWarMember(data.getJSONObject("opponent").getJSONArray("members").getJSONObject(i),2));
        }
        
    }
    
    @Override
    public String toString(){
        String temp =
        "State: " + state + "\n" +
        "Team Size: " + teamSize + "\n" +
        "Prep Start Time: " + preparationStartTime + "\n" +
        "Start Time: " + startTime + "\n" +
        "End Time: " + endTime + "\n" +
        "Clan 1 Tag: " + clan1Tag + "\n" +
        "Clan 1 Name: " + clan1Name + "\n" +
        "Clan 1 Level: " + clan1Level + "\n" +
        "Clan 1 Attacks: " + clan1Attacks + "\n" +
        "Clan 1 Stars: " + clan1Stars + "\n" +
        "Clan 1 Destruction: " + clan1Destruction + "%" + "\n\n" +
        "Clan 2 Tag: " + clan2Tag + "\n" +
        "Clan 2 Name: " + clan2Name + "\n" +
        "Clan 2 Level: " + clan2Level + "\n" +
        "Clan 2 Attacks: " + clan2Attacks + "\n" +
        "Clan 2 Stars: " + clan2Stars + "\n" +
        "Clan 2 Destruction: " + clan2Destruction + "%" + "\n";
        return temp;
    }
}
