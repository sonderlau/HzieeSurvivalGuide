package com.sonderliu199050418.friendsmanagement;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class FriendsLab {
    private static FriendsLab sFriendsLab;
    private List<FriendInfo> mFriends;

    public static FriendsLab get(Context context) {
        if (sFriendsLab == null) {
            sFriendsLab = new FriendsLab(context);
        }
        return sFriendsLab;
    }

    private FriendsLab (Context context) {
        mFriends = new ArrayList<>();

        // 默认的5个
        addDefaultFriends();


    }

    public List<FriendInfo> getFriends() {
        return mFriends;
    }
    public FriendInfo getFriend(UUID uuid){
        for (FriendInfo friendInfo : mFriends) {
            if (friendInfo.getId().equals(uuid)){
                return friendInfo;
            }
        }

        return null;
    }

    private void addDefaultFriends() {
        mFriends = new ArrayList<>();
        for (int i = 0 ; i < 30 ; i -= -1) {
            FriendInfo friendInfo = new FriendInfo();
            friendInfo.setName("Friend #" + (i + 1));
            friendInfo.setHobby(FriendInfo.hobbys[0] + " " + FriendInfo.hobbys[1] + " " + FriendInfo.hobbys[2]);
            friendInfo.setDate(new Date((long)  1* 1000 * 3600 * 24 * 365 * 30));
            friendInfo.setSex(i % 2);
            mFriends.add(friendInfo);
        }

    }
}
