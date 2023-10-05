package DesignPatterns.ChainOfResponsibility.Loggers.abstractClasses;

public abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    public static int WARNING = 4;

    protected int level;

    //next element in chain or responsibility
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message){
        if(this.level <= level){
            write(message);
        }
        if(nextLogger !=null){
            nextLogger.logMessage(level, message);
        }
    }

    private void printLevel(int level){
        System.out.println("Level: " + level);
    }

    public void activeLogger(int  level, String message){
        if(this.level <= level){
            write(message);
        }
        else if(nextLogger !=null){

            nextLogger.activeLogger(level, message);
        }
        else{
            System.out.println("This feature is not available");
        }
    }
    abstract protected void write(String message);

}