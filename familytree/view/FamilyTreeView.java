package familytree.view;

public interface FamilyTreeView {
    int getUserInput();
    String getMemberInput();
    void displayMessage(String message);
    void displayMemberInfo(String info);
    void displayFamilyTree(String tree);
}
