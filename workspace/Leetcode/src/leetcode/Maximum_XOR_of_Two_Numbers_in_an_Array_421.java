package leetcode;

public class Maximum_XOR_of_Two_Numbers_in_an_Array_421 {

	public int findMaximumXOR(int[] nums) {
		int n=nums.length;
		if(n<2){
			return 0;
		}
		Trie root=new Trie();
		for(int i=0;i<nums.length;i++){
			int num=nums[i];
			Trie theNode=root;
			for(int bit=31;bit>=0;bit--){
				int index=(num>>bit)&1;
				if(theNode.children[index]==null){
					theNode.children[index]=new Trie();
					
				}
				theNode=theNode.children[index];
			}			
		}
		int max=0;
		for(int i=0;i<nums.length;i++){
			int num=nums[i];
			Trie theNode=root;
			int yihuo=0;
			for(int bit=31;bit>=0;bit--){
				int index=(num>>bit)&1;
				if(theNode.children[index^1]!=null){
					yihuo+=(1<<bit);
					theNode=theNode.children[index^1];
				}
				else{
					theNode=theNode.children[index];
				}
			}
			if(yihuo>max){
				max=yihuo;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maximum_XOR_of_Two_Numbers_in_an_Array_421 m=new Maximum_XOR_of_Two_Numbers_in_an_Array_421();
		int[] nums=new int[]{3, 10, 5, 25, 2, 8};
		System.out.println(m.findMaximumXOR(nums));
	}
	
	class Trie{
		Trie[] children;
		public Trie(){
			children=new Trie[2];
		}
	}

}
