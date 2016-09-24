/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int sum = 0;
        while(l1 != null || l2 != null || sum != 0) {
            if(l1 != null) sum += l1.val;
            if(l2 != null) sum += l2.val;
            ListNode cur = new ListNode(sum % 10);
            head.next = cur;
            sum /= 10;
            head = head.next;
            l1 = l1 == null? l1 : l1.next;
            l2 = l2 == null? l2 : l2.next;
        }
        return dummy.next;
    }
}