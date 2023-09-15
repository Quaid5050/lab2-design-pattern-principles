package DesignPatterns.Singleton.without;

public class PDFDocument {
    public void processPDF(String content) {
        // Process the PDF document content
        GrammerCheck grammerCheck = new GrammerCheck();
        boolean isGrammarCorrect = grammerCheck.check(content);
        if (isGrammarCorrect) {
            System.out.println("PDF document is grammatically correct.");
        } else {
            System.out.println("PDF document has grammar issues.");
        }
    }
}
