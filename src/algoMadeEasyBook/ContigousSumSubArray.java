package algoMadeEasyBook;

public class ContigousSumSubArray {
    public static void main(String[] args) {
        ContigousSumSubArray obj = new ContigousSumSubArray();
        obj.contigousSumSubArray(new int[] {1, 4, 20, 3, 10, 5},18);
        obj.contigousSumSubArray(new int[] {1,2,3,4,5,6,7,8,9,10},15);
        obj.contigousSumSubArray(new int[] {1,2,3,7,5},12);
        obj.contigousSumSubArray(new int[] {1,2,3,7,5},12);
        String line= "135 101 170 125 79 159 163 65 106 146 82 28 162 92 196 143 28 37 192 5 103 154 93 183 22 117 119 96 48 127 172 139 70 113 68 100 36 95 104 12 123 134";
        String[] strs = line.trim().split("\\s+");
        int[] a =new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            a[i] =Integer.valueOf(strs[i]);
        }
        obj.contigousSumSubArray(a,468);
        line = "142 112 54 69 148 45 63 158 38 60 124 142 130 179 117 36 191 43 89 107 41 143 65 49 47 6 91 130 171 151 7 102 194 149 30 24 85 155 157 41 167 177 132 109 145 40 27 124 138 139 119 83 130 142 34 116 40 59 105 131 178 107 74 187 22 146 125 73 71 30 178 174 98 113";
        strs = line.trim().split("\\s+");
        int[] b =new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            b[i] =Integer.valueOf(strs[i]);
        }
        obj.contigousSumSubArray(b,665);
    }

    public void contigousSumSubArray(int[] array, int target) {
        int i = 0;
        int j = 0;
        int sum = array[0];
        while (j < array.length && i < array.length) {
            if(sum == target) {
                break;
            } else if(sum > target) {
                sum -= array[i];
                i++;
            } else {
                ++j;
                if(j < array.length){
                    sum += array[j];
                }

            }
        }
        if(sum == target) {
            System.out.println("Sum found between index  : " + i + " to " + j );
        } else {
            System.out.println("No Sum Found");
        }
    }
}
