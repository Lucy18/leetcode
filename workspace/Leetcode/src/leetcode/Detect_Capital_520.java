package leetcode;

public class Detect_Capital_520 {

	public boolean ifAllUpperCase(char[] a,int begin,int length){
		for(int i=begin;i<length;i++){
			if(a[i]<'A'||a[i]>'Z'){
				return false;
			}
		}
		return true;
	}
	
	public boolean ifAllLowerCase(char[] a,int begin,int length){
		for(int i=begin;i<length;i++){
			if(a[i]<'a'||a[i]>'z'){
				return false;
			}
		}
		return true;
	}
	
	public boolean detectCapitalUse(String word) {
		char[] a=word.toCharArray();
		int length=a.length;
		if(a[0]>='A'&&a[0]<='Z'){
			return ifAllUpperCase(a, 1, length)||ifAllLowerCase(a, 1, length);
		}
		else if(a[0]>='a'&&a[0]<='z'){
			return ifAllLowerCase(a, 1, length);
		}
		else{
			return false;
		}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Detect_Capital_520 d=new Detect_Capital_520();
		System.out.println(d.detectCapitalUse("flaG"));
	}

}
