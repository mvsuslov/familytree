package familytree.presenter.commands;

import familytree.service.FamilyTreeService;
import familytree.view.FamilyTreeView;

public class SaveTreeCommand implements Command {
    private FamilyTreeService service;
    private FamilyTreeView view;

    public SaveTreeCommand(FamilyTreeService service, FamilyTreeView view) {
        this.service = service;
        this.view = view;
    }

    @Override
    public void execute() {
        view.displayMessage("Введите имя файла для сохранения:");
        String filename = view.getMemberInput();
        service.saveTree(filename);
        view.displayMessage("Генеалогическое древо сохранено.");
    }

    @Override
    public String getDescription() {
        return "Сохранить Генеалогическое Древо в Файл";
    }
}
