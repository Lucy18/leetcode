import java.util.Scanner;

public class Tencent_Moni {
	
	boolean isequal(double x,double y){  
	    if(x-y>=-1e-8&&x-y<=1e-8)  
	        return true;  
	    return false;  
	}  
	boolean isSquare(int[][] nodes){  
	    double[] len=new double[6];  
	    len[0]=getDistance(nodes[0][0],nodes[0][1],nodes[1][0],nodes[1][1]);  
	    len[1]=getDistance(nodes[0][0],nodes[0][1],nodes[2][0],nodes[2][1]);  
	    len[2]=getDistance(nodes[0][0],nodes[0][1],nodes[3][0],nodes[3][1]);  
	    len[3]=getDistance(nodes[1][0],nodes[1][1],nodes[2][0],nodes[2][1]);  
	    len[4]=getDistance(nodes[1][0],nodes[1][1],nodes[3][0],nodes[3][1]);  
	    len[5]=getDistance(nodes[2][0],nodes[2][1],nodes[3][0],nodes[3][1]);  
	    double len1=len[0];  
	    double len2=len[0];  
	    for(int i=1;i<6;++i){  
	        if(!isequal(len[i],len2)&&!isequal(len[i],len1))  
	            len2=len[i];  
	    }  
	    for(int i=0;i<6;++i){  
	        if(isequal(len[i],len2)||isequal(len[i],len1));  
	        else return false;  
	    }  
	    if(len2-len1<-1e-8) {
	    	double tmp=len1;
	    	len1=len2;
	    	len2=tmp;
	    }	       
	    if(!isequal(2*len1*len1,len2*len2))  
	        return false;  
	    return true;  
	}  
	
	public double getDistance(int x1,int y1,int x2,int y2){
		
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
	
	
	public boolean ifVertical(int x1,int y1,int x2,int y2,int x3,int y3){
		if(x1==x2){
			return y1==y3||y2==y3;
		}
		if(x1==x3){
			return y1==y2||y3==y2;
		}
		if(x2==x3){
			return y2==y1||y3==y1;
		}
		int fenzi=(y2-y1)*(y3-y2);
		int fenmu=(x2-x1)*(x3-x2);
		return fenzi==-fenmu;
	}

	public static void main(String[] args) {
		Tencent_Moni tm=new Tencent_Moni();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int[][] stones=new int[4][2];
			for(int j=0;j<4;j++){
				int x=sc.nextInt();
				stones[j][0]=x;
			}
			for(int j=0;j<4;j++){
				int y=sc.nextInt();
				stones[j][1]=y;
			}
			
			if(tm.isSquare(stones)){
				System.out.println("Yes");
			}
			else{
				System.out.println("No");
			}
		}
		
//		
//		int[][] stones=new int[][]{
//			{0,0},{0,2},{2,0},{2,2}
//		};
//		System.out.println(tm.isSquare(stones));
		
		
		sc.close();
	}

}
