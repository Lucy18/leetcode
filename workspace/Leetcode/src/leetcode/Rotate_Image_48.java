package leetcode;

public class Rotate_Image_48 {

	public void rotate(int[][] matrix) {
		if(matrix.length==0){
			return;
		}
		int bianchang=matrix.length;
		int leftTop=0;
		while(bianchang>1){
			int[] buffer=new int[bianchang];
			//把上边存入buffer中
			for(int i=0;i<bianchang;i++){
				buffer[i]=matrix[leftTop][leftTop+i];
			}
			//左边覆盖上边
			for(int i=0;i<bianchang;i++){
				//上边从右到左开始覆盖，如果从左到右，会出现交叉点覆盖(右上角被覆盖成21)
				matrix[leftTop][leftTop+bianchang-i-1]=matrix[leftTop+i][leftTop];
			}
			//下边覆盖左边
			for(int i=0;i<bianchang;i++){
				matrix[leftTop+i][leftTop]=matrix[leftTop+bianchang-1][leftTop+i];
			}
			//右边覆盖下边
			for(int i=0;i<bianchang;i++){
				matrix[leftTop+bianchang-1][leftTop+i]=matrix[leftTop+bianchang-i-1][leftTop+bianchang-1];
			}
			//buffer覆盖右边
			for(int i=0;i<bianchang;i++){
				matrix[leftTop+i][leftTop+bianchang-1]=buffer[i];
			}
			leftTop+=1;
			bianchang-=2;
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rotate_Image_48 r=new Rotate_Image_48();
		int[][] matrix=new int[][]{
			{1,2,3,4,5},
			{6,7,8,9,10},
			{11,12,13,14,15},
			{16,17,18,19,20},
			{21,22,23,24,25}	
		};
		r.rotate(matrix);
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

}
