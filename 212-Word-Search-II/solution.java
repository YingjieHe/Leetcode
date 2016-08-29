public class Solution {
    Set<String> res = new HashSet<String>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String s : words) {
            trie.insert(s);
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, "", i, j, trie);
            }
        }
        return new ArrayList<String>(res);
    }
    
    private void dfs(char[][] board, String s, int i, int j, Trie trie) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if(board[i][j] == '*') return;
        s += board[i][j];
        if(!trie.startsWith(s)) return;
        if(trie.search(s)) res.add(s);
        char temp = board[i][j];
        board[i][j] = '*';
        dfs(board, s, i - 1, j, trie);
        dfs(board, s, i, j - 1, trie);
        dfs(board, s, i + 1, j, trie);
        dfs(board, s, i, j + 1, trie);
        board[i][j] = temp;
    }
    
    class TrieNode {
        TrieNode[] children;
        String word;
        public TrieNode() {
            children = new TrieNode[26];
            word = "";
        }
    }
    
    class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        
        public void insert(String s) {
            TrieNode node = root;
            for(char c : s.toCharArray()) {
                if(node.children[c -'a'] == null) {
                    node.children[c -'a'] = new TrieNode();
                }
                node = node.children[c -'a'];
            }
            node.word = s;
        }
        
        public boolean search(String s) {
            TrieNode node = root;
            for(char c : s.toCharArray()) {
                if(node.children[c -'a'] == null) {
                    return false;
                }
                node = node.children[c -'a'];
            }
            return node.word.equals(s);
        }
        
        public boolean startsWith(String s) {
            TrieNode node = root;
            for(char c : s.toCharArray()) {
                if(node.children[c -'a'] == null) {
                    return false;
                }
                node = node.children[c -'a'];
            }
            return true;
        }
    }
}