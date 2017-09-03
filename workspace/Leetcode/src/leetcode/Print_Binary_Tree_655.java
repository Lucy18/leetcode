package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Print_Binary_Tree_655 {

	public List<List<String>> printTree(TreeNode root) {
		int height=getHeight(root);
		int size=(int)Math.pow(2, height)-1;
		List<List<String>> result=new ArrayList<List<String>>();
		for(int i=0;i<height;i++){
			List<String> list=new ArrayList<String>();
			for(int j=0;j<size;j++){
				list.add("");
			}
			result.add(list);
		}
		helper(result, root, 0, 0, size-1);
		return result;
	}
	
	public void helper(List<List<String>> result,TreeNode node,
			int level,int left,int right){
		if(node==null){
			return;
		}
		int index=(left+right)/2;
		result.get(level).set(index, node.val+"");
		helper(result, node.left, level+1, left, index-1);
		helper(result, node.right, level+1, index+1, right);
	}
	
	public int getHeight(TreeNode node){
		if(node==null){
			return 0;
		}
		return Math.max(1+getHeight(node.left), 1+getHeight(node.right));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Print_Binary_Tree_655 p=new Print_Binary_Tree_655();
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(5);
		root.left.left=new TreeNode(3);
		root.left.left.left=new TreeNode(4);
		List<List<String>> res=p.printTree(root);
		for(List<String> list:res){
			for(String s:list){
				if(s.equals("")){
					System.out.print("\"\"");
				}
				else{
					System.out.print("\""+s+"\"");
				}
				System.out.print("   ");
			}
			System.out.println();
		}
	}

}
