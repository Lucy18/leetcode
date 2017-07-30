package leetcode;

public class Add_Strings_415 {

	public String addStrings(String num1, String num2) {
		String resultString="";
		char[] cs1=num1.toCharArray();
		char[] cs2=num2.toCharArray();
		int len1=cs1.length;
		int len2=cs2.length;
		int maxLen=len1>=len2?len1:len2;
		char[] result=new char[maxLen+1];
		int pointer1=cs1.length-1;
		int pointer2=cs2.length-1;
		int pointerResult=maxLen;
		int jinwei=0;
		while(pointer1>=0&&pointer2>=0){
			int digit1=cs1[pointer1]-'0';
			int digit2=cs2[pointer2]-'0';
			int sum=(digit1+digit2+jinwei)%10;
			jinwei=(digit1+digit2+jinwei)/10;
			result[pointerResult]=(char)(sum+'0');
			pointer1--;pointer2--;pointerResult--;
		}
		while(pointer1>=0){
			int digit1=cs1[pointer1]-'0';
			int sum=(digit1+jinwei)%10;
			jinwei=(digit1+jinwei)/10;
			result[pointerResult]=(char)(sum+'0');
			pointer1--;pointerResult--;
		}
		while(pointer2>=0){
			int digit2=cs2[pointer2]-'0';
			int add=(digit2+jinwei)%10;
			jinwei=(digit2+jinwei)/10;
			result[pointerResult]=(char)(add+'0');
			pointer2--;pointerResult--;
		}
		int beginPointer=1;
		if(jinwei==1){
			result[pointerResult]='1';
			beginPointer=0;
		}
		for(;beginPointer<maxLen+1;beginPointer++){
			resultString+=result[beginPointer];
		}
		return resultString;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Add_Strings_415 a=new Add_Strings_415();
		System.out.println(a.addStrings("109", "3"));
	}

}
   
