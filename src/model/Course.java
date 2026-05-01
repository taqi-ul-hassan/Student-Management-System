package model;

public class Course {
    private int id;
    private String name;
    private int teacher_id;

    public Course(){}
    public Course(int id,String name,int teacher_id){
        this.id = id;
        this.name = name;
        this.teacher_id = teacher_id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacherId(int teacher_id) {
        this.teacher_id= teacher_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTeacherId() {
        return teacher_id;
    }
    @Override
    public String toString() {
        return "Course [ID=" + id + ", Name=" + name + ", teacher_id=" +teacher_id + "]";
    }
}
