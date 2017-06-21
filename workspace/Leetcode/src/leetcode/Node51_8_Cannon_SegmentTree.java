package leetcode;

import java.io.PrintWriter;
import java.util.Scanner;

public class Node51_8_Cannon_SegmentTree {

	public int[] solve(int m,int n,int[] A,int[] B){
		SegmentTreeNode[] tree=new SegmentTreeNode[200000];//index为0空着
		createTree(tree, A, 1, 1, m);
		for(int i=0;i<n;i++){
			int paodan=B[i];
			int mostHigh=tree[1].val;
			if(paodan<=A[1]||paodan>mostHigh){//炮弹被地形1挡下来，或者炮弹飞过全部地形，continue
				continue;
			}
			else{
				int updateIndex=queryTree(tree, 1, paodan)-1;//从1开始往下搜索，-1是因为要得到前一个地形
				A[updateIndex]++;
				updateTree(tree, A, 1, updateIndex);//从1开始往下搜索
			}
		}
		return A;
	}
	
	public void createTree(SegmentTreeNode[] tree,int[] A,int index,int left,int right){
		tree[index]=new SegmentTreeNode(left, right);
		if(left==right){
			tree[index].val=A[left];
			return;
		}
		int middle=(left+right)/2;
		createTree(tree, A, index*2, left, middle);
		createTree(tree, A, index*2+1, middle+1, right);
		tree[index].val=Math.max(tree[index*2].val, tree[index*2+1].val);
	}
	
	public int queryTree(SegmentTreeNode[] tree,int index,int paodan){//找到第一个大于等于paodan的数在A中的index
		if(tree[index].left==tree[index].right){
			return tree[index].left;
		}
		else{
			if(tree[index*2].val>=paodan){
				return queryTree(tree, index*2, paodan);//因为炮弹从左边飞来，所以当左子树大于时，优先考虑左子树
			}
			else{
				return queryTree(tree, index*2+1, paodan);
			}
		}
	}
	
	public void updateTree(SegmentTreeNode[] tree,int[] A,int index,int APointer){
		if(tree[index].left==tree[index].right){
			tree[index].val=A[APointer];
			return;
		}
		int middle=(tree[index].left+tree[index].right)/2;
		if(middle>=APointer){//左子树的范围包括APointer
			updateTree(tree, A, index*2, APointer);
		}
		else{
			updateTree(tree, A, index*2+1, APointer);
		}
		tree[index].val=Math.max(tree[index*2].val, tree[index*2+1].val);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int m = in.nextInt();//地形个数
		int n = in.nextInt();//炮弹个数
		int[] A=new int[m+1];//从左到右的地形高度,index为0空着
		int[] B=new int[n];//炮弹高度
		for(int i=1;i<=m;i++){
			A[i]=in.nextInt();
		}
		for(int i=0;i<n;i++){
			B[i]=in.nextInt();

		}
		in.close();
		Node51_8_Cannon_SegmentTree node = new Node51_8_Cannon_SegmentTree();
		int[] result = node.solve(m, n, A,B);
		for(int i=1;i<=m;i++){
			out.println(result[i]);
		}	
		out.flush();
	}
	
	class SegmentTreeNode{
		int left;//这个线段点的左边界限
		int right;//这个线段点的右边界限
		int val;
		public SegmentTreeNode(int left,int right){
			this.left=left;
			this.right=right;
		}
		public SegmentTreeNode(int val,int left,int right){
			this.val=val;
			this.left=left;
			this.right=right;
		}
	}

}
