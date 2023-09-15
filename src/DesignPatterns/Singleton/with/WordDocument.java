package DesignPatterns.Singleton.with;

public class WordDocument {
    private GrammarCheck grammarCheck;

    public WordDocument() {
        this.grammarCheck = GrammarCheck.getInstance();
    }

    public void processWord(String content) {
        // Process the Word document content
        boolean isGrammarCorrect = grammarCheck.check(content);
        if (isGrammarCorrect) {
            System.out.println("Word document is grammatically correct.");
        } else {
            System.out.println("Word document has grammar issues.");
        }
    }
}
