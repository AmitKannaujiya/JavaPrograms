package bst;

import Utills.Utills;

import java.util.ArrayList;
import java.util.ListIterator;

public class TrieDataStructureTest {
    public static void main(String[] args) {
        String keys[] = {"the", "a", "there",
                "answer", "any", "by",
                "bye", "their"};
        Trie root = new Trie();
        for (String key : keys) {
            insertKey(root, key);
        }

        System.out.println("Search for the : " + searchKey(root, "the"));
        System.out.println("Search for amit : " + searchKey(root, "amit"));
        System.out.println("Search for there : " + searchKey(root, "there"));
        System.out.println("Search for their : " + searchKey(root, "their"));

        System.out.println(wordCount(root));
        //System.out.println(wordCount1(root));
        ArrayList<String> al = displayAllWords(root);
        System.out.println("List of Words");
        ListIterator iterator = al.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        al = getSearchSuggestions(root, "the");
        System.out.println("List of Suggesstions");
        iterator = al.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        al = getSearchSuggestions(root, "a");
        System.out.println("List of Suggesstions");
        iterator = al.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        TrieDataStructure trieDataStructure = new TrieDataStructure(keys);
        Utills.printArrayList(trieDataStructure.getPrefixSearch("a"));
        Utills.printArrayList(trieDataStructure.getPrefixSearch("the"));

    }

    static void insertKey(Trie root, String key) {
        Trie node = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    static boolean searchKey(Trie root, String key) {
        Trie node = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node != null && node.isEndOfWord == true;
    }

    static int wordCount(Trie root) {
        int result = 0;
        if (root.isEndOfWord) {
            result++;
        }
        for (int i = 0; i < Trie.ALPHABET_SIZE; i++) {
            if (root.children[i] != null) {
                result += wordCount(root.children[i]);
            }
        }
        return result;
    }

    static ArrayList<String> displayAllWords(Trie root) {
        ArrayList<String> arrayList = new ArrayList<>();
        int level = 0;
        for (int i = 0; i < Trie.ALPHABET_SIZE; i++) {
            if (root.children[i] != null) {
                char ch = (char) (i + 'a');
                displayAllWords(root.children[i], arrayList, new StringBuilder(ch));
            }
        }
        return arrayList;
    }

    static void displayAllWords(Trie root, ArrayList<String> arrayList, StringBuilder sb) {
        if (root.isEndOfWord) {
            arrayList.add(sb.toString());
        }
        for (int i = 0; i < Trie.ALPHABET_SIZE; i++) {
            if (root.children[i] != null) {
                char ch = (char) (i + 'a');
                displayAllWords(root.children[i], arrayList, sb.append(ch));
            }
        }
    }

    static ArrayList<String> getSearchSuggetions(Trie root, String key, ArrayList<String> arrayList, String data) {
        if (key.isEmpty()) {
            return null;
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }

//        if(root.isEndOfWord ) {
//            arrayList.add(data);
//        }
//        Trie node = root;
//        for (int i = 0; i < key.length(); i++) {
//            int index = key.charAt(i) - 'a';
//            if(node.children[index] !=null ) {
//
//                getSearchSuggetions(root.children[index], key, arrayList, data+
//            }
//        }

        return arrayList;
    }
    // Search Key:   ab
    // Result :  abc , abcd,
//     static String getSearchString(Trie root, String tillNow) {
//        if(root.isEndOfWord) {
//            tillNow += "\n";
//        }
//
//
//
//     }

    static ArrayList<String> getSearchSuggestions(Trie root, String key) {
        if (key.isEmpty()) {
            return null;
        }
        Trie node = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (node.children[index] != null) {
                node = node.children[index];
            } else {
                return null;
            }
        }

        return getSuggestion(node, key, null);

    }

    static ArrayList<String> getSuggestion(Trie node, String stringTillNow, ArrayList<String> arrayList) {

        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (node.isEndOfWord) {
            arrayList.add(stringTillNow);
        }
        if (node == null) {
            return null;
        }

        for (int i = 0; i < Trie.ALPHABET_SIZE; i++) {
            int index = i + 'a';
            Trie[] children = node.children;
            if (children[i] != null) {
                getSuggestion(node.children[i], stringTillNow + (char) index, arrayList);
            }
        }
        return arrayList;
    }


//    static int wordCount1(Trie trie ) {
//        int result = 0;
//
//        for (int i = 0; i < Trie.ALPHABET_SIZE; i++) {
//            if(trie.children[i] !=null) {
//                result += wordCount1(trie.children[i], 0);
//            }
//        }
//        return result;
//    }
//
//    static int wordCount1(Trie root, int result) {
//
//        if(root.isEndOfWord) {
//            result++;
//        }
//        for (int i = 0; i < Trie.ALPHABET_SIZE; i++) {
//            if(root.children[i] !=null) {
//                result += wordCount1(root.children[i], result);
//            }
//        }
//        return result;
//    }
}
