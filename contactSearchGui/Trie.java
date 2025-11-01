import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
    String contactNumber = null;
}

public class Trie {
    private final TrieNode root = new TrieNode();

    public void insert(String name, String number) {
        TrieNode node = root;
        for (char ch : name.toLowerCase().toCharArray()) {
            node = node.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        node.isEndOfWord = true;
        node.contactNumber = number;
    }

    public List<String> search(String prefix) {
        List<String> results = new ArrayList<>();
        TrieNode node = root;
        for (char ch : prefix.toLowerCase().toCharArray()) {
            node = node.children.get(ch);
            if (node == null) return results;
        }
        dfs(node, new StringBuilder(prefix), results);
        return results;
    }

    private void dfs(TrieNode node, StringBuilder prefix, List<String> results) {
        if (node.isEndOfWord)
            results.add(prefix + " - " + node.contactNumber);
        for (char ch : node.children.keySet()) {
            dfs(node.children.get(ch), prefix.append(ch), results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public void clear() {
        root.children.clear();
        root.isEndOfWord = false;
        root.contactNumber = null;
    }
}
