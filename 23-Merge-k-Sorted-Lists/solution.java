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
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        if(lists == null || lists.length == 0) return dummy.next;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode o1, ListNode o2){
                return o1.val - o2.val;
            }
        });
        for(ListNode i : lists){
            if(i != null)
                q.add(i);
        }
        while(!q.isEmpty()){
            head.next = q.poll();
            head = head.next;
            if(head.next != null){
                q.add(head.next);
            }
        }
        return dummy.next;
    }
}