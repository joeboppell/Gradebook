import java.util.ArrayList;

public class Classroom {
    
    public ArrayList<Student> students;
    private String filename;

    public Classroom (String file){
        students = new ArrayList<Student>();
        filename = file;
    }

    public ArrayList<String> createNameList (){
        ArrayList<String> names = FileReader.getStringData(filename);
        for (int i = 0; i<names.size(); i++){
            String current = names.get(i);
            for (int j = 0; j<current.length(); j++){
                if (current.substring(j,j+1).equals(",")){
                    names.set(i, current.substring(0,j));
                }
            }
        }
        return names;
    }

    private ArrayList<String> createGradeList (){
        ArrayList<String> grades = FileReader.getStringData(filename);
        for (int i = 0; i<grades.size(); i++){
            String current = grades.get(i);
            for (int j = 0; j<current.length(); j++){
                if (current.substring(j,j+1).equals(",")){
                    grades.set(i, current.substring(j+1, current.indexOf(":")));
                }
            }
        }
        return grades;
    }

  public ArrayList<String> createGNList(){
    ArrayList<String> grades = FileReader.getStringData(filename);
    for (int i = 0; i<grades.size(); i++){
            String current = grades.get(i);
            for (int j = 0; j<current.length(); j++){
                if (current.substring(j,j+1).equals(":")){
                    grades.set(i, current.substring(j+1, current.length()));
                }
            }
        }
    return grades;
  }

    public ArrayList<Integer> parseIntList(){
      ArrayList<String> ogList = createGNList();
        ArrayList<Integer> newList = new ArrayList<Integer>();
        for (int i = 0; i<ogList.size(); i++){
            String current = ogList.get(i);
            newList.add(Integer.parseInt(current));
        }
        return newList;
    }
    
    public ArrayList<Double> parseDoubleList(){
        ArrayList<String> ogList = createGradeList();
        ArrayList<Double> newList = new ArrayList<Double>();
        for (int i = 0; i<ogList.size(); i++){
            String current = ogList.get(i);
            newList.add(Double.parseDouble(current));
        }
        return newList;
    }

    public void createList(){
        ArrayList<String> names = createNameList();
        ArrayList<Double> grades = parseDoubleList();
        ArrayList<Integer> gradeN = parseIntList();
        for (int i = 0; i<names.size(); i++){
            Student newStudent = new Student(names.get(i), grades.get(i), gradeN.get(i));
            students.add(newStudent);
        }
    }
    public void printList(){
      for (int i = 0; i<students.size(); i++){
        System.out.println(students.get(i).getName());
        System.out.println(students.get(i).getGrade());
      }
    }
    public void getFile(){
      System.out.println(filename);
    }
}
