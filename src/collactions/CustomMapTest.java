package collactions;

/**
 * Created by amit on 20/12/18.
 */
public class CustomMapTest {

    public static void main(String[] args) {
        CustomMap<String, Integer> customMap = new CustomMap<>();
        customMap.put("A", 1);
        customMap.put("B", 2);
        customMap.put("C", 1);
        customMap.put("D", 4);
        customMap.put("A", 5);
        System.out.println(customMap.toString());

        CustomMap<String, Integer> customMap1 = new CustomMap<>();
        customMap.put("Aaam", 1);
        customMap.put("Baam", 2);
        customMap.put("Bam", 1);
        customMap.put("AA", 4);
        customMap.put("Aaap", 5);
        System.out.println(customMap.toString());
    }
}
