import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Scanner;

/**
 * 阿里巴巴2018年内推在线编程题
 * @author huanghanqian
 *
 */
public class Main {
	
	public static void main(String[] args) {
      
		List<Integer> order = new ArrayList<Integer>();
		Map<String, List<Integer>> boms = new HashMap<String, List<Integer>>();

		Scanner in = new Scanner(System.in);
		String line = in.nextLine();

		Integer n = Integer.parseInt(line.split(",")[0]);
		Integer m = Integer.parseInt(line.split(",")[1]);

		line = in.nextLine();
		String[] itemCnt = line.split(",");
		for (int i = 0; i < n; i++) {
			order.add(Integer.parseInt(itemCnt[i]));
		}

		for (int i = 0; i < m; i++) {
			line = in.nextLine();
			String[] bomInput = line.split(",");
			List<Integer> bomDetail = new ArrayList<Integer>();

			for (int j = 1; j <= n; j++) {
				bomDetail.add(Integer.parseInt(bomInput[j]));
			}
			boms.put(bomInput[0], bomDetail);
		}
		in.close();

		Map<String, Integer> res = resolve(order, boms);

		System.out.println("match result:");
		for (String key : res.keySet()) {
			System.out.println(key + "*" + res.get(key));
		}
	}

	// write your code here
	public static Map<String, Integer> resolve(List<Integer> order, Map<String, List<Integer>> boms) {
		HashSet<String> visited=new HashSet<String>();
		HashMap<String, Integer> result=helper(order,boms,visited).map;
		return result;
	}
	
	public static MyResult helper(List<Integer> order, Map<String, List<Integer>> boms,HashSet<String> visited){
		int max=0;
		HashMap<String, Integer> mapMax=new HashMap<String, Integer>();
		for(Entry<String, List<Integer>> entry:boms.entrySet()){
			HashMap<String, Integer> map=new HashMap<String,Integer>();
			int count=0;
			if(visited.contains(entry.getKey())){
				continue;
			}
			else{
				List<Integer> boom=entry.getValue();
				List<Integer> orderClone=new ArrayList<>(order);
				int min=Integer.MAX_VALUE;
				for(int j=0;j<orderClone.size();j++){
					if(boom.get(j)==0){
						continue;
					}
					min=Math.min(min, orderClone.get(j)/boom.get(j));
				}
				if(min>0){
					for(int j=0;j<orderClone.size();j++){
						orderClone.set(j, orderClone.get(j)-min*boom.get(j));
						count+=min*boom.get(j);
					}
					
					visited.add(entry.getKey());
					map.put(entry.getKey(), min);
					MyResult newResult=helper(orderClone, boms, visited);
					count+=newResult.count;
					if(count>max){
						max=count;
						HashMap<String, Integer> newmap=newResult.map;
						for(String key:newmap.keySet()){
							map.put(key, newmap.get(key));
						}
						mapMax=cloneMap(map);
					}
					visited.remove(entry.getKey());
					map.remove(entry.getKey());
				}
			}		
		}
		return new MyResult(max, mapMax);
	}
	
	public static class MyResult{
		int count;
		HashMap<String, Integer> map;
		public MyResult(int a,HashMap<String, Integer> b){
			count=a;
			map=cloneMap(b);
		}
	}
	
	public static HashMap<String, Integer> cloneMap(HashMap<String, Integer> b){
		HashMap<String, Integer> map=new HashMap<String,Integer>();
		for(String key:b.keySet()){
			map.put(key, b.get(key));
		}
		return map;
	}
}