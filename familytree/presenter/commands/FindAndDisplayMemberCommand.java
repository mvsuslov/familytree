package familytree.presenter.commands;

import familytree.service.FamilyTreeService;
import familytree.view.FamilyTreeView;

public class FindAndDisplayMemberCommand implements Command {
    private FamilyTreeService service;
    private FamilyTreeView view;

    public FindAndDisplayMemberCommand(FamilyTreeService service, FamilyTreeView view) {
        this.service = service;
        this.view = view;
    }

    @Override
    public void execute() {
        view.displayMessage("Введите ID человека:");
        int id = Integer.parseInt(view.getMemberInput());

        Person person = service.findMemberById(id);
        if (person != null) {
            view.displayMemberInfo(person.toString());
        } else {
            view.displayMessage("Человек не найден.");
        }
    }

    @Override
    public String getDescription() {
        return "Найти и Показать Человека";
    }
}
