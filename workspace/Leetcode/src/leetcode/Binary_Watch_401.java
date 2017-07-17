package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Binary_Watch_401 {

	public List<String> readBinaryWatch(int num) {
		List<String> result=new ArrayList<String>();
		HashMap<Integer, List<String>> minuteMap=getMinute();
		HashMap<Integer, List<String>> secondMap=getSecond();
		int minMinute=3;
		if(num<minMinute){
			minMinute=num;
		}
		for(int minute=0;minute<=minMinute;minute++){
			int second=num-minute;
			if(second>=6){
				continue;
			}
			List<String> minuteList=minuteMap.get(minute);
			List<String> secondList=secondMap.get(second);
			for(String m:minuteList){
				for(String s:secondList){
					result.add(m+":"+s);
				}
			}
		}
		return result;
	}
	
	public HashMap<Integer, List<String>> getMinute(){
		HashMap<Integer, List<String>> map=new HashMap<Integer, List<String>>();
		ArrayList<String> list0=new ArrayList<String>();
		list0.add("0");
		map.put(0, list0);
		ArrayList<String> list1=new ArrayList<String>();
		list1.add("1");list1.add("2");list1.add("4");list1.add("8");
		map.put(1, list1);
		ArrayList<String> list2=new ArrayList<String>();
		list2.add("3");list2.add("5");list2.add("6");list2.add("9");list2.add("10");
		map.put(2, list2);
		ArrayList<String> list3=new ArrayList<String>();
		list3.add("7");list3.add("11");
		map.put(3, list3);
		return map;
	}
	
	public HashMap<Integer, List<String>> getSecond(){
		HashMap<Integer, List<String>> map=new HashMap<Integer, List<String>>();
		ArrayList<String> list0=new ArrayList<String>();
		list0.add("00");
		map.put(0, list0);
		map.put(1, new ArrayList<String>());
		map.put(2, new ArrayList<String>());
		map.put(3, new ArrayList<String>());
		map.put(4, new ArrayList<String>());
		map.put(5, new ArrayList<String>());
		for(int second=1;second<60;second++){
			int count=0;
			int secondTmp=second;
			while(secondTmp!=1){
				int yu=secondTmp%2;
				if(yu==1){
					count++;
				}
				secondTmp=secondTmp/2;
			}
			count++;
			List<String> list=map.get(count);
			if(second<10){
				list.add("0"+second);
			}
			else{
				list.add(second+"");
			}
			map.put(count,list);
		}
		return map;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Binary_Watch_401 b=new Binary_Watch_401();
		List<String> result=b.readBinaryWatch(6);
		for(String s:result){
			System.out.println(s);
		}
	}

}
