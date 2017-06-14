package leetcode;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Node51_6_Dataflow {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		Node51_6_Dataflow node=new Node51_6_Dataflow();
		DecimalFormat df = new DecimalFormat("0.00");
		int n = in.nextInt();//操作数
		int k = in.nextInt();//窗口
		int[] queue=new int[1000001];
		int frontPointer=0;//指向队列第一个元素
		int endPointer=-1;//指向队列最后一个元素
		int sum=0;
		int numNow=0;//当前窗口内的满意个数
		for(int i=0;i<n;i++){
			int operation=in.nextInt();
			switch (operation) {
				case 1:
					int satisfy=in.nextInt();
					if(numNow!=k){
						sum=sum+satisfy;
						numNow++;
						endPointer++;
						queue[endPointer]=satisfy;						
					}
					else{
						sum=sum-queue[frontPointer]+satisfy;
						frontPointer++;
						endPointer++;
						queue[endPointer]=satisfy;
					}
					break;
				case 2:
					int average=(int)Math.floor((double)sum/numNow);
					out.println(df.format(average));
					break;
				case 3:
					double avg=(double)sum/numNow;
					double sumOfSquare=0;
					for(int j=frontPointer;j<=endPointer;j++){
						sumOfSquare+=(queue[j]-avg)*(queue[j]-avg);
					}
					double biaozhuncha=sumOfSquare/numNow;
					out.println(df.format(biaozhuncha));
					break;
				case 4:
					int[] queueCopy=new int[numNow];
					int pointer=0;
					for(int j=frontPointer;j<=endPointer;j++){
						queueCopy[pointer]=queue[j];
						pointer++;
					}
					Arrays.sort(queueCopy);
					double zhongweishu=0;
					if(numNow%2!=0){//当前窗口内有奇数个满意度
						zhongweishu=queueCopy[numNow/2];
					}
					else{//偶数时，中位数有两个
						zhongweishu=(double)(queueCopy[numNow/2-1]+queueCopy[numNow/2])/2;
					}
					out.println(df.format(zhongweishu));
					break;					
				default:
					break;
			}
		}
		in.close();
		out.flush();
	}
}

//package leetcode;
//
//import java.io.PrintWriter;
//import java.text.DecimalFormat;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class Node51_6_Dataflow {
//	
//	public void insertToList(LinkedList<Integer> list,int satisfy){
//		Iterator<Integer> it = list.iterator();
//		int index = 0;
//		while (it.hasNext()) {
//			int theNumber = it.next();
//			if (theNumber > satisfy) {
//				break;
//			} else {
//				index++;
//			}
//		}
//		list.add(index, satisfy);
//	}
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner in = new Scanner(System.in);
//		PrintWriter out = new PrintWriter(System.out);
//
//		Node51_6_Dataflow node=new Node51_6_Dataflow();
//		DecimalFormat df = new DecimalFormat("0.00");
//		int n = in.nextInt();//操作数
//		int k = in.nextInt();//窗口
//		Queue<Integer> queue=new LinkedList<Integer>();
//		LinkedList<Integer> list=new LinkedList<Integer>();//插入排序的list
//		int sum=0;
//		int numNow=0;//当前窗口内的满意个数
//		for(int i=0;i<n;i++){
//			int operation=in.nextInt();
//			switch (operation) {
//				case 1:
//					int satisfy=in.nextInt();
//					sum=sum+satisfy;
//					numNow++;
//					if (queue.size() < k) {
//						queue.offer(satisfy);
//						node.insertToList(list, satisfy);
//					}
//					else{
//						int removedValue=queue.poll();
//						numNow--;
//						sum=sum-removedValue;
//						list.remove(Integer.valueOf(removedValue));//注意
//						queue.offer(satisfy);
//						node.insertToList(list, satisfy);
//					}
//					break;
//				case 2:
//					int average=(int)Math.floor((double)sum/numNow);
//					out.println(df.format(average));
//					break;
//				case 3:
//					double avg=(double)sum/numNow;
//					Iterator<Integer> it = list.iterator();
//					double sumOfSquare=0;
//					while (it.hasNext()) {
//						int theNumber = it.next();
//						sumOfSquare+=Math.pow((theNumber-avg), 2);
//					}
//					double biaozhuncha=sumOfSquare/numNow;
//					out.println(df.format(biaozhuncha));
//					break;
//				case 4:
//					it = list.iterator();
//					double zhongweishu=0;
//					if(numNow%2!=0){//当前窗口内有奇数个满意度					
//						int index=0;				
//						while (it.hasNext()) {
//							int theNumber = it.next();
//							if(index==numNow/2){
//								zhongweishu=theNumber;
//								break;
//							}
//							index++;
//						}
//					}
//					else{
//						int index=0; 
//						while (it.hasNext()) {
//							int theNumber = it.next();
//							if(index==numNow/2-1||index==numNow/2){//偶数时，中位数有两个
//								zhongweishu+=theNumber;
//								if(index==numNow/2){
//									break;
//								}						
//							}
//							index++;
//						}
//						zhongweishu=zhongweishu/2;
//					}
//					out.println(df.format(zhongweishu));
//					break;					
//				default:
//					break;
//			}
//		}
//		in.close();
//		out.flush();
//	}
//}
//
