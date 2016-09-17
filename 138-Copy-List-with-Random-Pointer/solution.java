/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode copy, next;
        RandomListNode node = head;
        while(node != null) {
            next = node.next;
            copy = new RandomListNode(node.label);
            node.next = copy;
            copy.next = next;
            node = next;
        }
        node = head;
        while(node != null) {
            if(node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        node = head;
        RandomListNode dummy = new RandomListNode(0);
        copy = dummy;
        while(node != null) {
            next = node.next.next;
            copy.next = node.next;
            node.next = next;
            node = node.next;
            copy = copy.next;
        }
        return dummy.next;
    }
}