package suan_fa_ke;

import java.util.Arrays;

/**
 * 写出将自由树转换为以给定顶点为根的有根树的算法伪代码
 * 
 * @author huanghanqian
 *
 *         首先标记一个顶点作为树的根，把该顶点放入队列。接着重复做如下操作，直到队列为空结束：
 *         如果队首元素有未被标记过的相邻顶点，标记该相邻顶点，并且将它作为树中队首元素结点的子结点，并将该顶点放入队列。
 *         如果队首元素没有未被标记过的相邻顶点，则将队首元素出列。
 * 
 */
public class FreeTreeToRootTree {

	void test(int[] a) {		
		int i = 1;
		int length=a.length;
		while (i < length) {
			if (a[i] < 0 && a[i - 1] > 0) {
				int temp = a[i];
				a[i] = a[i - 1];
				a[i - 1] = temp;
				i = 1;
			} else {
				i++;
			}
		}

	}
	
	void test2(int[] a){
		for (int i=0, j=0; i<a.length; i++) {
		    if (a[i] < 0) {
		        int t = a[i];
		        for (int k=i; k>j; k--) {
		            a[k] = a[k-1];
		        }
		        a[j++] = t;
		    }
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1,7,-5,9,-12,15 };
		FreeTreeToRootTree f=new FreeTreeToRootTree();
		f.test2(a);
		System.out.println(Arrays.toString(a));
	}

}
