package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Level_Order_Traversal_102 {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		helper(res, 0, root);
		return res;
	}
	public void helper(List<List<Integer>> res,int level,TreeNode node){
		if(node==null){
			return;
		}
		if(res.size()==level){
			res.add(new ArrayList<Integer>());
		}
		res.get(level).add(node.val);
		helper(res, level+1, node.left);
		helper(res, level+1, node.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Binary_Tree_Level_Order_Traversal_102 b=new Binary_Tree_Level_Order_Traversal_102();
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(9);
		root.right=new TreeNode(20);
		root.right.left=new TreeNode(15);
		root.right.right=new TreeNode(7);
		List<List<Integer>> res=b.levelOrder(root);
		for(List<Integer> list:res){
			for(Integer i:list){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}

}
