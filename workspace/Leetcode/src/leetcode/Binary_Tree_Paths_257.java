package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Paths_257 {

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> list=new ArrayList<String>();
		if(root==null){
			return list;
		}
		helper(root, list, new ArrayList<Integer>());
		return list;
	}
	
	public void helper(TreeNode node,List<String> list,List<Integer> currentPath){
		currentPath.add(node.val);
		
		if(node.left==null&&node.right==null){		
			list.add(getString(currentPath));
		}
		if(node.left!=null){
			helper(node.left, list, currentPath);
		}
		if(node.right!=null){
			helper(node.right, list, currentPath);
		}
		currentPath.remove(currentPath.size()-1);
	}
	
	public String getString(List<Integer> currentPath){
		String result=currentPath.get(0)+"";
		for(int i=1;i<currentPath.size();i++){
			result+="->"+currentPath.get(i);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Binary_Tree_Paths_257 b=new Binary_Tree_Paths_257();
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.right=new TreeNode(5);
		List<String> list=b.binaryTreePaths(root);
		for(String s:list){
			System.out.println(s);
		}
	}

}
