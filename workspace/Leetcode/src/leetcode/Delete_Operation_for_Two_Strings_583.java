package leetcode;

public class Delete_Operation_for_Two_Strings_583 {

	public int minDistance(String word1, String word2) {
		char[] wc1=word1.toCharArray();
		char[] wc2=word2.toCharArray();
		int[][] DP=new int[wc1.length+1][wc2.length+1];
		for(int i=1;i<=wc1.length;i++){
			for(int j=1;j<=wc2.length;j++){
				char c1=wc1[i-1];
				char c2=wc2[j-1];
				if(c1==c2){
					DP[i][j]=DP[i-1][j-1]+1;
				}
				else{
					DP[i][j]=Math.max(DP[i-1][j], DP[i][j-1]);
				}
			}
		}
		int maxCommon=DP[wc1.length][wc2.length];
		int result=(wc1.length-maxCommon)+(wc2.length-maxCommon);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Delete_Operation_for_Two_Strings_583 d=new Delete_Operation_for_Two_Strings_583();
		System.out.println(d.minDistance("intention","execution"));
	}

}
