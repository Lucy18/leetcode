//package codejam;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class mofangcplus {
//	
//	int testcaseCount=0;
//	int MAXN=45;
//	int INF=0x3f3f3f3f;
//	int n,m;
//	int[][] a=new int[MAXN][MAXN];
//	int[][][][] dp=new int[MAXN][MAXN][MAXN][MAXN];
//	int[][][][] mi=new int[MAXN][MAXN][MAXN][MAXN];
//	
//	void initmi(int x,int y)
//	{
//		
//		for(int i=x-1;i<=n;i++)
//	     mi[x][y][i][y-1]=INF;
//		for(int j=y-1;j<=m;j++)
//	     mi[x][y][x-1][j]=INF;
//	}
//	
//	void Input(int rowNum, int columnNum, int[][] matrix)
//	{
//		n=rowNum;
//		m=columnNum;
//	 
//	    for(int i=1;i<=n;i++)
//	    {
//	    	for(int j=1;j<=m;j++)
//	        {
//	    		a[i][j]=matrix[i-1][j-1];
//	        }
//	    }
//	    for(int i=1;i<=n;i++)     
//	    {
//	    	for(int j=1;j<=m;j++)
//	        {
//	            initmi(i,j);
//	           
//	            for(int p=i;p<=n;p++)
//	            {
//	            	for(int q=j;q<=m;q++)
//	                {
//	                    mi[i][j][p][q]=Math.min(Math.min(a[p][q],mi[i][j][p-1][q]),mi[i][j][p][q-1]);
//	                }
//	            }
//	        }
//	    }
//	    dp=new int[MAXN][MAXN][MAXN][MAXN];
//	}
//	int f(int u,int d,int l,int r)
//	{
//	    if(u==d&&l==r) return 0;
//	    if(dp[u][d][l][r]>0) return dp[u][d][l][r];
//	    int ans=0;
//	    
//	    for(int i=u;i<=d-1;i++)
//	    {
//	        ans=Math.max(ans,f(u,i,l,r)+f(i+1,d,l,r));
//	    }
//	    for(int j=l;j<=r-1;j++)
//	    {
//	        ans=Math.max(ans,f(u,d,l,j)+f(u,d,j+1,r));
//	    }
//	    dp[u][d][l][r]=ans+getMinValue(a, u, l, d, r);
//	    return dp[u][d][l][r];
//	}
//	
//	public long helper(int u,int topLeftColumn,int rightBottomRow,int rightBottomColumn){
//		if(memo[u][topLeftColumn][rightBottomRow][rightBottomColumn]>0){
//			return memo[u][topLeftColumn][rightBottomRow][rightBottomColumn];
//		}	
//		if(topleftRow==rightBottomRow&&topLeftColumn==rightBottomColumn){
//			return 0;
//		}
//		long maxVal=0;
//		//从cutRow下方切
//		for(int cutRow=u;cutRow<=rightBottomRow-1;cutRow++){
//			maxVal=Math.max(maxVal, helper(u, topLeftColumn, cutRow, rightBottomColumn)+
//					                helper(cutRow+1, topLeftColumn, rightBottomRow, rightBottomColumn));
//				System.out.println("ans1:"+maxVal+" cutRow:"+cutRow);
//		}
//		//从cutColumn右侧切
//		for(int cutColumn=topLeftColumn;cutColumn<=rightBottomColumn-1;cutColumn++){
//			maxVal=Math.max(maxVal, helper(topleftRow, topLeftColumn, topleftRow, cutColumn)+
//					                helper(matrix,memo, topleftRow, cutColumn+1, rightBottomRow, rightBottomColumn));
//				System.out.println("ans2:"+maxVal+" cutColumn:"+cutColumn);
//		}
//		memo[topleftRow][topLeftColumn][rightBottomRow][rightBottomColumn]=maxVal+getMinValue(matrix, topleftRow, topLeftColumn, rightBottomRow, rightBottomColumn);
//		return memo[topleftRow][topLeftColumn][rightBottomRow][rightBottomColumn];
//	}
//	
//	public int getMinValue(int[][] matrix,int topleftRow,int topLeftColumn,int rightBottomRow,int rightBottomColumn){
//		int min=Integer.MAX_VALUE;
//		for(int i=topleftRow;i<=rightBottomRow;i++){
//			for(int j=topLeftColumn;j<=rightBottomColumn;j++){
//				min=Math.min(min, matrix[i][j]);
//			}
//		}
//		return min;
//	}
//	
//	public void readFromFile() {
//		//File file = new File("C-large-practice.in");
//		File file = new File("test.txt");
//		BufferedReader reader = null;
//		try {
//			reader = new BufferedReader(new FileReader(file));
//			String tempString = reader.readLine();
//			testcaseCount = Integer.parseInt(tempString);
//			for (int i = 0; i < testcaseCount; i++) {
//					tempString = reader.readLine();
//					String[] tmp=tempString.split(" ");
//					int rowNum=Integer.parseInt(tmp[0]);
//					int columnNum=Integer.parseInt(tmp[1]);
//					int[][] matrix=new int[rowNum][columnNum];
//					for(int row=0;row<rowNum;row++){
//						tempString = reader.readLine();
//						tmp=tempString.split(" ");
//						for(int col=0;col<columnNum;col++){
//							matrix[row][col]=Integer.parseInt(tmp[col]);
//						}
//					}	
//				    Input(rowNum, columnNum, matrix);
//				    int ans=f(1,n,1,m);
//				    System.out.println("Case #"+(i+1)+": "+ans+"\n");
//			}
//			reader.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if (reader != null) {
//				try {
//					reader.close();
//				} catch (IOException e1) {
//				}
//			}
//		}
//	}
//	
//	public static void main(String[] args) {
//		mofangcplus m=new mofangcplus();
//		m.readFromFile();
//	}
//}
