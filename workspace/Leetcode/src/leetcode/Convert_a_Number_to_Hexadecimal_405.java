package leetcode;

import java.util.HashMap;

public class Convert_a_Number_to_Hexadecimal_405 {

	public String toHex(int num) {
		if(num==0){
			return "0";
		}
		HashMap<Integer, Character> map=new HashMap<Integer, Character>();
		map.put(0,'0');
		map.put(1,'1');map.put(2,'2');map.put(3,'3');
		map.put(4,'4');map.put(5,'5');map.put(6,'6');
		map.put(7,'7');map.put(8,'8');map.put(9,'9');
		map.put(10,'a');map.put(11,'b');map.put(12,'c');
		map.put(13,'d');map.put(14,'e');map.put(15,'f');
		
		int[] bits=new int[32];
		long absNum=Math.abs((long)num);
		int pointer=31;
		while(absNum>0){
			if(absNum%2==1){
				bits[pointer]=1;
			}
			absNum=absNum/2;
			pointer--;
		}
		if(num<0){
			reverseAddOne(bits);
		}
		String result="";
		boolean isLeadingZero=true;
		for(int i=0;i<8;i++){
			int one=bits[i*4];
			int two=bits[i*4+1];
			int three=bits[i*4+2];
			int four=bits[i*4+3];
			if(isLeadingZero&&one==0&&two==0&&three==0&&four==0){
				continue;//前导0 可以忽略
			}
			isLeadingZero=false;//之后的0就不是前导0了
			int thisNumber=one*8+two*4+three*2+four;
			result=result+map.get(thisNumber);
		}		
		return result;
	}
	
	public void reverseAddOne(int[] bits){//取反加一
		for(int i=0;i<32;i++){
			bits[i]=1-bits[i];//1-0=1,1-1=0
		}
		int pointer=31;
		while(pointer>=0){
			if(bits[pointer]==0){
				bits[pointer]=1;
				break;
			}
			else{
				bits[pointer]=0;
				pointer--;
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Convert_a_Number_to_Hexadecimal_405 c=new Convert_a_Number_to_Hexadecimal_405();
		System.out.println(c.toHex(16));
		System.out.println(c.toHex(-2147483648));
	}

}
