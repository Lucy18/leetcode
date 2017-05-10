package leetcode;

public class Optimal_Division_553 {
	
	public String optimalDivision(int[] nums) {
		String s="";
		if(nums.length==1){
			return s+nums[0];
		}
		if(nums.length==2){
			return s+nums[0]+"/"+nums[1];
		}
		
		s+=nums[0]+"/(";
		s+=nums[1];
		for(int i=2;i<nums.length;i++){
			s+="/"+nums[i];
		}
		s+=")";
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Optimal_Division_553 o=new Optimal_Division_553();
		int[] a=new int[]{1000,100,10,2};
		System.out.println(o.optimalDivision(a));
	}

}
