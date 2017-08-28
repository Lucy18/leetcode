package leetcode;

public class Zuma_Game_488 {

	public int findMinStep(String board, String hand) {
		int[] hands=new int[26];
		for(int i=0;i<hand.length();i++){
			hands[hand.charAt(i)-'A']++;
		}
		int steps=minSteps(board, hands);
		if(steps==6){
			return -1;
		}
		else{
			return steps;
		}
	}
	
	public int minSteps(String board,int[] hands){
		board=removeDuplicate3(board);
		if(board.length()==0){
			return 0;
		}
		char[] cs=board.toCharArray();
		int min=6;//因为The number of balls in your hand won't exceed 5
		int low=0;
		int high=1;
		int duplicate=1;
		while(low<cs.length){
			if(high>=cs.length||cs[high]!=cs[low]){
				int need=3-duplicate;
				if(hands[cs[low]-'A']>=need){
					hands[cs[low]-'A']-=need;
					String subStr="";
					if(high>=cs.length){
						subStr=board.substring(0,low);
					}
					else{
						 subStr=board.substring(0,low)+board.substring(high);
					}
					int step=need+minSteps(subStr, hands);
					if(step<min){
						min=step;
					}
					hands[cs[low]-'A']+=need;
				}
				low=high;
				high=low+1;
				duplicate=1;
			}
			else{
				high++;
				duplicate++;
			}
		}
		return min;
	}
	
	public String removeDuplicate3(String board){
		boolean isFind=true;
		String result="";
		while(isFind==true){
			isFind=false;
			if(board.length()<3){
				return board;
			}	
			result="";
			int low=0;
			int fast=1;
			int duplicate=1;
			//之所以不让fast<board.length()
			//是考虑到BYYBBRRB这个末尾有一个独立的字母的情况
			while(low<board.length()){
				while(fast<board.length()&&board.charAt(fast)==board.charAt(low)){
					fast++;
					duplicate++;
				}
				if(duplicate<3){
					for(int i=low;i<fast;i++){
						result+=board.charAt(i);
					}
				}
				else{
					isFind=true;
				}
				low=fast;
				fast=low+1;
				duplicate=1;			
			}
			board=result;
		}		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Zuma_Game_488 z=new Zuma_Game_488();
		System.out.println(z.findMinStep("RRGGWYYWWGGR","YRG"));
	//	System.out.println(z.removeDuplicate3("RRGGWYYYWWGGR"));
	}

}
