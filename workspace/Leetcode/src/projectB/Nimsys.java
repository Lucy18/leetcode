package projectB;

import java.util.Scanner;

public class Nimsys {

	NimGame currentGame;
	NimPlayer[] players;
	int numOfPlayers;

	public Nimsys() {
		players = new NimPlayer[100];
		numOfPlayers = 0;
	}

	public void execute() {
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to Nim");
		while (true) {
			System.out.println();
			System.out.print("$");
			String command = in.nextLine();
			String[] commands = command.split(" ");
			if (commands[0].equals("addplayer")) {
				String[] names = commands[1].split(",");
				String username = names[0];
				String family_name = names[1];
				String given_name = names[2];
				boolean result = addPlayer(username, family_name, given_name);
				if (result == false) {
					System.out.println("The player already exists.");
				}
			} else if (commands[0].equals("removeplayer")) {
				if (commands.length == 1) {
					System.out.println("Are you sure you want to remove all players? (y/n)");
					String a = in.nextLine();
					if (a.equals("y")) {
						players = new NimPlayer[100];// 把players这个数组指向一个new的新数组
						numOfPlayers = 0;// 重置玩家数
					}
				} else {
					String username = commands[1];
					boolean result = removePlayer(username);// 删除指定元素
					if (result == false) {
						System.out.println("The player does not exist");
					}
				}
			} else if (commands[0].equals("editplayer")) {
				String[] names = commands[1].split(",");
				String username = names[0];
				String family_name = names[1];
				String given_name = names[2];
				int result = containsPlayer(username);
				if (result == -1) {
					System.out.println("The player does not exist.");
				} else {
					players[result].setFamilyName(family_name);
					players[result].setGivenName(given_name);
				}
			} else if (commands[0].equals("resetstats")) {
				if (commands.length == 1) {
					System.out.println("Are you sure you want to reset all player statistics? (y/n)");
					String a = in.nextLine();
					if (a.equals("y")) {
						int i = 0;
						int num = 0;
						while (i < numOfPlayers) {
							players[i].setNumOfPlayedGames(num);
							players[i].setNumOfWonGames(num);
							i++;
						} // 重置玩家玩的游戏数
					}
				} else {
					String username = commands[1];
					int result = containsPlayer(username);
					if (result == -1) {
						System.out.println("The player does not exist.");
					} else {
						int a = 0;
						players[result].setNumOfPlayedGames(a);
						players[result].setNumOfWonGames(a);// 把Nimplayer
															// 里的numOfPlayedGames
															// numOfWonGames
															// 重新赋值成0
					}
				}
			} else if (commands[0].equals("displayplayer")) {
				if (commands.length == 1) {
					desc();
					for (int a = 0; a < numOfPlayers; a++) {
						System.out.println(players[a].getUserName() + "," + players[a].getGivenName() + ","
								+ players[a].getFamilyName() + "," + players[a].getNumOfPlayedGames() + " games,"
								+ players[a].getNumOfWonGames() + " wins");
					}
				} // display 所有玩家 先循环排序好 然后再循环输出
				else {
					String username = commands[1];
					int result = containsPlayer(username);
					if (result == -1) {
						System.out.println("The player does not exist.");
					} else {
						System.out.println(players[result].getUserName() + "," + players[result].getGivenName() + ","
								+ players[result].getFamilyName() + "," + players[result].getNumOfPlayedGames()
								+ " games," + players[result].getNumOfWonGames() + " wins");
					}
				}
			} else if (commands[0].equals("rankings")) {
				if (commands.length == 1 || commands[1].equals("desc")) {
					rankingDesc();
					for (int a = 0; a < numOfPlayers; a++) {
						System.out.println(players[a].getRatio()+" | "+players[a].getNumOfPlayedGames()+" games | "+players[a].getFamilyName()+" "+players[a].getGivenName());
					}
				} else {
					rankingAsc();
					for (int a = 0; a < numOfPlayers; a++) {
						System.out.println(players[a].getRatio()+" | "+players[a].getNumOfPlayedGames()+" games | "+players[a].getFamilyName()+" "+players[a].getGivenName());
					}
				}
			} else if (commands[0].equals("startgame")) {
				String[] game = commands[1].split(",");
				int numOfCurrentStones = Integer.valueOf(game[1]).intValue();// 把字符串转成int
				int upperbound = Integer.valueOf(game[0]).intValue();// 同上
				String name1 = game[2];
				String name2 = game[3];
				int a = containsPlayer(name1);
				int b = containsPlayer(name2);
				if (a == -1 || b == -1) {
					System.out.println("One of the players does not exist.");
				} else {
					NimGame nimgame = new NimGame(players[a], players[b], numOfCurrentStones, upperbound);
					nimgame.execute(in);// 引用NimGame 的方法
				}
			} else if (commands[0].equals("exit")) {
				System.out.println();
				in.close();
				System.exit(0);
			}
		}

	}

	public boolean addPlayer(String username, String family_name, String given_name) {
		int e = containsPlayer(username);
		if (e != -1) {
			return false;
		} else {
			NimPlayer player = new NimPlayer(username, given_name, family_name);
			players[numOfPlayers] = player;
			numOfPlayers++;
			return true;
		}
	}

	public int containsPlayer(String username) {
		for (int i = 0; i < numOfPlayers; i++) {
			NimPlayer player = players[i];
			if (player.getUserName().equals(username)) {
				return i;
			}
		}
		return -1;
	}

	public boolean removePlayer(String username) {
		int e = containsPlayer(username);
		if (e != -1) {
			players[e] = players[numOfPlayers - 1];// 用数组的最后一个元素替代制定元素
			numOfPlayers--;
			return true;//
		} else {
			return false;
		}
	}

	public void desc() {
		for (int i = 0; i < numOfPlayers - 1; i++) {
			for (int j = 0; j < numOfPlayers - 1 - i; j++) {
				if (players[j + 1].getUserName().compareTo(players[j].getUserName()) < 0) {
					NimPlayer temp = players[j + 1];
					players[j + 1] = players[j];
					players[j] = temp;
				}
			}
		}
	}

	public void rankingDesc() {
		for (int i = 0; i < numOfPlayers - 1; i++) {
			for (int j = 0; j < numOfPlayers - 1 - i; j++) {
				if (players[j + 1].getRatio() > players[j].getRatio()) {
					NimPlayer temp = players[j + 1];
					players[j + 1] = players[j];
					players[j] = temp;
				}
			}
		}
	}

	public void rankingAsc() {
		for (int i = 0; i < numOfPlayers - 1; i++) {
			for (int j = 0; j < numOfPlayers - 1 - i; j++) {
				if (players[j + 1].getRatio() < players[j].getRatio()) {
					NimPlayer temp = players[j + 1];
					players[j + 1] = players[j];
					players[j] = temp;
				}
			}
		}

	}

	public static void main(String[] args) {
		Nimsys nim = new Nimsys();
		nim.execute();
	}
}
