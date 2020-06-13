package com.sonderliu199050418.personalfinancialassistant.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.sonderliu199050418.personalfinancialassistant.Model.User;

import java.util.ArrayList;

public class UserSearch {

    private String TAG = "UserSearch";
    private DBOpenHelper dbOpenHelper;
    private SQLiteDatabase sqliteDatabase;

    public UserSearch(Context context) {
        dbOpenHelper = new DBOpenHelper(context);
    }

    // 用户插入数据
    public void addNewUser(String password) {
        sqliteDatabase = dbOpenHelper.getWritableDatabase();
        String SQL = "insert into user(password,isDel) values (?,0)";
        Object[] bindArgs = new Object[] { password };
        sqliteDatabase.execSQL(SQL, bindArgs);
    }

    // 收入 插入数据
    public void addIncome(String i_money, String year,String month,String day, String i_type,
                          String payer, String note) {
        sqliteDatabase = dbOpenHelper.getWritableDatabase();
        String SQL = "insert into income (money,year,month,day,type,payer,note,isDel) values (?,?,?,?,?,?,?,0)";
        Object[] bindArgs = new Object[] { i_money, year,month,day, i_type, payer, note };
        sqliteDatabase.execSQL(SQL, bindArgs);
    }

    // 支出 插入数据
    public void addOutcome(String o_money, String year,String month,String day,String o_type,
                           String place, String o_note) {
        sqliteDatabase = dbOpenHelper.getWritableDatabase();
        String SQL = "insert into outcome(money,year,month,day,type,place,note,isDel) values (?,?,?,?,?,?,?,0)";
        Object[] bindArgs = new Object[] { o_money, year,month,day, o_type, place, o_note };
        sqliteDatabase.execSQL(SQL, bindArgs);
    }


    // 根据o_time查阅 add out account表
    public User queryOutcomeByTime(String o_time) {
        sqliteDatabase = dbOpenHelper.getWritableDatabase();
        String SQL = "select * from outcome where time=? and isDel=0";
        String[] selectionArgs = new String[] { o_time };
        Cursor cursor = sqliteDatabase.rawQuery(SQL, selectionArgs);
        if (cursor.moveToNext()) {
            User user = new User();
            user.setExpenditures_ID(cursor.getInt(cursor.getColumnIndex("id")));
            user.setExpendituresType(cursor.getString(cursor.getColumnIndex("type")));
            user.setExpendituresMoney(cursor.getString(cursor.getColumnIndex("money")));
            user.setPlaceName(cursor.getString(cursor.getColumnIndex("place")));
            user.setExpendituresNote(cursor.getString(cursor.getColumnIndex("text")));
            return user;
        }
        cursor.close();
        return null;
    }

    // 根据 i_time查阅 add in account表
    public User queryIncomeByTime(String i_time) {
        sqliteDatabase = dbOpenHelper.getWritableDatabase();
        String sql2 = "select * from income where time=? and isDel=0";
        String[] selectionArgs = new String[] { i_time };
        Cursor cursor = sqliteDatabase.rawQuery(sql2, selectionArgs);
        if (cursor.moveToNext()) {
            User user = new User();
            user.setIncome_ID(cursor.getInt(cursor.getColumnIndex("i_id")));
            user.setIncome_Type(cursor.getString(cursor.getColumnIndex("i_type")));
            user.setIncome_Money(cursor.getString(cursor.getColumnIndex("i_money")));
            user.setPayer(cursor.getString(cursor
                    .getColumnIndex("payer")));
            user.setIncome_Note(cursor.getString(cursor.getColumnIndex("i_text")));
            return user;
        }
        cursor.close();
        return null;
    }

    // 根据password查阅t_user表
    public User queryUserByPassword(String password) {
        sqliteDatabase = dbOpenHelper.getWritableDatabase();
        String sql = "select * from user where password=? and isDel=0";
        String[] selectionArgs = new String[] { password };
        Cursor cursor = sqliteDatabase.rawQuery(sql, selectionArgs);
        if (cursor.moveToNext()){
            User user = new User();
            user.setID(cursor.getInt(cursor.getColumnIndex("id")));
            user.setPassword(cursor.getString(cursor.getColumnIndex("password")));
            cursor.close();
            return user;// 返回一个用户给前台
        }
        cursor.close();
        return null;// 没有返回null
    }

