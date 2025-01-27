class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word : words)
            trie.insert(word);

        List<String> result = new ArrayList<>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                backtrack(i, j, board, trie.root, result);
            }
        }
        return result;
    }

    private void backtrack(int row, int col, char[][] board, TrieNode node, List<String> result){
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == '#') return;

        char letter = board[row][col];
        TrieNode childNode = node.children[letter - 'a'];
        if(childNode == null) return;

        if(childNode.word != null){
            result.add(childNode.word);
            childNode.word = null; //to avoid duplicates
        }

        board[row][col] = '#';

        int[] rowOffsets = {0, 0, -1, 1}; //left, right, up, down
        int[] colOffsets = {-1, 1, 0, 0};
        for(int i = 0; i < 4; i++)
            backtrack(row + rowOffsets[i], col + colOffsets[i], board, childNode, result);

        board[row][col] = letter;
    }
}

class TrieNode{
    TrieNode[] children;
    String word;

    TrieNode(){
        children = new TrieNode[26];
    }
}

class Trie{
    TrieNode root;

    Trie(){
        root = new TrieNode();
    }

    void insert(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.word = word;
    }
}