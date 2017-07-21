package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class Maximum_Product_of_Word_Lengths_318 {

	public int maxProduct(String[] words) {
		int maxProduct=0;
		HashMap<String, HashSet<Character>> map=new HashMap<String, HashSet<Character>>();
		for(int i=0;i<words.length;i++){
			String word=words[i];
			char[] c=word.toCharArray();
			HashSet<Character> hashSet=new HashSet<Character>();
			for(int j=0;j<c.length;j++){
				hashSet.add(c[j]);
			}
			map.put(word, hashSet);
		}
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			int length1 = word.length();
			char[] cs = word.toCharArray();
			for (int nextI = i + 1; nextI < words.length; nextI++) {
				HashSet<Character> set = map.get(words[nextI]);
				boolean hasCommon=false;
				for (int j = 0; j < cs.length; j++) {
					char c=cs[j];
					if(set.contains(c)){
						hasCommon=true;
						break;
					}				
				}
				if(hasCommon==false){
					int length2=words[nextI].length();
					int product=length1*length2;
					if(product>maxProduct){
						maxProduct=product;
					}
				}
			}
		}
		return maxProduct;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maximum_Product_of_Word_Lengths_318 m=new Maximum_Product_of_Word_Lengths_318();
		String[] words=new String[]{"a", "aa", "aaa", "aaaa"};
		System.out.println(m.maxProduct(words));
	}
	
}
