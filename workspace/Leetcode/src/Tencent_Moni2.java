import java.util.Scanner;

public class Tencent_Moni2 {
	
	int count=0;
	
	public int getCount(int n){
		int k=0;
		while(Math.pow(2, k)*2<=n){
			k++;
		}
		int[] pos=new int[k];
		for(int i=0;i<k;i++){
			pos[i]=2;
		}
		return 0;
	}
	
	public void helper(){
		
	}

	public static void main(String[] args) {
		Tencent_Moni2 tm=new Tencent_Moni2();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(tm.getCount(n));
		sc.close();
	}

}
