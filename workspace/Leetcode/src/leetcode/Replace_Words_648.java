package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Replace_Words_648 {

	public String replaceWords(List<String> dict, String sentence) {
		String result="";
		HashSet<String> set=new HashSet<String>();
		for(String s:dict){
			set.add(s);
		}
		String[] words=sentence.split(" ");
		for(int i=0;i<words.length;i++){
			String word=words[i];
			for(int j=1;j<=word.length()&&j<101;j++){
				String subWord=word.substring(0,j);
				if(set.contains(subWord)){
					word=subWord;
					break;
				}
			}
			result+=word+" ";
		}
		return result.substring(0,result.length()-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Replace_Words_648 r=new Replace_Words_648();
		List<String> dict=new ArrayList<String>();
		dict.add("cat");dict.add("bat");dict.add("rat");
		System.out.println(r.replaceWords(dict, "the cattle was rattled by the battery"));
	}

}
