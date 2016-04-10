/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while(p.next != null && p.next.next != null){
            ListNode first = p.next;
            ListNode second = first.next;
            first.next = second.next;
            p.next = second;
            second.next = first;
            p = p.next.next;
        }
        return dummy.next;
    }
}