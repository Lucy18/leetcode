package leetcode;

public class Balanced_Binary_Tree_110 {

    boolean isBalanced=true;
    
	public boolean isBalanced(TreeNode root) {
		if(root==null){
			return true;
		}
		helper(root);
		return isBalanced;
	}
	
	//返回左右子树的高度
	public int[] helper(TreeNode node){
		if(node.left==null&&node.right==null){
			return new int[]{0,0};
		}
		int left=0;
		int right=0;
		if(node.left!=null){
			//左子树的高度等于 1+以左结点为根的左右子树的最大高度
			int[] subLeft=helper(node.left);
			left=1+Math.max(subLeft[0], subLeft[1]);
		}
		if(node.right!=null){
			int[] subRight=helper(node.right);
			right=1+Math.max(subRight[0], subRight[1]);
		}
		if(Math.abs(left-right)>1){
			isBalanced=false;
		}
		return new int[]{left,right};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Balanced_Binary_Tree_110 b=new Balanced_Binary_Tree_110();
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.left.left.right=new TreeNode(5);
		System.out.println(b.isBalanced(root));
	}

}
