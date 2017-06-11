package leetcode;

public class Invert_Binary_Tree_226 {

	public TreeNode invertTree(TreeNode root) {
		if(root==null){
			return root;
		}
		invert(root);
		return root;
	}
	
	public void invert(TreeNode node){
		if(node.left==null&&node.right==null){//两子树都为空
			return;
		}
		else if(node.left!=null&&node.right!=null){//左右子树都不为空
			TreeNode temp=node.left;
			node.left=node.right;
			node.right=temp;
			invert(node.left);
			invert(node.right);
		}
		else if(node.left!=null){//左子树不空，右子树为空
			node.right=node.left;
			node.left=null;
			invert(node.right);
		}
		else{//左子树为空，右子树不空
			node.left=node.right;
			node.right=null;
			invert(node.left);
		}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(4);
		root.left=new TreeNode(2);
		root.right=new TreeNode(7);
		root.left.left=new TreeNode(1);
		root.left.right=new TreeNode(3);
		root.right.left=new TreeNode(6);
		root.right.right=new TreeNode(9);
		Invert_Binary_Tree_226  i=new Invert_Binary_Tree_226();
		i.invertTree(root);
		System.out.println("1");
	}

}
