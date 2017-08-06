package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subtree_of_Another_Tree_572 {

	public boolean isSubtree(TreeNode s, TreeNode t) {
		List<TreeNode> rootNodes=new ArrayList<TreeNode>();
		DFS(s, rootNodes, t.val);
		for(TreeNode m:rootNodes){
			if(isSame(m, t)==true){
				return true;
			}
		}
		return false;
	}
	
	public void DFS(TreeNode node,List<TreeNode> list,int rootVal){
		if(node==null){
			return;
		}
		if(node.val==rootVal){
			list.add(node);
		}
		DFS(node.left,list,rootVal);
		DFS(node.right,list,rootVal);
	}
	
	public boolean isSame(TreeNode m,TreeNode n){
		if(m==null&&n==null){
			return true;
		}
		if(m!=null && n!=null){
			if(m.val!=n.val){
				return false;
			}
			else{
				return isSame(m.left, n.left) && isSame(m.right, n.right);
			}
		}
		else{
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subtree_of_Another_Tree_572 sub=new Subtree_of_Another_Tree_572();
		TreeNode s=new TreeNode(3);
		s.left=new TreeNode(4);
		s.right=new TreeNode(5);
		s.left.left=new TreeNode(1);
		s.left.right=new TreeNode(2);
		s.left.right.left=new TreeNode(0);
		TreeNode t=new TreeNode(4);
		t.left=new TreeNode(1);
		t.right=new TreeNode(2);
		System.out.println(sub.isSubtree(s, t));
	}

}
