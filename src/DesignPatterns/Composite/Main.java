package DesignPatterns.Composite;


import java.util.ArrayList;
import java.util.List;

interface IEmployees {
    public void giveBonus(int bonus);
}

class BaseEmployee implements IEmployees {
    private String name;
    private int salary;

    // constructor
    public BaseEmployee(String name, int sal) {
        this.name = name;
        this.salary = sal;
    }

    public void giveBonus(int bonus) {
        this.salary += bonus;
    }

    public String toString(){
        return ("Employee :[ Name : " + name + ",salary :" + salary+" ]");
    }
}

class Director extends BaseEmployee {
    private List<IEmployees> subordinates;

    // constructor
    public Director(String name, int sal) {
        super(name, sal);
        subordinates = new ArrayList<IEmployees>();
    }

    public void add(IEmployees e) {
        subordinates.add(e);
    }

    public void remove(IEmployees e) {
        subordinates.remove(e);
    }

    public List<IEmployees> getSubordinates(){
        return subordinates;
    }

    public String toString(){
        return ("Director :[ Name : " + super.toString());
    }
}


class Hod extends BaseEmployee {
    private String dept;
    private List<IEmployees> subordinates;

    // constructor
    public Hod(String name, int sal, String dept) {
        super(name, sal);
        this.dept = dept;
        subordinates = new ArrayList<IEmployees>();
    }

    public void add(IEmployees e) {
        subordinates.add(e);
    }

    public void remove(IEmployees e) {
        subordinates.remove(e);
    }

    public List<IEmployees> getSubordinates(){
        return subordinates;
    }

    public String toString(){
        return ("Hod :[ Name : " + super.toString() + ", dept : " + dept + " ]");
    }
}


class Doo extends BaseEmployee {
    private String dept;

    // constructor
    public Doo(String name, int sal, String dept) {
        super(name, sal);
        this.dept = dept;
    }

    public String toString(){
        return ("Doo :[ Name : " + super.toString() + ", dept : " + dept + " ]");
    }
}

class Teacher extends BaseEmployee {
    private String qualification;
    private Boolean isAvaliable;

    // constructor
    public Teacher(String name, int sal, String qualification, Boolean isAvaliable) {
        super(name, sal);
        this.qualification = qualification;
        this.isAvaliable = isAvaliable;
    }

    public String toString(){
        return ("Teacher :[ Name : " + super.toString() + ", qualification : " + qualification + ", isAvaliable : " + isAvaliable + " ]");
    }
}


class EmployeesController {
    //IEmployees interface composed in the generateOrganization method

}
public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");

  }
}
