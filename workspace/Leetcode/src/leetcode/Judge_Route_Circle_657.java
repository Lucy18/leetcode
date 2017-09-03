package leetcode;

public class Judge_Route_Circle_657 {

	public boolean judgeCircle(String moves) {
		//L放在int[0]，R放在int[1]
		//U放在int[2]，D放在int[3]
		int[] directions=new int[4];
		for(int i=0;i<moves.length();i++){
			char c=moves.charAt(i);
			switch (c) {
			case 'L':
				directions[0]++;
				break;
			case 'R':
				directions[1]++;
				break;
			case 'U':
				directions[2]++;
				break;
			case 'D':
			    directions[3]++;
			    break;
			}
		}
		if(directions[0]==directions[1]&&directions[2]==directions[3]){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Judge_Route_Circle_657 j=new Judge_Route_Circle_657();
		System.out.println(j.judgeCircle("LL"));
	}

}
