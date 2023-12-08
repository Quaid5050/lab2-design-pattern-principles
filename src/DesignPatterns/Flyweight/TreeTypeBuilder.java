package DesignPatterns.Flyweight;

import java.awt.Color;

public class TreeTypeBuilder {
    private String name;
    private Color color;
    private String otherTreeData;
    private boolean isFruitTree;
    private int countOfFruits;

    public TreeTypeBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public TreeTypeBuilder withColor(Color color) {
        this.color = color;
        return this;
    }

    public TreeTypeBuilder withOtherTreeData(String otherTreeData) {
        this.otherTreeData = otherTreeData;
        return this;
    }

    public TreeTypeBuilder isFruitTree(boolean isFruitTree) {
        this.isFruitTree = isFruitTree;
        return this;
    }

    public TreeTypeBuilder withCountOfFruits(int countOfFruits) {
        this.countOfFruits = countOfFruits;
        return this;
    }

    public TreeType build() {
        return new TreeType(name, color, otherTreeData, isFruitTree, countOfFruits);
    }
}
