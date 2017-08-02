package leetcode;


public class Four_Keys_Keyboard_651 {
	
	public int maxA(int N) {
		Integer[] memo=new Integer[N+1];
		return helper(N,memo);
	}
	
	public Integer helper(int N,Integer[] memo){
		if(memo[N]!=null){
			return memo[N];
		}
		if(N<3){
			memo[N]=N;
			return N;
		}
		else{
			int maxCount=0;
			for(int i=3;i<N;i++){
				int count=helper(N-i, memo)*(i-1);
				if(count>maxCount){
					maxCount=count;
				}
			}
			if(N>maxCount){
				maxCount=N;
			}
			memo[N]=maxCount;
			return maxCount;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Four_Keys_Keyboard_651 f=new Four_Keys_Keyboard_651();
		System.out.println(f.maxA(9));
	}

}
