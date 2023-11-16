package Midterm_Exam.source_code;

// Computer class representing individual computers
class Computer {
    private int computerNo;
    private String os;
    private String tools;

    public Computer(int computerNo, String os, String tools) {
        this.computerNo = computerNo;
        this.os = os;
        this.tools = tools;
    }

    public int getComputerNo() {
        return computerNo;
    }

    public String getOs() {
        return os;
    }

    public String getTools() {
        return tools;
    }

    public void setTools(String tools) {
        this.tools = tools;
    }

}