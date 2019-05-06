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
    
    private JSONObject data;
    private String state;
    private int teamSize;
    private String preparationStartTime;
    private String startTime;
    private String endTime;
    private String clan1Tag;
    private String clan1Name;
    private int clan1Level;
    private int clan1Attacks;
    private int clan1Stars;
    private int clan1Destruction;
    private ArrayList<LeagueWarMember> clan1Members = new ArrayList();
    private String clan2Tag;
    private String clan2Name;
    private int clan2Level;
    private int clan2Attacks;
    private int clan2Stars;
    private int clan2Destruction;
    private ArrayList<LeagueWarMember> clan2Members = new ArrayList();
    
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
    
    
    public String getState() {
        return state;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public String getPreparationStartTime() {
        return preparationStartTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getClan1Tag() {
        return clan1Tag;
    }

    public String getClan1Name() {
        return clan1Name;
    }

    public int getClan1Level() {
        return clan1Level;
    }

    public int getClan1Attacks() {
        return clan1Attacks;
    }

    public int getClan1Stars() {
        return clan1Stars;
    }

    public int getClan1Destruction() {
        return clan1Destruction;
    }

    public ArrayList<LeagueWarMember> getClan1Members() {
        return clan1Members;
    }

    public String getClan2Tag() {
        return clan2Tag;
    }

    public String getClan2Name() {
        return clan2Name;
    }

    public int getClan2Level() {
        return clan2Level;
    }

    public int getClan2Attacks() {
        return clan2Attacks;
    }

    public int getClan2Stars() {
        return clan2Stars;
    }

    public int getClan2Destruction() {
        return clan2Destruction;
    }

    public ArrayList<LeagueWarMember> getClan2Members() {
        return clan2Members;
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
