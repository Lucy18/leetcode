package leetcode;

public class Fraction_Addition_and_Subtraction_592 {

	public String fractionAddition(String expression) {
		int fenshuPointer=0;
		int fuhaoPointer=0;
		int[] fenzi=new int[11];
		int[] fenmu=new int[11];
		char[] fuhao=new char[11];
		char[] chars=expression.toCharArray();
		if(chars[0]=='-'){
			fuhao[0]='-';			
			expression=expression.substring(1);
		}
		else{
			fuhao[0]='+';
		}
		fuhaoPointer++;
		for(int i=1;i<chars.length;i++){//将所有符号存入fuhao[]，以便之后的计算
			if(chars[i]=='+'||chars[i]=='-'){
				fuhao[fuhaoPointer]=chars[i];
				fuhaoPointer++;
			}
		}
		String[] fenshus=expression.split("\\+|-");
		for(int i=0;i<fenshus.length;i++){
			String[] it=fenshus[i].split("/");
			fenzi[fenshuPointer]=Integer.parseInt(it[0]);
			fenmu[fenshuPointer]=Integer.parseInt(it[1]);
			fenshuPointer++;
		}
		int production=1;
		for(int i=0;i<fenshuPointer;i++){
			production=production*fenmu[i];
		}
		int lastFenzi=0;
		for(int i=0;i<fenshuPointer;i++){
			int theFenzi=production/fenmu[i]*fenzi[i];
			if(fuhao[i]=='+'){
				lastFenzi+=theFenzi;
			}
			else{
				lastFenzi-=theFenzi;
			}
		}
		if(lastFenzi==0){
			return "0/1";
		}
		String lastFuhao="";
		if(lastFenzi<0){
			lastFuhao="-";
			lastFenzi=-lastFenzi;
		}
		if(lastFenzi%production==0){
			return lastFuhao+(lastFenzi/production)+"/1";
		}
		int zuidagongyueshu=maxCommonDivisor2(production, lastFenzi);
		lastFenzi=lastFenzi/zuidagongyueshu;
		production=production/zuidagongyueshu;
		return lastFuhao+lastFenzi+"/"+production;		
	}
	
	//得到两个数的最大公约数
	public int maxCommonDivisor2(int m, int n) {  
		  
        if (m < n) {// 保证m>n,若m<n,则进行数据交换  
            int temp = m;  
            m = n;  
            n = temp;  
        }  
        while (m % n != 0) {// 在余数不能为0时,进行循环  
            int temp = m % n;  
            m = n;  
            n = temp;  
        }  
        return n;// 返回最大公约数  
    }  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fraction_Addition_and_Subtraction_592 f=new Fraction_Addition_and_Subtraction_592();
		System.out.println(f.fractionAddition("5/3+1/3"));
	}

}
