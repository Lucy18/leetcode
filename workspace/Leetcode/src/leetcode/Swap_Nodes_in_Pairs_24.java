package leetcode;

public class Swap_Nodes_in_Pairs_24 {

	public ListNode swapPairs(ListNode head) {
		if(head==null||head.next==null){
			return head;
		}
		ListNode newHead=head.next;
		ListNode node=head;
		while(node!=null&&node.next!=null){
			ListNode tmp=node.next.next;
			node.next.next=node;
			node.next=tmp;
		    if(tmp!=null&&tmp.next!=null){
		    	node.next=tmp.next;
		    }
			node=tmp;
		}
		return newHead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Swap_Nodes_in_Pairs_24 s=new Swap_Nodes_in_Pairs_24();
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(4);
		head.next.next.next.next=new ListNode(5);
		ListNode node=s.swapPairs(head);
		while(node!=null){
			System.out.print(node.val+" ");
			node=node.next;
		}
	}

}
