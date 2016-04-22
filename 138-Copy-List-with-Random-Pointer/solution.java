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
        RandomListNode temp = head, next;
        while(temp != null){
            next = temp.next;
            RandomListNode copy = new RandomListNode(temp.label);
            temp.next = copy;
            copy.next = next;
            temp = next;
        }
        temp = head;
        while(temp != null){
            if(temp.random != null)
                temp.next.random = temp.random.next;
            temp = temp.next.next;
        }
        temp = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode copy = dummy;
        while(temp != null){
            next = temp.next.next;
            copy.next = temp.next;
            copy = copy.next;
            temp.next = next;
            temp = next;
        }
        return dummy.next;
    }
}