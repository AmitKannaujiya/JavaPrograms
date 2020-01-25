package array;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.ArrayList;

public class RLEIterator_Leetcode_900 {
    public static void main(String[] args) {
//        RLEIterator iterator = new RLEIterator(new int[]{3,8,0,9,2,5});
//        iterator.next(2);
//        iterator.next(1);
//        iterator.next(1);
//        iterator.next(2);

//        ["RLEIterator","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next","next"]
//[[[923381016,843,898173122,924,540599925,391,705283400,275,811628709,850,895038968,590,949764874,580,450563107,660,996257840,917,793325084,82]],[612783106],[486444202],[630147341],[845077576],[243035623],[731489221],[117134294],[220460537],[794582972],[332536150],[815913097],[100607521],[146358489],[697670641],[45234068],[573866037],[519323635],[27431940],[16279485],[203970]]

        RLEIterator iterator = new RLEIterator(new int[]{923381016,843,898173122,924,540599925,391,705283400,275,811628709,850,895038968,590,949764874,580,450563107,660,996257840,917,793325084,82});
        //[612783106],[486444202],[630147341],[845077576],[243035623],[731489221],[117134294],[220460537],[794582972],[332536150],
        iterator.next(612783106);
        iterator.next(486444202);
                iterator.next(630147341);
                iterator.next(845077576);
                                iterator.next(243035623);
                        iterator.next(731489221);
                        iterator.next(117134294);
    }
}

class RLEIterator {
    // List<Integer> list;
    // int index = 0;
    Long[] array = null;
    HashMap<Long, Integer> map = new LinkedHashMap<>();
    long key= 0;
    public RLEIterator(int[] A) {
        // decodeArray(A);
        this.array= generateArrayMap(A);
    }
    private Long[] generateArrayMap(int[] a) {
        long key = 0;
        ArrayList<Long> list = new ArrayList<>();
        for(int i=1; i<a.length;) {
            if(a[i-1] > 0) {
                key += a[i-1];
                list.add(key);
                map.put(key, a[i]);
            }
            i +=2;
        }
        Long [] array = list.toArray(new Long[list.size()]);
        return array;
    }
    private Long getKeyLinear(long key) {
        for(int i=1;i<array.length; i++) {
            if(array[i-1]< key && key <= array[i]) {
                return array[i];
            } else if(array[i-1]>= key && array[i] > key) {
                return array[i-1];
            }
        }
        return new Long(-1);
    }
    private int getKey(int key, int low, int high) {
        if(low > high) {
            return -1;
        }
        int mid = (low+high)/2;
        if(mid-1 >= low && array[mid] >= key && array[mid-1] < key) {
            return mid;
        }
        if(mid+1<high && array[mid+1] >= key && array[mid] < key) {
            return mid+1;
        }
        if(array[mid]<key) {
            return getKey(key, mid+1, high);
        } else {
            return getKey(key, low, mid-1);
        }
    }
    // private void decodeArray(int [] a) {
    //     this.list = new ArrayList<>();
    //     for(int i=1; i<a.length;) {
    //         while(a[i-1] > 0 ) {
    //             list.add(a[i]);
    //             a[i-1]--;
    //         }
    //         i += 2;
    //     }
    // }

    public int next(int n) {
        // this.index += n;
        // if(index <= list.size()) {
        //     return list.get(index-1);
        // }
        // return -1;
        key +=n;
        long lastKey = getKeyLinear(key);
        //int lastKey = getKey(key+n, 0, array.length);
        if(lastKey == -1) {
            return -1;
        }
        return map.get(lastKey);
    }
}
