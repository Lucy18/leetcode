package leetcode;

public class Binary_Tree_Tilt_563 {
	
	int tilt=0;

	public int findTilt(TreeNode root) {
		if(root==null){
			return 0;
		}
		recursion(root);
		return tilt;	
	}
	
	public int recursion(TreeNode root){
		int left=0;
		int right=0;
		if(root.left!=null){
			left=root.left.val+recursion(root.left);
		}
		if(root.right!=null){
			right=root.right.val+recursion(root.right);
		}
		tilt+=Math.abs(left-right);
		return left+right;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Binary_Tree_Tilt_563 b=new Binary_Tree_Tilt_563();
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.right.left=new TreeNode(5);
		System.out.println(b.findTilt(root));
	}

}
