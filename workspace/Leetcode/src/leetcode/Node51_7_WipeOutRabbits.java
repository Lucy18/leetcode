package leetcode;

import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Node51_7_WipeOutRabbits {

	public int solve(int n,int m,int[] B,int[][] DP){
		int QB=0;
		quicksortRabbit(B, 0, n-1);//倒序排兔子血量
		Arrow[] arrows=new Arrow[m];
		for(int i=0;i<m;i++){
			arrows[i]=new Arrow(DP[i][0],DP[i][1]);
		}
		quicksortArrow(arrows, 0, m-1);//倒序排箭的伤害值
		Comparator<Arrow> OrderIsdn =  new Comparator<Arrow>(){//设置优先级队列的排序方法
            public int compare(Arrow o1, Arrow o2) {  
                // TODO Auto-generated method stub  
                int numbera = o1.price;  
                int numberb = o2.price;  
                if(numbera < numberb)  {  
                    return -1;  
                }  
                else if(numbera > numberb)  {  
                    return 1;  
                }  
                else  {  
                    return 0;  
                }             
            }            
        };  
		Queue<Arrow> queue=new PriorityQueue<Arrow>(m,OrderIsdn);
		int rabbitPointer=0;
		int arrowPointer=0;
		for(rabbitPointer=0;rabbitPointer<n;rabbitPointer++){
			while(arrowPointer<m&&arrows[arrowPointer].kill>=B[rabbitPointer]){
				queue.offer(arrows[arrowPointer]);
				arrowPointer++;
			}
			if(queue.size()==0){
				break;
			}
			else{
				Arrow minPriceArrow=queue.poll();
				QB+=minPriceArrow.price;	
			}				
		}
		if(rabbitPointer==n){
			return QB;
		}
		else{
			return -1;
		}		
	}
	
	
	
	public void quicksortRabbit(int[] B,int left,int right){
		if(left<right){
			int low=left;
			int high=right;
			int pivot=B[low];
			while(low<high){
				while(low<high&&B[high]<=pivot){
					high--;
				}
				if(low<high){
					B[low]=B[high];
					low++;
				}
				while(low<high&&B[low]>=pivot){
					low++;
				}
				if(low<high){
					B[high]=B[low];
					high--;
				}				
			}
			B[low]=pivot;
			quicksortRabbit(B, left, low-1);
			quicksortRabbit(B, low+1, right);
		}		
	}
	
	public void quicksortArrow(Arrow[] arrows,int left,int right){
		if(left<right){
			int low=left;
			int high=right;
			Arrow pivot=arrows[low];
			while(low<high){
				while(low<high&&arrows[high].kill<=pivot.kill){
					high--;
				}
				if(low<high){
					arrows[low]=arrows[high];
					low++;
				}
				while(low<high&&arrows[low].kill>=pivot.kill){
					low++;
				}
				if(low<high){
					arrows[high]=arrows[low];
					high--;
				}				
			}
			arrows[low]=pivot;
			quicksortArrow(arrows, left, low-1);
			quicksortArrow(arrows, low+1, right);
		}		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = in.nextInt();//兔子的个数
		int m = in.nextInt();//箭的种类
		int[] B=new int[n];//兔子的血量
		for(int i=0;i<n;i++){
			B[i]=in.nextInt();
		}
		int[][] DP=new int[m][2];//箭的伤害值和价格
		for(int i=0;i<m;i++){
			DP[i]=new int[2];
			DP[i][0]=in.nextInt();
			DP[i][1]=in.nextInt();
		}
		in.close();
		Node51_7_WipeOutRabbits node = new Node51_7_WipeOutRabbits();
		int b = node.solve(n, m, B, DP);
		if(b!=-1){
			out.println(b);
		}
		else{
			out.println("No Solution");
		}		
		out.flush();
	}
	
	class Arrow{
		int kill;
		int price;
		public Arrow(int kill,int price){
			this.kill=kill;
			this.price=price;
		}
	}

}
