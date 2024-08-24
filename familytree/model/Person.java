package familytree.model;

import java.util.ArrayList;
import java.util.List;

public class Person {
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", spouse=" + (spouse != null ? spouse.getName() : "none") +
                ", mother=" + (mother != null ? mother.getName() : "unknown") +
                ", father=" + (father != null ? father.getName() : "unknown") +
                ", children=" + children.size() +
                '}';
    }
}
