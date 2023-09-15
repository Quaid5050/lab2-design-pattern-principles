package DesignPatterns.Singleton.with;


public class PDFDocument {
    private GrammarCheck grammarCheck;

    public PDFDocument() {
        this.grammarCheck = GrammarCheck.getInstance();
    }

    public void processPDF(String content) {
        // Process the PDF document content
        boolean isGrammarCorrect = grammarCheck.check(content);
        if (isGrammarCorrect) {
            System.out.println("PDF document is grammatically correct.");
        } else {
            System.out.println("PDF document has grammar issues.");
        }
    }
}
