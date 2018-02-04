package leetcode;

public class Decode_Ways_91 {

	public int numDecodings(String s) {
		if(s==null||s.equals("")){
			return 0;
		}
		char[] cs=s.toCharArray();
		int[][] memo=new int[cs.length][cs.length];
		return helper(cs, 0, cs.length-1, memo);		
	}
	
	public int helper(char[] cs,int left,int right,int[][] memo){
		if(memo[left][right]>0){
			return memo[left][right];
		}
		if(left>right){
			return 0;
		}
		if(left==right){
			if(cs[left]=='0'){
				return 0;
			}
			else{
				return 1;
			}			
		}
		int mid=(left+right)/2;
		int leftPart=helper(cs, left, mid, memo);
		int rightPart=helper(cs, mid+1, right, memo);
		int result=leftPart*rightPart;
		char borderLeft=cs[mid];
		char borderRight=cs[mid+1];
		if(borderLeft=='1'||(borderLeft=='2'&&borderRight>='0'&&borderRight<='6')){
			int leftleft=1;
			if(left<=mid-1){
				leftleft=helper(cs, left, mid-1, memo);
			}
			int rightright=1;
			if(mid+2<=right){
				rightright=helper(cs, mid+2, right, memo);
			}
			result+=leftleft*rightright;			
		}
		memo[left][right]=result;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Decode_Ways_91 d=new Decode_Ways_91();
		System.out.println(d.numDecodings("0"));
	}

}
