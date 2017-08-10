package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Path_Sum_III_437 {

	int count=0;
	
	public int pathSum(TreeNode root, int sum) {
		List<Integer> list=new ArrayList<Integer>();
		DFS(root,list,sum);
		return count;
	}
	
	public void DFS(TreeNode root,List<Integer> prelist,int sum){
		if(root==null){
			return;
		}
		if(root.val==sum){
			count+=1;
		}
		int pre=0;
		for(int i=prelist.size()-1;i>=0;i--){
			pre+=prelist.get(i);
			if(pre+root.val==sum){
				count+=1;
			}
		}
		prelist.add(root.val);	
		
		DFS(root.left,prelist,sum);
		DFS(root.right,prelist,sum);
		prelist.remove(prelist.size()-1);		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path_Sum_III_437 p=new Path_Sum_III_437();
		TreeNode root=new TreeNode(10);
		root.left=new TreeNode(5);
		root.right=new TreeNode(-3);
		root.left.left=new TreeNode(3);
		root.left.right=new TreeNode(2);
		root.left.left.left=new TreeNode(3);
		root.left.left.right=new TreeNode(-2);
		root.left.right.right=new TreeNode(1);
		root.right.right=new TreeNode(11);	
		System.out.println(p.pathSum(root, 8));
	}

}
