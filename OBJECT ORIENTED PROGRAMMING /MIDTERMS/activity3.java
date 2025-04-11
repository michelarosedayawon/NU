import java.util.Scanner;

public class activity3 {
    private double num1;
    private double num2;
    private boolean isSecretUnlocked = false;
    private final String secret_op = "1234";

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public double add() {
        return num1 + num2;
    }

    public double subtract() {
        return num1 - num2;
    }

    public double multiply() {
        return num1 * num2;
    }

    public double divide() {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return num1 / num2;
    }

    public double power() {
        if (isSecretUnlocked) {
            return Math.pow(num1, num2);
        } else {
            throw new SecurityException("Access to secret operation denied.");
        }
    }

    public void unlockSecret(String passcode) {
        if (secret_op.equals(passcode)) {
            isSecretUnlocked = true;
        }
    }

    public boolean isSecretFeatureUnlocked() {
        return isSecretUnlocked;
    }

    public static void main(String[] args) {
        Scanner pherecebells = new Scanner(System.in);
        activity3 calc = new activity3();

        System.out.print("Enter the passcode to unlock the secret operation: ");
        String inputPasscode = pherecebells.next();
        calc.unlockSecret(inputPasscode);

        if (!calc.isSecretFeatureUnlocked()) {
            System.out.println("Access Denied. We are proceeding with basic operations only.");
        }

        int choice = 0;
        boolean validOperation = false;

        while (!validOperation) {
            System.out.println("\nChoose an operation:");
            System.out.println("1 - Add");
            System.out.println("2 - Subtract");
            System.out.println("3 - Multiply");
            System.out.println("4 - Divide");

            if (calc.isSecretFeatureUnlocked()) {
                System.out.println("5 - Power (Power Operation)");
            }

            System.out.print("Enter your choice: ");
            if (pherecebells.hasNextInt()) {
                choice = pherecebells.nextInt();
                if (!calc.isSecretFeatureUnlocked() && choice == 5) {
                    System.out.println("Invalid choice. Secret operations are locked.");
                } else if (choice >= 1 && choice <= 5) {
                    validOperation = true;
                } else {
                    System.out.println("Invalid choice. Please choose a valid operation.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                pherecebells.next();
            }
        }

        double num1 = 0;
        boolean validNum1 = false;
        while (!validNum1) {
            System.out.print("Enter first number: ");
            if (pherecebells.hasNextDouble()) {
                num1 = pherecebells.nextDouble();
                calc.setNum1(num1);
                validNum1 = true;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                pherecebells.next();
            }
        }

        double num2 = 0;
        boolean validNum2 = false;
        while (!validNum2) {
            System.out.print("Enter second number: ");
            if (pherecebells.hasNextDouble()) {
                num2 = pherecebells.nextDouble();
                calc.setNum2(num2);
                validNum2 = true;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                pherecebells.next();
            }
        }

        try {
            double result;
            switch (choice) {
                case 1:
                    result = calc.add();
                    System.out.println("Result: " + result);
                    break;
                case 2:
                    result = calc.subtract();
                    System.out.println("Result: " + result);
                    break;
                case 3:
                    result = calc.multiply();
                    System.out.println("Result: " + result);
                    break;
                case 4:
                    result = calc.divide();
                    System.out.println("Result: " + result);
                    break;
                case 5:
                    if (calc.isSecretFeatureUnlocked()) {
                        result = calc.power();
                        System.out.println("Result of " + num1 + "^" + num2 + " = " + result);
                    } else {
                        System.out.println("Secret feature is not unlocked yet.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        pherecebells.close();
    }
}