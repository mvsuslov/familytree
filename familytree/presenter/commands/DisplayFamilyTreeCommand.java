package familytree.presenter.commands;

import familytree.model.FamilyTree;
import familytree.model.Person;
import familytree.view.FamilyTreeView;

public class DisplayFamilyTreeCommand implements Command {
    private FamilyTree<Person> familyTree;
    private FamilyTreeView view;

    public DisplayFamilyTreeCommand(FamilyTree<Person> familyTree, FamilyTreeView view) {
        this.familyTree = familyTree;
        this.view = view;
    }

    @Override
    public void execute() {
        view.displayMessage("Enter ID of member to display family tree:");
        int id = view.getUserInput();
        Person member = familyTree.findMemberById(id);
        if (member != null) {
            StringBuilder tree = new StringBuilder();
            buildFamilyTreeString(member, 0, tree);
            view.displayFamilyTree(tree.toString());
        } else {
            view.displayMessage("Member not found.");
           }

    private void buildFamilyTreeString(Person member, int level, StringBuilder tree) {
        tree.append(" ".repeat(level * 4))
            .append(member.getName())
            .append(" (")
            .append(member.getGender())
            .append(", ")
            .append(member.getAge())
            .append(")\n");

        if (member.getSpouse() != null) {
            tree.append(" ".repeat(level * 4))
                .append("Spouse: ")
                .append(member.getSpouse().getName())
                .append("\n");
        }

        for (Person child : member.getChildren()) {
            buildFamilyTreeString(child, level + 1, tree);
        }
    }

    @Override
    public String getDescription() {
        return "Display Family Tree by ID";
    }
}
