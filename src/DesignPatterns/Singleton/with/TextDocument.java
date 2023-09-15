package DesignPatterns.Singleton.with;

public class TextDocument {
    private GrammarCheck grammarCheck;

    public TextDocument() {
        this.grammarCheck = GrammarCheck.getInstance();
    }

    public void processText(String content) {
        // Process the text document content
        boolean isGrammarCorrect = grammarCheck.check(content);
        if (isGrammarCorrect) {
            System.out.println("Text document is grammatically correct.");
        } else {
            System.out.println("Text document has grammar issues.");
        }
    }
}
