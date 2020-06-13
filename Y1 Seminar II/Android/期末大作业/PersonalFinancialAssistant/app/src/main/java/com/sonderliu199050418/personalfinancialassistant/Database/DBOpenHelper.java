package com.sonderliu199050418.personalfinancialassistant.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper{

    public DBOpenHelper(Context context) {
        super(context, "data.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqliteDatabase) {
        String SQLCreateTUser = "create table if not exists user("
                + "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + "password VARCHAR(255) UNIQUE,"
                + "isDel INTEGER DEFAULT 0" + ")";

        sqliteDatabase.execSQL(SQLCreateTUser);

        String SQLAddDefaultUser = "insert into user(id,password) values(1,'123')";
        sqliteDatabase.execSQL(SQLAddDefaultUser);

        String SQLCreateOutcome = "create table if not exists outcome("
                + "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + "money VARCHAR(255),"
                + "year VARCHAR(4),"
                + "month VARCHAR(2),"
                + "day VARCHAR(2),"
                + "type VARCHAR(255),"
                + "place VARCHAR(255),"
                + "note VARCHAR(255),"
                + "isDel INTEGER DEFAULT 0" + ")";
        sqliteDatabase.execSQL(SQLCreateOutcome);

        String SQLCreateIncome = "create table if not exists income("
                + "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + "money VARCHAR(255),"
                + "year VARCHAR(4),"
                + "month VARCHAR(2),"
                + "day VARCHAR(2),"
                + "type VARCHAR(255),"
                + "payer VARCHAR(255),"
                + "note VARCHAR(255),"
                + "isDel INTEGER DEFAULT 0" + ")";
        sqliteDatabase.execSQL(SQLCreateIncome);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //todo : upgrade database
    }
}
