public class LinkedListRandomPoniter {

	public static void main(String[] args) {
		LLNode head= new LLNode(2);
		head.next= new LLNode(10);
		head.next.next=new LLNode(13);
		head.next.next.next=new LLNode(14);
		
		head.random=head.next;
		head.next.random=head;
		head.next.next.random=head.next.next;
		head.next.next.next.random=head.next;
		LLNode newHead=reverse1(head);
		while(newHead!=null) {
			System.out.print(newHead.data+"\t");
		}
	}
	
	public static LLNode clone(LLNode head) {
		if(head==null) return null;
		LLNode prev=new LLNode(head.data);
		LLNode newHead=prev;
		LLNode curr=null;
		head=head.next;
		while(head!=null){
			curr=new LLNode(head.data);
			prev.next=curr;
			prev=curr;
			head=head.next;
		}
		return newHead;
	}
	
	
	public static LLNode clone1(LLNode head) {
		if(head==null)
			return null;
		LLNode prev=null;
		LLNode newHead=null;
		LLNode curr=new LLNode(head.data);
		head=head.next;
		while(head!=null){
			curr.next=new LLNode(head.data);
			prev=curr;
			curr=curr.next;
			head=head.next;
		}
		return newHead;
	}
	
	public static LLNode reverse(LLNode head) {
		if(head==null)
			return null;
		LLNode prev=null;
		LLNode curr=head;
		LLNode next1=curr.next;
		while(curr!=null) {
			curr.next=prev;
			prev=curr;
			curr=next1;
			next1=next1.next;
			
		}
		return prev;
	}
	
	
	public static LLNode reverse1(LLNode head) {
		if(head==null)
			return null;
		LLNode prev=null;
		LLNode curr=head;
		while(head!=null) {
			head=head.next;
			curr.next=prev;
			prev=curr;
			curr=head;
		}
		return prev;
	}
	
}


class LLNode{
	int data;
	LLNode next;
	LLNode random;
	LLNode(int data){
		this.data=data;
	}
	
}
