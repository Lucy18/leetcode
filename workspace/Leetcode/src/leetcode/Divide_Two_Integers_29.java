package leetcode;

public class Divide_Two_Integers_29 {

	public int divide(int dividend, int divisor) {
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}
		int result = 0;
		boolean isNegative = false;
		if (dividend == -2147483648) {
			if(divisor==1){
				return dividend;
			}
			dividend = 2147483647;
			if (divisor > 0) {
				isNegative = true;
			} else {
				if (divisor == -2147483648) {
					return 1;
				} else {
					divisor = ~divisor + 1;
				}
			}
		} else if (divisor == -2147483648) {
			return 0;
		} else {
			if (dividend < 0 && divisor > 0) {
				isNegative = true;
				dividend = ~dividend + 1;
			} else if (dividend > 0 && divisor < 0) {
				isNegative = true;
				divisor = ~divisor + 1;
			} else if (dividend < 0 && divisor < 0) {
				dividend = ~dividend + 1;
				divisor = ~divisor + 1;
			}
		}
		if (divisor == 1) {
			result = dividend;
		} else {
			while (dividend >= divisor) {
				dividend = dividend - divisor;
				result++;
			}
		}
		if (isNegative) {
			result = ~result + 1;
		}
		return result;
	}
	
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        int len=pre.length;
        return helper(pre,0,len-1,in,0,len-1);
    }
    
    public TreeNode helper(int [] pre,int pLow,int pHigh,int [] in,int iLow,int iHigh){
    	if(pLow>pHigh){
    		return null;
    	}
    	if(pLow==pHigh){
            return new TreeNode(pre[pLow]);
        }
        else{
            TreeNode root=new TreeNode(pre[pLow]);
            int i=iLow;
            for(;i<=iHigh;i++){
                if(in[i]==pre[pLow]){
                    break;
                }
            }
            int len=i-iLow;
            root.left=helper(pre,pLow+1,pLow+len,in,iLow,i-1);
            root.right=helper(pre,pLow+len+1,pHigh,in,i+1,iHigh);        
            return root;
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Divide_Two_Integers_29 d = new Divide_Two_Integers_29();
//		System.out.println(d.divide(-3, 2));// 应该返回-1
//		System.out.println(d.divide(3, -2));// 应该返回-1
//		System.out.println(d.divide(-1, -1));
//		System.out.println(d.divide(-2147483648, -1));
//		System.out.println(d.divide(-2147483648, 1));
//		System.out.println(d.divide(-2147483648, 2));
//		int[] pre=new int[]{1,2,4,7,3,5,6,8};
//		int[] in=new int[]{4,7,2,1,5,3,8,6};
//		TreeNode root=d.reConstructBinaryTree(pre, in);
//		System.out.println(1);
	}

}
