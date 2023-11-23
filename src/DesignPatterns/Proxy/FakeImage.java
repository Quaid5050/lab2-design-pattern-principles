package DesignPatterns.Proxy;

public class FakeImage implements Image {
    private String fileName;

    public FakeImage(String fileName){
        this.fileName = fileName;
    }

    public void display(){
        System.out.println("Displaying " + fileName);
    }

}
