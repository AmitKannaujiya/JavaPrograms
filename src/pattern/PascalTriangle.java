package pattern;

import inheritance.sub.PackageTest;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        PascalTriangle obj = new PascalTriangle();
       // obj.generate(6);
       //System.out.println(obj.numDecodings("12"));
       // System.out.println(obj.numDecodings("226"));
        System.out.println(obj.numDecodings("2345"));

    }

    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++)
        {
            row.add(0, 1);
            for(int j=1;j<row.size()-1;j++)
                row.set(j, row.get(j)+row.get(j+1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;

    }

    public int numDecodings(String s) {
        int length = s.length();
        int currentIndex = 0;
        if(s== null || s.length() ==0 ||s.charAt(0) == '0') {
            return 0;
        }
        int[] d=new int[s.length()+1];
        //c =numDecodings(s, currentIndex,1, c);
        numDecodings(s, currentIndex, d);
        int c = 0;
        for (int i = 0; i < d.length; i++) {
            c+= d[i];
        }

        return c;
    }

    public int numDecodings(String s, int currentIndex,int len, int count) {
        if(currentIndex> s.length()) {
            return 0;
        }
        if(currentIndex== s.length()) {
            return 1;
        }
        if(s.length() >= currentIndex+len) {
            String sub = s.substring(currentIndex, currentIndex+len);
            int d = Integer.parseInt(sub);
            if(len==1 & d >=1 && d<=9) {
                currentIndex +=len;
            } else if(len==2 & d >=10 && d<=26){
                currentIndex +=len;
            } else {
                return  0;
            }
        }
        return numDecodings(s, currentIndex, 1,count) +  numDecodings(s, currentIndex, 2,count);

    }
    public int numDecodings(String s, int currentIndex, int[]d) {
        if(currentIndex +2 <= s.length()){
            String sub1 = s.substring(currentIndex, currentIndex+1);
            String sub2 = s.substring(currentIndex, currentIndex+2);
            int d1 = Integer.parseInt(sub1);
            int d2 = Integer.parseInt(sub2);
            if(d1 >=1 && d1<=9){
                d[currentIndex] += numDecodings(s, currentIndex+1,d);
            } else {
                return 0;
            }
            if(d2 >=10&& d2 <=26) {
                d[currentIndex] +=numDecodings(s, currentIndex+2,d);
            } else {
                return 0;
            }
        } else if(currentIndex +1 <= s.length()){
            String sub1 = s.substring(currentIndex, currentIndex+1);
            int d1 = Integer.parseInt(sub1);
            if(d1 >=1 && d1<=9){
                d[currentIndex] += numDecodings(s, currentIndex+1,d);
            } else {
                return 0;
            }
        } else if(currentIndex==s.length()){
            return 1;
        }
        return 0;
    }
}
