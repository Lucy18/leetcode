package leetcode;

public class Keys_2_Keyboard_650 {

	public int minSteps(int n) {
		int[] memo=new int[n+1];
		memo[1]=0;
		return helper(n, memo);
	}
	
	public int helper(int n,int[] memo){
		if(n==1||memo[n]>0){
			return memo[n];
		}
		memo[n]=n;
		for(int i=2;i<=n/2;i++){
			if(n%i==0){
				int times=n/i;
				//复制1次+粘贴(times-1)次
				memo[n]=Math.min(memo[n], helper(i, memo)+times);
			}
		}
		return memo[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Keys_2_Keyboard_650 k=new Keys_2_Keyboard_650();
		System.out.println(k.minSteps(1));
	}

}
