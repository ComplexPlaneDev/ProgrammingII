import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

class TrieNode {
    // children keyed by the next character
    Map<Character, TrieNode> children = new HashMap<>();

    // true if a stored word ends exactly at this node
    boolean endOfWord = false;
}

class Trie {
    final TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); ++i) {
            TrieNode next = current.children.get(word.charAt(i));
            if (next == null) {
                TrieNode newNode = new TrieNode();
                current.children.put(word.charAt(i), newNode);
                current = newNode;
            } else {
                current = next;
            }
        }

        current.endOfWord = true;
    }

    public List<String> similar(String prefix) {
        final List<String> out = new ArrayList<>();

        TrieNode current = root;

        for (int i = 0; i < prefix.length(); ++i) {
            current = current.children.get(prefix.charAt(i));
            if (current == null) {
                return out;
            }
        }

        if (current.endOfWord) {
            out.add(prefix);
        }

        similarHelper(current, prefix, out);
        return out;
    }

    private void similarHelper(TrieNode stRoot /* root of the subtree */, String currWord, List<String> out) {
        for (final Character c : stRoot.children.keySet()) {
            final TrieNode child = stRoot.children.get(c);
            if (child.endOfWord) {
                out.add(currWord + c);
            }

            similarHelper(child, currWord + c, out);
        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        final Trie tn = new Trie();

        tn.insert("car");
        tn.insert("card");
        tn.insert("dog");
        tn.insert("cat");

        List<String> ls = tn.similar("ca");
        List<String> ls1 = tn.similar("pe");
        List<String> ls2 = tn.similar("car");
    }
}
