package leetcode;

import java.util.Stack;

public class Reverse_Linked_List_206 {

	public ListNode reverseList(ListNode head) {
		if(head==null){
			return null;
		}
		Stack<ListNode> stack=new Stack<ListNode>();
		while(head!=null){
			stack.push(head);
			head=head.next;
		}
		ListNode resultHead=stack.pop();
		ListNode node=resultHead;
		while(!stack.isEmpty()){
			ListNode nextNode=stack.pop();
			node.next=nextNode;
			node=node.next;
		}
		node.next=null;
		return resultHead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reverse_Linked_List_206 r=new Reverse_Linked_List_206();
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		ListNode result=r.reverseList(head);
		while(result!=null){
			System.out.print(result.val+" ");
			result=result.next;
		}
	}

}
