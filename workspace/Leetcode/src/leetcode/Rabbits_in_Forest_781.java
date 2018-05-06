package leetcode;

public class Rabbits_in_Forest_781 {

	public int numRabbits(int[] answers) {
		int[] map = new int[1000];
		int rabbits = 0;
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == 0) {
				rabbits += 1;
			} else if (map[answers[i]] == 0) {
				rabbits += (answers[i] + 1);
				map[answers[i]] = 1;
			} else {
				if (map[answers[i]] < (answers[i] + 1)) {
					map[answers[i]]++;
				} else {// map[answers[i]]已等于(answers[i]+1)，不能再加了
					rabbits += (answers[i] + 1);
					map[answers[i]] = 1;
				}
			}
		}
		return rabbits;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rabbits_in_Forest_781 r = new Rabbits_in_Forest_781();
		int[] answers = new int[] { 1, 0, 1, 0, 0 };
		int[] answers2 = new int[] { 0, 0, 1, 1, 1 };
		System.out.println(r.numRabbits(answers2));
	}

}
