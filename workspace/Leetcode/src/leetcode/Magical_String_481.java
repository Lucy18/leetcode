package leetcode;

public class Magical_String_481 {

	public int magicalString(int n) {
		if(n==0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		if(n==2){
			return 1;
		}
		if(n==3){
			return 1;
		}
		int[] string=new int[n];
		int result=0;
		boolean isOne=true;
		int pointer=3;int occurrencePointer=2;
		string[0]=1;string[1]=2;string[2]=2;
		while(pointer<n){
			int occurrence=string[occurrencePointer];
			if(isOne){
				while(pointer<n&&occurrence>0){
					string[pointer]=1;
					pointer++;
					occurrence--;
				}
				isOne=false;
			}
			else{
				while(pointer<n&&occurrence>0){
					string[pointer]=2;
					pointer++;
					occurrence--;
				}
				isOne=true;
			}
			occurrencePointer++;
		}
		for(int i=0;i<n;i++){
			if(string[i]==1){
				result+=1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Magical_String_481 m=new Magical_String_481();
		System.out.println(m.magicalString(7));
	}

}
