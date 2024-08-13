package familytree;

import familytree.model.Person;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Person> {
    private List<Person> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.people.add(person);
    }

    public Person findPersonById(int id) {
        for (Person person : people) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public List<Person> getAllChildren(Person person) {
        return person.getChildren();
    }

    public List<Person> getPeople() {
        return people;
    }

    public void inputPersonData() {
        Scanner scanner = new Scanner(System.in);

        int id = promptForInt(scanner, "Enter ID: ");
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        int age = promptForInt(scanner, "Enter Age: ");

        Person newPerson = new Person(id, name, gender, age);

        int spouseId = promptForInt(scanner, "Enter Spouse ID (or -1 if none): ");
        if (spouseId != -1) {
            Person spouse = findPersonById(spouseId);
            if (spouse != null) {
                newPerson.setSpouse(spouse);
                spouse.setSpouse(newPerson);
            }
        }

        int fatherId = promptForInt(scanner, "Enter Father ID (or -1 if unknown): ");
        if (fatherId != -1) {
            Person father = findPersonById(fatherId);
            if (father != null) {
                newPerson.setFather(father);
                father.addChild(newPerson);
            }
        }

        int motherId = promptForInt(scanner, "Enter Mother ID (or -1 if unknown): ");
        if (motherId != -1) {
            Person mother = findPersonById(motherId);
            if (mother != null) {
                newPerson.setMother(mother);
                mother.addChild(newPerson);
            }
        }

        int numberOfChildren = promptForInt(scanner, "Enter number of children: ");
        for (int i = 0; i < numberOfChildren; i++) {
            int childId = promptForInt(scanner, "Enter Child ID: ");
            Person child = findPersonById(childId);
            if (child != null) {
                newPerson.addChild(child);
                if (newPerson.getGender().equalsIgnoreCase("Male")) {
                    child.setFather(newPerson);
                } else {
                    child.setMother(newPerson);
                }
            }
        }

        addPerson(newPerson);
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

    public void displayPersonInfo(int id) {
        Person person = findPersonById(id);
        if (person != null) {
            System.out.println(person);
        } else {
            System.out.println("Person not found.");
        }
    }

    public void displayFamilyTree(int id) {
        Person person = findPersonById(id);
        if (person != null) {
            displayFamilyTree(person, 0);
        } else {
            System.out.println("Person not found.");
        }
    }

    private void displayFamilyTree(Person person, int level) {
        if (person == null) return;

        System.out.println(" ".repeat(level * 4) + person.getName() + " (" + person.getGender() + ", " + person.getAge() + ")");

        if (person.getSpouse() != null) {
            System.out.println(" ".repeat(level * 4) + "  Spouse: " + person.getSpouse().getName() + " (" + person.getSpouse().getGender() + ", " + person.getSpouse().getAge() + ")");
        }

        for (Person child : person.getChildren()) {
            displayFamilyTree(child, level + 1);
        }
    }

    // Реализация интерфейса Iterable
    @Override
    public Iterator<Person> iterator() {
        return people.iterator();
    }

    // Методы сортировки
    public void sortByName() {
        Collections.sort(people, Comparator.comparing(Person::getName));
    }

    public void sortByAge() {
        Collections.sort(people, Comparator.comparingInt(Person::getAge));
    }
}