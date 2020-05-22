
/**
 * Definition for singly-linked list.
 *  */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    ListNode(int val1, int val2, int val3){
        this.val = val1;
        ListNode lastNum = new ListNode(val3);
        this.next = new ListNode(val2, lastNum);
    }
}