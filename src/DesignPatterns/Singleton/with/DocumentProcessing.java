package DesignPatterns.Singleton.with;

public class DocumentProcessing {
    public static void main(String[] args) {

        // Create instances of document handling classes
        PDFDocument pdfDocument = new PDFDocument();
        WordDocument wordDocument = new WordDocument();
        TextDocument textDocument = new TextDocument();

        // Sample document content
        String pdfContent = "This is a PDF document with correct grammar.";
        String wordContent = "This is a Word document with grammar issues.";
        String textContent = "This is a plain text document without grammar problems.";

        // Process documents
        pdfDocument.processPDF(pdfContent);
        wordDocument.processWord(wordContent);
        textDocument.processText(textContent);
    }
}
