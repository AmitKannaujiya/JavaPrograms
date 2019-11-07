package bst;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ArrayList;

public class TrieDataStructure {
    private TrieNode root;

    public TrieDataStructure(String[] dictionary) {
        this.root = new TrieNode();
        for (String word : dictionary) {
            insertKey(word);
        }
    }

    class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isWordEnd;

        public TrieNode() {
            this.children = new LinkedHashMap<>();
            this.isWordEnd = false;
        }
    }

    public void insertKey(String key) {
        TrieNode node = this.root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        node.isWordEnd = true;
    }

    public ArrayList<String> getPrefixSearch(String s) {
        ArrayList<String> results = new ArrayList<>();
        TrieNode node = this.root;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (node.children.containsKey(ch)) {
                node = node.children.get(ch);
            } else {
                return results;
            }
        }
        findAllPrefixOfKey(node, results, s);
        return results;
    }

    private void findAllPrefixOfKey(TrieNode node, ArrayList<String> results, String prefix) {
        if (node.isWordEnd) {
            results.add(prefix);
        }
        for (Character ch : node.children.keySet()) {
            findAllPrefixOfKey(node.children.get(ch), results, prefix + ch);
        }
    }
}

