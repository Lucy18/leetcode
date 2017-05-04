package leetcode;

public class Queue_Reconstruction_by_Height_406 {
	
	public int[][] daoxu(int[][] people){
		for(int i=0;i<people.length;i++){
			for(int j=0;j<people.length-1-i;j++){
				if(people[j][0]<people[j+1][0]||(people[j][0]==people[j+1][0]&&people[j][1]>people[j+1][1])){
					int[] temp=people[j];
					people[j]=people[j+1];
					people[j+1]=temp;
				}
			}
		}
		return people;
	}

	public int[][] reconstructQueue(int[][] people) {
		people=daoxu(people);
		for(int i=1;i<people.length;i++){
			int count=0;
			for (int j = 0; j < i; j++) {
				if(count==people[i][1]){
					int[] temp=people[i];
					for(int k=i;k>j;k--){
						people[k]=people[k-1];
					}
					people[j]=temp;
					break;
				}
				if (people[j][0] >= people[i][0]) {
					count++;
				}
			}
		}
		return people;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue_Reconstruction_by_Height_406 q=new Queue_Reconstruction_by_Height_406();
		int[][] a=new int[][]{{9,0},{7,0},{1,9},{3,0},{2,7},{5,3},{6,0},{3,4},{6,2},{5,2}};
		int[][] b=q.reconstructQueue(a);
		for(int i=0;i<b.length;i++){
			System.out.print("("+b[i][0]+","+b[i][1]+") ");
		}
	}

}
