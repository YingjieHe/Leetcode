/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        int size = 0;
        ListNode p = head;
        node = head;
        
        while(p != null) {
            p = p.next;
            size++;
        }
        
        return buildTree(0, size - 1);
    }
    
    private TreeNode buildTree(int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start) / 2;
        
        TreeNode left = buildTree(start, mid - 1);
        TreeNode root = new TreeNode(node.val);
        root.left = left;
        node = node.next;
        TreeNode right = buildTree(mid + 1, end);
        root.right = right;
        return root;
    }
}