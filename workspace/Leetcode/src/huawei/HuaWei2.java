package huawei;

import java.util.Scanner;

public class HuaWei2 {

	public String getResult(String s){
		char[] eights=new char[32];
		if(s.contains("::")){
			int index=s.indexOf("::");
			int j=index;
			j+=2;
			for(int i=0;i<index;i++){
				eights[i]=s.charAt(i);
			}
			int beforeLength=index+2;
			int leftLength=s.length()-beforeLength;
			int zeroLength=32-index-leftLength;
			for(int i=0;i<zeroLength;i++){
				eights[index]='0';
				index++;
			}
			for(;index<32;index++){
				eights[index]=s.charAt(j);
				j++;
			}			
		}
		else if(s.contains(":")){
			String[] sps=s.split(":");
			if(sps.length!=8){
				return "Error";
			}
			int index=0;
			for(int i=0;i<8;i++){
				String now=sps[i];
				if(now.length()!=4){
					return "Error";
				}
				else{
					for(int j=0;j<4;j++){
						eights[index]=now.charAt(j);
						index++;
					}
				}
			}
		}
		else{
			return "Error";
		}
		
			//环回地址
			boolean huanwei=true;
			for(int i=0;i<31;i++){
				if(eights[i]!='0'){
					huanwei=false;
					break;
				}
			}
			if(huanwei&&eights[31]=='1'){
				return "Loopback";
			}
			if(huanwei&&eights[31]=='0'){
				return "Unspecified";
			}
			if(eights[0]=='F'&&eights[1]=='E'){
				if(eights[2]=='8'||eights[2]=='9'||eights[2]=='A'||eights[2]=='B'){
					return "LinkLocal";
				}
				else if(eights[2]=='C'||eights[2]=='D'||eights[2]=='E'||eights[2]=='F'){
					return "SiteLocal";
				}
				else{
					return "GlobalUnicast";
				}
			}
			if(eights[0]=='F'&&eights[1]=='F'){
				return "Multicast";
			}
			return "GlobalUnicast";		
	}
	
	//FE81:0001:0000:0000:FF01:0203:0405:0607
	public static void main(String[] args) {
		HuaWei2 h=new HuaWei2();
		Scanner in = new Scanner(System.in);		
		String s=in.nextLine();
		System.out.println(h.getResult(s));
		in.close();
	}
}
