/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = dummy;
            dummy = head;
            head = temp;
        }
        return dummy;
    }
}