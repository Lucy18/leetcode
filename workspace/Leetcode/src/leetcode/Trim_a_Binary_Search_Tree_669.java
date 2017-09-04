package leetcode;

public class Trim_a_Binary_Search_Tree_669 {

	public TreeNode trimBST(TreeNode root, int L, int R) {
		if(root==null){
			return root;
		}
		if(root.val>=L&&root.val<=R){
			root.left=trimBST(root.left, L, R);
			root.right=trimBST(root.right, L, R);
			return root;
		}
		else if(root.val<L){//root和root左边的部分肯定要被trim掉
			while (root.val < L) {
				root = root.right;
				// 保证 root.val>=l
				while (root != null && root.val < L) {
					root = root.right;
				}
				// 保证 l<=root.val<=R
				while (root != null && root.val > R) {
					root = root.left;
				}
				if (root == null) {
					return root;
				}
			}
			root.left=trimBST(root.left, L, R);
			root.right=trimBST(root.right, L, R);
			return root;
		}
		else{//root.val>R
			while (root.val > R) {
				root = root.left;
				// 保证 root.val<=R
				while (root != null && root.val > R) {
					root = root.left;
				}
				// 保证 l<=root.val<=R
				while (root != null && root.val < L) {
					root = root.right;
				}
				if (root == null) {
					return root;
				}
			}
			root.left=trimBST(root.left, L, R);
			root.right=trimBST(root.right, L, R);
			return root;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trim_a_Binary_Search_Tree_669 t=new Trim_a_Binary_Search_Tree_669();
		TreeNode root=new TreeNode(18);
		root.left=new TreeNode(0);
		root.right=new TreeNode(40);
		root.right.left=new TreeNode(22);
		root.right.right=new TreeNode(49);
		root.right.left.left=new TreeNode(21);
		root.right.left.right=new TreeNode(32);
		root.right.left.right.right=new TreeNode(35);
		TreeNode result=t.trimBST(root, 35, 35);
	    System.out.println(1);
	}

}
