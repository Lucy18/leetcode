package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Minimum_Distance_Between_BST_Nodes_783 {	
	
	public int minDiffInBST(TreeNode root) {
		List<Integer> list=new ArrayList<Integer>();
		dfs(root, list);
		Collections.sort(list);
		int min=Integer.MAX_VALUE;
		for(int i=0;i<list.size()-1;i++){
			int distance=list.get(i+1)-list.get(i);
			min=Math.min(min, distance);
		}
		return min;
	}
	
	public void dfs(TreeNode node,List<Integer> list){
		if(node!=null){
			list.add(node.val);
			dfs(node.left, list);
			dfs(node.right, list);
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
