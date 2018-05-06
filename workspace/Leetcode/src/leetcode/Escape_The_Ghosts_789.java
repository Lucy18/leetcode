package leetcode;

public class Escape_The_Ghosts_789 {
	
	public boolean escapeGhosts(int[][] ghosts, int[] target) {
		int myDistance=Math.abs(target[0])+Math.abs(target[1]);
		for(int i=0;i<ghosts.length;i++){
			int ghostDistance=Math.abs(target[0]-ghosts[i][0])+Math.abs(target[1]-ghosts[i][1]);
			if(ghostDistance<=myDistance){
				return false;
			}
		}
			return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Escape_The_Ghosts_789 e=new Escape_The_Ghosts_789();
		int[][] ghosts=new int[][]{
			{2,0}
		};
		int[] target=new int[]{1,0};
		System.out.println(e.escapeGhosts(ghosts, target));
	}

}
