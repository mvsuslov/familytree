package familytree;

import familytree.model.Person;

public class FamilyTreeApp {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();
        UserInteraction<Person> userInteraction = new UserInteraction<>(familyTree);

        userInteraction.start();
    }
}
