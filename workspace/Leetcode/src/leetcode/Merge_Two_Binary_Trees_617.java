package leetcode;

public class Merge_Two_Binary_Trees_617 {

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1==null){
			t1=t2;
			return t1;
		}
		else if(t2==null){
			return t1;
		}
		TreeNode root=new TreeNode(0);
		DFS(null,false,root,t1,t2);
		return root;
	}
	
	public void DFS(TreeNode before,boolean isLeft,TreeNode root,TreeNode t1, TreeNode t2){
		if(t1!=null&&t2!=null){
			root.val=t1.val+t2.val;
			root.left=new TreeNode(0);
			root.right=new TreeNode(0);
			DFS(root,true,root.left,t1.left,t2.left);
			DFS(root,false,root.right,t1.right,t2.right);
		}
		else if(t1!=null&&t2==null){
			root.val=t1.val;
			root.left=new TreeNode(0);
			root.right=new TreeNode(0);
			DFS(root,true,root.left,t1.left,null);
			DFS(root,false,root.right,t1.right,null);
		}
		else if(t1==null&&t2!=null){
			root.val=t2.val;
			root.left=new TreeNode(0);
			root.right=new TreeNode(0);
			DFS(root,true,root.left,null,t2.left);
			DFS(root,false,root.right,null,t2.right);
		}
		else{
			if(isLeft==true){
				before.left=null;
			}
			else{
				before.right=null;
			}		
			return;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Merge_Two_Binary_Trees_617 m=new Merge_Two_Binary_Trees_617();
		TreeNode root1=new TreeNode(1);
		root1.left=new TreeNode(3);
		root1.right=new TreeNode(2);
		root1.left.left=new TreeNode(5);
		TreeNode root2=new TreeNode(2);
		root2.left=new TreeNode(1);
		root2.right=new TreeNode(3);
		root2.left.right=new TreeNode(4);
		root2.right.right=new TreeNode(7);
		TreeNode t=m.mergeTrees(root1, root2);
		System.out.println(1);
	}

}
