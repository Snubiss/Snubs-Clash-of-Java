/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClashOfJava;

import Exceptions.ClashException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    

    
    
    
    public static void main(String[] args) throws IOException, ClashException {
        
       
        // INSERT CLAN TAG
        String clanTag = "";
        // INSERT API TOKEN
        API.setToken("");
        
        LeagueGame game = new LeagueGame(clanTag);
        ArrayList<LeagueWar> warList= new ArrayList();
        warList.add(game.getRound1());
        warList.add(game.getRound2());
        warList.add(game.getRound3());
        warList.add(game.getRound4());
        warList.add(game.getRound5());
        warList.add(game.getRound6());
        warList.add(game.getRound7());
        
        
        //System.out.println(warList.get(4).toString());
        
        String user = "Snub";
        
        for(int i = 0; i < warList.size(); i++){
           for (int j = 0; j < warList.get(i).clan1Members.size(); j++){
               if (warList.get(i).clan1Members.get(j).name.equalsIgnoreCase(user)){
                   System.out.println(warList.get(i).clan1Members.get(j).toString());
           }
        }  
           
            //System.out.println(warList);
            //if (game.getRound2().clan2Members.get(i).attacks.get(0).attackerTag != null){
            //System.out.println(game.getRound2().clan2Members.get(i));
            //System.out.println(String.format("%20s%20s%20s%20s", o.getName(), " " + o.getTrophies() , " " + o.getNumberOfTroopsDonated() , " " + o.getNumberOfTroopsReceived()));
            //}
        }
        for(int i = 0; i < warList.size(); i++){
           for (int j = 0; j < warList.get(i).clan2Members.size(); j++){
               if (warList.get(i).clan2Members.get(j).name.equalsIgnoreCase(user)){
                   System.out.println(warList.get(i).clan2Members.get(j).toString());
           }
        }  }
        
        
        
    }
    
}
