public class Test {
    public static void main(String[] args) {

        // ProxyImage instances for different images
        Image image1 = new ProxyImage("cat.jpg");
        Image image2 = new ProxyImage("forest.jpg");

        // Display images
        // Image will be loaded from server only when display() is called
        image1.display();  // Loading and displaying
        image2.display();  // Loading and displaying

        image1.display();  // Loading does not occur here (cached)
    }
}
