/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        while(fast != null && n >= 0){
            fast = fast.next;
            n--;
        }
        ListNode slow = dummy;
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}