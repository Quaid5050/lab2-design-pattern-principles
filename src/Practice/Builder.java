
/*
   Builder Pattern: Creation Pattern

    Intent:
    Separate the construction of a complex object from its representation so that the same construction
    process can create different representations.

    Participants:
    Builder
        ❍ specifies an abstract interface for creating parts of a Product object.
    ConcreteBuilder
        ❍ constructs and assembles parts of the product by implementing the Builder interface.
        ❍ defines and keeps track of the representation it creates.
        ❍ provides an interface for retrieving the product.
    Director
        ❍ constructs an object using the Builder interface.
    Product
        ❍ represents the complex object under construction. ConcreteBuilder builds the product’s internal
        representation and defines the process by which it’s assembled.
        ❍ includes classes that define the constituent parts, including interfaces for assembling the parts
        into the final result.

    Collaborations:
    The client creates the Director object and configures it with the desired Builder object.
    Director notifies the builder whenever a part of the product should be built.
    Builder handles requests from the director and adds parts to the product.
    The client retrieves the product from the builder.

 */
interface Builder {
    void buildPartA();
    void buildPartB();
    void buildPartC();
    Product getResult();

}

class ConcreteBuilder implements Builder {
    private final Product product;

    public ConcreteBuilder() {
        this.product = new Product();
    }

    @Override
    public void buildPartA() {
        product.setPartA("Part A");
    }

    @Override
    public void buildPartB() {
        product.setPartB("Part B");
    }

    @Override
    public void buildPartC() {
        product.setPartC("Part C");
    }

    @Override
    public Product getResult() {
        return product;
    }
}

class Product {
    private String partA;
    private String partB;
    private String partC;

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public void printParts() {
        System.out.println("Part A: " + partA);
        System.out.println("Part B: " + partB);
        System.out.println("Part C: " + partC);
    }
}


class Director {
    public void construct(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
    }
}

class BuilderPatternClient {
    public static void main(String[] args) {
        Director director = new Director();
        Builder builder = new ConcreteBuilder();

        director.construct(builder);

        Product product = builder.getResult();
        product.printParts();
    }
}
