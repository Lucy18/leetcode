package leetcode;

public class Maximum_Product_of_Three_Numbers_628 {

	public int maximumProduct(int[] nums) {
		if(nums.length==3){
			return nums[0]*nums[1]*nums[2];
		}
		int[] three_Positive=new int[3];
		int[] three_negaive=new int[3];
		int[] three_negative_max=new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
		for(int i=0;i<nums.length;i++){
			int the=nums[i];
			if(the>=0){
				if(the>three_Positive[0]){
					three_Positive[0]=the;
					if(the>three_Positive[2]){
						swap(three_Positive, 0, 1);
						swap(three_Positive, 1, 2);
					}
					else if(the>three_Positive[1]){
						swap(three_Positive, 0, 1);
					}
				}
			}
			else{
				if(the<three_negaive[0]){
					three_negaive[0]=the;
					if(the<three_negaive[2]){
						swap(three_negaive, 0, 1);
						swap(three_negaive, 1, 2);
					}
					else if(the<three_negaive[1]){
						swap(three_negaive, 0, 1);
					}
				}
				if(the>three_negative_max[0]){
					three_negative_max[0]=the;
					if(the>three_negative_max[2]){
						swap(three_negative_max, 0, 1);
						swap(three_negative_max, 1, 2);
					}
					else if(the>three_negative_max[1]){
						swap(three_negative_max, 0, 1);
					}
				}
			}
			
		}
		int product=1;
	    if(three_Positive[2]>0){
	    	product=three_Positive[2];
	    	if(three_Positive[0]*three_Positive[1]>three_negaive[1]*three_negaive[2]){
				product=product*three_Positive[0]*three_Positive[1];
			}
			else{
				product=product*three_negaive[1]*three_negaive[2];
			}
	    }
	    else{
	    	product=three_negative_max[0]*three_negative_max[1]*three_negative_max[2];
	    }
		return product;
	}
	
	
	public void swap(int[] three,int i,int j){
		int temp=three[i];
		three[i]=three[j];
		three[j]=temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maximum_Product_of_Three_Numbers_628 m=new Maximum_Product_of_Three_Numbers_628();
		int[] nums=new int[]{-4,-3,-2,-1,60};
		int[] nums1=new int[]{1,0,100};
		int[] nums2=new int[]{0,0,0,4};
		int[] nums3=new int[]{-5,-4,-3,-2,-1};
		System.out.println(m.maximumProduct(nums3));
	}

}
