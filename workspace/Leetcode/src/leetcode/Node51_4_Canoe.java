package leetcode;

import java.io.PrintWriter;
import java.util.Scanner;

public class Node51_4_Canoe {

	public int solve(int n,long m,long[] peoples){
		if(peoples==null||peoples.length==0){
			return 0;
		}
		if(peoples.length==1){
			return 1;
		}
		int result=0;
		quicksort(peoples, 0, n-1);
		Node front=new Node(peoples[0]);//front是前指针
		Node behind=new Node(peoples[1]);//behind是后指针
		front.behind=behind;
		for(int i=2;i<n;i++){
			behind.front=front;
			front=behind;
			behind=new Node(peoples[i]);
			front.behind=behind;
		}
		behind.front=front;
		while(front!=null&&behind!=null&&front!=behind){
			while(front!=null&&front.value+behind.value>m){
				front=front.front;
			}
			if(front==null){//到最左边了都没能满足，说明只能behind独享一艘船了
				result++;
				behind=behind.front;
				behind.behind.remove();
				behind.behind=null;	
				front=behind.front;
			}
			else if(front.behind==behind){//两个连在一起的要去掉
				result++;
				behind=front.front;//一次跳两级，behind只能往前跳不能往后跳
				if(behind!=null){
					behind.behind=null;
					front=behind.front;
				}
				else{
					front=null;
				}		
			}
			else if(front!=null&&behind!=null&&front!=behind){
				result++;
				behind=behind.front;
				if(behind.front!=null){
					behind.behind.remove();
					behind.behind=null;
				}				
				front.remove();
				front=null;
				front=behind.front;			
			}
		}
		if(front!=null||behind!=null){//还存在值
			result++;
		}
		return result;
	}
	
	public void quicksort(long[] peoples,int left,int right){
		if(left<right){
			int low=left;
			int high=right;
			long pivot=peoples[low];
			while(low<high){
				while(low<high&&peoples[high]>=pivot){
					high--;
				}
				if(low<high){
					peoples[low]=peoples[high];
					low++;
				}
				while(low<high&&peoples[low]<=pivot){
					low++;
				}
				if(low<high){
					peoples[high]=peoples[low];
					high--;
				}				
			}
			peoples[low]=pivot;
			quicksort(peoples, left, low-1);
			quicksort(peoples, low+1, right);
		}		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = in.nextInt();//人数
		long m = in.nextInt();//独木舟的载重
		long[] peoples=new long[n];//每个人的重量
		for(int i=0;i<n;i++){
			peoples[i]=in.nextLong();
		}
		in.close();
		Node51_4_Canoe node = new Node51_4_Canoe();
		int b = node.solve(n,m,peoples);

		out.println(b);
		out.flush();
	}
	
	class Node{
		long value;
		Node front;
		Node behind;
		public Node(long value){
			this.value=value;			
		}
		public void setFront(Node front) {
			this.front=front;
		}
		public void setBehind(Node behind) {
			this.behind=behind;
		}
		public void remove(){
			if(front!=null&&behind!=null){
				front.behind=behind;
				behind.front=front;
			}
			else if(front==null&&behind!=null){
				behind.front=null;
			}
			else if(front!=null&&behind==null){
				front.behind=null;
			}
		}
	}

}
