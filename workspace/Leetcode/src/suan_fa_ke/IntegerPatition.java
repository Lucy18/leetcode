package suan_fa_ke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * @author huanghanqian
 * 给定n个正整数,把它们划分为各元素的和相同但不相交的子集,
 * 为该问题设计一个穷举查找算法,应尽量减少算法需要生成的子集数量。
 */
public class IntegerPatition {
	
	Map<Integer,List<List<Integer>>> mapList=new HashMap<Integer,List<List<Integer>>>();
	
	public void start(int[] a){
		Arrays.sort(a); //这一步可以不要，这里放在这里是使得打印结果好看一点。。。
		List<Integer> list=new ArrayList<Integer>();
		int[] visited=new int[a.length];
		qiongju(a, list, 0,0,visited);
		collect(a);
	}
	
	//先穷举出所有可能出现的和（即得到数组中元素的所有组合情况，算出每种组合的和）
	public void qiongju(int[] a,List<Integer> list,int index,int currentSum,int[] visited){
		for(int i=index;i<a.length;i++){
			visited[i]=1;
			list.add(a[i]);
			currentSum+=a[i];
			int[] tmp=new int[a.length];
			int k=0;
			for(int j=0;j<a.length;j++){
				if(visited[j]==0){
					tmp[k]=a[j];
					k++;
				}
			}
			if(helper(tmp,k,currentSum,0,0,new int[k])){
				//-----------------
				List<Integer> storeList=new ArrayList<Integer>();
				int theSum=0;
				for(Integer integer:list){
					storeList.add(integer);
					theSum+=integer;
				}
				List<List<Integer>> bigList=mapList.getOrDefault(theSum, new ArrayList<List<Integer>>());
				bigList.add(storeList);
				mapList.put(theSum, bigList);
				//-----------------
				
			}
			qiongju(a, list, i+1, currentSum, visited);
			visited[i]=0;
			list.remove(list.size()-1);
			currentSum-=a[i];
		}
	}
	
	//对于每种可能的和，求出 是否能使用这个和划分数组
	public boolean helper(int[] list,int length,int target,int index,int currentSum,int[] visited){
		boolean result=false;
		for(int i=index;i<length;i++){
			visited[i]=1;
			if(currentSum+list[i]==target){
				boolean isAll1=true;
				for(int j=0;j<length;j++){
					if(visited[j]==0){
						isAll1=false;
					}					
				}
				if(isAll1){
					return true;
				}
				int k=0;
				int[] tmp=new int[length];
				for(int j=0;j<length;j++){
					if(visited[j]==0){
						tmp[k]=list[j];
						k++;
					}
				}
				result=result|helper(tmp, k, target, 0, 0, new int[k]);
			}
			else if(currentSum+list[i]<target){
				currentSum=currentSum+list[i];
				result=result|helper(list, length, target, i+1, currentSum, visited);
				currentSum=currentSum-list[i];
			}
			visited[i]=0;
		}
		return result;
	}
	
	//得到所有被划分的子集，此时要将他们组合到一起
	//如[1,2,3,4,5,6,7]，此时得到的mapList为
	// 1,6
	// 1,2,4,7
	// 1,3,5,6
	// 1,3,4,6
	// 1,6,7
	// 2,3,4,5
	// 2,5
	// .......
	//collect方法则是将 互不相交且并集为整个数组的 放到一行里打印出来
	public void collect(int[] a){
		Set<Integer> hashSet=new HashSet<Integer>();
		for(int i=0;i<a.length;i++){
			hashSet.add(a[i]);
		}
		for(Entry<Integer, List<List<Integer>>> entry:mapList.entrySet()){
			List<List<Integer>> value=entry.getValue();
			helper2(value, new ArrayList<List<Integer>>(), hashSet, 0, new int[value.size()]);
		}
	}
	
	public void helper2(List<List<Integer>> list,List<List<Integer>> chuan,Set<Integer> hashSet,int index,int[] used){
		for(int i=index;i<list.size();i++){
			if(used[i]==1){
				continue;
			}
			List<Integer> the=list.get(i);
			boolean isOK=true;
			for(Integer number:the){
				if(!hashSet.contains(number)){//数字已被用过，已从set中被移除了
					isOK=false;
					break;
				}
			}
			if(isOK==false){
				helper2(list, chuan, hashSet, i+1,used);
			}
			else{
				for(Integer number:the){
					hashSet.remove(Integer.valueOf(number));
				}
				chuan.add(the);
				if(hashSet.isEmpty()){
					for(List<Integer> one:chuan){
						int theIndex=list.indexOf(one);
						used[theIndex]=1;
					}
					print(chuan);
				}
				else{
					helper2(list, chuan, hashSet, i+1,used);
				}
				chuan.remove(chuan.size()-1);
				for(Integer number:the){
					hashSet.add(Integer.valueOf(number));
				}
			}
		}
	}

	public void print(List<List<Integer>> chuan){
		for(List<Integer> the:chuan){
			for(Integer i:the){
				System.out.print(i+" ");
			}
			System.out.print(",    ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerPatition i=new IntegerPatition();
		int[] a=new int[]{3,5,4,6,7,1,2};
//		int[] b=new int[]{1,3,4,5,6,8};
		i.start(a);
	}

}
