package Midterm_Exam.source_code;

class Student {
    private int regNo;
    private String name;
    private String discipline;
    private int semester;

    public Student(int regNo, String name, String discipline, int semester) {
        this.regNo = regNo;
        this.name = name;
        this.discipline = discipline;
        this.semester = semester;
    }

    public int getRegNo() {
        return regNo;
    }

    public String getName() {
        return name;
    }

    public String getDiscipline() {
        return discipline;
    }

    public int getSemester() {
        return semester;
    }
}