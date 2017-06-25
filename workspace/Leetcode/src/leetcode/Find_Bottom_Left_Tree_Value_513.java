package leetcode;

public class Find_Bottom_Left_Tree_Value_513 {

	int[] array=new int[2];//array[0]填当前最下最左元素，array[1]填该元素的层次
	public void findLeft(TreeNode node,int Cengci){
		if(Cengci>array[1]){
			array[0]=node.val;
			array[1]=Cengci;
		}
		if(node.left!=null){
			findLeft(node.left, Cengci+1);
		}
		if(node.right!=null){
			findLeft(node.right, Cengci+1);
		}		
	}

	public int findBottomLeftValue(TreeNode root) {
		array[0]=root.val;
		array[1]=1;
		findLeft(root, 1);
		return array[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Find_Bottom_Left_Tree_Value_513 f=new Find_Bottom_Left_Tree_Value_513();
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.right.left=new TreeNode(5);
		root.right.right=new TreeNode(6);
		root.right.left.left=new TreeNode(7);
		System.out.println(f.findBottomLeftValue(root));
	}

}
