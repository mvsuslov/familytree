package familytree;

import familytree.model.FamilyTree;
import familytree.model.Person;
import familytree.presenter.FamilyTreePresenter;
import familytree.presenter.commands.*;
import familytree.view.ConsoleView;

import java.util.ArrayList;
import java.util.List;

public class FamilyTreeApp {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();
        ConsoleView view = new ConsoleView();

        List<Command> commands = new ArrayList<>();
        commands.add(new AddMemberCommand(familyTree, view));
        commands.add(new FindAndDisplayMemberCommand(familyTree, view));
        commands.add(new DisplayFamilyTreeCommand(familyTree, view));
        commands.add(new SortByNameCommand(familyTree, view));
        commands.add(new SortByAgeCommand(familyTree, view));
        commands.add(new ExitCommand(view));

        FamilyTreePresenter presenter = new FamilyTreePresenter(commands, view);
        presenter.start();
    }
}
