public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if(board == null || board.length == 0 || board[0].length == 0) return res;
        TrieNode root = buildTree(words);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode root, List<String> res) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        char c = board[i][j];
        if(c == '*' || root.children[c - 'a'] == null) return;
        root = root.children[c - 'a'];
        if(root.word != null) {
            res.add(root.word);
            root.word = null;
        }
        board[i][j] = '*';
        dfs(board, i - 1, j, root, res);
        dfs(board, i + 1, j, root, res);
        dfs(board, i, j - 1, root, res);
        dfs(board, i, j + 1, root, res);
        board[i][j] = c;
    }
    
    private TrieNode buildTree(String[] words) {
        TrieNode root = new TrieNode();
        for(String s : words) {
            TrieNode node = root;
            for(char c : s.toCharArray()) {
                if(node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = s;
        }
        return root;
    }
    
    class TrieNode{
        String word;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
}