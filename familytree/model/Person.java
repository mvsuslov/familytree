package familytree.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private int id;
    private String name;
    private String gender;
    private int age;
    private Person spouse;
    private Person mother;
    private Person father;
    private List<Person> children;

    public Person(int id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.children = new ArrayList<>();
    }

    // Getters and setters...

    public void addChild(Person child) {
        children.add(child);
    }

    public void setParents(Person father, Person mother) {
        this.father = father;
        this.mother = mother;
    }

    @Override
    public String toString() {
        return "Человек{" +
                "id=" + id +
                ", имя='" + name + '\'' +
                ", пол='" + gender + '\'' +
                ", возраст=" + age +
                ", супруг(а)=" + (spouse != null ? spouse.getName() : "отсутствует") +
                ", мать=" + (mother != null ? mother.getName() : "неизвестно") +
                ", отец=" + (father != null ? father.getName() : "неизвестно") +
                ", дети=" + children.size() +
                '}';
    }
}
