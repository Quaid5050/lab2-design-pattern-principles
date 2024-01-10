package Practice.composite;

//Composite Design Pattern

import java.util.ArrayList;
import java.util.List;

// Component
interface Box {
    void add(Box box);
    void remove(Box box);
    int calculatePrice();
    void print();
}


// Leaf
class ProductBox implements Box {
    private String name;
    private int price;

    public ProductBox(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void add(Box box) {

    }

    @Override
    public void remove(Box box) {

    }

    @Override
    public int calculatePrice() {
        return price;
    }

    @Override
    public void print() {
        System.out.println("Product : " + name + ", Price : " + price);
    }
}

//Leaf 2
class GameBox implements Box {
    private String name;
    private int price;

    public GameBox(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void add(Box box) {

    }

    @Override
    public void remove(Box box) {

    }

    @Override
    public int calculatePrice() {
        return price;
    }

    @Override
    public void print() {
        System.out.println("Game : " + name + ", Price : " + price);
    }
}

//Leaf 3
class ToyBox implements Box {
    private String name;
    private int price;

    public ToyBox(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void add(Box box) {

    }

    @Override
    public void remove(Box box) {

    }

    @Override
    public int calculatePrice() {
        return price;
    }

    @Override
    public void print() {
        System.out.println("Toy : " + name + ", Price : " + price);
    }
}

//Leaf 4
class BookBox implements Box {
    private String name;
    private int price;

    public BookBox(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void add(Box box) {

    }

    @Override
    public void remove(Box box) {

    }

    @Override
    public int calculatePrice() {
        return price;
    }

    @Override
    public void print() {
        System.out.println("Book : " + name + ", Price : " + price);
    }
}

//Composite
class SmallBox implements Box {
    private List<Box> boxes = new ArrayList<>();

    @Override
    public int calculatePrice() {
        int total = 0;
        for (Box box : boxes) {
            total += box.calculatePrice();
        }
        return total;
    }

    @Override
    public void print() {
        for (Box box : boxes) {
            box.print();
        }
    }
    @Override
    public void add(Box box) {
        boxes.add(box);
    }

    @Override
    public void remove(Box box) {
        boxes.remove(box);
    }
}

//Composite 2
class BigBox implements Box {
    private List<Box> boxes = new ArrayList<>();

    @Override
    public int calculatePrice() {
        int total = 0;
        for (Box box : boxes) {
            total += box.calculatePrice();
        }
        return total;
    }

    @Override
    public void print() {
        for (Box box : boxes) {
            box.print();
        }
    }
    @Override
    public void add(Box box) {
        boxes.add(box);
    }
    @Override
    public void remove(Box box) {
        boxes.remove(box);
    }
}


public class CompositeBox {
    public static void main(String[] args) {
        // Leaf
        Box productBox = new ProductBox("Laptop", 1000);
        Box gameBox = new GameBox("PS5", 500);
        Box toyBox = new ToyBox("Lego", 50);
        Box bookBox = new BookBox("Harry Potter", 10);

        // Composite
        Box smallBox = new SmallBox();
        Box bigBox = new BigBox();

        // Composite smallBox leafs
        smallBox.add(productBox);
        smallBox.add(gameBox);

        // Composite bigBox leafs
        bigBox.add(toyBox);
        bigBox.add(bookBox);

        // add the  smallBox into bigBox
        bigBox.add(smallBox);


        //print all boxes
        bigBox.print();



        //print small box price and big box price
        System.out.println("Small Box Price : " + smallBox.calculatePrice());
        System.out.println("Big Box Price : " + bigBox.calculatePrice());
    }
}