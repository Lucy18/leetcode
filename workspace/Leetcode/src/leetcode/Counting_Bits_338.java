package leetcode;
import java.util.Arrays;

public class Counting_Bits_338 {

	public int[] countBits(int num) {
		int[] a = new int[32];
		int pointer = 0;
		int[] result = new int[num + 1];
		int count = 0;
		for (int i = 1; i <= num; i++) {
			if (a[pointer] == 0) {
				a[pointer] = 1;
				count++;
			} else {
				while(a[pointer]==1){
					pointer++;
				}
				a[pointer] = 1;
				count++;
				pointer--;
				while(pointer>=0){
					a[pointer] = 0;
					count--;
					pointer--;
				}						
				pointer = 0;
			}
			result[i] = count;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counting_Bits_338 c = new Counting_Bits_338();
		System.out.println(Arrays.toString(c.countBits(7)));
	}

}
