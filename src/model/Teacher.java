package model;

public class Teacher {
    private int id;
    private String name;
    private String subject;

    public Teacher() {
    }

    public Teacher(int id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "Teacher [ID=" + id + ", Name=" + name + ", Subject=" + subject + "]";
    }
}
