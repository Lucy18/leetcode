package leetcode;

public class Assign_Cookies_455 {

	public int findContentChildren(int[] g, int[] s) {
		if(g.length==0||s.length==0){
			return 0;
		}
		quicksort(g, 0, g.length-1);//children
		quicksort(s, 0, s.length-1);//cookies
		int cookiePointer=0;
		for(int chidrenPointer=0;chidrenPointer<g.length;chidrenPointer++){
			int childrenNeed=g[chidrenPointer];
			if(childrenNeed>s[cookiePointer]){
				continue;
			}
			else{
				cookiePointer++;
				if(cookiePointer==s.length){
					break;
				}
			}
		}
		return cookiePointer;
	}
	
	//倒序快排
	public void quicksort(int[] a,int left,int right){
		if(left<right){
			int low=left;
			int high=right;
			int pivot=a[low];
			while(low<high){
				while(low<high&&a[high]<=pivot){
					high--;
				}
				if(low<high){
					a[low]=a[high];
					low++;
				}
				while(low<high&&a[low]>=pivot){
					low++;
				}
				if(low<high){
					a[high]=a[low];
					high--;
				}				
			}
			a[low]=pivot;
			quicksort(a, left, low-1);
			quicksort(a, low+1, right);
		}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assign_Cookies_455 a=new Assign_Cookies_455();
		int[] g=new int[]{1,2,3};
		int[] s=new int[]{3};
		System.out.println(a.findContentChildren(g, s));
	}

}
