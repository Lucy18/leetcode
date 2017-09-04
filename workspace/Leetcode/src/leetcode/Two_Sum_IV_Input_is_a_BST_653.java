package leetcode;

import java.util.HashSet;

public class Two_Sum_IV_Input_is_a_BST_653 {

	public boolean findTarget(TreeNode root, int k) {
		HashSet<Integer> hashSet=new HashSet<Integer>();
		return find(root, k, hashSet);
	}
	
	public boolean find(TreeNode node,int k,HashSet<Integer> hashSet){
		if(node==null){
			return false;
		}
		if(hashSet.contains(k-node.val)){
			return true;
		}
		hashSet.add(node.val);
		return find(node.left, k, hashSet)||find(node.right, k, hashSet);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Two_Sum_IV_Input_is_a_BST_653 s=new Two_Sum_IV_Input_is_a_BST_653();
		TreeNode root=new TreeNode(5);
		root.left=new TreeNode(3);
		root.right=new TreeNode(6);
		root.left.left=new TreeNode(2);
		root.left.right=new TreeNode(4);
		root.right.right=new TreeNode(7);
		System.out.println(s.findTarget(root, 28));
	}

}
