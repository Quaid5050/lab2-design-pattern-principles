package DesignPatterns.src.Singleton.with;

public class GrammerCheck {
    private static GrammerCheck instance;

    private GrammerCheck() {
    }

    public static GrammerCheck getInstance() {
        if (instance == null) {
            instance = new GrammerCheck();
        }
        return instance;
    }

    public boolean check(String text) {
        return text.matches("^[A-Z].*[.]$");
    }
}
