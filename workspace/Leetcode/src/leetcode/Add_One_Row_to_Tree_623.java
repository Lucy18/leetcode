package leetcode;

public class Add_One_Row_to_Tree_623 {

	public TreeNode addOneRow(TreeNode root, int v, int d) {
		if(d==1){
			TreeNode newRoot=new TreeNode(v);
			newRoot.left=root;
			return newRoot;
		}
		else{
			int deep=d-1;
			addRow(root, v, deep, 1);
		}
		return root;
	}
	
	public void addRow(TreeNode node,int v,int deep,int thisDeep){
		if(node==null){
			return;
		}
		if(deep==thisDeep){
			TreeNode leftTemp=node.left;
			TreeNode rightTemp=node.right;
			node.left=new TreeNode(v);
			node.right=new TreeNode(v);
			node.left.left=leftTemp;
			node.right.right=rightTemp;
			return;
		}
		addRow(node.left, v, deep, thisDeep+1);
		addRow(node.right, v, deep, thisDeep+1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Add_One_Row_to_Tree_623 a=new Add_One_Row_to_Tree_623();
		TreeNode root=new TreeNode(4);
		root.left=new TreeNode(2);
		root.right=new TreeNode(6);
		root.left.left=new TreeNode(3);
		root.left.right=new TreeNode(1);
		root.right.left=new TreeNode(5);
		root=a.addOneRow(root, 1, 2);
		System.out.println("1");
	}

}
