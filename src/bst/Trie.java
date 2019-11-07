package bst;

public class Trie {
    static int ALPHABET_SIZE = 26;
    public Trie children[];
    public boolean isEndOfWord = false;

    public Trie() {
        this.children = new Trie[ALPHABET_SIZE];
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            this.children[i] = null;
        }
    }

    public Trie(boolean isEndOfWord) {
        super();
        this.isEndOfWord = isEndOfWord;
    }
}
