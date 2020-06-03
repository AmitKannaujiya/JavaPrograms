package array;
import java.util.HashMap;

public class ContiguousArrayLeetCode {
    public static void main(String[] args) {
        int[] array = new int[] {0,1,0,0, 1, 0};
        ContiguousArrayLeetCode obj = new ContiguousArrayLeetCode();
        System.out.println(obj.findMaxLength(array));

        System.out.println(obj.findMaxLengthV2(array));
    }

    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = 0, sum = 0;
        for(int i=0; i< nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(sum)) {
                ans = Math.max(ans, i - map.get(sum));
            }
            map.putIfAbsent(sum, i);
        }
        return ans;
    }

    public int findMaxLengthV2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int count = 0;
        
        map.put(0, -1);
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0)   count--;
            else                count++;
            
            if (map.containsKey(count)) {
                result = Math.max(result, i-map.get(count));
            } else {
                map.put(count, i);
            }
        }
        
        return result;
    }
}