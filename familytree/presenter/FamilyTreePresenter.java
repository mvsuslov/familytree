package familytree.presenter;

import familytree.service.FamilyTreeService;
import familytree.presenter.commands.*;
import familytree.view.FamilyTreeView;

import java.util.ArrayList;
import java.util.List;

public class FamilyTreePresenter {
    private FamilyTreeService service;
    private FamilyTreeView view;
    private List<Command> commands;

    public FamilyTreePresenter(FamilyTreeService service, FamilyTreeView view) {
        this.service = service;
        this.view = view;
        this.commands = new ArrayList<>();

        commands.add(new AddMemberCommand(service, view));
        commands.add(new FindAndDisplayMemberCommand(service, view));
        commands.add(new DisplayFamilyTreeCommand(service, view));
        commands.add(new SortByNameCommand(service, view));
        commands.add(new SortByAgeCommand(service, view));
        commands.add(new SaveTreeCommand(service, view));
        commands.add(new LoadTreeCommand(service, view));
        commands.add(new ExitCommand(view));
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = view.getUserInput();

            if (choice >= 1 && choice <= commands.size()) {
                commands.get(choice - 1).execute();
            } else {
                view.displayMessage("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }

    private void displayMenu() {
        view.displayMessage("Выберите действие:");
        for (int i = 0; i < commands.size(); i++) {
            view.displayMessage((i + 1) + ". " + commands.get(i).getDescription());
        }
    }
}
