package leetcode;

public class Binary_Tree_Maximum_Path_Sum_124 {

	public int maxPathSum(TreeNode root) {
		int[] maxSum=new int[1];
		maxSum[0]=Integer.MIN_VALUE;
		helper(root, maxSum);
		return maxSum[0];
	}
	
	public int helper(TreeNode node,int[] maxSum){
		if(node==null){
			return 0;
		}
		int leftMax=helper(node.left, maxSum);
		int rightMax=helper(node.right, maxSum);
		if(leftMax+node.val>maxSum[0]){
			maxSum[0]=leftMax+node.val;
		}
		if(rightMax+node.val>maxSum[0]){
			maxSum[0]=rightMax+node.val;
		}
		if(leftMax+node.val+rightMax>maxSum[0]){
			maxSum[0]=leftMax+node.val+rightMax;
		}
		int returnValue;
		returnValue=Math.max(leftMax+node.val, node.val);
		returnValue=Math.max(returnValue, rightMax+node.val);
		if(returnValue<0){
			returnValue=0;
		}
		return returnValue;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Binary_Tree_Maximum_Path_Sum_124 b=new Binary_Tree_Maximum_Path_Sum_124();
		TreeNode root=new TreeNode(-2);
		root.left=new TreeNode(-1);
		System.out.println(b.maxPathSum(root));
	}

}
