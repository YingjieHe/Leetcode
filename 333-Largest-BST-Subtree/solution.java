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
    public int largestBSTSubtree(TreeNode root) {
    int[] res = recursive(root);
    return res[2];
}
    public int[] recursive(TreeNode root){
      int[] res = new int[5];
      res[0] = 1; res[3] = Integer.MAX_VALUE; res[4] = Integer.MIN_VALUE;
      if (root == null) return res;
      int[] resL = recursive(root.left);
      int[] resR = recursive(root.right);
      if (resL[0] == 0 || resR[0] == 0 || resL[4] > root.val || root.val > resR[3])
      res[0] = 0;
      res[1] = resL[1] + resR[1] + 1;
      res[2] = (res[0] > 0) ? res[1] : (Math.max(resL[2], resR[2]));
      res[3] = Math.min(root.val, Math.min(resL[3], resR[3]));
      res[4] = Math.max(root.val, Math.max(resL[4], resR[4]));
      return res;
    }
}


// Similar to post order traversal, but we store information in a short array res[], in which res[2] is the answer (res[0] is whether the node is the root of a BST, res[1] is the number of nodes, res[3] is the minimum value of the subtree, res[4] is the maximum value of the subtree).

// Every node should be called just once.


