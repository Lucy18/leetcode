package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class K_th_Smallest_Prime_Fraction_786 {

	public int[] kthSmallestPrimeFraction(int[] A, int K) {
		
		PriorityQueue<Value> queue=new PriorityQueue<Value>(new Comparator<Value>() {
			@Override
			public int compare(Value o1, Value o2) {
				return myCompare(o1, o2);
			}
		});
		int low=0;
		int high=A.length-1;
		Value nowVal=new Value(A[low], A[high]);
		while(K>0){
			Value val1=new Value(A[low], A[high]);
			Value val2=null;
			if(!queue.isEmpty()){
				val2=queue.peek();
			}
			if(val2==null||myCompare(val1, val2)<0){
				for(int i=low+1;i<=high-1;i++){
					queue.offer(new Value(A[i], A[high]));
				}
				for(int i=low+1;i<=high-1;i++){
					queue.offer(new Value(A[low], A[i]));
				}
				nowVal=new Value(A[low], A[high]);
				low++;
				high--;
			}
			else{//val1>val2
				nowVal=queue.poll();
			}
			K--;
		}
		return new int[]{nowVal.fenzi,nowVal.fenmu};		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		K_th_Smallest_Prime_Fraction_786 k=new K_th_Smallest_Prime_Fraction_786();
		int[] A=new int[]{1,2,3,5};
		System.out.println(Arrays.toString(k.kthSmallestPrimeFraction(A, 3)));
	}
	
	class Value{
		int fenzi;
		int fenmu;
		public Value(int fenzi,int fenmu){
			this.fenzi=fenzi;
			this.fenmu=fenmu;
		}
	}
	
	public int myCompare(Value v1,Value v2){
		int s1 = v1.fenzi * v2.fenmu;
        int s2 = v2.fenzi * v1.fenmu;
        return s1 - s2;
	}

}
