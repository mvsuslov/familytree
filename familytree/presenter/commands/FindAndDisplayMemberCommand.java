package familytree.presenter.commands;

import familytree.model.FamilyTree;
import familytree.model.Person;
import familytree.view.FamilyTreeView;

public class FindAndDisplayMemberCommand implements Command {
    private FamilyTree<Person> familyTree;
    private FamilyTreeView view;

    public FindAndDisplayMemberCommand(FamilyTree<Person> familyTree, FamilyTreeView view) {
        this.familyTree = familyTree;
        this.view = view;
    }

    @Override
    public void execute() {
        view.displayMessage("Enter ID of member to find:");
        int id = view.getUserInput();
        Person member = familyTree.findMemberById(id);
        if (member != null) {
            view.displayMemberInfo(member.toString());
        } else {
            view.displayMessage("Member not found.");
        }
    }

    @Override
    public String getDescription() {
        return "Find and Display Member by ID";
    }
}
