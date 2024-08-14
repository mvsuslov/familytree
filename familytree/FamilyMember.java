package familytree.model;

import java.util.List;

public interface FamilyMember {
    int getId();
    String getName();
    String getGender();
    int getAge();
    FamilyMember getSpouse();
    List<? extends FamilyMember> getChildren();
}
