package leetcode;

import java.util.Stack;

public class Add_Two_Numbers_II_445 {

	Stack<Integer> stack=new Stack<Integer>();
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int length1=0;
		ListNode head1=l1;
		ListNode head2=l2;
		while(l1!=null){
			length1++;
			l1=l1.next;
		}
		int length2=0;
		while(l2!=null){
			length2++;
			l2=l2.next;
		}
		ListNode pointer1=head1;
		ListNode pointer2=head2;
		if(length1>length2){
			pointer1=head1;
			pointer2=new ListNode(0);
			int m=length1-length2;
			ListNode node=pointer2;
			while(m>1){ //因为已经填了一个开头的0
				node.next=new ListNode(0);
				node=node.next;
				m--;
			}
			node.next=head2;
		}
		if(length2>length1){
			pointer1=new ListNode(0);
			pointer2=head2;
			int m=length2-length1;
			ListNode node=pointer1;
			while(m>1){
				node.next=new ListNode(0);
				node=node.next;
				m--;
			}
			node.next=head1;
		}
		int add=DFS(pointer1,pointer2);
		ListNode head;
		if(add==1){
			head=new ListNode(1);
		}
		else{
			head=new ListNode(stack.pop());
		}
		ListNode node=head;
		while(!stack.isEmpty()){
			node.next=new ListNode(stack.pop());
			node=node.next;
		}
		return head;
	}
	
	public int DFS(ListNode pointer1,ListNode pointer2){
		if(pointer1==null&&pointer2==null){
			return 0;
		}
		int add=DFS(pointer1.next,pointer2.next);
		int sum=pointer1.val+pointer2.val+add;
		if(sum>=10){
			sum=sum-10;
			add=1;
		}
		else{
			add=0;
		}
		stack.push(sum);
		return add;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Add_Two_Numbers_II_445 a=new Add_Two_Numbers_II_445();
		ListNode l1=new ListNode(5);
		ListNode l2=new ListNode(5);
		ListNode result=a.addTwoNumbers(l1, l2);
		while(result!=null){
			System.out.print(result.val+" ");
			result=result.next;
		}
	}

}
