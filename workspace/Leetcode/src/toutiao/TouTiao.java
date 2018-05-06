package toutiao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class TouTiao {
	
	public int getCount(int[] a,int n,int k){
		HashSet<Integer> set=new HashSet<Integer>();
		for(int i=0;i<n;i++){
			set.add(a[i]);
		}
		int[] newA=new int[set.size()];
		HashSet<Integer> set2=new HashSet<Integer>();
		int p=0;
		for(int i=0;i<n;i++){
			if(!set2.contains(a[i])){
				newA[p]=a[i];
				p++;
				set2.add(a[i]);
			}
		}
		int count=0;
		for(int i=0;i<p;i++){
			if(set2.contains(newA[i]+k)){
				count++;
			}
		}
		return count;
	}
	
	public int getCount2(int[] nums,int n, int k) {
        if (nums == null || nums.length == 0 || k < 0){
        	return 0;
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) {
                    count++;
                } 
            } else {
            	int theKey=entry.getKey() + k;
                if (map.containsKey(theKey)) {
                    count++;
                }
            }
        }
        
        return count;
    }

	public static void main(String[] args) {
		TouTiao t=new TouTiao();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=in.nextInt();
		}
		System.out.println(t.getCount2(a, n, k));
		in.close();
	}

}
