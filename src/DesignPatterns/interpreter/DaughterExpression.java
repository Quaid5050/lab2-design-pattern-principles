package DesignPatterns.interpreter;
public class DaughterExpression implements Expression {
    private String parentName;
    private String daughterName;

    public DaughterExpression(String parentName, String daughterName) {
        this.parentName = parentName;
        this.daughterName = daughterName;
    }

    @Override
    public boolean interpret(String context) {
        return context.contains(parentName) && context.contains(daughterName);
    }
}