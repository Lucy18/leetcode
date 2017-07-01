package leetcode;

public class Sum_of_Left_Leaves_404 {
	
	int sum=0;
	
	public int sumOfLeftLeaves(TreeNode root) {
		if(root==null){
			return 0;
		}
		DFS(root,false);
		return sum;
	}
	
	public void DFS(TreeNode node,Boolean isLeft){
		if(node.left==null&&node.right==null){
			if(isLeft==true){
				sum+=node.val;
			}
			return;
		}
		if(node.left!=null){
			DFS(node.left,true);
		}
		if(node.right!=null){
			DFS(node.right,false);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sum_of_Left_Leaves_404 s=new Sum_of_Left_Leaves_404();
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		System.out.println(s.sumOfLeftLeaves(root));
	}

}
