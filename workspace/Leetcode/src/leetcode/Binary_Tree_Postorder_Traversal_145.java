package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Postorder_Traversal_145 {

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list=new ArrayList<Integer>();
		if(root==null){
			return list;
		}
		Stack<TreeNodeUsed> stack=new Stack<>();
		stack.push(new TreeNodeUsed(root));
		while(!stack.isEmpty()){
			TreeNodeUsed nodeUsed=stack.pop();
			if(nodeUsed.leftUsed==true&&nodeUsed.rightUsed==true){
				list.add(nodeUsed.node.val);
			}
			else{
				nodeUsed.rightUsed=true;
				nodeUsed.leftUsed=true;
				stack.push(nodeUsed);
				if(nodeUsed.node.right!=null){
					stack.push(new TreeNodeUsed(nodeUsed.node.right));
				}
				if(nodeUsed.node.left!=null){
					stack.push(new TreeNodeUsed(nodeUsed.node.left));
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Binary_Tree_Postorder_Traversal_145 b=new Binary_Tree_Postorder_Traversal_145();
		TreeNode root=new TreeNode(1);
		root.right=new TreeNode(2);
		root.right.left=new TreeNode(3);
		List<Integer> list=b.postorderTraversal(root);
		for(Integer i:list){
			System.out.print(i+" ");
		}
	}
	
	class TreeNodeUsed{
		TreeNode node;
		boolean leftUsed;
		boolean rightUsed;
		public TreeNodeUsed(TreeNode n){
			node=n;
			leftUsed=false;
			rightUsed=false;
		}
	}
}
