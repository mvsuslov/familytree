package familytree.service;

import familytree.model.FamilyTree;
import familytree.model.FileHandler;
import familytree.model.Person;

public class FamilyTreeService {
    private FamilyTree<Person> tree;
    private FileHandler<Person> fileHandler;

    public FamilyTreeService() {
        this.tree = new FamilyTree<>();
        this.fileHandler = new FileHandler<>();
    }

    public void addMember(int id, String name, String gender, int age) {
        Person member = new Person(id, name, gender, age);
        tree.addMember(member);
    }

    public Person findMemberById(int id) {
        return tree.findMemberById(id);
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sortByAge() {
        tree.sortByAge();
    }

    public void saveTree(String filename) {
        fileHandler.saveToFile(filename, tree);
    }

    public void loadTree(String filename) {
        this.tree = fileHandler.loadFromFile(filename);
    }

    public void establishRelationship(int parentId, int childId) {
        Person parent = findMemberById(parentId);
        Person child = findMemberById(childId);
        if (parent != null && child != null) {
            tree.establishRelationship(parent, child);
        }
    }

    public FamilyTree<Person> getTree() {
        return tree;
    }
}
