package leetcode;

public class Palindrome_Linked_List_234 {

	public boolean isPalindrome(ListNode head) {
		if(head==null){
			return true;
		}
		ListNode middle=getMiddle(head);
		ListNode rightHead=middle.next;
		ListNode rightReverse=reverse(rightHead);
		while(rightReverse!=null){
			if(rightReverse.val!=head.val){
				return false;
			}
			else{
				head=head.next;
				rightReverse=rightReverse.next;
			}
		}
		return true;
	}
	
	public ListNode reverse(ListNode head){
		ListNode rHead=null;		
		ListNode now=head;
		ListNode pre=null;	
		while(now!=null){
			ListNode next=now.next;
			if(next==null){
				rHead=now;
			}
			now.next=pre;
			pre=now;
			now=next;
		}
		return rHead;
	}
	
	public ListNode getMiddle(ListNode head){//1->2->3->4->3->2-1
		ListNode fast=head;
		ListNode slow=head;
		while(fast!=null&&fast.next!=null&&fast.next.next!=null){
			fast=fast.next.next;
			slow=slow.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Palindrome_Linked_List_234 p=new Palindrome_Linked_List_234();
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(3);
		head.next.next.next.next=new ListNode(2);
		head.next.next.next.next.next=new ListNode(1);
		System.out.println(p.isPalindrome(head));
	}

}
