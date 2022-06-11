package algoMadeEasyBook;

import java.util.*;

public class CodingTestTrackson {
    public static void main(String[] args) {
       String str = "-+-+*++-*++-" ;
       int len = 2;
       CodingTestTrackson obj = new CodingTestTrackson();
       System.out.println(obj.getCoddedString(str, len));
       System.out.println(obj.getCoddedString("*++*+-", 3));

    }

    public String getCoddedString(String str, int len) {
        List<String> list = new ArrayList<>();
        int i =0;
        HashMap<String, Integer> map = new HashMap<>();
        while (i < str.length()) {
           //String s = str.substring(i, i+len);
            list.add(str.substring(i, i+len));
            //map.put(s, map.getOrDefault(s, 0)+1);
            i +=len;
        }

        for (int j = 0; j < list.size(); j++) {
            String s = list.get(j);
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        List<WeigtedString> outPutList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: map.entrySet()){
            outPutList.add(new WeigtedString(entry.getKey(), entry.getValue()));
        }
        outPutList.sort(new Comparator<WeigtedString>() {
            @Override
            public int compare(WeigtedString first, WeigtedString second) {
                if(first.weight > second.weight) {
                    return -1;
                }
                if(first.weight== second.weight) {
                    for (int j = 0; j < first.str.length(); j++) {
                        char ch = first.str.charAt(j);
                        char ch2 = second.str.charAt(j);
                        if (ch != ch2) {
                            if (ch == '*') {
                                return -1;
                            }
                            if (ch2 == '*') {
                                return 1;
                            }
                            if (ch == '-') {
                                return -1;
                            }
                            if (ch2 == '-') {
                                return 1;
                            }
                            if (ch == '+') {
                                return -1;
                            }
                            if (ch2 == '+') {
                                return 1;
                            }

                        }

                    }
                    return second.str.compareTo(first.str);
                }
                return second.weight - first.weight;
            }
        });
        String result = "";
        for (int j = 0; j < outPutList.size(); j++) {
            result += outPutList.get(j).str;
        }
        return result;
    }

    private String hashGenerate(String str, int len){

        int i =0;
        Map<String , Integer> map = new HashMap<>();
        while (i < str.length()){

            String sub = str.substring(i, i+len);
            if(map.containsKey(sub))
                map.put(sub, map.get(sub)+1);
            else
                map.put(sub,1);
        }
        return null;
    }

    private int calculateWeight(String str){

        int weight=0;
        char [] arr = str.toCharArray();
        for(char val : arr){

          if(val =='*')
              weight+=3;
          else if(val =='-')
                weight+=2;
          else if(val =='+')
                weight+=1;
        }

        return weight;
    }

}
class WeigtedString {
    String str;
    int weight;
    WeigtedString(String str, int weight) {
        this.str= str;
        this.weight = weight;
    }
}
