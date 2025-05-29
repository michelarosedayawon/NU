import java.util.Scanner;
abstract class Edadz {
  int age;

  Edadz(int age) {
    this.age = age;
  }

  abstract void displayInfo();
}


class Agee extends Edadz { 
  Agee(int age) { 
    super(age); 
  }

  @Override
  void displayInfo() {
    if (2 % age == 0) {
      System.out.println("This age " + age + " is Even");

    }else {
      System.out.println("This  age " + age + " is Odd");
    }
  }
}

class AgeRange extends Edadz {
  AgeRange(int age) {
    super(age);
  }

  @Override
  void displayInfo() {
    if (age >= 0 && age <= 12) {
      System.out.println("This age " + age + " is a Child");
    } else if (age >= 13 && age <= 17) {
      System.out.println("This age " + age + " is a Teenager");
    } else if ( age >= 18) {
      System.out.println("this age " + age + " in an Adult");
    }
  }
}

public class AgeeSys {
  public static void main(String[] args) {
    Scanner moshmosh = new Scanner(System.in);
    boolean runRun = true;


    while (runRun) {
      System.out.println("_____________________________________________");
      System.out.println("");
      System.out.println("===== WELCOME TO AGE DIRECTORY PROGRAM =====");
      System.out.println("");
      System.out.print("Enter your age: ");
      int age = moshmosh.nextInt();

      System.out.println("");
      Agee ageChckr = new Agee(age);
      AgeRange ageRng = new AgeRange(age);

      ageChckr.displayInfo();
      ageRng.displayInfo();
      System.out.println("_____________________________________________");
      System.out.println("");
      System.out.println("Do you want to exit? (yes/no): ");
      String answer = moshmosh.next();
        if(answer.equalsIgnoreCase("yes")) {
          System.out.println("");
          System.out.println("_____________________________________________");
          System.out.println("");
          System.out.println("End. Thank you for using this program!");
          System.out.println("_____________________________________________");
          runRun = false;
        } else if(!answer.equalsIgnoreCase("no")) {
          System.out.println("Invalid input");
        }
          System.out.println();

    }
  }
}

