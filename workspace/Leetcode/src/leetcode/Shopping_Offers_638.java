package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Shopping_Offers_638 {

	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		HashMap<List<Integer>, Integer> map=new HashMap<List<Integer>, Integer>();
		return helper(price, special, needs, needs.size(), map);
	}

	public int helper(List<Integer> price, List<List<Integer>> special, 
			List<Integer> needs,int n,HashMap<List<Integer>, Integer> map){
		if(map.get(needs)!=null){
			return map.get(needs);
		}
		int minPrice=0;
		//下面是完全不用套餐的情况
		for(int i=0;i<n;i++){
			minPrice+=(needs.get(i)*price.get(i));
		}
		//下面是用套餐的情况
		for(List<Integer> taocan:special){
			boolean canUseThisTaocan=true;
			int thisPrice=0;
			for(int i=0;i<n;i++){
				if(needs.get(i)<taocan.get(i)){//套餐里的内容超过我需要的数目了
					canUseThisTaocan=false;
					break;
				}
			}
			if(canUseThisTaocan){
				List<Integer> needClone=new ArrayList<>(needs);
				for(int i=0;i<n;i++){
					needClone.set(i, needClone.get(i)-taocan.get(i));
				}
				thisPrice=taocan.get(n)+helper(price, special, needClone, n, map);
				if(thisPrice<minPrice){
					minPrice=thisPrice;
				}
			}
		}
		map.put(needs, minPrice);
		return minPrice;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shopping_Offers_638 s=new Shopping_Offers_638();
		List<Integer> price=new ArrayList<Integer>();
		price.add(2);price.add(3);price.add(4);
		List<List<Integer>> special=new ArrayList<List<Integer>>();
		List<Integer> sp1=new ArrayList<Integer>();
		sp1.add(1);sp1.add(1);sp1.add(0);sp1.add(4);
		List<Integer> sp2=new ArrayList<Integer>();
		sp2.add(2);sp2.add(2);sp2.add(1);sp2.add(9);
		special.add(sp1);special.add(sp2);
		List<Integer> needs=new ArrayList<Integer>();
		needs.add(1);needs.add(2);needs.add(1);
		System.out.println(s.shoppingOffers(price, special, needs));
	}

}
