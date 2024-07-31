public class ConcreteWordDocument implements WordDocument {

    @Override
    public void open() {
        System.out.println("\nOpening Word Document...");
    }

    @Override
    public void save() {
        System.out.println("Saving Word Document...");
    }

    @Override
    public void formatText() {
        System.out.println("Formatting text in Word Document...");
    }
}
