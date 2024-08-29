package familytree;

import familytree.presenter.FamilyTreePresenter;
import familytree.service.FamilyTreeService;
import familytree.view.ConsoleView;

public class FamilyTreeApp {
    public static void main(String[] args) {
        FamilyTreeService service = new FamilyTreeService();
        ConsoleView view = new ConsoleView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(service, view);

        presenter.start();
    }
}
