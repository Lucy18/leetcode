package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Kth_Smallest_Element_in_a_BST_230 {

	public int kthSmallest(TreeNode root, int k) {
		List<Integer> list=new ArrayList<Integer>();
		traversal(root, k, list);
		return list.get(k-1);
	}
	
	public void traversal(TreeNode node,int k,List<Integer> list){
		if(node==null||list.size()==k){
			return;
		}
		traversal(node.left, k, list);
		list.add(node.val);
		if(list.size()<k){
			traversal(node.right, k, list);
		}			
	}

}