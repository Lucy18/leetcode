package leetcode;

public class Number_of_1_Bits_191 {

	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	int count=0;
        for(int i=0;i<32;i++){
        	if((n>>i & 1)==1){
        		count++;
        	}
        }
        return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Number_of_1_Bits_191 n=new Number_of_1_Bits_191();
		System.out.println(n.hammingWeight(11));
	}

}
