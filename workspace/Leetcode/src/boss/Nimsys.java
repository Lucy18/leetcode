package boss;

import java.util.Scanner;

public class Nimsys {

	NimGame currentGame;
	NimPlayer[] players;
	int numOfPlayers;
	
    public Nimsys(){
    	players=new NimPlayer[100];
    	numOfPlayers=0;
    }
    
    public void execute(){
    	System.out.println("Welcome to Nim");
    	Scanner in=new Scanner(System.in);
    	while(true){
    		System.out.println();
        	System.out.print("$");
        	String command=in.nextLine();
        	String[] commands=command.split(" ");
        	if(commands[0].equals("addplayer")){
        		String[] names=commands[1].split(",");
        		String username=names[0];
        		String family_name=names[1];
        		String given_name=names[2];
        		boolean result=addPlayer(username, family_name, given_name);
        		if(result==false){
        			System.out.println("The player already exists.");
        		}
        	}
        	else if(commands[0].equals("removeplayer")){
        		//你来写
        		
        		
        	}
        	else if(commands[0].equals("editplayer")){
        		//你来写
        		
        	}
        	//.......以及其他命令
        	
        	
        	else if(commands[0].equals("exit")){
        		System.out.println();
        		in.close();
        		System.exit(0);
        	}        	       	
    	} 
    	
    }
	
    public boolean addPlayer(String username,String family_name,String given_name){
    	if(containsPlayer(username)){
    		return false;
    	}
    	else{
    		NimPlayer player=new NimPlayer(username, given_name, family_name);
    		players[numOfPlayers]=player;
    		numOfPlayers++;
    		return true;
    	}
    }
    
    public boolean containsPlayer(String username){
    	for(int i=0;i<numOfPlayers;i++){
    		NimPlayer player=players[i];
    		if(player.getUserName().equals(username)){
    			return true;
    		}
    	}
    	return false;
    }
    
    public static void main(String[] args) {
		Nimsys nimsys=new Nimsys();
		nimsys.execute();
	}
    
	
}
