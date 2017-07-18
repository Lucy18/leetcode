package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Preorder_Traversal_144 {

	public List<Integer> preorderTraversal1(TreeNode root) {
		List<Integer> list=new ArrayList<Integer>();
		DFS(list,root);
		return list;
	}
	
	public void DFS(List<Integer> list,TreeNode node){
		if(node==null){
			return;
		}
		list.add(node.val);
		DFS(list,node.left);
		DFS(list,node.right);
	}
	
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> list=new ArrayList<Integer>();
		if(root==null){
			return list;
		}
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node=stack.pop();
			list.add(node.val);
			if(node.right!=null){
				stack.push(node.right);
			}
			if(node.left!=null){
				stack.push(node.left);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Binary_Tree_Preorder_Traversal_144 b=new Binary_Tree_Preorder_Traversal_144();
		TreeNode root=new TreeNode(1);
		root.right=new TreeNode(2);
		root.right.left=new TreeNode(3);
		List<Integer> list=b.preorderTraversal2(root);
		for(Integer i:list){
			System.out.print(i+" ");
		}
	}

}
