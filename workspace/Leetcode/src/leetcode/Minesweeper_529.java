package leetcode;

public class Minesweeper_529 {

	public char[][] updateBoard(char[][] board, int[] click) {
		int x=click[0];
		int y=click[1];
		if(board[x][y]=='M'){
			board[x][y]='X';
			return board;
		}
		if(board[x][y]!='E'){
			return board;
		}
		int xLength=board.length;
		int yLength=board[0].length;
		int countMines=0;
		if(x-1>=0){//不在第一行
			if(board[x-1][y]=='M'){//[x-1][y]
				countMines++;
			}
			if(y-1>=0){
				if(board[x-1][y-1]=='M'){//[x-1][y-1]
					countMines++;
				}
			}
			if(y+1<yLength){
				if(board[x-1][y+1]=='M'){//[x-1][y+1]
					countMines++;
				}
			}
		}
		if(x+1<xLength){//不在最后一行
			if(board[x+1][y]=='M'){//[x+1][y]
				countMines++;
			}
			if(y-1>=0){
				if(board[x+1][y-1]=='M'){//[x+1][y-1]
					countMines++;
				}
			}
			if(y+1<yLength){
				if(board[x+1][y+1]=='M'){//[x+1][y+1]
					countMines++;
				}
			}
		}
		if(y-1>=0){//不在最左列
			if(board[x][y-1]=='M'){//[x][y-1]
				countMines++;
			}
		}
		if(y+1<yLength){//不在最右列
			if(board[x][y+1]=='M'){//[x][y+1]
				countMines++;
			}
		}
		if(countMines!=0){
			board[x][y]=(char)('0'+countMines);
		}
		else{
			board[x][y]='B';
			if(x-1>=0){//不在第一行
				click[0]=x-1;
				click[1]=y;
				updateBoard(board, click);
				if(y-1>=0){
					click[0]=x-1;
					click[1]=y-1;
					updateBoard(board, click);
				}
				if(y+1<yLength){
					click[0]=x-1;
					click[1]=y+1;
					updateBoard(board, click);
				}
			}
			if(x+1<xLength){//不在最后一行
				click[0]=x+1;
				click[1]=y;
				updateBoard(board, click);
				if(y-1>=0){
					click[0]=x+1;
					click[1]=y-1;
					updateBoard(board, click);
				}
				if(y+1<yLength){
					click[0]=x+1;
					click[1]=y+1;
					updateBoard(board, click);
				}
			}
			if(y-1>=0){//不在最左列
				click[0]=x;
				click[1]=y-1;
				updateBoard(board, click);
			}
			if(y+1<yLength){//不在最右列
				click[0]=x;
				click[1]=y+1;
				updateBoard(board, click);
			}
		}
		return board;
	}

	public static void main(String[] args) {
		Minesweeper_529 m=new Minesweeper_529();
		char[][] a=new char[][]{{'E', 'E', 'E', 'E', 'E'},{'E', 'E', 'M', 'E', 'E'},
			{'E', 'E', 'E', 'E', 'E'},{'E', 'E', 'E', 'E', 'E'}};
		int[] click=new int[]{3,0};
		char[][] b=m.updateBoard(a, click);
		int xLength=b.length;
		int yLength=b[0].length;
		for(int i=0;i<xLength;i++){
			for(int j=0;j<yLength;j++){
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
	}
}
