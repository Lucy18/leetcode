package suan_fa_ke;

import java.util.LinkedList;
import java.util.Queue;

public class PrintBinaryTree {

	boolean IsAllElementsNull(Queue<Node> queue) {
		for (Node node : queue) {
			if (null != node)
				return false;
		}
		return true;
	}

	public int GetDepth(Node root) {
		if (root == null)
			return 0;

		int depth1 = GetDepth(root.right);
		int depth2 = GetDepth(root.left);
		if (depth1 > depth2)
			return depth1 + 1;
		else
			return depth2 + 1;
	}

	public void PrintSpaces(int num) {
		for (int i = 0; i < num; ++i)
			System.out.print(" ");
	}

	public void PrintNumPre(int curLevel, int maxLevel) {
		int pow = maxLevel - curLevel - 1;
		if (pow >= 0) {
			int num = 3 * (int) Math.pow(2, pow);
			PrintSpaces(num);
		} else
			PrintSpaces(1);
	}

	public void PrintSymbolPre(int curLevel, int maxLevel) {
		int pow = maxLevel - curLevel - 2;
		if (pow >= 0) {
			int num = 3 * (int) Math.pow(2, pow);
			PrintSpaces(num + 1);
		} else
			PrintSpaces(2);
	}

	public void PrintNumLR(int curLevel, int maxLevel) {
		int pow = maxLevel - curLevel;
		int num = 3;
		if (pow > 0) {
			num = 3 * (int) Math.pow(2, pow) - 1;
		}
		PrintSpaces(num);
	}

	public void PrintNumRL(int curLevel, int maxLevel) {
		int pow = maxLevel - curLevel;
		int num = 1;
		if (pow > 0) {
			num = 3 * (int) Math.pow(2, pow) - 1;
		}
		PrintSpaces(num);
	}

	public void PrintSymbolLR(int curLevel, int maxLevel) {
		int pow = maxLevel - curLevel - 1;
		int num = 3;
		if (pow > 0) {
			num = 3 * (int) Math.pow(2, pow) - 1;
		}
		num = num - 2;
		PrintSpaces(num);
	}

	public void PrintSymbolRL(int curLevel, int maxLevel) {
		int pow = maxLevel - curLevel - 1;
		int num = 1;
		if (pow > 0) {
			num = 3 * (int) Math.pow(2, pow) - 1;
		}
		num = num + 2;
		PrintSpaces(num);
	}

	public void PrintLeft() {
		System.out.print("/");
	}

	public void PrintRight() {
		System.out.print("\\");
	}

	public void PrintQueue(Queue<Node> queueR, Queue<Node> queueW, int level, int maxLevel) {
		if (queueR.size() == 0 || IsAllElementsNull(queueR))
			return;
		level++;
		Node curNode;
		int index = 0;
		PrintNumPre(level, maxLevel);
		Queue<Node> queueT = new LinkedList<Node>();
		while (queueR.size() > 0) {
			curNode = queueR.poll();
			queueT.offer(curNode);
			++index;

			if (null != curNode) {
				queueW.offer(curNode.left);
				queueW.offer(curNode.right);
			} else {
				queueW.offer(null);
				queueW.offer(null);
			}

			if (null != curNode) {
				System.out.print(curNode.data);
			} else {
				System.out.print("n");
			}
			if (index % 2 == 0) {
				PrintNumRL(level, maxLevel);
			} else {
				PrintNumLR(level, maxLevel);
			}
		}

		if (!IsAllElementsNull(queueW)) {
			System.out.print("\n");
			PrintSymbolPre(level, maxLevel);
			while (queueT.size() > 0) {
				curNode = queueT.poll();
				PrintLeft();
				PrintSymbolLR(level, maxLevel);
				PrintRight();
				PrintSymbolRL(level, maxLevel);

			}
		}

		System.out.print("\n");
		PrintQueue(queueW, queueR, level, maxLevel);
	}

	public void Print(Node root) {
		if (null == root)
			return;

		Queue<Node> queue1 = new LinkedList<Node>();
		Queue<Node> queue2 = new LinkedList<Node>();

		int maxLevel = GetDepth(root);
		queue1.offer(root);
		PrintQueue(queue1, queue2, 0, maxLevel);
	}

	public static void main(String[] args) {

		PrintBinaryTree p = new PrintBinaryTree();

		Node root1 = new Node();
		root1.data = 1;
		root1.left = new Node();
		root1.left.data = 2;
		root1.right = new Node();
		root1.right.data = 3;

		root1.left.left = new Node();
		root1.left.left.data = 4;
		root1.left.right = new Node();
		root1.left.right.data = 5;

		root1.right.left = new Node();
		root1.right.left.data = 6;
		root1.right.right = new Node();
		root1.right.right.data = 7;

		root1.left.left.left = new Node();
		root1.left.left.left.data = 8;

		root1.right.right.right = new Node();
		root1.right.right.right.data = 9;

		p.Print(root1);

		Node root2 = new Node();
		root2.data = 1;
		root2.right = new Node();
		root2.right.data = 2;
		root2.right.right = new Node();
		root2.right.right.data = 3;
		root2.right.right.right = new Node();
		root2.right.right.right.data = 4;
		root2.right.right.right.right = new Node();
		root2.right.right.right.right.data = 5;
		System.out.println();
		p.Print(root2);

	}

	static class Node {
		int data;
		Node left;
		Node right;
	}

}
