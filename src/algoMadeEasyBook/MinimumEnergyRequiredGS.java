package algoMadeEasyBook;

public class MinimumEnergyRequiredGS {
    public static void main(String[] args) {
        int[] array = {4, -10, 4, -8, 4};
        MinimumEnergyRequiredGS obj = new MinimumEnergyRequiredGS();
        System.out.println(obj.getMinimumIntialEnergy(array));
        int[] arr = {3, 5, 2, 6, 1};
        System.out.println(obj.getMinimumIntialEnergy(arr));
        int[] a = {-1, -5, -9};
        System.out.println(obj.getMinimumIntialEnergy(a));
    }

    public int getMinimumIntialEnergy(int[] array) {
        int minimumEnergy = 1;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if(array[i] < 0 && sum < 0) {
                minimumEnergy = Math.max(minimumEnergy, Math.abs(sum) );
            }
        }
        return minimumEnergy + array[0] + 1;
    }

}
