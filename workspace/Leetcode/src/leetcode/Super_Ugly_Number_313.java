package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Super_Ugly_Number_313 {

	public int nthSuperUglyNumber(int n, int[] primes) {
		if(n==1){
			return 1;
		}
		int[] uglys=new int[n];
		uglys[0]=1;
		PriorityQueue<Number> queue = new PriorityQueue<Number>(n,
				new Comparator<Number>(){   
            public int compare(Number o1, Number o2) {  
                return o1.val-o2.val;
            }             
        });  
		for(int num:primes){
			queue.offer(new Number(num,1,num));
		}
		for(int i=1;i<n;i++){
			uglys[i] = queue.peek().val;
	        while (queue.peek().val == uglys[i]) {
	        	Number num=queue.poll();
	        	queue.offer(new Number(num.base*uglys[num.index], num.index+1, num.base));
	        }
		}
		return uglys[n-1];
	}
	
	class Number{
		int val;
		int index;
		int base;
		Number(int val,int index,int base){
			this.val=val;
			this.index=index;
			this.base=base;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Super_Ugly_Number_313 s=new Super_Ugly_Number_313();
		int[] primes=new int[]{3,5,7,11,19,23,29,41,43,47};
//		System.out.print(s.nthSuperUglyNumber(15, primes)+" ");
		for(int i=1;i<=15;i++){
			System.out.print(s.nthSuperUglyNumber(i, primes)+" ");
		}	
	}

}
