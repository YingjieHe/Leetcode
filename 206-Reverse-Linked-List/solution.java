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
        ListNode nhead = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = nhead;
            nhead = head;
            head = temp;
        }
        return nhead;
    }
}