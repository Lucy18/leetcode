package leetcode;

public class Median_of_Two_Sorted_Arrays_4 {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m=nums1.length;
		int n=nums2.length;
		int before_median_count=(m+n)/2;
		int after_median_count=(m+n)/2+1;
		int count=0;
		int i=0;int j=0;
		int before_median=0;int after_median=0;int num=0;
		while(count<after_median_count&&i<m&&j<n){					
			if(nums1[i]<=nums2[j]){
				num=nums1[i];
				i++;
			}
			else{
				num=nums2[j];
				j++;
			}
			count++;
			if(count==before_median_count){
				before_median=num;
			}
		}
		while(count<after_median_count&&i<m){
			num=nums1[i];
			i++;
			count++;
			if(count==before_median_count){
				before_median=num;
			}
		}
		while(count<after_median_count&&j<n){
			num=nums2[j];
			j++;
			count++;
			if(count==before_median_count){
				before_median=num;
			}
		}
		after_median=num;
		if((m+n)%2==1){
			return after_median;
		}
		else{
			return (double)(before_median+after_median)/2;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Median_of_Two_Sorted_Arrays_4 m=new Median_of_Two_Sorted_Arrays_4();
		int[] m1=new int[]{};
		int[] m2=new int[]{2,3};
		System.out.println(m.findMedianSortedArrays(m1, m2));
	}

}
