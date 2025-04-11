/* Steps to Follow:
Create a Student class with the following attributes: name, age, program, year level, course,
Add a method named displayStudentInfo() to print the student's details.

In the main method:
  Create an object of the Student class.

  Assign values to the attributes.

  Call displayStudentInfo() to print the student's details.
*/ 

class Student {
  String name;
  int age;
  String program;
  int yearLevel;
  String course;

  void displayStudentInfo() {
    System.out.println("----------------------------------------------------------------------------------------");
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Program: " + program);
    System.out.println("Year Level: " + yearLevel);
    System.out.println("Course: " + course);
    System.out.println("----------------------------------------------------------------------------------------");
  }
}

public class activity1 {
  public static void main(String[] args) {
    Student student = new Student();
    student.name = "Michela Rose Dayawon";
    student.age = 18;
    student.program = "Bachelor of Science in Computer Science with Specialization in Machine Learning";
    student.yearLevel = 1;
    student.course = "CCOBJPGL";
    student.displayStudentInfo();
  }
}