package Model;

import java.sql.Timestamp;
import java.util.UUID;

public class Homework {
    private String ID;
    private String Brief_Description;
    private String Requirements;
    private int Need_For_Review;
    private String Arrange_For;
    private Timestamp Start_Time;
    private Timestamp End_Time;
    private Timestamp Overdue_Time;
    private String Question_List;
    private String LessonID;

    public Homework() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        this.ID = id;
    }

    public String getBrief_Description() {
        return Brief_Description;
    }

    public void setBrief_Description(String brief_Description) {
        Brief_Description = brief_Description;
    }

    public String getRequirements() {
        return Requirements;
    }

    public void setRequirements(String requirements) {
        Requirements = requirements;
    }

    public int getNeed_For_Review() {
        return Need_For_Review;
    }

    public void setNeed_For_Review(int need_For_Review) {
        Need_For_Review = need_For_Review;
    }

    public String getArrange_For() {
        return Arrange_For;
    }

    public void setArrange_For(String arrange_For) {
        Arrange_For = arrange_For;
    }

    public Timestamp getStart_Time() {
        return Start_Time;
    }

    public void setStart_Time(Timestamp start_Time) {
        Start_Time = start_Time;
    }

    public Timestamp getEnd_Time() {
        return End_Time;
    }

    public void setEnd_Time(Timestamp end_Time) {
        End_Time = end_Time;
    }

    public Timestamp getOverdue_Time() {
        return Overdue_Time;
    }

    public void setOverdue_Time(Timestamp overdue_Time) {
        Overdue_Time = overdue_Time;
    }

    public String getQuestion_List() {
        return Question_List;
    }

    public void setQuestion_List(String question_List) {
        Question_List = question_List;
    }

    public String getLessonID() {
        return LessonID;
    }

    public void setLessonID(String lessonID) {
        LessonID = lessonID;
    }
}
