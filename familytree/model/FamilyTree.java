package familytree.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FamilyTree<T extends Person> implements Serializable {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T member) {
        members.add(member);
    }

    public T findMemberById(int id) {
        for (T member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    public void sortByName() {
        members.sort(Comparator.comparing(T::getName));
    }

    public void sortByAge() {
        members.sort(Comparator.comparingInt(T::getAge));
    }

    public List<T> getMembers() {
        return Collections.unmodifiableList(members);
    }

    public void establishRelationship(T parent, T child) {
        parent.addChild(child);
        child.setParents(parent, null);  // Предполагается, что один родитель
    }
}
