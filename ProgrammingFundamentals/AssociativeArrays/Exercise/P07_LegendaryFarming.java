package ProgrammingFundamentals.AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P07_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int shadowmourneShards = 0;
        int valanyrFragments = 0;
        int dragonwrathMotes = 0;

        boolean isFoundLegendary = shadowmourneShards >= 250 || valanyrFragments >= 250 || dragonwrathMotes >= 250;

        Map<String, Integer> keyMaterialsMap = new TreeMap<>();
        Map<String, Integer> junkMap = new LinkedHashMap<>();

        boolean isFoundShadowmourne = false;
        boolean isFoundValanyr = false;
        boolean isFoundDragonwrath= false;

        while (!isFoundLegendary) {
            for (int i = 0; i < input.length; i+= 2) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i+1].toLowerCase();

                switch (material) {
                    case "shards":
                        shadowmourneShards += quantity;
                        if (!keyMaterialsMap.containsKey(material)) {
                            keyMaterialsMap.put(material, quantity);
                        } else {
                            keyMaterialsMap.put(material, keyMaterialsMap.get(material) + quantity);
                        }
                        if (shadowmourneShards >= 250) {
                            isFoundShadowmourne = true;
                            break;
                        }
                        break;
                    case "fragments":
                        valanyrFragments += quantity;
                        if (!keyMaterialsMap.containsKey(material)) {
                            keyMaterialsMap.put(material, quantity);
                        } else {
                            keyMaterialsMap.put(material, keyMaterialsMap.get(material) + quantity);
                        }
                        if (valanyrFragments >= 250) {
                            isFoundValanyr = true;
                            break;
                        }
                        break;
                    case "motes":
                        dragonwrathMotes += quantity;
                        if (!keyMaterialsMap.containsKey(material)) {
                            keyMaterialsMap.put(material, quantity);
                        } else {
                            keyMaterialsMap.put(material, keyMaterialsMap.get(material) + quantity);
                        }
                        if (dragonwrathMotes >= 250) {
                            isFoundDragonwrath = true;
                            break;
                        }
                        break;
                    default:
                        if (!junkMap.containsKey(material)) {
                            junkMap.put(material, quantity);
                        } else {
                            junkMap.put(material, junkMap.get(material) + quantity);
                        }
                        break;
                }
                if (isFoundShadowmourne || isFoundValanyr || isFoundDragonwrath) {
                    break;
                }
            }
            if (isFoundShadowmourne || isFoundValanyr || isFoundDragonwrath) {
                break;
            } else {
                input = scanner.nextLine().split(" ");
            }
        }
        if (isFoundShadowmourne) {
            System.out.println("Shadowmourne obtained!");
            keyMaterialsMap.put("shards", keyMaterialsMap.get("shards") - 250);
        } else if (isFoundValanyr) {
            System.out.println("Valanyr obtained!");
            keyMaterialsMap.put("fragments", keyMaterialsMap.get("fragments") - 250);
        } else {
            System.out.println("Dragonwrath obtained!");
            keyMaterialsMap.put("motes", keyMaterialsMap.get("motes") - 250);
        }

        String[] keyMaterials = {"shards", "0", "fragments", "0", "motes", "0"};
        for (Map.Entry<String, Integer> entry : keyMaterialsMap.entrySet()) {
            if (entry.getKey().equals("shards")) {
                keyMaterials[1] = String.valueOf(entry.getValue());
            } else if (entry.getKey().equals("fragments")) {
                keyMaterials[3] = String.valueOf(entry.getValue());
            } else {
                keyMaterials[5] = String.valueOf(entry.getValue());
            }
        }
        for (int i = 0; i < keyMaterials.length; i+=2) {
            System.out.println(keyMaterials[i] + ": " + keyMaterials[i+1]);
        }
        junkMap.forEach((material, quantity) -> System.out.printf("%s: %d%n", material, quantity));

    }
}