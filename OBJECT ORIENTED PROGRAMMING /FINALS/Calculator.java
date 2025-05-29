import java.util.Scanner;

abstract class Functions {
  double num1, num2;

  Functions(double num1, double num2) {
    this.num1 = num1;
    this.num2 = num2;
  }
  abstract double operate();
}

class Add extends Functions {
  Add(double num1, double num2) {   
    super(num1, num2);         
  }

  double operate() {
    return num1 + num2;
  }
}

class Subs extends Functions { 
  Subs(double num1, double num2) {
    super(num1, num2);
  }

  double operate() {
    return num1 - num2;
  }
}

class Mul extends Functions {
  Mul(double num1, double num2) {
    super(num1, num2);
  }

  double operate() {
    return num1 * num2;
  }
}

class Div extends Functions {
  Div(double num1, double num2) {
    super(num1, num2);
  }

  double operate() {
    if (num2 == 0) {
      System.out.println("Cannot divide by 0");
      return Double.NaN; 
    }
    return num1 /num2; 
  }
}

public class Calculator {
  public static void main(String[] args) {
      Scanner moshmosh = new Scanner(System.in);
      boolean run = true;  

      while (run) {
        System.out.println("_____________________________________");
        System.out.println("======== C A L C U L A T O R ========");
        System.out.println("_____________________________________");
        System.out.println("");
        System.out.println("OPERATIONS:");
        System.out.println("[1] Addition");
        System.out.println("[2] Subtraction");
        System.out.println("[3] Multiplication");
        System.out.println("[4] Division");
        System.out.println("[5] Exit");
        System.out.println("");
        System.out.print("CHOOSE AN OPERATION: ");
        int choice = moshmosh.nextInt(); 

        if (choice == 5) {
          run = false;
          System.out.println("_____________________________________");
          System.out.println("THANK YOU FOR USING MY CALCULATOR!");
          System.out.println("_____________________________________");
          break;
        }
        System.out.print("Enter first number: ");
        double num1 = moshmosh.nextDouble();
        System.out.print("Enter second numebr: ");
        double num2 = moshmosh.nextDouble();

        Functions op;

        switch (choice) { 
          case 1:
            op = new Add (num1, num2);
            break;
          case 2:
            op = new Subs (num1, num2);
            break;
          case 3:
            op = new Mul (num1, num2);
            break;  
          case 4:
          op = new Div (num1, num2);
            break;
          default:
            System.out.println("Invalid choice. Try again..");
            continue;
        }
        System.out.println("Result: " + op.operate());
      }
  }
}