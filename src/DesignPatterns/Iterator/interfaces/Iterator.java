package DesignPatterns.Iterator.interfaces;

public interface Iterator {
    public boolean hasNext();
    public Object next();
    public Object previous();
    public boolean hasPrevious();
    public void moveToLast();
    public void moveToFirst();


}

