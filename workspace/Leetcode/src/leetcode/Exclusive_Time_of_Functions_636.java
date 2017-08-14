package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Exclusive_Time_of_Functions_636 {

	public int[] exclusiveTime(int n, List<String> logs) {
		int[] time=new int[n];
		//stack存:所有的start
		//int[0]存:functionId,int[1]存:timePoint,int[2]存:被别人占用的时间
		Stack<int[]> stack=new Stack<int[]>();
		for(String s:logs){
			String[] it=s.split(":");
			int id=Integer.parseInt(it[0]);
			String startOrEnd=it[1];
			int timePoint=Integer.parseInt(it[2]);
			if(startOrEnd.equals("start")){
				stack.push(new int[]{id,timePoint,0});
			}
			else{//startOrEnd.equals("end")
				int[] the=stack.pop();
				int usedTime=timePoint+1-the[1]-the[2];
				time[id]+=usedTime;
				//对于当前还在栈中的每个function
				//都被当前function占用了时间
				ArrayList<int[]> list=new ArrayList<int[]>();
				while(!stack.isEmpty()){
					int[] tmp=stack.pop();
					tmp[2]+=usedTime;				
					list.add(tmp);
				}
				for(int i=list.size()-1;i>=0;i--){
					stack.push(list.get(i));
				}
			}
		}
		return time;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exclusive_Time_of_Functions_636 e=new Exclusive_Time_of_Functions_636();
		List<String> logs=new ArrayList<String>();
		int n=2;
		logs.add("0:start:0");
		logs.add("0:start:2");
		logs.add("0:end:5");
		logs.add("1:start:6");
		logs.add("1:end:6");
		logs.add("0:end:7");
		System.out.println(Arrays.toString(e.exclusiveTime(n, logs)));
	}

}
