package DesignPatterns.Flyweight;


import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class TreeTypeFactory {
    private static final Map<String, ITreeType> treeTypes = new HashMap<>();

    public static ITreeType getTreeType(String name, Color color, String otherTreeData) {
        String key = name + color + otherTreeData;
        ITreeType result = treeTypes.get(key);

        if (result == null) {
            result = new BasicTreeType(color); // Passing color to the BasicTreeType constructor
            treeTypes.put(key, result);
        }

        return result;
    }
}