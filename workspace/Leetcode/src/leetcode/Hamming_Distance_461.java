package leetcode;

public class Hamming_Distance_461 {

	public int hammingDistance(int x, int y) {
          int xor=x^y;
          int num=0;
          for(int i=0;i<32;i++){
        	  num+= (xor>>i)&1;
          }
          return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hamming_Distance_461 h = new Hamming_Distance_461();
        System.out.println(h.hammingDistance(1,4));
	}

}
