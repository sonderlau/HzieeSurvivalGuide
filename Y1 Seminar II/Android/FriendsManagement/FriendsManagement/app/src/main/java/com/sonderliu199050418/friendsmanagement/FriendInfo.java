package com.sonderliu199050418.friendsmanagement;

import java.util.Date;
import java.util.UUID;

public class FriendInfo {
    public static final String[] hobbys = {"电影", "编程","篮球","足球","游泳","羽毛球","绘画","写作","美食","游戏","购物","阅读","登山","旅行"};

    private String mName;
    private UUID mId;
    private int mSex;
    private String mHobby;
    private Date mDate;

    private int day;
    private int month;

    public int getSex() {
        return mSex;
    }

    public Date getDate() {
        return mDate;
    }

    public String getName() {
        return mName;
    }

    public FriendInfo() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }


    public String getHobby() {
        return mHobby;
    }

    public String getConstellation(int month, int day) {
        return day < dayArr[month - 1] ? constellationArr[month - 1] : constellationArr[month];
    }

    public void setSex(int sex) {
        mSex = sex;
    }

    public void setHobby(String hobby) {
        mHobby = hobby;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public void setName(String name) {
        mName = name;
    }

    public UUID getId() {
        return mId;
    }

    private final static int[] dayArr = new int[] { 20, 19, 21, 20, 21, 22, 23, 23, 23, 24, 23, 22 };
    private final static String[] constellationArr = new String[] { "摩羯座", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座" };


}
