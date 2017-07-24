package leetcode;

public class Odd_Even_Linked_List_328 {

	public ListNode oddEvenList(ListNode head) {
		if(head==null){
			return null;
		}
		if(head.next==null) {
			return head;
		}
		ListNode oddHead=getOddList(head);
		//切掉头元素，之前的偶数列就是 切掉头元素之后的奇数列
		ListNode evenHead=getOddList(head.next);
		
		ListNode oddTail=oddHead;
		while (oddTail.next!=null){
			oddTail=oddTail.next;
		}
		oddTail.next=evenHead;
		return oddHead;		
	}
	
	public ListNode getOddList(ListNode head){	
		ListNode result=new ListNode(head.val);
		ListNode node=result;
		boolean isOdd=false;
		head=head.next;
		while(head!=null){
			if(isOdd){
				node.next=new ListNode(head.val);
				node=node.next;
			}
			isOdd=(isOdd==true)?false:true;
			head=head.next;
		}
		return result;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Odd_Even_Linked_List_328 o=new Odd_Even_Linked_List_328();
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(4);
		head.next.next.next.next=new ListNode(5);
		ListNode result=o.oddEvenList(head);
		while(result!=null){
			System.out.print(result.val+" ");
			result=result.next;
		}
	}

}
