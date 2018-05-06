package boss;

public class NimPlayer {
	
	String userName;
	String givenName;
	String familyName;
	int numOfPlayedGames;
	int numOfWonGames;

	public NimPlayer(String userName, String givenName, String familyName) {
		this.userName = userName;
		this.givenName = givenName;
		this.familyName = familyName;
		numOfPlayedGames=0;
		numOfWonGames=0;
	}

	public String getUserName() {
		return userName;
	}

	public String getGivenName() {
		return givenName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public int getNumOfPlayedGames() {
		return numOfPlayedGames;
	}

	public int getNumOfWonGames() {
		return numOfWonGames;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public void setNumOfPlayedGames(int numOfPlayedGames) {
		this.numOfPlayedGames = numOfPlayedGames;
	}

	public void setNumOfWonGames(int numOfWonGames) {
		this.numOfWonGames = numOfWonGames;
	}

}
