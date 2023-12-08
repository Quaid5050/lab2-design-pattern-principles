package DesignPatterns.Flyweight;

import java.awt.Color;
import java.awt.Graphics;

public class BasicTreeType implements ITreeType {
   Color color;
    public BasicTreeType(Color color) {
        this.color = color;
    }

    @Override
    public boolean isFruitTree() {
        return false; // Override for fruit tree check
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public int getCountOfFruits() {
        return 0; // Override for count of fruits
    }

    @Override
    public void draw(Graphics g, int x, int y, ForestSize forestSize) {
        // Implement draw logic based on forestSize for varying tree sizes
        // Existing draw logic
    }
}
