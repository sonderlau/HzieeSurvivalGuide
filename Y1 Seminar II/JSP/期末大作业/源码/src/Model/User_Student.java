package Model;

import utils.string.md5String;

public class User_Student {
    private String username;
    private String password;
    private String affiliation;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User_Student() {

    }

    public User_Student(String username, String password,String code) {
        this.username = username;
        this.password = md5String.crypt(password);
        this.code = code;
    }

    public User_Student(String username, String password, String affiliation,String code) {
        this.username = username;
        this.password =  md5String.crypt(password);
        this.affiliation = affiliation;
        this.code = code;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

}
