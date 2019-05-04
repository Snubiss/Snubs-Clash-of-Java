/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClashOfJava;

import org.json.JSONObject;


public class ClanMember {
    
    String tag;
    String name;
    int expLevel;
    String leagueID;
    String leagueName;
    String leagueIcon;
    int trophies;
    int versusTrophies;
    String role;
    int clanRank;
    int previousClanRank;
    int donations;
    int donationsReceived;
    
    ClanMember(JSONObject data){
    
        
        tag = data.getString("tag");
        name = data.getString("name");
        expLevel = data.getInt("expLevel");
        leagueID = data.getJSONObject("league").get("id").toString();
        leagueName = data.getJSONObject("league").get("name").toString();
        leagueIcon = data.getJSONObject("league").getJSONObject("iconUrls").get("small").toString();
        trophies = data.getInt("trophies");
        versusTrophies = data.getInt("versusTrophies");
        role = data.getString("role");
        clanRank = data.getInt("clanRank");
        previousClanRank = data.getInt("previousClanRank");
        donations = data.getInt("donations");
        donationsReceived = data.getInt("donationsReceived");
        
        
    }
    
    public String toString(){
        String temp =
        "Tag: " + tag + "\n" +
        "Name: " + name + "\n" +
        "XP Level: " + expLevel + "\n" +
        "League ID: " + leagueID + "\n" +
        "League Name: " + leagueName + "\n" +
        "League Icon: " + leagueIcon + "\n" +
        "Trophies: " + trophies + "\n" +
        "Versus Trophies: " + versusTrophies + "\n" +
        "Role: " + role + "\n" +
        "Clan Rank: " + clanRank + "\n" +
        "Prev Clan Rank: " + previousClanRank + "\n" +
        "Donations Out: " + donations + "\n" +
        "Donations In: " + donationsReceived + "\n";
        return temp;
    }
}
