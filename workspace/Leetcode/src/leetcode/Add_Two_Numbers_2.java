package leetcode;

public class Add_Two_Numbers_2 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result=null;
		ListNode before=null;
		int add=0;
		while(l1!=null&&l2!=null){
			int sum=l1.val+l2.val+add;
			int val=sum%10;
			add=sum/10;
			if(result==null){
				result=new ListNode(val);
				before=result;
			}
			else{
				before.next=new ListNode(val);
				before=before.next;
			}
			l1=l1.next;
			l2=l2.next;
		}
		while(l1!=null){
			int sum=l1.val+add;
			int val=sum%10;
			add=sum/10;
			if(result==null){
				result=new ListNode(val);
				before=result;
			}
			else{
				before.next=new ListNode(val);
				before=before.next;
			}
			l1=l1.next;
		}
		while(l2!=null){
			int sum=l2.val+add;
			int val=sum%10;
			add=sum/10;
			if(result==null){
				result=new ListNode(val);
				before=result;
			}
			else{
				before.next=new ListNode(val);
				before=before.next;
			}
			l2=l2.next;
		}
		if(add!=0){
			before.next=new ListNode(add);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Add_Two_Numbers_2 a=new Add_Two_Numbers_2();
		ListNode l1=new ListNode(2);
		l1.next=new ListNode(4);
		l1.next.next=new ListNode(3);
		ListNode l2=new ListNode(5);
		l2.next=new ListNode(6);
		l2.next.next=new ListNode(4);
		ListNode result=a.addTwoNumbers(l1, l2);
		while(result!=null){
			System.out.println(result.val);
			result=result.next;
		}
		
	}

}
