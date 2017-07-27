package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Longest_Word_in_Dictionary_through_Deleting_524 {

	public String findLongestWord(String s, List<String> d) {
		HashMap<Character, ArrayList<Integer>> map=new HashMap<Character, ArrayList<Integer>>();
		char[] cs=s.toCharArray();
		for(int i=0;i<cs.length;i++){
			ArrayList<Integer> list=map.getOrDefault(cs[i], new ArrayList<Integer>());
			list.add(i);
			map.put(cs[i], list);
		}
		int maxLength=0;
		ArrayList<String> candidates=new ArrayList<String>();
		for(String string:d){
			int end=-1;
			boolean isOK=true;
			for(int i=0;i<string.length();i++){
				char c=string.charAt(i);
				if(map.get(c)==null){
					isOK=false;
					break;
				}
				ArrayList<Integer> indexes=map.get(c);
				boolean isFind=false;
				for(Integer index:indexes){
					if(index>end){
						isFind=true;
						end=index;
						break;
					}
				}
				if(isFind==false){
					isOK=false;
					break;
				}
			}
			if(isOK==true){
				if(string.length()>maxLength){
					maxLength=string.length();
					candidates.clear();
					candidates.add(string);
				}
				else if(string.length()==maxLength){
					candidates.add(string);
				}
			}
		}
		if(candidates.size()==0){
			return "";
		}
		Collections.sort(candidates);
		return candidates.get(0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Longest_Word_in_Dictionary_through_Deleting_524 l=new Longest_Word_in_Dictionary_through_Deleting_524();
		List<String> d=new ArrayList<String>();
		d.add("a");d.add("b");d.add("c");
		System.out.println(l.findLongestWord("abpcplea", d));
	}

}
