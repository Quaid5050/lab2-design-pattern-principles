package DesignPatterns.Flyweight;

import java.awt.Color;
import java.awt.Graphics;

public interface ITreeType {
    void draw(Graphics g, int x, int y, ForestSize forestSize);
    boolean isFruitTree();
    Color getColor();
    int getCountOfFruits();
}
