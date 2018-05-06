package leetcode;

public class Swap_Adjacent_in_LR_String_777 {

	public boolean canTransform(String start, String end) {
		if (start.length() != end.length()) {
			return false;
		}
		return helper(start.toCharArray(), end.toCharArray(), 0, start.length() - 1);
	}

	public boolean helper(char[] start, char[] end, int low, int high) {
		if (low > high) {
			return true;
		}
		if (low == high) {
			return false;
		}
		while (low <= high && start[low] == end[low]) {
			low++;
		}
		if (low < high) {
			int i=-1;
			for (i = low; i < high; i++) {
				if (start[i] == 'X' && start[i + 1] == 'L') {
					start[i]='L';
					start[i+1]='X';
					break;
				} else if (start[i] == 'R' && start[i + 1] == 'X') {
					start[i]='X';
					start[i+1]='R';
					break;
				}
			}
			if(i==high){
				return false;
			}
		}
		return helper(start, end, low, high);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Swap_Adjacent_in_LR_String_777 s = new Swap_Adjacent_in_LR_String_777();
		System.out.println(s.canTransform("LLR", "RRL"));
		System.out.println(s.canTransform("XXXLXXXXXX", "XXXLXXXXXX"));
		System.out.println(s.canTransform("XXXXXLXXXX", "LXXXXXXXXX"));
	}

}
