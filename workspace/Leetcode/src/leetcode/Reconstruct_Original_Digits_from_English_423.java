package leetcode;

import java.util.HashMap;

public class Reconstruct_Original_Digits_from_English_423 {

	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	int[] resultInt = new int[10];

	public String originalDigits(String s) {
		char[] cs = s.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			int count = map.getOrDefault(cs[i], 0);
			count++;
			map.put(cs[i], count);
		}
		// zero one two three four five six seven eight nine
		// z是zero的唯一标识，w是two的唯一标识，
		// u是four的唯一标识，x是six的唯一标识
		// g是eight的唯一标识
		// 不可以说n、i是nine的唯一标志(因为n、i有可能是one和six出现的ni）
		remove(0, 'z', new char[] { 'z', 'e', 'r', 'o' });
		remove(2, 'w', new char[] { 't', 'w', 'o' });
		remove(4, 'u', new char[] { 'f', 'o', 'u', 'r' });
		remove(6, 'x', new char[] { 's', 'i', 'x' });
		remove(8, 'g', new char[] { 'e', 'i', 'g', 'h', 't' });

		// 把上述都remove掉之后，剩下了：
		// one three five seven nine
		// 其中o时候one的唯一标识,t是three的唯一标识
		// f是five的唯一标识，s是seven的唯一标识
		remove(1, 'o', new char[] { 'o', 'n', 'e' });
		remove(3, 't', new char[] { 't', 'h', 'r', 'e', 'e' });
		remove(5, 'f', new char[] { 'f', 'i', 'v', 'e' });
		remove(7, 's', new char[] { 's', 'e', 'v', 'e', 'n' });

		// 最后只剩下nine了
		int nine_count = map.getOrDefault('i', 0);
		resultInt[9] = nine_count;
		String result = "";
		for (int i = 0; i <= 9; i++) {
			while (resultInt[i] > 0) {
				result += i;
				resultInt[i]--;
			}
		}
		return result;
	}

	public void remove(int digit, char unusualChar, char[] chars) {
		while (map.get(unusualChar) != null) {
			resultInt[digit]++;
			for (int i = 0; i < chars.length; i++) {
				int count = map.get(chars[i]);
				count--;
				if (count == 0) {
					map.remove(chars[i]);
				} else {
					map.put(chars[i], count);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reconstruct_Original_Digits_from_English_423 r = new Reconstruct_Original_Digits_from_English_423();
		System.out.println(r.originalDigits("fviefuro"));
	}

}