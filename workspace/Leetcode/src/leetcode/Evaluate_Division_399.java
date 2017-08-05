package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class Evaluate_Division_399 {

	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		double[] result=new double[queries.length];
		HashMap<String, HashMap<String,Double>> map=new HashMap<String, HashMap<String,Double>>();
		for(int i=0;i<equations.length;i++){
			String a=equations[i][0];
			String b=equations[i][1];
			HashMap<String, Double> m=map.getOrDefault(a, new HashMap<String, Double>());
			m.put(b, values[i]);
			map.put(a, m);
			HashMap<String, Double> n=map.getOrDefault(b, new HashMap<String, Double>());
			n.put(a, 1/values[i]);
			map.put(b, n);
		}
		for(int i=0;i<queries.length;i++){
			String beichushu=queries[i][0];
			String chushu=queries[i][1];
			if(map.get(beichushu)==null||map.get(chushu)==null){
				result[i]=-1.0;
				continue;
			}
			if(beichushu.equals(chushu)){
				result[i]=1.0;
				continue;
			}
			if(map.get(beichushu).get(chushu)!=null){
				result[i]=map.get(beichushu).get(chushu);
				continue;
			}
			HashSet<String> visited=new HashSet<String>();
			result[i]=helper(beichushu, chushu, map,visited);
		}
		return result;
	}
	
	public double helper(String beichushu,String chushu,
			HashMap<String, HashMap<String,Double>> map,HashSet<String> visited){
		visited.add(beichushu);
		HashMap<String, Double> tmp=map.get(beichushu);
		if(tmp.get(chushu)!=null){
			return tmp.get(chushu);
		}
		else{
			for(Entry<String, Double> entry:tmp.entrySet()){
				String newBeichushu=entry.getKey();
				if(visited.contains(newBeichushu)){
					continue;
				}
				double val=helper(newBeichushu, chushu, map, visited);
				if(val!=-1){
					return entry.getValue()*val;
				}			
			}
		}
		visited.remove(beichushu);
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Evaluate_Division_399 e=new Evaluate_Division_399();
		String[][] equations=new String[][]{
			{"a","b"},{"c","d"}
		};
		double[] values=new double[]{ 1,1 };
		String[][] queries=new String[][]{
			{"a","c"},{"b","d"},{"b","a"},{"d","c"}
		};
		System.out.println(Arrays.toString(e.calcEquation(equations, values, queries)));
	}

}
