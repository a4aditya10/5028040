public class RealImage implements Image {
    private String file;

    public RealImage(String file) {
        this.file = file;
        loadImageFromServer();
    }

    private void loadImageFromServer() {
        System.out.println("Loading image: " + file);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + file+"\n");
    }
}
