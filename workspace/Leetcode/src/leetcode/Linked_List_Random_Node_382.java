package leetcode;

import java.util.ArrayList;

public class Linked_List_Random_Node_382 {
	ArrayList<Integer> arrayList=new ArrayList<Integer>();

	/**
	 * @param head
	 *            The linked list's head. Note that the head is guaranteed to be
	 *            not null, so it contains at least one node.
	 */
	public Linked_List_Random_Node_382(ListNode head) {
		while(head!=null){
			arrayList.add(head.val);
			head=head.next;
		}
	}

	/** Returns a random node's value. */
	public int getRandom() {
		int randomIndex=(int)Math.floor(Math.random()*arrayList.size());
		return arrayList.get(randomIndex);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		Linked_List_Random_Node_382 l=new Linked_List_Random_Node_382(head);
		System.out.println(l.getRandom());
	}

}
