package leetcode;

public class Symmetric_Tree_101 {

	public boolean isSymmetric(TreeNode root) {
		if(root==null){
			return true;
		}
		return isSymmetric(root.left, root.right);
	}
	
	public boolean isSymmetric(TreeNode left,TreeNode right){
		if(left==null&&right==null){
			return true;
		}
		if(left==null||right==null){
			return false;
		}
		if(left.val==right.val){
			return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Symmetric_Tree_101 s=new Symmetric_Tree_101();
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
	//	root.left.left=new TreeNode(3);
		root.left.right=new TreeNode(4);
		root.right=new TreeNode(2);
		root.right.left=new TreeNode(4);
		root.right.right=new TreeNode(3);
		System.out.println(s.isSymmetric(root));
	}

}
