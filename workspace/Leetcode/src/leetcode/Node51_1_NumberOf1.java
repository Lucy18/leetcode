package leetcode;
import java.io.*;
import java.util.*;

public class Node51_1_NumberOf1{
	
   public long solve(int num){
		long result=0;
		long base=10;
		//从个位开始统计1的个数
		long shang=num/base;
		long yu=num%base;
		long weishu=base/10;//如12011，base为1000,得到商为12，余数为11，要是看百位上的话就要base/10=100
		while(yu>=weishu||shang!=0){
			if(yu/weishu==0){
				result+=shang*weishu;//如12011，就是12*100
			}
			else if(yu/weishu==1){
				result+=shang*weishu+yu%weishu+1;//如12113，就是12*100+（13-0+1）
			}
			else{
				result+=(shang+1)*weishu;//如12312,就是13*100
			}
			base=base*10;
			shang=num/base;
			yu=num%base;
			weishu=base/10;
		}
		return result;
    }
   
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out);

      int a = in.nextInt();
      in.close();
      Node51_1_NumberOf1 s=new Node51_1_NumberOf1();
      long b=s.solve(a);
    
      out.println(b);

      out.flush();
   }
}