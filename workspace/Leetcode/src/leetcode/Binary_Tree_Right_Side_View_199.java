package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Right_Side_View_199 {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result=new ArrayList<Integer>();
		if(root==null){
			return result;
		}
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			int size=queue.size();
			for(int i=0;i<size;i++){
				TreeNode node=queue.poll();
				if(node.left!=null){
					queue.offer(node.left);
				}
				if(node.right!=null){
					queue.offer(node.right);
				}
				if(i==size-1){
					result.add(node.val);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Binary_Tree_Right_Side_View_199 b=new Binary_Tree_Right_Side_View_199();
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.right=new TreeNode(5);
		root.right.right=new TreeNode(4);
		List<Integer> result=b.rightSideView(root);
		for(Integer i:result){
			System.out.print(i+" ");
		}
	}

}
