package familytree.presenter.commands;

import familytree.service.FamilyTreeService;
import familytree.view.FamilyTreeView;

public class SortByAgeCommand implements Command {
    private FamilyTreeService service;
    private FamilyTreeView view;

    public SortByAgeCommand(FamilyTreeService service, FamilyTreeView view) {
        this.service = service;
        this.view = view;
    }

    @Override
    public void execute() {
        service.sortByAge();
        view.displayMessage("Члены семьи отсортированы по возрасту.");
    }

    @Override
    public String getDescription() {
        return "Сортировать по Возрасту";
    }
}
