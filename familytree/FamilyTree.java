package familytree;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends FamilyMember> implements Serializable, Iterable<T> {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T member) {
        this.members.add(member);
    }

    public T findMemberById(int id) {
        for (T member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    public List<T> getAllChildren(T member) {
        return member.getChildren();
    }

    public List<T> getMembers() {
        return members;
    }

    public void inputMemberData() {
        Scanner scanner = new Scanner(System.in);

        int id = promptForInt(scanner, "Enter ID: ");
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        int age = promptForInt(scanner, "Enter Age: ");

        T newMember = (T) new Person(id, name, gender, age);

        addMember(newMember);
    }

    private int promptForInt(Scanner scanner, String prompt) {
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

    public void displayMemberInfo(int id) {
        T member = findMemberById(id);
        if (member != null) {
            System.out.println(member);
        } else {
            System.out.println("Member not found.");
        }
    }

    public void displayFamilyTree(int id) {
        T member = findMemberById(id);
        if (member != null) {
            displayFamilyTree(member, 0);
        } else {
            System.out.println("Member not found.");
        }
    }

    private void displayFamilyTree(T member, int level) {
        if (member == null) return;

        System.out.println(" ".repeat(level * 4) + member.getName() + " (" + member.getGender() + ", " + member.getAge() + ")");

        if (member.getSpouse() != null) {
            System.out.println(" ".repeat(level * 4) + "  Spouse: " + member.getSpouse().getName() + " (" + member.getSpouse().getGender() + ", " + member.getSpouse().getAge() + ")");
        }

        for (T child : member.getChildren()) {
            displayFamilyTree(child, level + 1);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }

    public void sortByName() {
        Collections.sort(members, Comparator.comparing(FamilyMember::getName));
    }

    public void sortByAge() {
        Collections.sort(members, Comparator.comparingInt(FamilyMember::getAge));
    }
}
