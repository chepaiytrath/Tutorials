package algorithms;

public class Q0002AddTwoNumbersInLinkedList {
	public static void main(String[] args) {
		/*ListNode a = new ListNode(2);
		ListNode b = new ListNode(4);
		ListNode c = new ListNode(3);
		b.next = c;
		a.next = b;
		
		
		ListNode d = new ListNode(5);
		ListNode e = new ListNode(6);
		ListNode f = new ListNode(4);
		e.next = f;
		d.next = e;
		
		ListNode l = addTwoNumbers(a, d);*/
		
		
		
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(8);
		a.next = b;
		
		ListNode c = new ListNode(0);
		
		ListNode l = addTwoNumbers(a, c);
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode l3 = new ListNode(0);
        ListNode l4 = l3; 
        while(l1 != null || l2 != null){
            int l1val = (l1 == null) ? 0 : l1.val; 
            int l2val = (l2 == null) ? 0 : l2.val;
            int sum = carry + l1val + l2val;
            carry = sum > 9 ? 1 : 0;
            sum = sum % 10;
            while(l4.next != null){
                l4 = l4.next;
            }
            l4.next = new ListNode(sum);
            if(l1 != null) {
            	l1 = l1.next;
            }
            if(l2 != null) {
            	l2 = l2.next;
            }
        }
        return l3.next;
    }
}