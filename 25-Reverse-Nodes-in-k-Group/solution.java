/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = dummy;
        while(true){
            for(int i = 0; i < k; i++){
                if(tail != null)
                    tail = tail.next;
                else break;
            }
            if(tail == null) break;
            head = pre.next;
            while(pre.next != tail){
                ListNode temp = pre.next;
                pre.next = temp.next;
                temp.next = tail.next;
                tail.next = temp;
            }
            tail = head;
            pre = head;
        }
        return dummy.next;
    }
}