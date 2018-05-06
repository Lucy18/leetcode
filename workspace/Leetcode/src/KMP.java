import java.util.ArrayList;
import java.util.List;

public class KMP {

	/**
     * 暴力匹配算法
     *
     * @param sStr 父串
     * @param dStr 子串
     * @return 子串在父串中下标index[int]
     */
    public int violentMatch(String sStr, String dStr) {
        int sLength = sStr.length();
        int dLength = dStr.length();
        int sIndex = 0, dIndex = 0;

        while (sIndex < sLength && dIndex < dLength) {
            //当前字符匹配
            if (sStr.charAt(sIndex) == dStr.charAt(dIndex)) {
                //父串和子串同时后移一个字符
                sIndex++;
                dIndex++;
            } else {//不匹配则sIndex回溯，dIndex被置为0
                sIndex = sIndex - (dIndex - 1);
                dIndex = 0;
            }
        }
        if (dIndex == dLength) {
            return sIndex - dLength;
        }
        return -1;
    }
    
    /**
     * KMP匹配算法
     *
     * @param sStr 父串
     * @param dStr 子串
     * @return 子串在父串中下标index[int]
     */
    public int KMPMatch(String sStr, String dStr) {
        int sLength = sStr.length();
        int dLength = dStr.length();
        int sIndex = 0, dIndex = 0;
        int[] next = getNextArray(dStr);
        while (sIndex < sLength && dIndex < dLength) {
            //当前字符匹配
            if (dIndex==-1||sStr.charAt(sIndex) == dStr.charAt(dIndex)) {
                //父串和子串同时后移一个字符
                sIndex++;
                dIndex++;
            } else {//不匹配 sIndex不变dIndex取next[j]
                dIndex = next[dIndex];
            }
        }
        if (dIndex == dLength) {
            return sIndex - dLength;
        }
        return -1;
    }
    
    /**
     * 获取next数组
     *
     * @param destStr 目的字符串
     * @return next数组 代表当前字符之前的字符串中，有多大长度的相同前缀后缀。
     */
    public int[] getNextArray(String destStr) {
        int[] nextArr = new int[destStr.length()];
        nextArr[0] = -1;
        int k = -1, j = 0;
        while (j < destStr.length() - 1) {
            if (k == -1 || (destStr.charAt(j) == destStr.charAt(k))) {
                ++k;
                ++j;
                nextArr[j] = k;
            } else {
                k = nextArr[k];
            }
        }
        return nextArr;
    }
    
    public List<Integer> getMatchIndexes(String s,String d){
    	List<Integer> list=new ArrayList<Integer>();
    	int index=KMPMatch(s, d);
    	int addLen=0;
    	while(index!=-1){
    		list.add(index+addLen);
    		s=s.substring(index+d.length());
    		addLen+=index+d.length();
    		index=KMPMatch(s, d);
    	}
    	return list;
    }
    
    public List<Integer> getMatchIndexes2(String s,String d){
    	List<Integer> list=new ArrayList<Integer>();
    	int index=violentMatch(s, d);
    	int addLen=0;
    	while(index!=-1){
    		list.add(index+addLen);
    		s=s.substring(index+d.length());
    		addLen+=index+d.length();
    		index=KMPMatch(s, d);
    	}
    	return list;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KMP k=new KMP();
		List<Integer> indexes=k.getMatchIndexes("BBC ABCDAB ABCDABCDABDEABCDABD", "ABCDABD");
		for(Integer i:indexes){
			System.out.println(i);
		}
	}

}
