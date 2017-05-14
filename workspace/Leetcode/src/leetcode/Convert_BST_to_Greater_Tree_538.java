package leetcode;

public class Convert_BST_to_Greater_Tree_538 {

	int length=0;
	int pointer=0;
	
	void getAllNums(TreeNode root,int[] nums){
		if(root==null){
			return ;
		}
		nums[length]=root.val;
		length++;
		getAllNums(root.left,nums);
		getAllNums(root.right,nums);
	}
	void setNums(TreeNode root,int[] addNums){
		if(root==null){
			return ;
		}
		root.val+=addNums[pointer];
		pointer++;
		setNums(root.left, addNums);
		setNums(root.right, addNums);
	}
	
	public TreeNode convertBST(TreeNode root) {
		int[] nums=new int[10000];
		getAllNums(root, nums);
		int[] addNums=new int[length];
		for(int i=0;i<length;i++){
			int theValue=nums[i];
			for(int j=0;j<length;j++){
				if(j!=i){
					if(nums[j]>theValue){
						addNums[i]+=nums[j];
					}
				}				
			}
		}
		setNums(root,addNums);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Convert_BST_to_Greater_Tree_538 c=new Convert_BST_to_Greater_Tree_538();
		TreeNode root=new TreeNode(5);
		root.left=new TreeNode(2);
		root.right=new TreeNode(13);
		c.convertBST(root);
		System.out.println("1");
	}

}
