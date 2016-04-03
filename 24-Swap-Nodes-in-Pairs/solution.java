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
         ListNode h = dummy;
         while(h.next != null && h.next.next != null){
             ListNode temp = h;
             h = h.next;
             temp.next = h.next;
             ListNode t = h.next.next;
             h.next.next = h;
             h.next = t;
         }
         return dummy.next;
    }
}