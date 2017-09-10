package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Populating_Next_Right_Pointers_in_Each_Node_116 {

	public void connect(TreeLinkNode root) {
		if(root==null){
			return;
		}
		Queue<TreeLinkNode> queue=new LinkedList<TreeLinkNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			int size=queue.size();
			TreeLinkNode tmp=queue.poll();
			if(tmp.left!=null){
				queue.offer(tmp.left);
				queue.offer(tmp.right);
			}
			for(int i=1;i<size;i++){
				TreeLinkNode theNode=queue.poll();
				tmp.next=theNode;
				if(theNode.left!=null){
					queue.offer(theNode.left);
					queue.offer(theNode.right);
				}
				tmp=theNode;
			}
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Populating_Next_Right_Pointers_in_Each_Node_116 p=new Populating_Next_Right_Pointers_in_Each_Node_116();
		TreeLinkNode root=new TreeLinkNode(1);
		root.left=new TreeLinkNode(2);
		root.right=new TreeLinkNode(3);
		root.left.left=new TreeLinkNode(4);
		root.left.right=new TreeLinkNode(5);
		root.right.left=new TreeLinkNode(6);
		root.right.right=new TreeLinkNode(7);
		p.connect(root);
		System.out.println(1);
	}

}
