package leetcode;

import java.util.HashMap;

public class House_Robber_III_337 {

	public int rob(TreeNode root) {
		HashMap<TreeNode,Integer> mapT=new HashMap<TreeNode,Integer>();
		HashMap<TreeNode,Integer> mapF=new HashMap<TreeNode,Integer>();
		int robTrue=rob(root,true,mapT,mapF);
		int robFalse=rob(root, false,mapT,mapF);
		if(robTrue>=robFalse){
			return robTrue;
		}
		else{
			return robFalse;
		}
	}
	
	public int rob(TreeNode node,boolean canRob,
			HashMap<TreeNode,Integer> mapT,HashMap<TreeNode,Integer> mapF){
		if(node==null){
			return 0;
		}
		if(canRob==true){
			if(mapT.get(node)!=null){
				return mapT.get(node);
			}
			int rob=node.val+rob(node.left,false,mapT,mapF)+
					rob(node.right,false,mapT,mapF);
			mapT.put(node, rob);
			return rob;
		}
		else{
			if(mapF.get(node)!=null){
				return mapF.get(node);
			}
			int leftMax=Math.max(rob(node.left,true,mapT,mapF),
					             rob(node.left,false,mapT,mapF));
			int rightMax=Math.max(rob(node.right,true,mapT,mapF), 
					              rob(node.right,false,mapT,mapF));
			int rob=(leftMax+rightMax);
			mapF.put(node, rob);
			return rob;			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		House_Robber_III_337 h=new House_Robber_III_337();
		TreeNode root=new TreeNode(2);
		root.left=new TreeNode(1);
		root.right=new TreeNode(3);
		root.left.right=new TreeNode(4);
		System.out.println(h.rob(root));
	}

}
