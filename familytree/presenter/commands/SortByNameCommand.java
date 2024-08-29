package familytree.presenter.commands;

import familytree.service.FamilyTreeService;
import familytree.view.FamilyTreeView;

public class SortByNameCommand implements Command {
    private FamilyTreeService service;
    private FamilyTreeView view;

    public SortByNameCommand(FamilyTreeService service, FamilyTreeView view) {
        this.service = service;
        this.view = view;
    }

    @Override
    public void execute() {
        service.sortByName();
        view.displayMessage("Члены семьи отсортированы по имени.");
    }

    @Override
    public String getDescription() {
        return "Сортировать по Имени";
    }
}
