/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClashOfJava;

import Exceptions.ClashException;
import java.io.IOException;


// TIME IS 4 Hours ahead.
public class Main {

    public static void main(String[] args) throws IOException, ClashException {
        
       
        // INSERT CLAN TAG
        String clanTag = "";
        
        // INSERT API TOKEN
        API.setToken("");
        
        
        
        Player temp = new Player("#LLPLY8UR");
        
        for (int i = 0; i < temp.getSpells().size(); i++){
            System.out.println(temp.getSpells().get(i));
        }
        //System.out.println(test.clan1Members);
        
        /*
        LeagueGame game = new LeagueGame(clanTag);
        ArrayList<LeagueWar> warList= new ArrayList();
        warList.add(game.getRound1());
        warList.add(game.getRound2());
        warList.add(game.getRound3());
        warList.add(game.getRound4());
        warList.add(game.getRound5());
        warList.add(game.getRound6());
        warList.add(game.getRound7());
        
        System.out.println(game.getRound1().getClan1Members().get(0).getName());
        //System.out.println(warList.get(4).toString());
        
        String user = "Snub";
        
        for(int i = 0; i < warList.size(); i++){
           for (int j = 0; j < warList.get(i).getClan1Members().size(); j++){
               if (warList.get(i).getClan1Members().get(j).getName().equalsIgnoreCase(user)){
                   System.out.println(warList.get(i).getClan1Members().get(j).toString());
           }
        }  
           
            //System.out.println(warList);
            //if (game.getRound2().getClan2Members().get(i).attacks.get(0).attackerTag != null){
            //System.out.println(game.getRound2().getClan2Members().get(i));
            //System.out.println(String.format("%20s%20s%20s%20s", o.getName(), " " + o.getTrophies() , " " + o.getNumberOfTroopsDonated() , " " + o.getNumberOfTroopsReceived()));
            //}
        }
        for(int i = 0; i < warList.size(); i++){
           for (int j = 0; j < warList.get(i).getClan2Members().size(); j++){
               if (warList.get(i).getClan2Members().get(j).getName().equalsIgnoreCase(user)){
                   System.out.println(warList.get(i).getClan2Members().get(j).toString());
                }    
            }  
        }
        
        for (int i=0; i< game.getRoundList().size(); i++){
            System.out.println(game.getRoundList().get(i));
        }
          */ 
        //My ID
      //#LLPLY8UR
    }
}
