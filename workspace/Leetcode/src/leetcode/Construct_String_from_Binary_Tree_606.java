package leetcode;

public class Construct_String_from_Binary_Tree_606 {

	public String tree2str(TreeNode t) {
		if(t==null){
			return "";
		}
		String string=t.val+"";
		if(t.left==null&&t.right==null){
			return string;
		}
		if(t.left!=null){
			string=string+"("+tree2str(t.left)+")";
			if(t.right!=null){
				string=string+"("+tree2str(t.right)+")";
			}
		}
		else{
			string=string+"()";
			if(t.right!=null){
				string=string+"("+tree2str(t.right)+")";
			}
		}
		return string;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Construct_String_from_Binary_Tree_606 c=new Construct_String_from_Binary_Tree_606();
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.right=new TreeNode(4);
		System.out.println(c.tree2str(root));
	}

}
