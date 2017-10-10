package Problem15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class LegendaryFarming {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> specialElements = new TreeMap<>();
        specialElements.put("shards", 0);
        specialElements.put("fragments", 0);
        specialElements.put("motes", 0);
        Map<String, Integer> trashElements = new TreeMap<>();
        while (true){
            if (specialElements.get("shards") >= 250 || specialElements.get("fragments") >= 250
                    || specialElements.get("motes") >= 250){
                break;
            }
            String[] materialsAndQuantities = reader.readLine().split("\\s+");
            for (int i = 0; i < materialsAndQuantities.length - 1; i+= 2) {
                if (specialElements.get("shards") >= 250 || specialElements.get("fragments") >= 250
                        || specialElements.get("motes") >= 250){
                    break;
                }
                int quantity = Integer.parseInt(materialsAndQuantities[i]);
                String material = materialsAndQuantities[i + 1].toLowerCase();
                if (specialElements.containsKey(material)){
                    int currentElementQuantity = specialElements.get(material);
                    specialElements.put(material, + currentElementQuantity + quantity);
                }else {
                    if (!trashElements.containsKey(material)){
                        trashElements.put(material, 0);
                    }
                    int currentElementQuantity = trashElements.get(material);
                    trashElements.put(material, + currentElementQuantity + quantity);
                }
            }
        }
        String legendaryItem = checkForObtainedElement(specialElements);
        System.out.println(legendaryItem + " obtained!");
        printSpecialItems(specialElements);
        printJunkItems(trashElements);
    }
    private static String checkForObtainedElement(Map<String, Integer> elements){
        String legendaryItem = "";
        if (elements.get("shards") >= 250){
            legendaryItem = "Shadowmourne";
            elements.put("shards", elements.get("shards") - 250);
        }else if (elements.get("fragments") >= 250){
            legendaryItem = "Valanyr";
            elements.put("fragments", elements.get("fragments") - 250);
        }else if (elements.get("motes") >= 250){
            legendaryItem = "Dragonwrath";
            elements.put("motes", elements.get("motes") - 250);
        }
        return legendaryItem;
    }
    private static void printSpecialItems(Map<String, Integer> specialItems){
        LinkedHashMap<String, Integer> sortedKeyMaterials = specialItems.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (String s : sortedKeyMaterials.keySet()) {
            System.out.println(s + ": " + specialItems.get(s));
        }
    }
    private static void printJunkItems(Map<String , Integer> junkItems){
        for (String material : junkItems.keySet()) {
            System.out.println(material + ": " + junkItems.get(material));
        }
    }
}
