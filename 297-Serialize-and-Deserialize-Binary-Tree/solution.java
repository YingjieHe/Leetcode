/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static final String spliter = ",";
    private static final String NN = "X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
    private void dfs(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(NN).append(spliter);
        }
        else {
            sb.append(root.val).append(spliter);
            dfs(root.left, sb);
            dfs(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(spliter)));
        return buildtree(q);
    }
    
    private TreeNode buildtree(Queue<String> q) {
        String s = q.poll();
        if(s.equals(NN)) return null;
        TreeNode node = new TreeNode(Integer.valueOf(s));
        node.left = buildtree(q);
        node.right = buildtree(q);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));