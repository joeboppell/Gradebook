import java.util.ArrayList;
import java.util.Scanner;
public class ClassData extends Classroom {
  
  public ClassData(String filename){
    super(filename);
    super.createList();
  }

  public void programInput(){
    Scanner input = new Scanner(System.in);
    System.out.println("\n\nWelcome to the classroom analyzer, aka hood lobotomy simulator!");
    System.out.println("\nPress the given number to get the subsequent analysis of your classroom.\n");
    System.out.println("1. Max Grade\n2. Min Grade\n3. Max By Grade Level\n4. Class Ranking List\n5. Change Student Grade\n6. Get Student Grade\n0. Quit\n");
    int choice = input.nextInt();

    if (choice == 1){
        System.out.println(max());
        int choice1 = keepGoing();
        if (choice1 == 1){
          programInput();
        }
    }
    else if (choice == 2){
        System.out.println(min());
        int choice2 = keepGoing();
        if (choice2 == 1){
          programInput();
        }
    }
    else if (choice == 3){
        System.out.println(maxByGrade());
        int choice3 = keepGoing();
        if (choice3 == 1){
          programInput();
        }
    }
    else if (choice == 4){
        System.out.println(classRank());
        int choice4 = keepGoing();
        if (choice4 == 1){
          programInput();
        }
    }
    else if (choice == 5){
      System.out.println("What is the student's first name?\n");
      String firstName = input.next();
      System.out.println("What is the student's last name?");
      String lastName = input.next();
      System.out.println("What is the student's grade level?\n");
      int gradeLevel = input.nextInt();
      System.out.println("What is the student's new grade?\n");
      double gradeN = input.nextDouble();
      changeStuff(firstName + " " + lastName, gradeN, gradeLevel);
      System.out.println("Done!");
      int choice5 = keepGoing();
        if (choice5 == 1){
          programInput();
        }
    }
    else if (choice == 6){
      System.out.println("What is the student's first name?\n");
      String firstN = input.next();
      System.out.println("What is the student's last name?");
      String lastN = input.next();
      System.out.println("\n" + accessStudent(firstN + " " + lastN));
      int choice6 = keepGoing();
        if (choice6 == 1){
          programInput();
        }
    }
    input.close();
  }

  public int keepGoing(){
    Scanner input = new Scanner(System.in);
    System.out.println("Would you like to keep going? Press 1 for yes, anything else for no.");
    int result = input.nextInt();
    return result;
  }
  
  public void changeStuff(String name, double studentGrade, int gradeLevel){
    for (int i = 0; i<students.size(); i++){
        if (students.get(i).getName().equals(name)){
            Student studentNew = new Student(name, studentGrade, gradeLevel);
            students.set(i, studentNew);
        }
    }
  }

  public String accessStudent(String name){
    String result = "";
    for (int i = 0; i<students.size(); i++){
      Student current = students.get(i);
      if (current.getName().equals(name)){
        result = "Grade Level: " + current.getGradeNum() + "\nGrade: " + current.getGrade();
      }
    }
    return result;
  }
  
  public String avgGrade(){
    double total = 0.0;
    for (int i = 0; i < students.size(); i++){
      double current = students.get(i).getGrade();
      total += current;
    }
    return "Average grade among all students: " + total/students.size();
  }

  public String max(){
    double max = 0.0;
    String name = "";
    for (int i = 0; i<students.size(); i++){
      if (students.get(i).getGrade()>max){
        max = students.get(i).getGrade();
        name = students.get(i).getName();
      }
    }
    return "Student with the highest grade: " + name + " " + max;
  }

  public String min(){
    double min = students.get(0).getGrade();
    String name = "";
    for (int i = 0; i<students.size(); i++){
      if (students.get(i).getGrade()<min){
        min = students.get(i).getGrade();
        name = students.get(i).getName();
      }
    }
    return "Student with the lowest grade: " + name + " " + min;
  }

  public String maxByGrade (){
    double max = 0.0;
    String names = "";
    for (int g = 9; g<=12; g++){
      max = 0.0;
      String newName = "";
      for (int i = 0; i<students.size(); i++){
        Student current = students.get(i);
        if (current.getGradeNum() == g && current.getGrade() > max){
          max = current.getGrade();
          newName = g + "th Grade. " + current.getName() + " - " + max + "\n";
        }
      }
        names += newName;
    }
    return "Highest grades by grade level: \n\n" + names;
  }
  
  private ArrayList<Student> sortStudents(){
    ArrayList<Student> newStudents = students;
    for (int index = 0; index < newStudents.size() - 1; index++){
      int current = index;
      for (int next = index + 1; next<newStudents.size(); next++){
        Student him = newStudents.get(next);
        Student heem = newStudents.get(current);
        if (him.getGrade()>heem.getGrade()){
          current = next;
        }
      }
      Student temp = newStudents.get(current);
      newStudents.set(current, newStudents.get(index));
      newStudents.set(index, temp);
    }
    return newStudents;
  }

  public String classRank(){
    ArrayList<Student> newStudents = sortStudents();
    String result = "";
    for (int i = 0; i<newStudents.size(); i++){
      result += (i+1) + ". " + newStudents.get(i).getName() + " - " + newStudents.get(i).getGrade() + "\n";
    }
    return result;
  }
}