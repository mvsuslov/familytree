package familytree.presenter.commands;

import familytree.service.FamilyTreeService;
import familytree.view.FamilyTreeView;

public class AddMemberCommand implements Command {
    private FamilyTreeService service;
    private FamilyTreeView view;

    public AddMemberCommand(FamilyTreeService service, FamilyTreeView view) {
        this.service = service;
        this.view = view;
    }

    @Override
    public void execute() {
        view.displayMessage("Введите ID:");
        int id = Integer.parseInt(view.getMemberInput());
        view.displayMessage("Введите имя:");
        String name = view.getMemberInput();
        view.displayMessage("Введите пол:");
        String gender = view.getMemberInput();
        view.displayMessage("Введите возраст:");
        int age = Integer.parseInt(view.getMemberInput());

        service.addMember(id, name, gender, age);
        view.displayMessage("Человек добавлен.");
    }

    @Override
    public String getDescription() {
        return "Добавить Человека";
    }
}

