package leetcode;

public class Maximum_Binary_Tree_654 {

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return construt(nums, 0, nums.length-1);
	}
	
	public TreeNode construt(int[] nums,int left,int right){
		if(left>right){
			return null;
		}
		int max=nums[left];
		int max_index=left;
		for(int i=left+1;i<=right;i++){
			if(nums[i]>max){
				max=nums[i];
				max_index=i;
			}
		}
		TreeNode root=new TreeNode(max);
		root.left=construt(nums, left, max_index-1);
		root.right=construt(nums, max_index+1, right);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maximum_Binary_Tree_654 m=new Maximum_Binary_Tree_654();
		int[] nums=new int[]{3,2,1,6,0,5};
		TreeNode root=m.constructMaximumBinaryTree(nums);
		System.out.println(1);
	}

}
