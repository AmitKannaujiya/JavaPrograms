package algoMadeEasyBook;

public class RGBArraySort {

    public static void main(String[] args) {
        RGBArraySort obj =new RGBArraySort();
        char[] input = new char[]{'G','B', 'R', 'R', 'B', 'R', 'G'};
        obj.sortRGB(input, new char[]{'G','R', 'B'});
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

    void sortRGB(char[] array, char[] sortOrder) {
        int start=0;
        int end = array.length-1;
        int count = sortOrder.length-1;
        int j=0;
        while (count-- > 0) {
            while (start < end) {
                while (array[start] == sortOrder[j]) {
                    start++;
                }
                while (array[end] != sortOrder[j]) {
                    end--;
                }
                if(start < end && start < array.length  && end >=0) {
                    char temp =  array[start];
                    array[start] =array[end];
                    array[end] = temp;
                }
            }
            end = array.length-1;
            j++;
        }

    }
}
