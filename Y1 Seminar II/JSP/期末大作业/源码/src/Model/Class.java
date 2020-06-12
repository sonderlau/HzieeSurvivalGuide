package Model;

import java.util.UUID;

public class Class {
    private String Lesson_ID;
    private String ID;
    private String name;
    private String teacher;
    private String creator;
    private String father;

    public Class() {
    }

    public Class(String lesson_ID, String ID, String name, String teacher, String creator, String father) {
        Lesson_ID = lesson_ID;
        this.ID = ID;
        this.name = name;
        this.teacher = teacher;
        this.creator = creator;
        this.father = father;
    }

    public String getLesson_ID() {
        return Lesson_ID;
    }

    public void setLesson_ID(String lesson_ID) {
        Lesson_ID = lesson_ID;
    }

    public String getID() {
        return ID.toString();
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }
}
