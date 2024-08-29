package familytree.presenter.commands;

import familytree.service.FamilyTreeService;
import familytree.model.Person;
import familytree.view.FamilyTreeView;

public class DisplayFamilyTreeCommand implements Command {
    private FamilyTreeService service;
    private FamilyTreeView view;

    public DisplayFamilyTreeCommand(FamilyTreeService service, FamilyTreeView view) {
        this.service = service;
        this.view = view;
    }

    @Override
    public void execute() {
        StringBuilder treeString = new StringBuilder();
        for (Person member : service.getTree().getMembers()) {
            buildFamilyTreeString(member, 0, treeString);
        }
        view.displayFamilyTree(treeString.toString());
    }

    private void buildFamilyTreeString(Person member, int level, StringBuilder tree) {
        tree.append(" ".repeat(level * 4))
            .append(member.getName())
            .append(" (")
            .append(member.getGender())
            .append(", ")
            .append(member.getAge())
            .append(")\n");

        if (member.getSpouse() != null) {
            tree.append(" ".repeat(level * 4))
                .append("Супруг(а): ")
                .append(member.getSpouse().getName())
                .append("\n");
        }

        for (Person child : member.getChildren()) {
            buildFamilyTreeString(child, level + 1, tree);
        }
    }

    @Override
    public String getDescription() {
        return "Показать Генеалогическое Древо";
    }
}
