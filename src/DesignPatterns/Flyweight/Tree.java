package DesignPatterns.Flyweight;


import java.awt.Graphics;

public class Tree {
    private int x;
    private int y;
    private ITreeType type;
    private ForestSize forestSize;

    public Tree(int x, int y, ITreeType type, ForestSize forestSize) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.forestSize = forestSize;
    }

    public void draw(Graphics g) {
        type.draw(g, x, y, forestSize);
    }
}
