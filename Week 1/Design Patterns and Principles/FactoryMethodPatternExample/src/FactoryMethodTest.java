public class FactoryMethodTest {
    public static void main(String[] args) {

        // Creating Word Document
        DocumentFactory wordFactory = new WordDocumentFactory();
        WordDocument wordDoc = (WordDocument) wordFactory.createDocument();
        wordDoc.open();
        wordDoc.save();
        wordDoc.formatText();

        // Creating PDF Document
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        PdfDocument pdfDoc = (PdfDocument) pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.save();
        pdfDoc.addBookmark();

        // Creating Excel Document
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        ExcelDocument excelDoc = (ExcelDocument) excelFactory.createDocument();
        excelDoc.open();
        excelDoc.save();
        excelDoc.createChart();
    }
}
