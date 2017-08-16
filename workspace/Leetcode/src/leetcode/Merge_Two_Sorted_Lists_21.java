package leetcode;

public class Merge_Two_Sorted_Lists_21 {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null){
			return l2;
		}
		if(l2==null){
			return l1;
		}
		ListNode head;
		if(l1.val<l2.val){
			head=splice(l1, l2);
		}
		else{
			head=splice(l2, l1);
		}
		return head;
	}
	
	//其中 l1 head.val<l2 head.val，保证是 把头大的list 绞接到 头小的list里
	public ListNode splice(ListNode l1,ListNode l2){
		ListNode head=l1;
		while(l1.next!=null&&l2!=null){
			if(l1.next.val<=l2.val){
				l1=l1.next;
			}
			else{ //把l2插到l1.next		
				ListNode tmp=l1.next;
				l1.next=l2;
				l2=l2.next;
				l1.next.next=tmp;
				l1=l1.next;
			}
		}
		if(l2!=null){
			l1.next=l2;
			l1=l1.next;
			l2=l2.next;
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Merge_Two_Sorted_Lists_21 m=new Merge_Two_Sorted_Lists_21();
		ListNode l1=new ListNode(1);
		l1.next=new ListNode(2);
		l1.next.next=new ListNode(3);
		ListNode l2=new ListNode(8);
		l2.next=new ListNode(10);
		ListNode head=m.mergeTwoLists(l1, l2);
		while(head!=null){
			System.out.print(head.val+" ");
			head=head.next;
		}
	}

}
