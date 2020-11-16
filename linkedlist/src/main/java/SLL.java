/**
 * @Author Anjana Shankar
 * @Created 2020-11-16
 */
public class SLL {
    ListNode head;

    ListNode reverseList(ListNode node) {
        if (node == null)
            return node;
        if(node.next == null) {
            this.head = node;
        }
        else {
            ListNode s = reverseList(node.next);
            node.next = null;
            s.next = node;
        }
        return node;
    }

    ListNode createList() {

        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        return node1;
    }

    public static void main(String[] args) {
        SLL sll = new SLL();
        sll.head = sll.createList();
        printList(sll.head);

        sll.reverseList(sll.head);
        printList(sll.head);
    }

    private static void printList(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
