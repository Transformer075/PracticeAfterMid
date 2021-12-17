package com.example.practiceapp02;

public class StudentData {

    private String name;
    private int age;
    private boolean isActive;
    private int id;

    public StudentData(String name, int age, boolean isActive) {
        this.name = name;
        this.age = age;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "StudentData{" + "Name: " + name + ", age: " + age + ", isActive: " + isActive +
                ", Id: " + id +
                "}";
    }
}
