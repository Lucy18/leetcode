package leetcode;

public class Remove_Duplicates_from_Sorted_List_83 {

	public ListNode deleteDuplicates(ListNode head) {
		if(head==null){
			return head;
		}
		int current=head.val;
		ListNode node=head;
		while(node.next!=null){
			while(node.next!=null&&node.next.val==current){
				node.next=node.next.next;			
			}
			if(node.next!=null){
				node=node.next;
				current=node.val;
			}
		}
		return head;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Remove_Duplicates_from_Sorted_List_83 r=new Remove_Duplicates_from_Sorted_List_83();
		ListNode head=new ListNode(1);
		head.next=new ListNode(1);
		head.next.next=new ListNode(2);
		head.next.next.next=new ListNode(3);
		head.next.next.next.next=new ListNode(3);
		ListNode node=r.deleteDuplicates(head);
		while(node!=null){
			System.out.print(node.val+" ");
			node=node.next;
		}
	}

}
