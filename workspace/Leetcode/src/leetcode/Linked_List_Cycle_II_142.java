package leetcode;

public class Linked_List_Cycle_II_142 {

	public ListNode detectCycle(ListNode head) {
		if(head==null||head.next==null){
			return null;
		}
		//k=nr
		//s=k-m=nr-m=(n-1)r+(r-m)
		//s=r-m
		boolean hasCycle=false;
		ListNode fast=head;
		ListNode slow=head;
		while(fast!=null&&fast.next!=null&&slow!=null){
			fast=fast.next.next;
			slow=slow.next;
			if(slow==fast){
				hasCycle=true;
				break;
			}
		}
		if(hasCycle==false){
			return null;
		}
		//现在slow和fast都到达meeting点了
		ListNode pointer1=head;
		ListNode pointer2=slow;
		while(pointer1!=pointer2){
			pointer1=pointer1.next;
			pointer2=pointer2.next;
		}
		return pointer1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linked_List_Cycle_II_142 l=new Linked_List_Cycle_II_142();
		ListNode one=new ListNode(1);
		ListNode two=new ListNode(2);
		one.next=two;
		ListNode result=l.detectCycle(one);
		if(result==null){
			System.out.println("null");
		}
		else{
			System.out.println(result.val);
		}		
	}

}
