package leetcode;

public class Battleships_in_a_Board_419 {

	public int countBattleships(char[][] board) {
		int count=0;
		int xLength=board.length;//xLength是行数
		int yLength=board[0].length;//yLength是列数
		int[][] isGoneThroguh = new int[xLength][yLength];
		for(int i=0;i<xLength;i++){
			for(int j=0;j<yLength;j++){
				if(isGoneThroguh[i][j]==1){
					continue;
				}
				if(board[i][j]=='.'){
					isGoneThroguh[i][j]=1;
					continue;
				}
				if(board[i][j]=='X'){
					if(j+1<yLength&&board[i][j+1]=='X'){
						while(j<yLength&&board[i][j]=='X'){
							isGoneThroguh[i][j]=1;
							j++;
						}
						j--;
						count++;
					}
					else if(i+1<xLength&&board[i+1][j]=='X'){
						int temp=i;
						while(temp<xLength&&board[temp][j]=='X'){
							isGoneThroguh[temp][j]=1;
							temp++;
						}
						count++;
					}
					else{
						count++;
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Battleships_in_a_Board_419 b = new Battleships_in_a_Board_419();
		char[][] a=new char[][]{{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
		System.out.println(b.countBattleships(a));	
	}

}
