package Model;

import java.util.UUID;

public class Lesson {
    private String name;
    private String teacher;
    private String ID;
    private String Description;
    private String Teacher_Description;
    private String Precursor_Lesson;
    private String Teaching_Plans;
    private String exams;
    private String Bibliography;
    private String File;
    private String Announcement;
    private String File_Type;

    public String getFile_Type() {
        return File_Type;
    }

    public void setFile_Type(String file_Type) {
        File_Type = file_Type;
    }

    public String getAnnouncement() {
        return Announcement;
    }

    public void setAnnouncement(String announcement) {
        Announcement = announcement;
    }

    public Lesson() {
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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTeacher_Description() {
        return Teacher_Description;
    }

    public void setTeacher_Description(String teacher_Description) {
        Teacher_Description = teacher_Description;
    }

    public String getPrecursor_Lesson() {
        return Precursor_Lesson;
    }

    public void setPrecursor_Lesson(String precursor_Lesson) {
        Precursor_Lesson = precursor_Lesson;
    }

    public String getTeaching_Plans() {
        return Teaching_Plans;
    }

    public void setTeaching_Plans(String teaching_Plans) {
        Teaching_Plans = teaching_Plans;
    }

    public String getExams() {
        return exams;
    }

    public void setExams(String exams) {
        this.exams = exams;
    }

    public String getBibliography() {
        return Bibliography;
    }

    public void setBibliography(String bibliography) {
        Bibliography = bibliography;
    }

    public String getFile() {
        return File;
    }

    public void setFile(String file) {
        File = file;
    }

    public Lesson(String name, String teacher,String ID, String description, String teacher_Description, String precursor_Lesson, String teaching_Plans, String exams, String bibliography, String file) {
        this.name = name;
        this.teacher = teacher;
        this.ID = ID;
        Description = description;
        Teacher_Description = teacher_Description;
        Precursor_Lesson = precursor_Lesson;
        Teaching_Plans = teaching_Plans;
        this.exams = exams;
        Bibliography = bibliography;
        File = file;
    }
}
