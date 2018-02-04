package codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Kickstart_2017_C_Matrix_Cutting {

	int testcaseCount=0;
	long[] result;
	
	public void readFromFile() {
		File file = new File("C-large-practice.in");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = reader.readLine();
			testcaseCount = Integer.parseInt(tempString);
			result=new long[testcaseCount];
			for (int i = 0; i < testcaseCount; i++) {
					tempString = reader.readLine();
					String[] tmp=tempString.split(" ");
					int rowNum=Integer.parseInt(tmp[0]);
					int columnNum=Integer.parseInt(tmp[1]);
					int[][] matrix=new int[rowNum][columnNum];
					for(int row=0;row<rowNum;row++){
						tempString = reader.readLine();
						tmp=tempString.split(" ");
						for(int col=0;col<columnNum;col++){
							matrix[row][col]=Integer.parseInt(tmp[col]);
						}
					}				
					long ans=solve(rowNum, columnNum, matrix);
					System.out.println(ans);
					result[i]=ans;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}
	
	public void outputToFile() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("output.txt");
			for (int i = 1; i <= testcaseCount; i++) {
				fw.write("Case #" + i + ": " + result[i - 1] + "\r\n");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e1) {
				}
			}
		}
	}
	
	public long solve(int rowNum,int columnNum,int[][] matrix) {		
		long[][][][] memo=new long[rowNum][columnNum][rowNum][columnNum];
		return helper(matrix,memo,  0, 0, rowNum-1, columnNum-1);
	}
	
	public long helper(int[][] matrix,long[][][][] memo,int topleftRow,int topLeftColumn,int rightBottomRow,int rightBottomColumn){
		if(memo[topleftRow][topLeftColumn][rightBottomRow][rightBottomColumn]>0){
			return memo[topleftRow][topLeftColumn][rightBottomRow][rightBottomColumn];
		}	
		if(topleftRow==rightBottomRow&&topLeftColumn==rightBottomColumn){
			return 0;
		}
		long maxVal=0;
		//从cutRow下方切
		for(int cutRow=topleftRow;cutRow<=rightBottomRow-1;cutRow++){
			maxVal=Math.max(maxVal, helper(matrix,memo, topleftRow, topLeftColumn, cutRow, rightBottomColumn)+
					                helper(matrix,memo, cutRow+1, topLeftColumn, rightBottomRow, rightBottomColumn));
		}
		//从cutColumn右侧切
		for(int cutColumn=topLeftColumn;cutColumn<=rightBottomColumn-1;cutColumn++){
			maxVal=Math.max(maxVal, helper(matrix,memo, topleftRow, topLeftColumn, rightBottomRow, cutColumn)+
					                helper(matrix,memo, topleftRow, cutColumn+1, rightBottomRow, rightBottomColumn));
		}
		memo[topleftRow][topLeftColumn][rightBottomRow][rightBottomColumn]=maxVal+getMinValue(matrix, topleftRow, topLeftColumn, rightBottomRow, rightBottomColumn);
		return memo[topleftRow][topLeftColumn][rightBottomRow][rightBottomColumn];
	}
	
	public long getMinValue(int[][] matrix,int topleftRow,int topLeftColumn,int rightBottomRow,int rightBottomColumn){
		long min=Long.MAX_VALUE;
		for(int i=topleftRow;i<=rightBottomRow;i++){
			for(int j=topLeftColumn;j<=rightBottomColumn;j++){
				min=Math.min(min, matrix[i][j]);
			}
		}
		return min;
	}
	
	public void procedure() {
		readFromFile();
		outputToFile();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kickstart_2017_C_Matrix_Cutting k=new Kickstart_2017_C_Matrix_Cutting();
//		int[][] matrix=new int[][]{
//			{1,2,1},
//			{2,3,2}
//		};
//		System.out.println(k.solve(2, 3, matrix));
		k.procedure();
	}
	
}
