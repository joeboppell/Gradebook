import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    
    private String name;
    private double gradeNum;
    private int grade;

    public Student (String n, double gn, int g) {
        name = n;
        gradeNum = gn;
        grade = g;
    }

    public void setName (String nombre){
        name = nombre;
    }

    public void setGradeNum (double gr){
        gradeNum = gr;
    }

    public void setGrade (int gra) {
        grade = gra;
    }

  public String getName (){
    return name;
  }

  public double getGrade(){
    return gradeNum;
  }

  public int getGradeNum(){
    return grade;
  }
}
