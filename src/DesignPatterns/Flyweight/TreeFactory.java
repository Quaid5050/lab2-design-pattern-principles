package DesignPatterns.Flyweight;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class TreeFactory {
    private static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, Color color, String otherTreeData, boolean isFruitTree, int countOfFruits) {
        String key = name + color + otherTreeData;
        TreeType result = treeTypes.get(key);

        if (result == null) {
            result = new TreeType(name, color, otherTreeData, isFruitTree, countOfFruits);
            treeTypes.put(key, result);
        }

        return result;
    }
}
