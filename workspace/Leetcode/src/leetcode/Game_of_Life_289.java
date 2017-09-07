package leetcode;

public class Game_of_Life_289 {

	//活->活=3   活->死=1
	//死->死=0   死->活=2
	public void gameOfLife(int[][] board) {
		if(board.length==0||board[0].length==0){
			return;
		}
		int m=board.length;
		int n=board[0].length;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				int liveNeighbors=getLiveCells(board, m, n, i, j);
				//Any live cell with fewer than two live neighbors dies.
				//Any live cell with two or three live neighbors lives.
				//Any live cell with more than three live neighbors dies.
				//Any dead cell with exactly three live neighbors becomes a live cell.
				if(board[i][j]%2==1){  //如果当前cell是活着的
					if(liveNeighbors<2||liveNeighbors>3){
						board[i][j]=1;  //活->死
					}
					else{
						board[i][j]=3;  //活->活
					}
				}
				else{  //如果当前cel是死着的
					if(liveNeighbors==3){
						board[i][j]=2;  //死->活
					}
					else{
						board[i][j]=0;  //死->死
					}
				}
			}
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				board[i][j]=board[i][j]/2;
			}
		}
		return;
	}
	
	public int getLiveCells(int[][] board,int m,int n,int i,int j){
		int count=0;
		int[][] directions=new int[][]{
			{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}
		};
		for(int c=0;c<8;c++){
			int x=i+directions[c][0];
			int y=j+directions[c][1];
			if(x<0||x>=m||y<0||y>=n){
				continue;
			}
			if(board[x][y]%2==1){
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game_of_Life_289 g=new Game_of_Life_289();
		int[][] board=new int[][]{};
		g.gameOfLife(board);
	}

}
