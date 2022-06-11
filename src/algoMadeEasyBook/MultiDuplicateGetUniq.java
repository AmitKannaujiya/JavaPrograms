package algoMadeEasyBook;

public class MultiDuplicateGetUniq {
    public static void main(String[] args) {
        MultiDuplicateGetUniq obj = new MultiDuplicateGetUniq();
        obj.getUniqueInDuplicate(new int[]{2,3, 4, 7,9, 2,3,4});
    }

    public void getUniqueInDuplicate(int[] array) {
        int xor = 0;
        for (int i = 0; i < array.length; i++) {
            xor ^= array[i];
        }
        int firstSetBit =  xor & ~(xor -1);
        int x = 0;
        int y = 0;
        for (int i = 0; i < array.length; i++) {
            if((firstSetBit & array[i]) > 0){
                x ^= array[i];
            } else {
                y ^= array[i];
            }
        }
        System.out.println("Both nos are " + x + " and " + y);

    }
}
