package leetcode;

public class Second_Minimum_Node_In_a_Binary_Tree_671 {

	int result=Integer.MAX_VALUE;
	
	public int findSecondMinimumValue(TreeNode root) {
		if(root==null){
			return -1;
		}
		find(root, root.val);
		if(result==Integer.MAX_VALUE){
			return -1;
		}
		else{
			return result;
		}
	}
	
	public void find(TreeNode node,int rootVal){
		if(node==null){
			return;
		}
		if(node.val>rootVal&&result>node.val){
			result=node.val;
		}
		find(node.left, rootVal);
		find(node.right, rootVal);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Second_Minimum_Node_In_a_Binary_Tree_671 s=new Second_Minimum_Node_In_a_Binary_Tree_671();
		TreeNode root=new TreeNode(2);
		root.left=new TreeNode(2);
		root.right=new TreeNode(2);
		System.out.println(s.findSecondMinimumValue(root));
	}

}
