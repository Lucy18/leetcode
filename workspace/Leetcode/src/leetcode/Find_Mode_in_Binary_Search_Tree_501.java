package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Find_Mode_in_Binary_Search_Tree_501 {

	int maxCount=1;
	
	public int[] findMode(TreeNode root) {
		if(root==null){
			return new int[]{};
		}
		ArrayList<Integer> values=new ArrayList<Integer>();
		helper(values,root);
		int[] result=new int[values.size()];
		for(int i=0;i<values.size();i++){
			result[i]=values.get(i);
		}
		return result;
	}
	
	public void helper(ArrayList<Integer> values,TreeNode root){
		int count=0;
		int val=root.val;
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode node=queue.poll();
			if(node.val==val){
				count++;
			}
			if(node.left!=null){
				if(node.left.val==val){
					queue.offer(node.left);
				}
				else{
					helper(values, node.left);
				}
			}
			if(node.right!=null){
				if(node.right.val==val){
					queue.offer(node.right);
				}
				else{
					helper(values, node.right);
				}
			}
		}
		if(count>maxCount){
			maxCount=count;
			values.clear();
			values.add(root.val);
		}
		else if(count==maxCount){
			values.add(root.val);
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Find_Mode_in_Binary_Search_Tree_501 f=new Find_Mode_in_Binary_Search_Tree_501();
		TreeNode root=new TreeNode(2147483647);
		System.out.println(Arrays.toString(f.findMode(root)));
	}

}
