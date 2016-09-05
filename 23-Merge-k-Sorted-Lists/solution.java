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
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        
        for(ListNode n : lists) {
            if(n != null) {
                q.offer(n);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(!q.isEmpty()) {
            ListNode temp = q.poll();
            head.next = temp;
            if(temp.next != null) q.offer(temp.next);
            head = head.next;
        }
        return dummy.next;
    }
}