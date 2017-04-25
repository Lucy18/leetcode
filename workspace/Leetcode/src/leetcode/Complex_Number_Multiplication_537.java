package leetcode;

public class Complex_Number_Multiplication_537 {

	public String complexNumberMultiply(String a, String b) {
		  //+是正则中的特殊字符
		  //对于单个匹配字段，如+，*，|、\等，可以使用类似于“\\+"或者[+]进行处理
		  //为什么需要两个\呢：第一个\是java字符串的转义字符，这样\\实际就代表\，正则处理的就是\+
          String[] split1=a.split("\\+");
          int a1=Integer.parseInt(split1[0]);
          String b1i=split1[1].substring(0, split1[1].length()-1);
          int b1=Integer.parseInt(b1i);
          
          String[] split2=b.split("\\+");
          int a2=Integer.parseInt(split2[0]);
          String b2i=split2[1].substring(0, split2[1].length()-1);
          int b2=Integer.parseInt(b2i);
          
          int final_a=a1*a2-b1*b2;
          int final_b=a1*b2+b1*a2;
          
          return String.valueOf(final_a)+'+'+String.valueOf(final_b)+'i';
          
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Complex_Number_Multiplication_537 c = new Complex_Number_Multiplication_537();
		System.out.println(c.complexNumberMultiply("1+1i", "1+1i"));
		System.out.println(c.complexNumberMultiply("1+-1i", "1+-1i"));
	}

}
