package com.sonderliu199050418.personalfinancialassistant.Model;

public class User {
    private String password;
    private int ID;

    private int Income_ID;
    private String Income_Money;
    private String Income_Time_Year;
    private String Income_Time_Month;
    private String Income_Time_Day;
    private String Income_Type;
    private String Income_Note;
    private String Payer;

    private int Expenditures_ID;
    private String ExpendituresMoney;
    private String ExpendituresTimeYear;
    private String ExpendituresTimeMonth;
    private String ExpendituresTimeDay;
    private String ExpendituresType;
    private String ExpendituresNote;
    private String PlaceName;


    private int isDeleted;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getExpenditures_ID() {
        return Expenditures_ID;
    }

    public void setExpenditures_ID(int expenditures_ID) {
        Expenditures_ID = expenditures_ID;
    }

    public int getIncome_ID() {
        return Income_ID;
    }

    public void setIncome_ID(int income_ID) {
        Income_ID = income_ID;
    }

    public String getExpendituresMoney() {
        return ExpendituresMoney;
    }

    public void setExpendituresMoney(String expendituresMoney) {
        ExpendituresMoney = expendituresMoney;
    }

    public String getIncome_Money() {
        return Income_Money;
    }

    public void setIncome_Money(String income_Money) {
        Income_Money = income_Money;
    }

    public String getExpendituresTimeYear() {
        return ExpendituresTimeYear;
    }

    public void setExpendituresTimeYear(String expendituresTimeYear) {
        ExpendituresTimeYear = expendituresTimeYear;
    }

    public String getExpendituresTimeMonth() {
        return ExpendituresTimeMonth;
    }

    public void setExpendituresTimeMonth(String expendituresTimeMonth) {
        ExpendituresTimeMonth = expendituresTimeMonth;
    }

    public String getExpendituresTimeDay() {
        return ExpendituresTimeDay;
    }

    public void setExpendituresTimeDay(String expendituresTimeDay) {
        ExpendituresTimeDay = expendituresTimeDay;
    }

    public String getIncome_Time_Year() {
        return Income_Time_Year;
    }

    public void setIncome_Time_Year(String income_Time_Year) {
        Income_Time_Year = income_Time_Year;
    }

    public String getIncome_Time_Month() {
        return Income_Time_Month;
    }

    public void setIncome_Time_Month(String income_Time_Month) {
        Income_Time_Month = income_Time_Month;
    }

    public String getIncome_Time_Day() {
        return Income_Time_Day;
    }

    public void setIncome_Time_Day(String income_Time_Day) {
        Income_Time_Day = income_Time_Day;
    }

    public String getExpendituresType() {
        return ExpendituresType;
    }

    public void setExpendituresType(String expendituresType) {
        ExpendituresType = expendituresType;
    }

    public String getIncome_Type() {
        return Income_Type;
    }

    public void setIncome_Type(String income_Type) {
        Income_Type = income_Type;
    }

    public String getExpendituresNote() {
        return ExpendituresNote;
    }

    public void setExpendituresNote(String expendituresNote) {
        ExpendituresNote = expendituresNote;
    }

    public String getIncome_Note() {
        return Income_Note;
    }

    public void setIncome_Note(String income_Note) {
        Income_Note = income_Note;
    }

    public String getPlaceName() {
        return PlaceName;
    }

    public void setPlaceName(String placeName) {
        PlaceName = placeName;
    }

    public String getPayer() {
        return Payer;
    }

    public void setPayer(String payer) {
        Payer = payer;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
