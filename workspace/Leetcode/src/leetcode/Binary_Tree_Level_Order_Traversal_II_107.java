package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Binary_Tree_Level_Order_Traversal_II_107 {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		if(root==null){
			return result;
		}
		Stack<List<Integer>> stack=new Stack<List<Integer>>();
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			int size=queue.size();
			List<Integer> list=new ArrayList<Integer>();
			for(int i=0;i<size;i++){
				TreeNode node=queue.poll();
				list.add(node.val);
				if(node.left!=null){
					queue.offer(node.left);
				}
				if(node.right!=null){
					queue.offer(node.right);
				}
			}
			stack.push(list);
		}
		
		while(!stack.isEmpty()){
			result.add(stack.pop());
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Binary_Tree_Level_Order_Traversal_II_107 b=new Binary_Tree_Level_Order_Traversal_II_107();
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(9);
		root.right=new TreeNode(20);
		root.right.left=new TreeNode(15);
		root.right.right=new TreeNode(7);
		List<List<Integer>> result=b.levelOrderBottom(root);
		for(List<Integer> list:result){
			for(Integer i:list){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}

}
