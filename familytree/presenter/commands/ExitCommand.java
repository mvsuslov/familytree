package familytree.presenter.commands;

import familytree.view.FamilyTreeView;

public class ExitCommand implements Command {
    private FamilyTreeView view;

    public ExitCommand(FamilyTreeView view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.displayMessage("Exiting program.");
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return "Exit";
    }
}
