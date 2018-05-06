import java.util.Scanner;

public class MeiTuan {

	public int getMinNum(String s){
		int[] map=new int[10];
		for(int i=0;i<s.length();i++){
			map[s.charAt(i)-'0']++;
		}
		int num=1;
		while(true){
			int[] theMap=new int[10];
			int copy=num;
			while(copy>0){
				int zhi=copy%10;
				theMap[zhi]++;
				copy=copy/10;
			}
			for(int i=0;i<10;i++){
				if(map[i]<theMap[i]){
					return num;
				}
			}
			num++;
		}
	}
	
	public static void main(String args[]) {
		MeiTuan meiTuan=new MeiTuan();
        Scanner cin = new Scanner(System.in);
        String s="";
        while (cin.hasNext()) {
            s=cin.nextLine();
            System.out.println(meiTuan.getMinNum(s));
        }
        cin.close();
    }

}
