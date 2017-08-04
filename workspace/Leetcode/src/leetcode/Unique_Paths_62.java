package leetcode;

public class Unique_Paths_62 {

	public int DP(int m,int n){
		int[][] dp=new int[m][n];	
		for(int y=0;y<n;y++){
			dp[m-1][y]=1;//最下面一行全是1
		}
		for(int x=m-2;x>=0;x--){//从下面倒数第二层，一层层往上填充
			for(int y=n-1;y>=0;y--){
				int count=0;
				if(y==n-1){//最右边缘
					count+=dp[x+1][y];
				}
				else{
					count+=(dp[x+1][y]+dp[x][y+1]);
				}
				dp[x][y]=count;
			}
		}
		return dp[0][0];
	}
	
	public int uniquePaths(int m, int n) {
		int[][] directions=new int[][]{
				{0,1},{1,0}
		};//{0,1}是右移，{1,0}是下移
		Integer[][] memo=new Integer[m][n];
		memo[m-1][n-1]=1;
		//初始位置在(1,1），要走到(m,n)
		return move(1, 1, m, n, directions, memo);
	}
	
	public int move(int curX,int curY,int m,int n,
			int[][] directions,Integer[][] memo){
		if(curX>m||curY>n){
			return 0;
		}
		if(memo[curX-1][curY-1]!=null){
			return memo[curX-1][curY-1];
		}
		int rightCount=move(curX+directions[0][0], curY+directions[0][1], m, n,directions, memo);
		int downCount=move(curX+directions[1][0], curY+directions[1][1], m, n,directions, memo);
		memo[curX-1][curY-1]=rightCount+downCount;
		return memo[curX-1][curY-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Unique_Paths_62 u=new Unique_Paths_62();
		System.out.println(u.DP(3, 7));
	}

}
