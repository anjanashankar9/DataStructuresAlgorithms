/**
 * @Author Anjana Shankar
 * @Created 2020-11-16
 *
 * Definition for singly-linked list.
 */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) { this.val = val; this.next = null;}

    public ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}
