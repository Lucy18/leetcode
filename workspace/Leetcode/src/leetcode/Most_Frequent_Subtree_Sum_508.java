package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Most_Frequent_Subtree_Sum_508 {

	void getSum(TreeNode root){
		if(root==null){
			return;
		}
		if(root.left!=null){
			getSum(root.left);
			root.val+=root.left.val;
		}
		if(root.right!=null){
			getSum(root.right);
			root.val+=root.right.val;
		}
	}
	
	void setNumber(Map<Integer,Integer> map,TreeNode root){
		if(root==null){
			return;
		}
		if(map.get(root.val)==null){
			map.put(root.val, 1);
		}
		else{
			int num=map.get(root.val);
			map.put(root.val, num+1);
		}
		setNumber(map, root.left);
		setNumber(map, root.right);
	}
	
	public int[] findFrequentTreeSum(TreeNode root) {
		if(root==null){
			return new int[]{};
		}
		getSum(root);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		setNumber(map, root);
		List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
            //降序排序
            public int compare(Entry<Integer, Integer> o1,
                    Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
            
        });
		int max=list.get(0).getValue();
		int numOfMax=1;
		for(int i=1;i<list.size();i++){
            int num=list.get(i).getValue();
            if(num==max){
            	numOfMax++;
            }
            else{
            	break;
            }
        }
		int[] result=new int[numOfMax];
		for(int i=0;i<numOfMax;i++){
			result[i]=list.get(i).getKey();
		}
		return result;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Most_Frequent_Subtree_Sum_508 m=new Most_Frequent_Subtree_Sum_508();
		TreeNode root=new TreeNode(5);
		root.left=new TreeNode(2);
		root.right=new TreeNode(-5);
		int[] result=m.findFrequentTreeSum(root);
		for(int i=0;i<result.length;i++){
			System.err.print(result[i]+" ");
		}
	}

}
