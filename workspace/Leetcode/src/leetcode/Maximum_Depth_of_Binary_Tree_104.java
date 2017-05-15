package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Depth_of_Binary_Tree_104 {

	public int maxDepth(TreeNode root) {
		if(root==null){
			return 0;
		}
		int count=0;
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size=queue.size();
			count++;
			for(int i=0;i<size;i++){
				TreeNode theNode=queue.poll();
				if(theNode.left!=null) queue.add(theNode.left);
				if(theNode.right!=null) queue.add(theNode.right);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
