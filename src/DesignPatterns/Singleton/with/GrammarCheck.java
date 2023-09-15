package DesignPatterns.Singleton.with;

public class GrammarCheck {
    private static GrammarCheck instance = null;

    private GrammarCheck() {
    }

    public static GrammarCheck getInstance() {
        if (instance == null) {
            instance = new GrammarCheck();
        }
        return instance;
    }

    public boolean check(String sentence) {
        return sentence.contains(" ");
    }
}
