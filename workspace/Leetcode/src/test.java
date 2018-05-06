import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import leetcode.ListNode;
import leetcode.TreeNode;

public class test {

	void doIT() {
		HashSet<Node> set = new HashSet<Node>();
		Node a = new Node();
		a.val = 1;
		set.add(a);
		a.val = 2;
		Iterator<Node> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().val);
		}
	}

	public int minNumberInRotateArray(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		int low = 0;
		int high = array.length - 1;
		while (low < high) {
			if (array[low] < array[high]) {
				return array[low];
			}
			int mid = low + (high - low) / 2;
			if (array[low] <= array[mid]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return array[low];
	}

	public int Fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		int beforebefore = 1;
		int before = 1;
		for (int i = 3; i <= n; i++) {
			int result = beforebefore + before;
			beforebefore = before;
			before = result;
		}
		return before;
	}

	public int JumpFloor(int target) {
		if (target == 1) {
			return 1;
		}
		if (target == 2) {
			return 2;
		}
		int[] dp = new int[target + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= target; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[target];
	}

	public int JumpFloorII(int target) {
		if (target == 1) {
			return 1;
		}
		int[] dp = new int[target + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= target; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] += dp[i - j];
			}
		}
		return dp[target];
	}

	public int RectCover(int target) {
		if (target <= 2) {
			return target;
		}
		int[] dp = new int[target + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= target; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[target];
	}

	public int NumberOf1(int n) {
		int count = 0;
		while (n != 0) {
			n = n & (n - 1);
			count++;
		}
		return count;
	}

	public double Power(double base, int exponent) {
		return Math.pow(base, exponent);
	}

	public void reOrderArray(int[] array) {
		if (array.length == 0 || array.length == 1)
			return;

		int oddCount = 0, oddBegin = 0;
		int[] newArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			if ((array[i] & 1) == 1)
				oddCount++;
		}
		for (int i = 0; i < array.length; i++) {
			if ((array[i] & 1) == 1)
				newArray[oddBegin++] = array[i];
			else
				newArray[oddCount++] = array[i];
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = newArray[i];
		}
	}

	public ListNode FindKthToTail(ListNode head, int k) {
		if (head == null || k <= 0) {
			return null;
		}
		ListNode fast = head;
		for (int i = 1; i < k; i++) {
			if (fast != null) {
				fast = fast.next;
			}
		}
		if (fast == null) {
			return null;
		}
		ListNode low = head;
		while (fast.next != null) {
			low = low.next;
			fast = fast.next;
		}
		return low;
	}

	public ListNode ReverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		ListNode newHead = ReverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}

	public ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		ListNode mergeHead = null;
		if (list1.val < list2.val) {
			mergeHead = list1;
			list1 = list1.next;
		} else {
			mergeHead = list2;
			list2 = list2.next;
		}
		ListNode merge = mergeHead;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				merge.next = list1;
				list1 = list1.next;
			} else {
				merge.next = list2;
				list2 = list2.next;
			}
			merge = merge.next;
		}
		while (list1 != null) {
			merge.next = list1;
			list1 = list1.next;
			merge = merge.next;
		}
		while (list2 != null) {
			merge.next = list2;
			list2 = list2.next;
			merge = merge.next;
		}
		return mergeHead;
	}

	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		boolean result = false;
		// 当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
		if (root2 != null && root1 != null) {
			// 如果找到了对应Tree2的根节点的点
			if (root1.val == root2.val) {
				// 以这个根节点为为起点判断是否包含Tree2
				result = doesTree1HaveTree2(root1, root2);
			}
			// 如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
			if (!result) {
				result = HasSubtree(root1.left, root2);
			}

			// 如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
			if (!result) {
				result = HasSubtree(root1.right, root2);
			}
		}
		// 返回结果
		return result;
	}

	public boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
		// 如果Tree2已经遍历完了都能对应的上，返回true
		if (node2 == null) {
			return true;
		}
		// 如果Tree2还没有遍历完，Tree1却遍历完了。返回false
		if (node1 == null) {
			return false;
		}
		// 如果其中有一个点没有对应上，返回false
		if (node1.val != node2.val) {
			return false;
		}

		// 如果根节点对应的上，那么就分别去子节点里面匹配
		return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
	}

	public void Mirror(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		Mirror(root.left);
		Mirror(root.right);
	}

	/**
	 *  * @description 顺时针打印矩阵  * @author GongchuangSu  * @since 2016.09.03
	 *  * @explain 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵：
	 *  *                    1 2 3 4  *                    5 6 7 8
	 *  *                    9 10 11 12  *                    13 14 15 16
	 *  *          则依次打印出数字  *                   
	 * 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.  
	 */
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		int up = 0;
		int down = matrix.length - 1;
		int left = 0;
		int right = matrix[0].length - 1;
		int count = matrix.length * matrix[0].length;
		while (res.size() < count) {
			if (left <= right && up <= down) {
				for (int i = left; i <= right; i++) {
					res.add(matrix[up][i]);
				}
				up++;
			}
			if (res.size() < count && up <= down && up <= down) {
				for (int i = up; i <= down; i++) {
					res.add(matrix[i][right]);
				}
				right--;
			}
			if (res.size() < count && left <= right && up <= down) {
				for (int i = right; i >= left; i--) {
					res.add(matrix[down][i]);
				}
				down--;
			}
			if (res.size() < count && up <= down && up <= down) {
				for (int i = down; i >= up; i--) {
					res.add(matrix[i][left]);
				}
				left++;
			}
		}
		return res;
	}

	/**
	 * 思路：用一个栈data保存数据，用另外一个栈min保存依次入栈最小的数 比如，data中依次入栈，5,  4,  3, 8, 10, 11,
	 * 12, 1        则min依次入栈，5,  4,  3，no,no, no, no, 1  
	 * 每次入栈的时候，如果入栈的元素比min中的栈顶元素小或等于则入栈，否则不如栈。
	 */
	Stack<Integer> data = new Stack<Integer>();
	Stack<Integer> min = new Stack<Integer>();
	Integer temp = null;

	public void push(int node) {
		if (temp != null) {
			if (node <= temp) {
				temp = node;
				min.push(node);
			}
			data.push(node);
		} else {
			temp = node;
			data.push(node);
			min.push(node);
		}
	}

	public void pop() {
		int num = data.pop();
		int num2 = min.pop();
		if (num != num2) {
			min.push(num2);
		}
	}

	public int top() {
		return data.peek();
	}

	public int min() {
		return min.peek();
	}

	public boolean IsPopOrder(int[] pushA, int[] popA) {
		if (pushA == null || pushA.length == 0 || popA == null || popA.length == 0) {
			return false;
		}
		if (pushA.length == 1 && popA.length == 1) {
			return pushA[0] == popA[0];
		}
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(pushA[0]);
		int i = 1;
		int j = 0;
		while (j < popA.length) {
			if (i == pushA.length) {
				return false;
			}
			while (i < pushA.length && stack.peek() != popA[j]) {
				stack.push(pushA[i]);
				i++;
			}
			stack.pop();
			j++;
			while (!stack.isEmpty() && stack.peek() == popA[j]) {
				stack.pop();
				j++;
			}
		}
		return true;
	}

	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode theNode = queue.poll();
			res.add(theNode.val);
			if (theNode.left != null) {
				queue.offer(theNode.left);
			}
			if (theNode.right != null) {
				queue.offer(theNode.right);
			}
		}
		return res;
	}

	// BST的后序序列的合法序列是，
	// 对于一个序列S，最后一个元素是x （也就是根）
	// 如果去掉最后一个元素的序列为T，那么T满足：
	// T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，
	// 且这两段（子树）都是合法的后序序列。完美的递归定义。
	public boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence == null || sequence.length == 0) {
			return false;
		}
		return helper(sequence, 0, sequence.length - 1);
	}

	public boolean helper(int[] sequence, int low, int high) {
		if (low >= high) {
			return true;
		}
		int pivot = sequence[high];
		int pointer = 0;
		while (pointer < high && sequence[pointer] < pivot) {
			pointer++;
		}
		int line = pointer;
		while (pointer < high && sequence[pointer] > pivot) {
			pointer++;
		}
		if (pointer < high) {
			return false;
		}
		return helper(sequence, low, line - 1) && helper(sequence, line, high - 1);
	}

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return res;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		helper2(res, list, root, 0, target);
		return res;
	}

	public void helper2(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, TreeNode node, int sum,
			int target) {
		sum += node.val;
		list.add(node.val);
		if (node.left == null && node.right == null) {
			if (sum == target) {
				res.add(new ArrayList<Integer>(list));
			}
		} else {
			if (node.left != null) {
				helper2(res, list, node.left, sum, target);
			}
			if (node.right != null) {
				helper2(res, list, node.right, sum, target);
			}
		}
		sum -= node.val;
		list.remove(list.size() - 1);
	}

	public RandomListNode Clone(RandomListNode pHead) {
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		return cloneHelper(pHead, map);
	}

	public RandomListNode cloneHelper(RandomListNode pHead, HashMap<RandomListNode, RandomListNode> map) {
		if (pHead == null) {
			return null;
		}
		if (map.containsKey(pHead)) {
			return map.get(pHead);
		}
		RandomListNode cloneHead = new RandomListNode(pHead.label);
		map.put(pHead, cloneHead);
		cloneHead.next = cloneHelper(pHead.next, map);
		cloneHead.random = cloneHelper(pHead.random, map);
		return cloneHead;
	}

	public TreeNode Convert(TreeNode pRootOfTree) {
		if (pRootOfTree == null) {
			return null;
		}
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		DFS(pRootOfTree, list);
		for (int i = 0; i < list.size() - 1; i++) {
			TreeNode now = list.get(i);
			TreeNode next = list.get(i + 1);
			now.right = next;
			next.left = now;
		}
		return list.get(0);
	}

	public void DFS(TreeNode node, ArrayList<TreeNode> list) {
		if (node != null) {
			DFS(node.left, list);
			list.add(node);
			DFS(node.right, list);
		}
	}

	TreeNode pre = null;

	TreeNode Convert2(TreeNode pRootOfTree) {
		if (pRootOfTree == null)
			return null;
		convertHelper(pRootOfTree);

		TreeNode res = pRootOfTree;
		while (res.left != null)
			res = res.left;
		return res;
	}

	void convertHelper(TreeNode cur) {
		if (cur == null)
			return;

		convertHelper(cur.left);

		cur.left = pre;
		if (pre != null)
			pre.right = cur;
		pre = cur;

		convertHelper(cur.right);
	}

	public ArrayList<String> Permutation(String str) {
		ArrayList<String> res = new ArrayList<String>();
		if (str == null || str.length() == 0) {
			return res;
		}
		char[] cs = str.toCharArray();
		Permutation(res, cs, 0);
		Collections.sort(res);
		return res;
	}

	public void swap(char[] cs, int i, int j) {
		char tmp = cs[i];
		cs[i] = cs[j];
		cs[j] = tmp;
	}

	public void Permutation(ArrayList<String> res, char[] cs, int index) {
		if (index == cs.length) {
			String val = String.valueOf(cs);
			if (!res.contains(val)) {
				res.add(val);
			}
			return;
		}
		for (int i = index; i < cs.length; i++) {
			swap(cs, index, i);
			Permutation(res, cs, index + 1);
			swap(cs, index, i);
		}
	}

	public int MoreThanHalfNum_Solution(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int count = 0;
		int candidate = 0;
		for (int i = 0; i < array.length; i++) {
			if (count == 0) {
				candidate = array[i];
				count = 1;
			} else if (candidate == array[i]) {
				count++;
			} else {
				count--;
			}
		}

		count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == candidate) {
				count++;
			}
		}
		if (count * 2 <= array.length) {
			return 0;
		} else {
			return candidate;
		}
	}

	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (input == null || input.length < k || k == 0) {
			return res;
		}
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);
		for (int i = 0; i < input.length; i++) {
			if (queue.size() < k) {
				queue.offer(input[i]);
			} else {
				if (queue.peek() > input[i]) {
					queue.poll();
					queue.offer(input[i]);
				}
			}
		}
		while (!queue.isEmpty()) {
			res.add(queue.poll());
		}
		return res;
	}

	public int FindGreatestSumOfSubArray(int[] array) {
		if(array==null||array.length==0){
			return 0;
		}
		int max=array[0];
		int beforeSum=array[0];
		for(int i=1;i<array.length;i++){
			if(beforeSum+array[i]>array[i]){
				beforeSum=beforeSum+array[i];
			}
			else{
				beforeSum=array[i];
			}
			if(beforeSum>max){
				max=beforeSum;
			}
		}
		return max;
	}
	
	public String PrintMinNumber(int [] numbers) {
		ArrayList<Integer> list=new ArrayList<Integer>();
		if(numbers==null||numbers.length==0){
			return "";
		}
		for(int i=0;i<numbers.length;i++){
			list.add(numbers[i]);
		}
		Collections.sort(list,new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				String a=o1+""+o2;
				String b=o2+""+o1;
				return a.compareTo(b);
			}
		});
		String res="";
		for(Integer i:list){
			res+=i;
		}
		return res;
    }
	
	

	public static void main(String[] args) {
		test t = new test();
		int[][] arr = new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
				{ 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 } };
		TreeNode n1 = new TreeNode(2);
		n1.left = new TreeNode(1);
		n1.right = new TreeNode(3);
		int[] a = new int[] { 4, 5, 1, 6, 2, 7, 3, 8 };
		ArrayList<Integer> b = t.GetLeastNumbers_Solution(a, 4);
		for (Integer i : b) {
			System.out.println(i);
		}
		int[] array=new int[]{3,32,321};	
		System.out.println(t.PrintMinNumber(array));
	}

	class Node {
		int val;
	}
}
