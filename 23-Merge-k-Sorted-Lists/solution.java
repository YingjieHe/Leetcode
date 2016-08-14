/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for(ListNode node : lists) {
            if(node != null) {
                q.offer(node);
            }
        }
        while(!q.isEmpty()) {
            head.next = q.poll();
            head = head.next;
            if(head.next != null) {
                q.offer(head.next);
            }
        }
        return dummy.next;
    }
}