    // 求出表 outcome 中有多少条数据
    public int getAmountsOfOutcome() {
        sqliteDatabase = dbOpenHelper.getWritableDatabase();
        String sql = "select count(*) from outcome where isDel=0";
        Cursor cursor = sqliteDatabase.rawQuery(sql, null);
        if (cursor.moveToNext())// 判断Cursor中是否有数据
        {
            return cursor.getInt(0);// 返回总记录数
        }
        cursor.close();
        return 0;// 如果没有数据，则返回0
    }

    // 求出表 add in account中有多少条数据
    public int getAmountsOfIncome() {
        sqliteDatabase = dbOpenHelper.getWritableDatabase();
        String sql = "select count(*) from income where isDel=0";
        Cursor cursor = sqliteDatabase.rawQuery(sql, null);
        if (cursor.moveToNext())// 判断Cursor中是否有数据
        {
            return cursor.getInt(0);// 返回总记录数
        }

        cursor.close();
        return 0;// 如果没有数据，则返回0
    }

    // 求出表 t_user 中有多少条数据
    public int getAmountsOfUser() {
        sqliteDatabase = dbOpenHelper.getWritableDatabase();
        String sql = "select count(*) from user where isDel=0";
        Cursor cursor = sqliteDatabase.rawQuery(sql, null);
        if (cursor.moveToNext())// 判断Cursor中是否有数据
        {
            return cursor.getInt(0);// 返回总记录数
        }
        cursor.close();

        //! 如果没有数据，则返回 0
        return 0;
    }

    // 查询 add out account 所有信息
    public ArrayList<User> queryAllOutcome() {
        ArrayList<User> userArrayList = new ArrayList<User>();
        sqliteDatabase = dbOpenHelper.getWritableDatabase();
        String sql = "select * from outcome where isDel=0";
        Cursor cursor = sqliteDatabase.rawQuery(sql, null);
        // 游标从头读到尾
        for (cursor.moveToFirst(); ! cursor.isAfterLast(); cursor.moveToNext()) {
            //* 是否已经被删除
            if (cursor.getInt(cursor.getColumnIndex("isDel")) != 1) {
                User user = new User();
                user.setExpenditures_ID(cursor.getInt(cursor.getColumnIndex("id")));
                user.setExpendituresMoney(cursor.getString(cursor.getColumnIndex("money")));
                user.setExpendituresTimeYear(cursor.getString(cursor.getColumnIndex("year")));
                user.setExpendituresTimeMonth(cursor.getString(cursor.getColumnIndex("month")));
                user.setExpendituresTimeDay(cursor.getString(cursor.getColumnIndex("day")));
                user.setExpendituresType(cursor.getString(cursor.getColumnIndex("type")));
                user.setPlaceName(cursor.getString(cursor.getColumnIndex("place")));
                user.setExpendituresNote(cursor.getString(cursor.getColumnIndex("note")));
                userArrayList.add(user);
            }
        }
        cursor.close();
        return userArrayList;
    }

    // 查询 收入 所有信息
    public ArrayList<User> queryAllIncome() {
        ArrayList<User> userArrayList = new ArrayList<User>();
        sqliteDatabase = dbOpenHelper.getWritableDatabase();
        String sql = "select * from income where isDel=0";
        Cursor cursor = sqliteDatabase.rawQuery(sql, null);
        // 游标从头读到尾
        for (cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()) {
            if (cursor.getInt(cursor.getColumnIndex("isDel")) != 1) {
                User user = new User();
                user.setIncome_ID(cursor.getInt(cursor.getColumnIndex("id")));
                user.setIncome_Money(cursor.getString(cursor.getColumnIndex("money")));
                user.setIncome_Time_Year(cursor.getString(cursor.getColumnIndex("year")));
                user.setIncome_Time_Month(cursor.getString(cursor.getColumnIndex("month")));
                user.setIncome_Time_Day(cursor.getString(cursor.getColumnIndex("day")));
                user.setIncome_Type(cursor.getString(cursor.getColumnIndex("type")));
                user.setPayer(cursor.getString(cursor.getColumnIndex("payer")));
                user.setIncome_Note(cursor.getString(cursor.getColumnIndex("note")));
                userArrayList.add(user);
            }
        }
        cursor.close();
        return userArrayList;
    }

    // 查询用户表 t_use r所有信息
    public ArrayList<User> queryAllUser_R() {
        ArrayList<User> userArrayList = new ArrayList<User>();
        sqliteDatabase = dbOpenHelper.getWritableDatabase();
        String sql = "select * from user where isDel=0";
        Cursor cursor = sqliteDatabase.rawQuery(sql, null);
        // 游标从头读到尾
        for (cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()) {
            if (cursor.getInt(cursor.getColumnIndex("isDel")) != 1) {
                User user = new User();
                user.setID(cursor.getInt(cursor.getColumnIndex("id")));
                user.setPassword(cursor.getString(cursor.getColumnIndex("password")));
                userArrayList.add(user);
            }
        }
        cursor.close();
        return userArrayList;
    }

