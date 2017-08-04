package leetcode;

public class Unique_Binary_Search_Trees_96 {

	public int numTrees(int n) {
		Integer[] memo=new Integer[n+1];
		memo[0]=0;
		memo[1]=1;
		return helper(n, memo);
	}
	
	public int helper(int n,Integer[] memo){
		if(memo[n]!=null){
			return memo[n];
		}
		int count=0;
		for(int i=1;i<=n;i++){//1~n数中选择i作为根节点
			int leftNum=i-1;
			int rightNum=n-i;
			int leftCount=helper(leftNum, memo);
			int rightCount=helper(rightNum, memo);
			if(leftCount==0){
				count+=rightCount;
			}
			else if(rightCount==0){
				count+=leftCount;
			}
			else{//都不为0
				count+= leftCount*rightCount;
			}
		}
		memo[n]=count;
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Unique_Binary_Search_Trees_96 u=new Unique_Binary_Search_Trees_96();
		System.out.println(u.numTrees(3));
	}
}
