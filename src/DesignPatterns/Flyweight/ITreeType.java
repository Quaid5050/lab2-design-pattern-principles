package DesignPatterns.Flyweight;

import java.awt.Color;
import java.awt.Graphics;

public interface ITreeType {
    boolean isFruitTree();
    Color getColor();
    int getCountOfFruits();
    void draw(Graphics g, int x, int y, ForestSize forestSize);
}
