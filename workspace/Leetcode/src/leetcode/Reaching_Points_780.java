package leetcode;

public class Reaching_Points_780 {

	public boolean reachingPoints(int sx, int sy, int tx, int ty) {
		NewTreeNode root = new NewTreeNode(sx,sy);
		constructTree(root, tx, ty);
		int count=dfs(root, tx, ty);
		if(count==1){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void constructTree(NewTreeNode node,int tx,int ty){
		if(node.x>tx||node.y>ty){
			return;
		}
		node.left=new NewTreeNode(node.x+node.y,node.y);
		node.right=new NewTreeNode(node.x, node.x+node.y);
		constructTree(node.left, tx, ty);
		constructTree(node.right, tx, ty);
	}
	
	public int dfs(NewTreeNode node,int tx,int ty){
		if(node==null){
			return 0;
		}
		if(node.x==tx&&node.y==ty){
			return 1;
		}
		if(node.x<=tx&&node.y<=ty){
			return dfs(node.left, tx, ty)+dfs(node.right, tx, ty);
		}
		else{
			return 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reaching_Points_780 r=new Reaching_Points_780();
		System.out.println(r.reachingPoints(1, 1, 1, 1));
	}

	class NewTreeNode {
		public int x;
		public int y;
		public NewTreeNode left;
		public NewTreeNode right;

		public NewTreeNode(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
