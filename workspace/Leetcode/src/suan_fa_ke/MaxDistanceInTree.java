package suan_fa_ke;

import leetcode.TreeNode;

/**
 * 完成求二叉树中节点间最大距离的代码。两个节点间的距离为包括的节点的个数,路径上的每个节点只能被包含一次。
 *
 */
public class MaxDistanceInTree {

	int maxDistance=0;
	
	int getMaxDistance(TreeNode root){
		heightOfBinaryTree(root);
		return maxDistance;
	}
	
	int heightOfBinaryTree(TreeNode pNode){  
	    if (pNode == null)  
	        return 0;   //空节点的高度为0  
	    //递归  
	    int heightOfLeftTree = heightOfBinaryTree(pNode.left);   //左子树的的高度 
	    int heightOfRightTree = heightOfBinaryTree(pNode.right) ;   //右子树的高度
	    int distance = heightOfLeftTree + heightOfRightTree+1;    //距离等于左子树的高度加上右子树的高度+1 
	    maxDistance=Math.max(maxDistance, distance);           //得到距离的最大值  
	    int height=Math.max(heightOfLeftTree, heightOfRightTree)+1;
	    return height;  
	}  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxDistanceInTree maxDistanceInTree=new MaxDistanceInTree();
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.left.left=new TreeNode(4);
		root.left.left.right=new TreeNode(7);
		root.right=new TreeNode(3);
		root.right.left=new TreeNode(5);
		root.right.right=new TreeNode(6);
		root.right.right.left=new TreeNode(8);
		System.out.println(maxDistanceInTree.getMaxDistance(root));
	}

}
