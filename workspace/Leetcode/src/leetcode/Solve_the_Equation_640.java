package leetcode;

public class Solve_the_Equation_640 {

	public String solveEquation(String equation) {
		String[] leftAndRight=equation.split("=");
		int[] left=solve(leftAndRight[0]);
		int[] right=solve(leftAndRight[1]);
		int x_xishu=left[0]-right[0];
		int changshu=right[1]-left[1];
		if(x_xishu==0&&changshu!=0){
			return "No solution";
		}
		if(x_xishu==0&&changshu==0){
			return "Infinite solutions";
		}
		int num=changshu/x_xishu;
		return "x="+num;
	}
	
	//int[0]返回当前表达式中x的系数
	//int[1]返回当前表达式中的常数大小
	public int[] solve(String s){
		int x_xishu=0;
		int changshu=0;
		int begin=0;
		int end=1;	
		char fuhao='+';
		if(s.charAt(0)=='-'){
			fuhao='-';
			begin=1;
			end=2;
		}	
		while (end <= s.length()) {
			while (end < s.length() && s.charAt(end) != '+' && s.charAt(end) != '-') {
				end++;
			}
			String the=s.substring(begin,end);
			if(the.indexOf('x')!=-1){//是系数
				String numString=the.substring(0, the.indexOf('x'));
				int num=1;
				if(!numString.equals("")){
					num=Integer.parseInt(numString);
				}
				if(fuhao=='+'){
					x_xishu+=num;
				}
				else{
					x_xishu-=num;
				}
			}
			else{//是常数
				int num=Integer.parseInt(the);
				if(fuhao=='+'){
					changshu+=num;
				}
				else{
					changshu-=num;
				}
			}			
			if(end<s.length()){
				fuhao = s.charAt(end);
			}			
			begin=end+1;
			end=begin+1;
		}
		return new int[]{x_xishu,changshu};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solve_the_Equation_640 s=new Solve_the_Equation_640();
		System.out.println(s.solveEquation("x=x+2"));
	}

}
