package leetcode;

import java.util.ArrayList;

public class License_Key_Formatting_482 {

	public String licenseKeyFormatting(String S, int K) {
		ArrayList<Character> list=new ArrayList<Character>();
		char[] cs=S.toCharArray();
		for(int i=0;i<cs.length;i++){
			char c=cs[i];
			if(c>='A'&&c<='Z'||c>='0'&&c<='9'){
				list.add(c);
			}
			else if(c>='a'&&c<='z'){
				char a=(char)(c-'a'+'A');
				list.add(a);
			}
		}
		StringBuilder sb=new StringBuilder();
		int size=list.size();
		int i=0;
		for(;i<size%K;i++){
			sb.append(list.get(i));
		}
		if(i>0&&i<size){
			sb.append('-');
		}		
		while(i<size){
			int tmp=K;
			while(tmp>0){
				sb.append(list.get(i));
				i++;
				tmp--;
			}
			if(i<size){
				sb.append('-');
			}			
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		License_Key_Formatting_482 l=new License_Key_Formatting_482();
		System.out.println(l.licenseKeyFormatting("2", 2));
	}

}
