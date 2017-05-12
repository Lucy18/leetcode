package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Find_Largest_Value_in_Each_Tree_Row_515 {
	
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> list=new ArrayList<Integer>();
		if(root==null){
			return list;
		}
		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size=queue.size();
			int max=Integer.MIN_VALUE;
			for(int i=0;i<size;i++){
				TreeNode theNode=queue.poll();
				max=max>theNode.val?max:theNode.val;
				if(theNode.left!=null){
					queue.add(theNode.left);
				}
				if(theNode.right!=null){
					queue.add(theNode.right);
				}
			}
			list.add(max);
		}
		return list;
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Find_Largest_Value_in_Each_Tree_Row_515 f=new Find_Largest_Value_in_Each_Tree_Row_515();
		TreeNode a=new TreeNode(1);
		a.left=new TreeNode(3);
		a.right=new TreeNode(2);
		a.left.left=new TreeNode(5);
		a.left.right=new TreeNode(3);
		a.right.left=new TreeNode(9);
		List<Integer> result=f.largestValues(a);
		for(Integer i:result){
			System.out.println(i);
		}
	}

}
