package DesignPatterns.Flyweight;

import java.awt.Color;
import java.awt.Graphics;

public class FruitTreeDecorator implements ITreeType {
    private TreeType decoratedTreeType;

    public FruitTreeDecorator(TreeType decoratedTreeType) {
        this.decoratedTreeType = decoratedTreeType;
    }

    @Override
    public boolean isFruitTree() {
        return true; // Override for fruit tree check
    }

    @Override
    public Color getColor() {
        // Adjust color for fruit trees
        return decoratedTreeType.getColor().brighter(); // Example: Slightly brighter color
    }

    @Override
    public int getCountOfFruits() {
        return 10; // Example: Set the count of fruits for decoration
    }

    @Override
    public void draw(Graphics g, int x, int y, ForestSize forestSize) {
        decoratedTreeType.draw(g, x, y, forestSize);
        // Additional decorations for fruit trees
        // Example: Draw fruits on the tree
        g.setColor(getColor());
        for (int i = 0; i < getCountOfFruits(); i++) {
            g.fillOval(x + i * 5, y - i * 5, 5, 5);
        }
    }
}
