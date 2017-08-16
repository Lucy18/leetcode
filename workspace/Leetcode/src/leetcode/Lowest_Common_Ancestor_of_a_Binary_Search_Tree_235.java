package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree_235 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> pPath=new ArrayList<TreeNode>();
		List<TreeNode> qPath=new ArrayList<TreeNode>();
		boolean[] isFind=new boolean[1];
		isFind[0]=false;
		findPath(root, p, pPath, isFind);
		isFind[0]=false;
		findPath(root, q, qPath, isFind);
		for(int i=pPath.size()-1;i>=0;i--){
			for(int j=qPath.size()-1;j>=0;j--){
				if(pPath.get(i)==qPath.get(j)){
					return pPath.get(i);
				}
			}
		}
		return null;
	}
	
	public void findPath(TreeNode node, TreeNode target,
			List<TreeNode> path,boolean[] isFind){
		if(node==null||isFind[0]==true){
			return;
		}
		path.add(node);
		if(node==target){
			isFind[0]=true;
			return;
		}
		findPath(node.left, target, path, isFind);
		if(isFind[0]==false){
			findPath(node.right, target, path, isFind);
		}
		if(isFind[0]==false){
			path.remove(node);
		}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lowest_Common_Ancestor_of_a_Binary_Search_Tree_235 l=new Lowest_Common_Ancestor_of_a_Binary_Search_Tree_235();
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(1);
		root.right=new TreeNode(4);
		root.left.right=new TreeNode(2);
		TreeNode result=l.lowestCommonAncestor(root, root.left, root.left.right);
		System.out.println(result.val);
	}

}
