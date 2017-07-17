package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Average_of_Levels_in_Binary_Tree_637 {

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> list=new ArrayList<Double>();
		if(root==null){
			return list;
		}
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			int size=queue.size();
			long sum=0;
			for(int i=0;i<size;i++){
				TreeNode node=queue.poll();
				sum+=node.val;
				if(node.left!=null){
					queue.offer(node.left);
				}
				if(node.right!=null){
					queue.offer(node.right);
				}
			}
			double avg=(double)sum/size;
			list.add(avg);
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Average_of_Levels_in_Binary_Tree_637 a=new Average_of_Levels_in_Binary_Tree_637();
		TreeNode root=new TreeNode(2147483647);
		root.left=new TreeNode(2147483647);
		root.right=new TreeNode(2147483647);
		List<Double> list=a.averageOfLevels(root);
		for(Double d:list){
			System.out.print(d+" ");
		}
	}

}
