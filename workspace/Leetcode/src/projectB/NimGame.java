package projectB;
import java.util.Scanner;


public class NimGame {

	int upperbound, numOfCurrentStones;
	NimPlayer Nimplayer1;
	NimPlayer Nimplayer2;
	int turn = 1;
	NimPlayer winner = null;

	public NimGame(NimPlayer player1, NimPlayer player2, int upperbound, int numberOfStones) {
		this.Nimplayer1 = player1;
		this.Nimplayer2 = player2;
		this.upperbound = upperbound;
		this.numOfCurrentStones = numberOfStones;
	}

	public boolean isGameOver() {// condition for gameover
		return winner != null;
	}

	public NimPlayer getCurrentPlayer() {
		if (turn == 1) {
			return Nimplayer1;
		} else {
			return Nimplayer2;
		}
	}
	
	public NimPlayer getNotCurrentPlayer() {
		if (turn == 1) {
			return Nimplayer2;
		} else {
			return Nimplayer1;
		}
	}

	public void takeTurn() { // change player's turn
		if (turn == 1) {
			turn = 2;
		} else {
			turn = 1;
		}
	}

	public void gameProcess(int num) {
		numOfCurrentStones = numOfCurrentStones - num;
		if (numOfCurrentStones <= 0) {
			winner = getNotCurrentPlayer();
		}
	}

	public NimPlayer getWinner() {
		return winner;
	}

	public void showStones() {
		System.out.print("\n" + numOfCurrentStones + " stones left:");
		for (int i = 0; i < numOfCurrentStones; i++) {
			System.out.print(" *");
		}
		System.out.println();
	}

	public void execute(Scanner in) {
		System.out.println("Initial stone count: "+numOfCurrentStones);
		System.out.println("Maximum stone removal: "+upperbound);
		System.out.println("Player 1: "+Nimplayer1.givenName+" "+Nimplayer1.getFamilyName());
		System.out.println("Player 2: "+Nimplayer2.givenName+" "+Nimplayer2.getFamilyName());
	  		while (!isGameOver()) {// the process of removing stones
	  		showStones();
			System.out.println(getCurrentPlayer().getGivenName() + "'s turn - remove how many?");
			int num = in.nextInt();
			if(num==0||num>upperbound){
				int min=Math.min(upperbound, numOfCurrentStones);
				System.out.println();
				System.out.println("Invalid move. You must remove between 1 and "+min+" stones.");
			}
			else{
				gameProcess(num);
				takeTurn();
			}		
		}

		System.out.println("\nGame Over");
		System.out.println(getWinner().getGivenName() + " "+getWinner().getFamilyName()+" wins!");
		
		int player1games = Nimplayer1.getNumOfPlayedGames();
		Nimplayer1.setNumOfPlayedGames(player1games+1);
		int player2games = Nimplayer2.getNumOfPlayedGames();
		Nimplayer2.setNumOfPlayedGames(player2games+1);
		int wingame = getWinner().getNumOfWonGames();
		getWinner().setNumOfWonGames(wingame+1);
		}

/**
	public static void main(String[] args) {
		NimPlayer player1 = new NimPlayer("lskywalker", "Luke","Skywalker");
		NimPlayer player2 = new NimPlayer("hsolo","Han","Solo");
		NimGame nimGame = new NimGame(player1, player2, 3, 10);
		nimGame.execute();
	}
**/
	
}
