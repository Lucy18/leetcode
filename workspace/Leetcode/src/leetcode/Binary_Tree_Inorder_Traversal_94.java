package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Inorder_Traversal_94 {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list=new ArrayList<Integer>();
		inorder(root, list);
		return list;
	}
	
	public void inorder(TreeNode node,List<Integer> list){
		if(node==null){
			return;
		}
		inorder(node.left, list);
		list.add(node.val);
		inorder(node.right, list);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Binary_Tree_Inorder_Traversal_94 b=new Binary_Tree_Inorder_Traversal_94();
		TreeNode root=new TreeNode(1);
		root.right=new TreeNode(2);
		root.right.left=new TreeNode(3);
		List<Integer> list=b.inorderTraversal(root);
		for(Integer i:list){
			System.out.print(i+" ");
		}
	}

}
