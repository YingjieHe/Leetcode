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
    private String spliter = ",";
    private String end = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
    
    private void dfs(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(end).append(spliter);
            return;
        }
        sb.append(root.val + spliter);
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(spliter)));
        return buildtree(q);
    }
    
    private TreeNode buildtree(Queue<String> q) {
        String val = q.poll();
        if(val.equals(end)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = buildtree(q);
        root.right = buildtree(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));