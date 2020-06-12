package Model;



import java.util.UUID;

public class Question {
    private String ID;
    private String Type;
    private String Brief_Description;
    private String Description;
    private String Answer;
    private float Score;
    private int Max_Size;
    private String File_Type;

    public Question() {
    }

    public Question(String ID, String type, String brief_Description, String description, String answer) {
        this.ID = ID;
        Type = type;
        Brief_Description = brief_Description;
        Description = description;
        Answer = answer;
    }

    public String getID() {
        return ID.toString();
    }

    public void setID(String ID) {
        this.ID = ID;
    }



    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getBrief_Description() {
        return Brief_Description;
    }

    public void setBrief_Description(String brief_Description) {
        Brief_Description = brief_Description;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public float getScore() {
        return Score;
    }

    public void setScore(float score) {
        Score = score;
    }

    public int getMax_Size() {
        return Max_Size;
    }

    public void setMax_Size(int max_Size) {
        Max_Size = max_Size;
    }

    public String getFile_Type() {
        return File_Type;
    }

    public void setFile_Type(String file_Type) {
        File_Type = file_Type;
    }
}
