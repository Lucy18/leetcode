package leetcode;

public class Same_Tree_100 {

	boolean isEqual=true;
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		DFS(p, q);
		return isEqual;
	}
	
	public void DFS(TreeNode p,TreeNode q){
		if(p==null&&q==null){
			return;
		}
		if((p==null&&q!=null)||p!=null&&q==null){
			isEqual=false;
			return;
		}
		if(p.val!=q.val){
			isEqual=false;
			return;
		}
		DFS(p.left,q.left);
		DFS(p.right,q.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Same_Tree_100 s=new Same_Tree_100();
		TreeNode p=null;
		TreeNode q=null;
		System.out.println(s.isSameTree(p, q));
	}

}
