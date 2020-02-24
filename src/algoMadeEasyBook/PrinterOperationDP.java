package algoMadeEasyBook;

public class PrinterOperationDP {
    public static void main(String[] args) {
        PrinterOperationDP obj = new PrinterOperationDP();
        System.out.println(obj.getNoOfOperations("abbccdd"));
    }

    public int getNoOfOperations(String s) {
        return getNoOfOperations(s, 0, 0);
    }

    public int getNoOfOperations(String s, int index, int operation) {
        if(s== null || s.isEmpty()) {
            return 0;
        }
        if(index >= s.length()) {
            return operation;
        }
        int j = index +1;
        while (j< s.length() && s.charAt(index) == s.charAt(j)) {
            j++;
        }
        return getNoOfOperations(s, j, operation+1);
    }

}
