package familytree.presenter;

import familytree.presenter.commands.Command;
import familytree.view.FamilyTreeView;

import java.util.List;

public class FamilyTreePresenter {
    private List<Command> commands;
    private FamilyTreeView view;

    public FamilyTreePresenter(List<Command> commands, FamilyTreeView view) {
        this.commands = commands;
        this.view = view;
    }

    public void start() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = view.getUserInput();

            if (choice > 0 && choice <= commands.size()) {
                commands.get(choice - 1).execute();
            } else {
                view.displayMessage("Invalid option. Please try again.");
            }
        }
    }

    private void displayMenu() {
        view.displayMessage("Menu:");
        for (int i = 0; i < commands.size(); i++) {
            view.displayMessage((i + 1) + ". " + commands.get(i).getDescription());
        }
        view.displayMessage("Choose an option: ");
    }
}
