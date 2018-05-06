import java.util.Scanner;

public class Nimsys {
	int upperbound, numberOfStones;
	Nimplayer Nimplayer1;
	Nimplayer Nimplayer2;
	Nimplayer Stonestaken;
	int turn = 1;
	Nimplayer winner = null;

	public Nimsys(Nimplayer player1, Nimplayer player2, Nimplayer Stonestaken, int upperbound, int numberOfStones) {
		this.Nimplayer1 = player1;
		this.Nimplayer2 = player2;
		this.Stonestaken= Stonestaken;
		this.upperbound = upperbound;
		this.numberOfStones = numberOfStones;
	}

	public boolean isGameOver() {//condition for gameover
		return winner != null;
	}

	public Nimplayer getCurrentPlayer() { 
		if (turn == 1) {
			return Nimplayer1;
		} else {
			return Nimplayer2;
		}
	}

	public void takeTurn() { //change player's turn 
		if (turn == 1) {
			turn = 2;
		} else {
			turn = 1;
		}
	}

	public  Nimplayer getRemovestones() {
		 return Stonestaken;
	}
	public void gameprocess(int num) {
		numberOfStones = numberOfStones - num;
		if(numberOfStones<=0) {
			takeTurn();//change their turn again which can get winner's name
			winner = getCurrentPlayer();	
		}
	}
    public Nimplayer getWinner() {
    	    return winner;
    }
	public void showStones() {
		System.out.print("\n"+numberOfStones + " stones left:");
		for (int i = 0; i < numberOfStones; i++) {
			System.out.print(" *");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		Nimplayer Nimplayer1 = new Nimplayer();
		Nimplayer Nimplayer2 = new Nimplayer();
		Nimplayer Stonestaken = new Nimplayer();
		String answer;

		System.out.print("Welcome to Nim\n");
		System.out.println("\nPlease enter Player 1's name:");

		String player1name = keyboard.next();
		Nimplayer1.setName(player1name);//set player1's name in Nimplayer

		System.out.println("\nPlease enter Player 2's name:");
		String player2name = keyboard.next();
		Nimplayer2.setName(player2name);// set player2's name in Nimplayer

		do {//the whole game loop
			System.out.println("\nPlease enter upper bound of stone removal:");
			int upperbound = keyboard.nextInt(); 
			
			System.out.println("\nPlease enter initial number of stones:");
			int numberOfStones = keyboard.nextInt();
			
			Nimsys nimsys = new Nimsys(Nimplayer1, Nimplayer2, Stonestaken, upperbound, numberOfStones);
			
		    while(!nimsys.isGameOver()) {//the process of removing stones
		        	nimsys.showStones();
		        	System.out.println(nimsys.getCurrentPlayer().getName() + "'s turn - remove how many?");
		        	int num = keyboard.nextInt();
		        	Stonestaken.setNum(num);
			    nimsys.gameprocess(nimsys.getRemovestones().getNum());
			    nimsys.takeTurn();
		    }
		    
			System.out.println("\nGame Over");
			System.out.println(nimsys.getWinner().getName() + " wins!");
			System.out.print("\nDo you want to play again (Y/N):");
			answer = keyboard.next();
		} while (answer.equalsIgnoreCase("y"));
		keyboard.close();
	}

}
