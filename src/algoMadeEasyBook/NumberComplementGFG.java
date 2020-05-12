package algoMadeEasyBook;

public class NumberComplementGFG {
    public static void main(String[] args) {
        NumberComplementGFG obj = new NumberComplementGFG();
        System.out.println(obj.findComplement(5));
    }

    public int findComplement(int num) {
        int res = 0;
        boolean found = false;
        for(int i=31; i>=0; i--) {
            if(!found && (num & 1 << i) != 0) {
                System.out.println("found" + i);
                found = true;
            }
            if(found) {
                res |= 1<< i;
            }
        }
        System.out.println(res);
        return num ^ res;
    }
}