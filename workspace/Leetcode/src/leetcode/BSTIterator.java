package leetcode;

import java.util.Stack;

public class BSTIterator {

	Stack<TreeNode> stack;
	
	public BSTIterator(TreeNode root) {
		stack=new Stack<TreeNode>();
		while(root!=null){
			stack.push(root);
			root=root.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node=stack.pop();
		int val=node.val;
		if(node.right!=null){
			stack.push(node.right);
			node=node.right;
			while(node.left!=null){
				stack.push(node.left);
				node=node.left;
			}
		}		
		return val;
	}

	public static void main(String[] args) {
		TreeNode root=new TreeNode(4);
		root.left=new TreeNode(1);
		root.left.right=new TreeNode(3);
		root.left.right.left=new TreeNode(2);
		root.right=new TreeNode(5);
		root.right.right=new TreeNode(7);
		root.right.right.left=new TreeNode(6);
		BSTIterator iterator=new BSTIterator(root);
		while(iterator.hasNext()){
			System.out.print(iterator.next()+" ");
		}
	}
}
