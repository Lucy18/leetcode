package leetcode;

public class Minimum_Absolute_Difference_in_BST_530 {

	int min=Integer.MAX_VALUE;
	
	public int getMinimumDifference(TreeNode root) {	
		if(root.left!=null){
			TreeNode leftNode=root.left;
			int theSub=0;
			if(leftNode.right!=null){
				theSub=root.val-findMostRight(leftNode);
			}
			else{
				theSub=root.val-leftNode.val;
			}
			min=min<theSub?min:theSub;
			theSub=getMinimumDifference(root.left);
			min=min<theSub?min:theSub;
		}
		if(root.right!=null){
			TreeNode rightNode=root.right;
			int theSub=0;
			if(rightNode.left!=null){
				theSub=findMostLeft(rightNode)-root.val;
			}
			else{
				theSub=rightNode.val-root.val;
			}
			min=min<theSub?min:theSub;
			theSub=getMinimumDifference(root.right);
			min=min<theSub?min:theSub;
		}
		return min;
	}
	
	public int findMostRight(TreeNode it){
		while(it.right!=null){
			it=it.right;
		}
		return it.val;
	}
	
	public int findMostLeft(TreeNode it){
		while(it.left!=null){
			it=it.left;
		}
		return it.val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Minimum_Absolute_Difference_in_BST_530 m=new Minimum_Absolute_Difference_in_BST_530();
		TreeNode root=new TreeNode(236);
		root.left=new TreeNode(104);
		root.right=new TreeNode(701);
		root.left.right=new TreeNode(227);
		root.right.right=new TreeNode(911);
		System.out.println(m.getMinimumDifference(root));
	}

}