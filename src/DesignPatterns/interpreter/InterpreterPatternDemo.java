package DesignPatterns.interpreter;

public class InterpreterPatternDemo {

    //Rule: Robert and John are male
    public static Expression getMaleExpression(){
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        return new OrExpression(robert, john);
    }

    //Rule: Julie is a married women
    public static Expression getMarriedWomanExpression(){
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }

    // New rule: Stuart is a son of Robert
    public static Expression getSonExpression() {
        return new SonExpression("Robert", "Stuart");
    }

    // New rule: Samantha is a daughter of Julie
    public static Expression getDaughterExpression() {
        return new DaughterExpression("Julie", "Samantha");
    }

    public static void main(String[] args) {
        Expression isMale = getMaleExpression();
        Expression isMarriedWoman = getMarriedWomanExpression();
        Expression isSon = getSonExpression();
        Expression isDaughter = getDaughterExpression();

        System.out.println("John is male? " + isMale.interpret("John"));
        System.out.println("Julie is a married women? " + isMarriedWoman.interpret("Married Julie"));

        System.out.println("Stuart is a son of Robert? " + isSon.interpret("Stuart is a son of Robert"));
        System.out.println("Samantha is a daughter of Julie? " + isDaughter.interpret("Samantha is a daughter of Julie"));
    }
}