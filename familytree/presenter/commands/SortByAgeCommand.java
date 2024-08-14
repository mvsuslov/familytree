package familytree.presenter.commands;

import familytree.model.FamilyTree;
import familytree.model.Person;
import familytree.view.FamilyTreeView;

public class SortByAgeCommand implements Command {
    private FamilyTree<Person> familyTree;
    private FamilyTreeView view;

    public SortByAgeCommand(FamilyTree<Person> familyTree, FamilyTreeView view) {
        this.familyTree = familyTree;
        this.view = view;
    }

    @Override
    public void execute() {
        familyTree.sortByAge();
        view.displayMessage("Members sorted by age.");
    }

    @Override
    public String getDescription() {
        return "Sort Members by Age";
    }
}
