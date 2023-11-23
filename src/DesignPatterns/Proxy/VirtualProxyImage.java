package DesignPatterns.Proxy;
// Modify VirtualProxyImage class
public class VirtualProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public VirtualProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            if (fileName.endsWith(".jpg") || fileName.endsWith(".png")) {
                realImage = new RealImage(fileName);
            } else {
                // Display a fake image for unsupported types
                System.out.println("Unsupported image type. Displaying placeholder image.");
                System.out.println("[Fake Image: " + fileName + "]");
            }
        }
        if (realImage != null) {
            realImage.display();
        }
    }
}
