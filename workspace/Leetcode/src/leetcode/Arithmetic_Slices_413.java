package leetcode;

import java.util.ArrayList;

public class Arithmetic_Slices_413 {

	public int numberOfArithmeticSlices(int[] A) {
		if(A.length<=2){
			return 0;
		}
		int sub=A[1]-A[0];
		ArrayList<Integer> lianxuNum=new ArrayList<Integer>();
		int lianxu=1;
		for(int i=2;i<A.length;i++){
			int thisSub=A[i]-A[i-1];
			if(thisSub==sub){
				lianxu++;
			}
			else{
				if(lianxu>=2){
					lianxuNum.add(lianxu+1);
				}
				sub=thisSub;
				lianxu=1;
			}
		}
		if(lianxu>=2){
			lianxuNum.add(lianxu+1);
		}
		int result=0;
		for(int i=0;i<lianxuNum.size();i++){
			int thisNum=lianxuNum.get(i)-2;
			if(thisNum==1){
				result+=1;
			}
			else{
				result+=(1+thisNum)*thisNum/2;
			}			
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arithmetic_Slices_413 a=new Arithmetic_Slices_413();
		int[] A=new int[]{1,2,3,4,5};
		System.out.println(a.numberOfArithmeticSlices(A));
	}

}
