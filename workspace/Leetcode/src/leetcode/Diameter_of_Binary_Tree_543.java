package leetcode;

public class Diameter_of_Binary_Tree_543 {

	public int diameterOfBinaryTree(TreeNode root) {
		int[] max=new int[1];
		cengshu(root, max);
		return max[0];
	}
	
	public int cengshu(TreeNode node,int[] max){//连带node自己的总共层数
		if(node==null){
			return 0;
		}
		int left=cengshu(node.left, max);
		int right=cengshu(node.right, max);
		if(left+right>max[0]){
			max[0]=left+right;
		}
		return Math.max(left, right)+1;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Diameter_of_Binary_Tree_543 d=new Diameter_of_Binary_Tree_543();
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
//		TreeNode root=new TreeNode(3);
//		root.left=new TreeNode(2);
//		root.left.right=new TreeNode(4);
//		root.left.right.left=new TreeNode(1);
		System.out.println(d.diameterOfBinaryTree(root));
	}

}

