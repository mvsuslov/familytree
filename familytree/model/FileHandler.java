package familytree.model;

import java.io.*;
import java.util.List;

public class FileHandler<T extends Person> {

    public void saveToFile(String filename, FamilyTree<T> tree) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(tree.getMembers());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public FamilyTree<T> loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<T> members = (List<T>) ois.readObject();
            FamilyTree<T> tree = new FamilyTree<>();
            for (T member : members) {
                tree.addMember(member);
            }
            return tree;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new FamilyTree<>();
        }
    }
}
