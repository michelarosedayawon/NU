import java.util.Scanner;

class Character {
    private String name;
    private String classType;
    private int level;

    public Character(String name, String classType, int level) {
        this.name = name;
        this.classType = classType;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getClassType() {
        return classType;
    }

    public int getLevel() {
        return level;
    }

    public void levelUp() {
        level++;
        System.out.println("Congratulations! " + name + " has leveled up to level " + level + "!");
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Class: " + classType);
        System.out.println("Level: " + level);
    }
}

public class activity2 {
    public static void main(String[] args) {
    Scanner mr = new Scanner(System.in);

    System.out.print("Enter character name: ");
    String name = mr.nextLine();

    String classType;
        while (true) {
    System.out.print("Enter class type (Warrior/Mage/Archer): ");
        classType = mr.nextLine();
        if (classType.equalsIgnoreCase("Warrior") || classType.equalsIgnoreCase("Mage") || classType.equalsIgnoreCase("Archer")) {
        break;
        } else {
    System.out.println("Invalid class type. Please enter either Warrior, Mage, or Archer.");
    }
}

        int level = 0;
        while (true) {
        System.out.print("Enter Initial level: ");
        if (mr.hasNextInt()) {
            level = mr.nextInt();
        if (level > 0) {
        break;
        } else {
        System.out.println("Level must be a positive integer. Please try again.");
            }
        } else {
        System.out.println("Invalid input. Please enter a valid integer for level.");
        mr.next();
            }
        }

        Character character = new Character(name, classType, level);
        System.out.println("\nCharacter Created!");
        character.displayInfo();

        mr.nextLine(); 
        String response;
        while (true) {
        System.out.print("Do you want to level up your character? (yes/no): ");
        response = mr.nextLine();
        if (response.equalsIgnoreCase("yes")) {
            character.levelUp();
            System.out.println("");
            System.out.println("Updated Character Info:");
            character.displayInfo();
        break;
        } else if (response.equalsIgnoreCase("no")) {
        System.out.println("Character has not leveled up.");
            break;
            } else {
        System.out.println("Invalid response. Please enter 'yes' or 'no'.");
            }
        }

        mr.close();
    }
}
