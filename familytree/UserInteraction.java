package familytree;

import java.util.Scanner;

public class UserInteraction<T extends FamilyMember> {
    private FamilyTree<T> familyTree;
    private Scanner scanner;

    public UserInteraction(FamilyTree<T> familyTree) {
        this.familyTree = familyTree;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            printMenu();
            int choice = promptForInt("Choose an option: ");

            switch (choice) {
                case 1:
                    familyTree.inputMemberData();
                    break;
                case 2:
                    int id = promptForInt("Enter ID of member to find and display: ");
                    familyTree.displayMemberInfo(id);
                    break;
                case 3:
                    int treeId = promptForInt("Enter ID of member to display family tree: ");
                    familyTree.displayFamilyTree(treeId);
                    break;
                case 4:
                    familyTree.sortByName();
                    System.out.println("Members sorted by name.");
                    break;
                case 5:
                    familyTree.sortByAge();
                    System.out.println("Members sorted by age.");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void printMenu() {
        System.out.println("1. Add Member");
        System.out.println("2. Find and Display Member by ID");
        System.out.println("3. Display Family Tree by ID");
        System.out.println("4. Sort Members by Name");
        System.out.println("5. Sort Members by Age");
        System.out.println("6. Exit");
    }

    private int promptForInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear invalid input
            }
        }
    }
}
