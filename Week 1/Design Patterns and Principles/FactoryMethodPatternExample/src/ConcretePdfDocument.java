public class ConcretePdfDocument implements PdfDocument {

    @Override
    public void open() {
        System.out.println("\nOpening PDF Document...");
    }


    @Override
    public void save() {
        System.out.println("Saving PDF Document...");
    }

    @Override
    public void addBookmark() {
        System.out.println("Adding bookmark to PDF Document...");
    }
}
