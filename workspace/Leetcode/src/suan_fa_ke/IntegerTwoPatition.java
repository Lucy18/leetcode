package suan_fa_ke;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author huanghanqian
 * 给定n个正整数,把它们划分为各元素的和相同但不相交的两个子集,（注意是两个啊！！！）
 * 为该问题设计一个穷举查找算法,应尽量减少算法需要生成的子集数量。
 */
public class IntegerTwoPatition {

	/**
	 * 
	 * 计算所有整数的和S。
	 * 如果S是奇数，那么该问题没有解。
	 * 如果S是偶数，那么生成所有的子集，直到碰到一个子集中元素的和为S/2或者没有剩下的子集了。
	 * 需要注意的是只要生成元素个数不超过n/2的子集就好了，避免出现重复的。
	 */
	public void solve(int[] a){
		int sum=0;
		for(int i=0;i<a.length;i++){
			sum+=a[i];
		}
		if(sum%2==1){
			System.out.println("无解");
		}
		else{
			int halfSum=sum/2;
			Set<Integer> hashSet=new HashSet<Integer>();
			for(int i=0;i<a.length/2-1;i++){//避免1，2，3，4中出现1，4和2，3的重复
				if(!hashSet.contains(a[i])){
					List<Integer> list=new ArrayList<Integer>();
					list.add(a[i]);
					helper(hashSet, list, a, i+1, a[i], halfSum);
				}								
			}
		}
		
	}
	
	public void helper(Set<Integer> hashSet,List<Integer> list,int[] a,int index,int currentSum,int target){
		for(int i=index;i<a.length;i++){			
			list.add(a[i]);
			currentSum+=a[i];
			if(currentSum<target){
				helper(hashSet,list,a,i+1,currentSum,target);
			}
			else if(currentSum==target){
				for(Integer integer:list){
					hashSet.add(integer);
					System.out.print(integer+" ");
				}
				System.out.println();
			}
			list.remove(list.size()-1);
			currentSum-=a[i];
		}
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerTwoPatition i=new IntegerTwoPatition();
		int[] a=new int[]{1,2,3,4,5,6,7};
		i.solve(a);
	}

}
