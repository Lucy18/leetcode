package leetcode;

public class Decode_String_394 {

	public String decodeString(String s) {
		if(s.indexOf('[')==-1){
			return s;
		}
		StringBuilder sb=new StringBuilder();
		char[] cs=s.toCharArray();
		String integs="";
		int i=0;
		while(i<cs.length){
			if(cs[i]>='0'&&cs[i]<='9'){
				integs+=cs[i];
				i++;
			}
			else if(cs[i]=='['){
				int leftBound=1;
				i++;
				String innerString="";
				while(i<cs.length&&leftBound>0){
					if(cs[i]=='['){
						leftBound++;
					}
					else if(cs[i]==']'){
						leftBound--;
					}
					if(leftBound>0){
						innerString+=cs[i];
					}
					i++;
				}
				String repeatString=decodeString(innerString);
				int repeatTimes=Integer.parseInt(integs);
				for(int count=0;count<repeatTimes;count++){
					sb.append(repeatString);
				}
				integs="";
			}
			else{//9[cs]ab中的ab这样的情况
				sb.append(cs[i]);
				i++;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Decode_String_394 d=new Decode_String_394();
		System.out.println(d.decodeString("2[abc]3[cd]ef"));
	}

}
