package familytree.presenter.commands;

import familytree.model.FamilyTree;
import familytree.model.Person;
import familytree.view.FamilyTreeView;

public class AddMemberCommand implements Command {
    private FamilyTree<Person> familyTree;
    private FamilyTreeView view;

    public AddMemberCommand(FamilyTree<Person> familyTree, FamilyTreeView view) {
        this.familyTree = familyTree;
        this.view = view;
    }

    @Override
    public void execute() {
        view.displayMessage("Enter ID:");
        int id = Integer.parseInt(view.getMemberInput());
        view.displayMessage("Enter Name:");
        String name = view.getMemberInput();
        view.displayMessage("Enter Gender:");
        String gender = view.getMemberInput();
        view.displayMessage("Enter Age:");
        int age = Integer.parseInt(view.getMemberInput());

        Person newMember = new Person(id, name, gender, age);
        familyTree.addMember(newMember);
        view.displayMessage("Member added.");
    }

    @Override
    public String getDescription() {
        return "Add Member";
    }
}
