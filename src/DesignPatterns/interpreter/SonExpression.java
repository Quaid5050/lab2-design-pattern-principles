package DesignPatterns.interpreter;

public class SonExpression implements Expression {
    private String parentName;
    private String sonName;

    public SonExpression(String parentName, String sonName) {
        this.parentName = parentName;
        this.sonName = sonName;
    }

    @Override
    public boolean interpret(String context) {
        return context.contains(parentName) && context.contains(sonName);
    }
}
