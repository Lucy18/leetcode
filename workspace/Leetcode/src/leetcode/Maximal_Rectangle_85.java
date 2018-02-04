package leetcode;

public class Maximal_Rectangle_85 {

	public int maximalRectangle(char[][] matrix) {
		if(matrix.length==0||matrix[0].length==0){
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[] height = new int[n];
		int[] left = new int[n];
		int[] right = new int[n];
		for (int i = 0; i < n; i++) {
			right[i] = n - 1;
		}
		int max_area = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					height[j] = height[j] + 1;
				} else {
					height[j] = 0;
				}
			}
			int current_left = 0;
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					left[j] = Math.max(left[j], current_left);
				} else {
					left[j] = 0;
					current_left = j + 1;
				}
			}
			int current_right = n - 1;
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					right[j] = Math.min(right[j], current_right);
				} else {
					right[j] = n - 1;
					current_right = j - 1;
				}
			}
			for(int j=0;j<n;j++){
				int area=(right[j]-left[j]+1)*height[j];
				max_area=Math.max(max_area, area);
			}
		}
		return max_area;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maximal_Rectangle_85 m=new Maximal_Rectangle_85();
		char[][] matrix=new char[][]{
			{'1','0','1','0','0'},
			{'1','0','1','1','1'},
			{'1','1','1','1','1'},
			{'1','0','0','1','0'}
		};
		System.out.println(m.maximalRectangle(matrix));
	}

}
