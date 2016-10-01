public class WordDictionary {
    class TrieNode {
        boolean isWord;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    private TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            if(node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfs(word.toCharArray(), 0, root);
    }
    
    private boolean dfs(char[] ch, int k, TrieNode node) {
        if(ch.length == k) return node.isWord;
        if(ch[k] != '.') return node.children[ch[k] - 'a'] != null && dfs(ch, k + 1, node.children[ch[k] - 'a']);
        else {
            for(int i = 0; i < 26; i++) {
                if(node.children[i] != null) {
                    if(dfs(ch, k + 1, node.children[i])) {
                        return true;
                    }
                }
             }
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");