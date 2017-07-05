package leetcode;

public class Integer_Break_343 {

	public int integerBreak(int n) {
		int left=n/2;
		int product=left*(n-left);
		while(left>2){
			left--;
			int pow=n/left;
			int yu=n%left;
			int thisProduct1=(int)Math.pow(left, pow-1)*(yu+left);
			int thisProduct2=(int)Math.pow(left, pow)*yu;
			int thisMaxProduct=thisProduct1>thisProduct2?thisProduct1:thisProduct2;
			if(thisMaxProduct>=product){
				product=thisMaxProduct;
			}
			else{
				break;
			}
		}
		return product;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer_Break_343 i=new Integer_Break_343();
		System.out.println(i.integerBreak(10));
	}

}
