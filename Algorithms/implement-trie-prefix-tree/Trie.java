
import java.util.ArrayList;
import java.util.List;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        int charIndex = 0;
        TrieNode curNode = root;
        while (charIndex < word.length()) {
            char c = word.charAt(charIndex);
            boolean isExisted = false;
            for (TrieNode child : curNode.childs) {
                if (child.val == c) {
                    charIndex ++;
                    curNode = child;
                    isExisted = true;
                    break;
                }
            }
            if (!isExisted)
                break;
            if (charIndex == word.length() - 1)
                curNode.isEnd = true;
        }
        
        TrieNode parentNode = curNode;
        while (charIndex < word.length()) {
            TrieNode node = new TrieNode(word.charAt(charIndex));
            parentNode.childs.add(node);
            charIndex ++;
            parentNode = node;
        }
        parentNode.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        boolean result = false;
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            boolean charExisted = false;
            for (TrieNode node : curNode.childs) {
                if (node.val == word.charAt(i)) {
                    charExisted = true;
                    curNode = node;
                    break;
                }
            }
            if (!charExisted) {
                break;
            }
            if (i == word.length() - 1 && curNode.isEnd)
                result = true;
        }
        return result;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        boolean result = true;
        TrieNode curNode = root;
        for (char c : prefix.toCharArray()) {
            boolean charExisted = false;
            for (TrieNode node : curNode.childs) {
                if (node.val == c) {
                    charExisted = true;
                    curNode = node;
                    break;
                }
            }
            if (!charExisted) {
                result = false;
                break;
            }
        }
        return result;
    }
    
    // For test
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("ab");
        System.out.println(trie.toString());
        
        System.out.println(trie.search("a"));
        System.out.println(trie.startsWith("a"));
    }
    
}

class TrieNode {
    char val;
    boolean isEnd;
    List<TrieNode> childs;
    
    public TrieNode() {
        isEnd = false;
        childs = new ArrayList<TrieNode>();
    }
    public TrieNode(char c) {
        val = c;
        isEnd = false;
        childs = new ArrayList<TrieNode>();
    }
    
}

