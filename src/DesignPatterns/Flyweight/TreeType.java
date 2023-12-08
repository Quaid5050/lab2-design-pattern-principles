package DesignPatterns.Flyweight;

import java.awt.Color;
import java.awt.Graphics;

public class TreeType {
    private String name;
    private Color color;
    private String otherTreeData;
    private boolean isFruitTree;
    private int countOfFruits;

    public TreeType(String name, Color color, String otherTreeData, boolean isFruitTree, int countOfFruits) {
        this.name = name;
        this.color = color;
        this.otherTreeData = otherTreeData;
        this.isFruitTree = isFruitTree;
        this.countOfFruits = countOfFruits;
    }

    public boolean isFruitTree() {
        return isFruitTree;
    }

    public Color getColor() {
        return color;
    }

    public int getCountOfFruits() {
        return countOfFruits;
    }

    public void draw(Graphics g, int x, int y, ForestSize forestSize) {
        // Draw logic based on forestSize
        switch (forestSize) {
            case SOUTH:
                // Draw large trees
                g.setColor(getColor());
                g.fillRect(x - 10, y - 20, 20, 40);
                break;
            case MIDDLE:
                // Draw medium-sized trees
                g.setColor(getColor());
                g.fillRect(x - 5, y - 10, 10, 20);
                break;
            case NORTH:
                // Draw small trees
                g.setColor(getColor());
                g.fillRect(x - 2, y - 5, 4, 10);
                break;
        }

        // Draw fruits for fruit trees
        if (isFruitTree) {
            g.setColor(color.brighter()); // Slightly brighter color for fruit trees
            // Draw fruits
            for (int i = 0; i < countOfFruits; i++) {
                g.fillOval(x + i * 5, y - i * 5, 5, 5);
            }
        }
    }
}
