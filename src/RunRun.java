public class RunRun {

    private static Solution solution;

    public static void main (String[] args){
        solution = new Solution();
//        ListNode l1 = new ListNode(2, 4, 3);
//        ListNode l2 = new ListNode(5, 6, 4);
//        ListNode l1 = new ListNode (5);
//        ListNode l2 = new ListNode (5);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9, new ListNode(9));
//        ListNode l1 = new ListNode(1, new ListNode(8));
//        ListNode l2 = new ListNode(9, 9, 9);
        ListNode result = solution.addTwoNumbers(l1, l2);

        solution.printListNode(result);
    }
}
