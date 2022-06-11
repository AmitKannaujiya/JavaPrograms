package algoMadeEasyBook;

import Utills.Utills;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateAllStr {
    public static void main(String[] args) {
        GenerateAllStr obj = new GenerateAllStr();
        List<String> list = new ArrayList<>();
        String str = "1??0?101";
        obj.generateAllStr(str,0,"", list);
        for (String s: list) {
            System.out.println(s);
        }
        System.out.println("########################");
        List<String> list1 = new ArrayList<>();
        obj.generateAllStrUsingQueue(str, list1);
        for (String s: list1) {
            System.out.println(s);
        }
    }

    public void generateAllStr(String str, int index, String out, List<String> list) {
        while (index < str.length()) {
            if(str.charAt(index) == '?') {
                index++;
                generateAllStr(str, index, out+"1", list);
                generateAllStr(str, index, out+"0", list);
            } else {
                out += str.charAt(index++);
            }
        }
        if (out.length() == str.length()) {
            list.add(out);
            return;
        }
    }

    public void generateAllStrUsingQueue(String input, List<String> list) {
        Queue<String> queue =  new LinkedList<>();
        queue.add(input);
        while (!queue.isEmpty()) {
            String str = queue.remove();
            if(str.indexOf("?") > -1) {
                int index = str.indexOf("?");
                str =  str.substring(0,index)+ "1" +str.substring(index+1);
                queue.add(str);
                str =  str.substring(0,index)+ "0" +str.substring(index+1);
                queue.add(str);
            } else {
                list.add(str);
            }
        }
    }

}
