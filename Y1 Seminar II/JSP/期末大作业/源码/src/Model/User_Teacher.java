package Model;

import utils.string.md5String;


public class User_Teacher {
    private String username;
    private String password;
    private String InCharge;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User_Teacher() {
    }

    public User_Teacher(String username, String password,String code) {
        this.username = username;
        this.password = md5String.crypt(password);
        this.code = code;
    }

    public User_Teacher(String username, String password, String inCharge,String code) {
        this.username = username;
        this.password = md5String.crypt(password);
        this.InCharge = inCharge;
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

    public String getInCharge() {
        return InCharge;
    }

    public void setInCharge(String inCharge) {
        InCharge = inCharge;
    }


}
