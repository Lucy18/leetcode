package leetcode;

import java.util.Arrays;

public class Valid_Square_593 {

	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		int[] allBian=new int[]{
				getDistance2(p1, p2),getDistance2(p1, p3),getDistance2(p1, p4),
				getDistance2(p2, p3),getDistance2(p2, p4),getDistance2(p3, p4)
		};
		Arrays.sort(allBian);
		if(allBian[0]==0){
			return false;
		}
		//保证有4个边相同,a^2可能比a大，也可能比a小
		if(allBian[0]==allBian[3]||allBian[2]==allBian[5]){
			//a^2比a大
			if(allBian[0]==allBian[3]){
				//使用勾股定理:a^2+b^2=c^2，而a=b，所以2a^2=c^2
				if(allBian[0]*2==allBian[5]){
					return true;
				}
			}
			else{//a^2比a小
				if(allBian[5]*2==allBian[0]){
					return true;
				}
			}
		}
		return false;
	}
	
	//返回距离的平方
	int getDistance2(int[] p1,int[] p2){
		int distance2=(p1[0]-p2[0])*(p1[0]-p2[0])+(p1[1]-p2[1])*(p1[1]-p2[1]);
		return distance2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Valid_Square_593 v = new Valid_Square_593();
		int[] p1 = new int[] { 0, 0 };
		int[] p2 = new int[] { 0, 0 };
		int[] p3 = new int[] { 0, 0 };
		int[] p4 = new int[] { 0, 0 };
		System.out.println(v.validSquare(p1, p2, p3, p4));
	}

}
