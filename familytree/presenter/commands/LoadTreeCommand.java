package familytree.presenter.commands;

import familytree.service.FamilyTreeService;
import familytree.view.FamilyTreeView;

public class LoadTreeCommand implements Command {
    private FamilyTreeService service;
    private FamilyTreeView view;

    public LoadTreeCommand(FamilyTreeService service, FamilyTreeView view) {
        this.service = service;
        this.view = view;
    }

    @Override
    public void execute() {
        view.displayMessage("Введите имя файла для загрузки:");
        String filename = view.getMemberInput();
        service.loadTree(filename);
        view.displayMessage("Генеалогическое древо загружено.");
    }

    @Override
    public String getDescription() {
        return "Загрузить Генеалогическое Древо из Файла";
    }
}
