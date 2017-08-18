package leetcode;

public class Ones_and_Zeroes_474 {
	
	public int findMaxForm(String[] strs, int m, int n) {
		int[][] str01Count=new int[strs.length][2];
		for(int i=0;i<strs.length;i++){
			char[] cs=strs[i].toCharArray();
			int count0=0;int count1=0;
			for(int j=0;j<cs.length;j++){
				if(cs[j]=='0'){
					count0++;
				}
				else {
					count1++;
				}
			}
			str01Count[i]=new int[]{count0,count1};
		}
		Integer[][][] memo=new Integer[strs.length][m+1][n+1];
		return helper(str01Count, 0, m, n, memo);
	}
	
	public int helper(int[][] str01Count,int index,int m,int n,
			Integer[][][] memo){
		if(index>=str01Count.length){
			return 0;
		}
		if(memo[index][m][n]!=null){
			return memo[index][m][n];
		}
		int maxCount=0;
		int count1=helper(str01Count, index+1, m, n,memo);
		int count2=0;
		if(m>=str01Count[index][0]&&n>=str01Count[index][1]){
			count2=1+helper(str01Count, index+1, m-str01Count[index][0], n-str01Count[index][1],memo);
		}
		maxCount=Math.max(count1, count2);
		memo[index][m][n]=maxCount;
		return maxCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ones_and_Zeroes_474 o=new Ones_and_Zeroes_474();
		String[] strs=new String[]{"11","11","0","0","10","1","1","0","11","1","0","111","11111000","0","11","000","1","1","0","00","1","101","001","000","0","00","0011","0","10000"};
		System.out.println(o.findMaxForm(strs, 90, 66));
	}

}
