package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Data_Stream_as_Disjoint_Intervals_352 {

	int[] map;
	int maxInteger;
	
	/** Initialize your data structure here. */
    public Data_Stream_as_Disjoint_Intervals_352() {
        map=new int[10000];
        maxInteger=0;
    }
    
    public void addNum(int val) {
        if(val>maxInteger){
        	maxInteger=val;
        }
        if(maxInteger>map.length+1){
        	int length=Math.max(map.length*2, maxInteger);
        	int[] newMap=new int[length+1];
        	for(int i=0;i<map.length;i++){
        		newMap[i]=map[i];
        	}
        }
        map[val]=1;
    }
    
    public List<Interval> getIntervals() {
        List<Interval> list=new ArrayList<Interval>();
        int i=0;
        int begin=0,end=0;
        while(i<=maxInteger){
        	while(map[i]==0){
        		i++;
        	}
        	begin=i;
        	while(map[i]==1){
        		i++;
        	}
        	end=i-1;
        	Interval interval=new Interval(begin,end);
        	list.add(interval);
        }
        return list;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data_Stream_as_Disjoint_Intervals_352 d=new Data_Stream_as_Disjoint_Intervals_352();
		d.addNum(1);
		d.print(d.getIntervals());
		d.addNum(3);
		d.print(d.getIntervals());
		d.addNum(7);
		d.print(d.getIntervals());
		d.addNum(2);
		d.print(d.getIntervals());
		d.addNum(6);
		d.print(d.getIntervals());	
	}
	
	public void print(List<Interval> s){
		for(Interval i:s){
			System.out.print("["+i.start+","+i.end+"],");
		}
		System.out.println();
	}

}
