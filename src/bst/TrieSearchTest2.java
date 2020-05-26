package bst;

import java.util.Scanner;

import Utills.Utills;


public class TrieSearchTest2 {
    public static void main(String[] args) {
        String[] mobileNos = {
            "98198989989",
            "98123243434",
            "99872323234",
            "99768568435",
            "87979878686",
            "98787877887",
            "98675655665"
        };

        TrieDataStructure trieDataStructure = new TrieDataStructure(mobileNos);
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Search From : ");
            String word = scanner.next();
            Utills.printArrayList(trieDataStructure.getPrefixSearch(word.trim()));
            System.out.println("Search More Y/N");
            String choose = scanner.next();
            if("YES".equalsIgnoreCase(choose.trim()) || "Y".equalsIgnoreCase(choose.trim())) {
                exit = false;
            } else {
                exit = true;
            }

        } while(!exit);

        scanner.close();
    }
}