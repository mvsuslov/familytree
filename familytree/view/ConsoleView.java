package familytree.view;

import java.util.Scanner;

public class ConsoleView implements FamilyTreeView {
    private Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int getUserInput() {
        return scanner.nextInt();
    }

    @Override
    public String getMemberInput() {
        return scanner.next();
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayMemberInfo(String info) {
        System.out.println("Member Info: " + info);
    }

    @Override
    public void displayFamilyTree(String tree) {
        System.out.println("Family Tree:\n" + tree);
    }
}
