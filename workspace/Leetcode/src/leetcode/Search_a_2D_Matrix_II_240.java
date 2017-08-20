package leetcode;

public class Search_a_2D_Matrix_II_240 {

	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length==0||matrix[0].length==0){
			return false;
		}
		return search(matrix, 0, matrix.length-1, 0, matrix[0].length-1, target);
	}
	
	public boolean search(int[][] matrix,int xBegin,int xEnd,
			int yBegin,int yEnd,int target){
		if(xBegin==xEnd&&yBegin==yEnd){
			//[[1]] target=1的情况
			if(matrix[xBegin][yBegin]==target){
				return true;
			}
			else{
				return false;
			}			
		}
		int length=Math.min(xEnd-xBegin, yEnd-yBegin);
		int i=0;
		//对于[[1,1]] target=0这种情况
		//第一个对角线结点就大于target，说明该矩阵中不存在target
    	if(matrix[xBegin+i][yBegin+i]>target){
    		return false;
    	}
	    for(i=0;i<=length;i++){
	    	if(matrix[xBegin+i][yBegin+i]==target){
	    		return true;
	    	}
	    	else if(matrix[xBegin+i][yBegin+i]>target){
	    		break;
	    	}
	    }
	    boolean currentCubeFind=false;
	    if(i<=length){
	    	 for(int j=0;j<i;j++){
	 	    	if(matrix[xBegin+i][yBegin+j]==target){
	 	    		return true;
	 	    	}
	 	    	if(matrix[xBegin+j][yBegin+i]==target){
	 	    		return true;
	 	    	}
	 	    }
	    	if(i<length){
	    		currentCubeFind=currentCubeFind||
	    			search(matrix, xBegin+i+1, xBegin+length, yBegin, yBegin+i, target)||
	    			search(matrix, xBegin, xBegin+i, yBegin+i+1, yBegin+length, target);
	    	}    
	    }
	   if(currentCubeFind==true){
		   return true;
	   }
	   if(xEnd-xBegin>yEnd-yBegin){//高比宽长的矩形
		   return search(matrix, xBegin+length+1, xEnd, yBegin, yEnd, target);
	   }
	   else if(xEnd-xBegin<yEnd-yBegin){//宽比高长的矩形
		   return search(matrix, xBegin, xEnd, yBegin+length+1, yEnd, target);
	   }
	   return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Search_a_2D_Matrix_II_240 s=new Search_a_2D_Matrix_II_240();
		int[][] matrix=new int[][]{
		     {1,2,3,4,5},
		     {6,7,8,9,10},
		     {11,12,13,14,15},
		     {16,17,18,19,20},
		     {21,22,23,24,25}
		};
		System.out.println(s.searchMatrix(matrix, 15));
	}

}
