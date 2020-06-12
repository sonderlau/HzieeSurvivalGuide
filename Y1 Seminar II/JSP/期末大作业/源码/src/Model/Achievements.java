package Model;

public class Achievements {
    private String ID;
    private String Student_ID;
    private int Serial_Number;
    private String Comment;
    private float Revised_Score;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(String student_ID) {
        Student_ID = student_ID;
    }

    public int getSerial_Number() {
        return Serial_Number;
    }

    public void setSerial_Number(int serial_Number) {
        Serial_Number = serial_Number;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public float getRevised_Score() {
        return Revised_Score;
    }

    public void setRevised_Score(float revised_Score) {
        Revised_Score = revised_Score;
    }

    public Achievements() {
    }
}
