package leetcode;

public class Convert_Sorted_Array_to_Binary_Search_Tree_108 {

	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length==0){
			return null;
		}
		return helper(nums, 0, nums.length-1);
	}
	
	public TreeNode helper(int[] nums,int left,int right){
		if(left>right){
			return null;
		}
		if(left==right){
			return new TreeNode(nums[left]);
		}
		int mid=(int)Math.ceil( (double)(left+right)/2 );
		TreeNode node=new TreeNode(nums[mid]);
		node.left=helper(nums, left, mid-1);
		node.right=helper(nums, mid+1, right);
		return node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Convert_Sorted_Array_to_Binary_Search_Tree_108 c=new Convert_Sorted_Array_to_Binary_Search_Tree_108();
		int[] nums=new int[]{1,2,3,4};
		TreeNode node=c.sortedArrayToBST(nums);
		System.out.println(node.val);
	}

}
