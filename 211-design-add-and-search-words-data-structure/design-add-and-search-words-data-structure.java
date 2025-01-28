class WordDictionary {
    class TrieNode{
        TrieNode[] children;
        boolean isWord;

        TrieNode(){
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word, root, 0);
    }

    private boolean searchHelper(String word, TrieNode node, int index){
        if(node == null) return false;
        if(index == word.length())
            return node.isWord;
        
        char letter = word.charAt(index);
        if(letter == '.'){
            for(TrieNode child : node.children)
                if(child != null && searchHelper(word, child, index + 1))
                    return true;
            
            return false;
        }
        else{
            return searchHelper(word, node.children[letter - 'a'], index + 1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */