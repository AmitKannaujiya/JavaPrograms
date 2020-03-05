package designConcepts.vendingMachin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class SeedVendingMachine {
    public static void main(String[] args) {
        String[] productCode = new String[] {
                "Chocolate", "Biscuits", "Water Bottle", "Toffi", "Lolipop"
        };
        double[] prices = new double[] {15.5, 10.5, 20, 10, 15};

        String[] [] productsList = {
                {"Cadbery", "Dairy Milk", "KitKat"},{"Hide & Seeks", "Oreo"}, {"Kindly", "Bislary"},{"Pulse", "Coffee"},
                {"Alpenlibey", "Candimaan"}
        };
        HashMap<String, Double> productPriceMap = new LinkedHashMap<>();
        HashMap<String, Set<String>> productItemMap = new LinkedHashMap<>();
        for (int i = 0; i < productCode.length; i++) {
            productPriceMap.put(productCode[i], prices[i]);
            Set<String> set = new HashSet<String>();
            for (int j = 0; j < productsList[i].length; j++) {
                set.add(productsList[i][j]);
            }
            productItemMap.put(productCode[i], set);
        }
        VendingMachineV2 vendingMachineV2 = new VendingMachineV2();
        vendingMachineV2.setProductCodeItem(productItemMap);
        vendingMachineV2.setProductCodePriceMap(productPriceMap);
    }
}
