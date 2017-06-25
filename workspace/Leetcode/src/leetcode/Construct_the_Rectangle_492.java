package leetcode;

import java.util.Arrays;

public class Construct_the_Rectangle_492 {

	public int[] constructRectangle(int area) {
		int [] result=new int[2];
		int width=(int)Math.floor(Math.sqrt(area));
		int length=0;
		while(width>=1){
			if(area%width!=0){
				width--;
			}
			else{
				length=area/width;
				break;
			}
		}
		result[0]=length;
		result[1]=width;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Construct_the_Rectangle_492 c=new Construct_the_Rectangle_492();
		System.out.println(Arrays.toString(c.constructRectangle(4)));
	}

}
