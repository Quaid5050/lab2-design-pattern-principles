package DesignPatterns.Singleton.without;

public class WordDocument {
    public void processWord(String content) {
        // Process the Word document content
        GrammerCheck grammerCheck = new GrammerCheck();
        boolean isGrammarCorrect = grammerCheck.check(content);
        if (isGrammarCorrect) {
            System.out.println("Word document is grammatically correct.");
        } else {
            System.out.println("Word document has grammar issues.");
        }
    }
}
