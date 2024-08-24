package familytree.presenter.commands;

import familytree.model.FamilyTree;
import familytree.model.Person;
import familytree.view.FamilyTreeView;

public class SortByNameCommand implements Command {
    private FamilyTree<Person> familyTree;
    private FamilyTreeView view;

    public SortByNameCommand(FamilyTree<Person> familyTree, FamilyTreeView view) {
        this.familyTree = familyTree;
        this.view = view;
    }

    @Override
    public void execute() {
        familyTree.sortByName();
        view.displayMessage("Members sorted by name.");
    }

    @Override
    public String getDescription() {
        return "Sort Members by Name";
    }
}
