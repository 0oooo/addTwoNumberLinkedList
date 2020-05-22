
public class Solution {

    private int carryOver;

    private int getLastDigit(int number){
        String numberAsString = "" + number;
        String lastDigit = numberAsString.substring(numberAsString.length() - 1);
        return Integer.parseInt(lastDigit);
    }

    private int calculateCurrentVal(ListNode l){
        int val;
        if(l.val + carryOver < 10 ){
            val = l.val + carryOver;
            carryOver = 0;
        }else{
            val = getLastDigit(l.val + carryOver);
        }

        return val;
    }

    private int calculateCurrentVal(ListNode l1, ListNode l2, ListNode currentNode){
        int val;
        if(l1.val + l2.val + currentNode.val < 10 ){
            val = l1.val + l2.val +  currentNode.val;
        }else{
            val = getLastDigit(l1.val + l2.val + currentNode.val);
            carryOver = 1;
        }

        return val;
    }

    private ListNode addRestOfList(ListNode l1, ListNode l2){
        ListNode next = new ListNode();

        if (l1.next == null && l2.next != null) {
            next = l2.next;
        }

        if (l2.next == null && l1.next != null){
            next = l1.next;
        }

        return next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode currentNode = new ListNode();

        while(l1 != null && l2 != null){
            carryOver = -1;

            currentNode.val = calculateCurrentVal(l1, l2, currentNode);

            if(head.val == -1){
                head = currentNode;
            }

            if((l1.next != null || l2.next != null) || carryOver > 0) {
                ListNode next = new ListNode();

                if(l1.next == null || l2.next == null){
                    next = addRestOfList(l1, l2);
                    currentNode.next = next;
                    while(carryOver > 0){

                        next.val = calculateCurrentVal(next);

                        if(next.next == null && carryOver > 0){
                            ListNode nextNext = new ListNode(carryOver);
                            carryOver = 0;
                            next.next = nextNext;
                        }
                        next = next.next;
                    }
                } else {
                    if (carryOver > 0) {
                        next.val = next.val + carryOver;
                    }
                    currentNode.next = next;
                    currentNode = next;
                }
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        return head;
    }

    public void printListNode(ListNode listToPrint){
        while(listToPrint != null){
            System.out.print(listToPrint.val);
            listToPrint = listToPrint.next;
        }
    }
}
