package leetcode;

public class Beautiful_Arrangement_526 {
	int count=0;
	
	public void getNextPosition(int thisNum,int N,int[] nums,int leftNums){
		if(thisNum>N){
			return;
		}
		for(int i=1;i<=N;i++){
			if(nums[i]==0&&(i%thisNum==0||thisNum%i==0)){
				nums[i]=thisNum;
				leftNums--;
				if(leftNums==0){
					count++;
				}
				getNextPosition(thisNum+1, N, nums,leftNums);
				nums[i]=0;
				leftNums++;
			}
		}
	}

	public int countArrangement(int N) {
		if(N==1)
			return 1;
		for(int i=1;i<=N;i++){
			int[] nums=new int[N+1];
			nums[i]=1;
			getNextPosition(2,N,nums,N-1);
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Beautiful_Arrangement_526 b=new Beautiful_Arrangement_526();
		System.out.println(b.countArrangement(5));
	}

}
