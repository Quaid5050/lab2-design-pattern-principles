package DesignPatterns.Singleton.without;

public class TextDocument {
    public void processText(String content) {
        // Process the text document content
        GrammerCheck grammerCheck = new GrammerCheck();
        boolean isGrammarCorrect = grammerCheck.check(content);
        if (isGrammarCorrect) {
            System.out.println("Text document is grammatically correct.");
        } else {
            System.out.println("Text document has grammar issues.");
        }
    }
}
