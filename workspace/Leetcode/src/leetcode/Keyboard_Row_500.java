package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Keyboard_Row_500 {
	char[][] keywords=new char[][]{{'q','w','e','r','t','y','u','i','o','p'},
		{'a','s','d','f','g','h','j','k','l'},
		{'z','x','c','v','b','n','m'}};
	
	private boolean isOK(String word){
		boolean isOK=true;
		word=word.toLowerCase();
		char[] chars=word.toCharArray();
		char firstChar=chars[0];
		int type=2;
		for(int i=0;i<keywords[0].length;i++){
			if(keywords[0][i]==firstChar){
				type=0;
				break;
			}
		}
		if(type!=1){
			for(int i=0;i<keywords[1].length;i++){
				if(keywords[1][i]==firstChar){
					type=1;
					break;
				}
			}
		}
		for(int i=1;i<chars.length;i++){
			char thisChar=chars[i];
			boolean isContains=false;
			for(int j=0;j<keywords[type].length;j++){
				if(thisChar==keywords[type][j]){
					isContains=true;
					break;
				}
			}
			if(isContains==false){
				isOK=false;
				break;
			}
		}
		return isOK;
	}

	public String[] findWords(String[] words) {
		ArrayList<String> s = new ArrayList<String>();
		for(int i=0;i<words.length;i++){
			if(isOK(words[i])==true){
				s.add(words[i]);
			}
		}
		String[] result=new String[s.size()];
		for(int i=0;i<s.size();i++){
			result[i]=s.get(i);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Keyboard_Row_500 k = new Keyboard_Row_500();
		String[] words=new String[]{"Hello", "Alaska", "Dad", "Peace"};
		System.out.println(Arrays.toString(k.findWords(words)));
	}

}
