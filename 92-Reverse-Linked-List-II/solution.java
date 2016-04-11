/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        for(int i = 0; i < m - 1; i++) p = p.next;
        ListNode start = p.next;
        ListNode end = start.next;
        for(int i = 0; i < n - m; i++){
            start.next = end.next;
            end.next = p.next;
            p.next = end;
            end = start.next;
        }
        return dummy.next;
    }
}