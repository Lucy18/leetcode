package leetcode;

public class Remove_9_660 {

	//将十进制数n 转化为九进制数
	public int newInteger(int n) {
		int result=0;
		int base=1;
		while(n>0){
			result=result+ n%9 * base;
			base=base*10;
			n=n/9;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Remove_9_660 r=new Remove_9_660();
		System.out.println(r.newInteger(10));
	}

}
