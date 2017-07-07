package leetcode;

import java.util.HashMap;

public class Roman_to_Integer_13 {

	public int romanToInt(String s) {
		int result=0;
		HashMap<Character,Integer> map=new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		char[] chars=s.toCharArray();
		int i=0;
		for(i=0;i<chars.length-1;i++){
			char c=chars[i];
			char next=chars[i+1];
			int thisInt=map.get(c);
			int nextInt=map.get(next);
			if(nextInt>thisInt){
				result+=(nextInt-thisInt);
				i++;
			}
			else{
				result+=thisInt;
			}
		}
		if(i==chars.length-1){
			result+=map.get(chars[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Roman_to_Integer_13 r=new Roman_to_Integer_13();
		System.out.println(r.romanToInt("MCMLXXXIV"));
	}

}
