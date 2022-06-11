package algoMadeEasyBook;

public class RainWaterTapping {
    public static void main(String[] args) {
        int[] buildigs =  new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        RainWaterTapping obj = new RainWaterTapping();
        obj.trap(buildigs);

    }
    // maxL = [0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3]
    // maxR = [3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1]
    // min =  [0, 1, 1, 2, 2, 2, 2, 3, 2, 2, 2, 1]
    //water = [0, 0, 1, 0, 1, 2, 1, 0, 0, 1, 0, 0]
    public int trap(int[] height) {
        int size = height.length;
        int[] maxL = new int[size];
        maxL[0] = height[0];
        int[] maxR = new int[size];
        maxR[size-1] = height[size-1];
        int[] water = new int[size];
        for(int i=1, j = size-2; i< size && j>=0; i++, j--) {
            maxL[i] = Math.max(height[i], maxL[i-1]);
            maxR[j] = Math.max(maxR[j], height[j +1]);
        }
        int sum = 0;
        for(int i=0; i< size;i++){
            water[i] = Math.min(maxL[i], maxR[i]) - height[i];
            sum +=water[i];
        }
        return sum;
    }
}
