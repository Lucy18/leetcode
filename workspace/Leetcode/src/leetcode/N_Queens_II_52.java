package leetcode;


public class N_Queens_II_52 {

	int n;
	int[] column;
	int[] leftUpToRightBottom;//从左上角到右下角的(不是线的起点终点，是趋势)：/一道道下去
	int[] rightUpToLeftBottom;//从右上角到左下角的(是趋势):\一道道下去
	int count=0;
	
	public int totalNQueens(int n) {
		this.n=n;
		column=new int[n];
		leftUpToRightBottom=new int[2*n-1];
		rightUpToLeftBottom=new int[2*n-1];
		backTrack(0);
		return count;
	}
	
	public void backTrack(int i){//i是row,j是column
		if(i==n){
			count++;
			return;
		}
		for(int j=0;j<n;j++){
			int zheng=i+j;
			int fan=i-j+n-1;
			if(column[j]==0&&leftUpToRightBottom[zheng]==0&&rightUpToLeftBottom[fan]==0){
				column[j]=1;
				leftUpToRightBottom[zheng]=1;
				rightUpToLeftBottom[fan]=1;
				backTrack(i+1);
				column[j]=0;
				leftUpToRightBottom[zheng]=0;
				rightUpToLeftBottom[fan]=0;
			}
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N_Queens_II_52 n=new N_Queens_II_52();
		System.out.println(n.totalNQueens(8));
	}

}