    /**
     *
     * @param source 来源： 0 =  支出  1 = 收入
     * @param year 年份
     * @param month 月份
     * @param day 日
     * @return 查询结果
     */

    public ArrayList<User> queryDataBySpecification(int source,String year,String month,String day){
        ArrayList<User> userArrayList = new ArrayList<User>();
        String SQL = "select * from ";
        SQL += source == 0 ? " outcome" : "income";
        SQL += " where year = " + year;
        SQL += month.equals("") ? "" : " and month = "+month;
        SQL += day.equals("") ? "" : " and day = " + month;

        Log.d(TAG, "queryDataBySpecification: " + SQL);

        sqliteDatabase = dbOpenHelper.getWritableDatabase();
        Cursor cursor = sqliteDatabase.rawQuery(SQL, null);
        // 游标从头读到尾
        for (cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()) {
            if (cursor.getInt(cursor.getColumnIndex("isDel")) != 1) {
                User user = new User();
                if (source == 0){
                    //* 支出
                    user.setExpenditures_ID(cursor.getInt(cursor.getColumnIndex("id")));
                    user.setExpendituresMoney(cursor.getString(cursor.getColumnIndex("money")));
                    user.setExpendituresTimeYear(cursor.getString(cursor.getColumnIndex("year")));
                    user.setExpendituresTimeMonth(cursor.getString(cursor.getColumnIndex("month")));
                    user.setExpendituresTimeDay(cursor.getString(cursor.getColumnIndex("day")));
                    user.setExpendituresType(cursor.getString(cursor.getColumnIndex("type")));
                    user.setPlaceName(cursor.getString(cursor.getColumnIndex("place")));
                    user.setExpendituresNote(cursor.getString(cursor.getColumnIndex("note")));
                    userArrayList.add(user);
                }else {
                    //* 收入
                    user.setIncome_ID(cursor.getInt(cursor.getColumnIndex("id")));
                    user.setIncome_Money(cursor.getString(cursor.getColumnIndex("money")));
                    user.setIncome_Time_Year(cursor.getString(cursor.getColumnIndex("year")));
                    user.setIncome_Time_Month(cursor.getString(cursor.getColumnIndex("month")));
                    user.setIncome_Time_Day(cursor.getString(cursor.getColumnIndex("day")));
                    user.setIncome_Type(cursor.getString(cursor.getColumnIndex("type")));
                    user.setPayer(cursor.getString(cursor.getColumnIndex("payer")));
                    user.setIncome_Note(cursor.getString(cursor.getColumnIndex("note")));
                    userArrayList.add(user);
                }

            }
        }
        cursor.close();
        return userArrayList;

    }


    // 删除 add out account 用户，其实是把相应的isDel值从0改1
    public void deleteOutcomeUser(int o_id) {
        sqliteDatabase = dbOpenHelper.getWritableDatabase();
        String sql = "update outcome set isDel=1 where id=?";
        Object[] bindArgs = new Object[] { o_id };
        sqliteDatabase.execSQL(sql, bindArgs);
    }

    // 删除 in 用户，其实是把相应的isDel值从0改1
    public void deleteIncomeUser(int i_id) {
        sqliteDatabase = dbOpenHelper.getWritableDatabase();
        String sql = "update income set isDel=1 where id=?";
        Object[] bindArgs = new Object[] { i_id };
        sqliteDatabase.execSQL(sql, bindArgs);
    }

    // 删除user用户，其实是把相应的isDel值从0改1
    public void dbDeleteUser2(int id) {
        sqliteDatabase = dbOpenHelper.getWritableDatabase();
        String sql = "update user set isDel=1 where id=?";
        Object[] bindArgs = new Object[] { id };
        sqliteDatabase.execSQL(sql, bindArgs);
    }

    // 修改密码
    public void changePassword(String newPassword) {
        sqliteDatabase = dbOpenHelper.getWritableDatabase();
        String sql = "update user set password=? and isDel=0";
        Object[] bindArgs = new Object[] { newPassword };
        sqliteDatabase.execSQL(sql, bindArgs);
    }

    private String addSingleQuote(String str){
        return "'"+str + "'";
    }
}
