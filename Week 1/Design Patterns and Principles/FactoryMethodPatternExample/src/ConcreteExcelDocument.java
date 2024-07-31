public class ConcreteExcelDocument implements ExcelDocument {

    @Override
    public void open() {
        System.out.println("\nOpening Excel Document...");
    }

    @Override
    public void save() {
        System.out.println("Saving Excel Document...");
    }

    @Override
    public void createChart() {
        System.out.println("Creating chart in Excel Document...");
    }
}
