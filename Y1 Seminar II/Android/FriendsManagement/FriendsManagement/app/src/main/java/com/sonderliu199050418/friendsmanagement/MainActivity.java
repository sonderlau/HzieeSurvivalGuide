package com.sonderliu199050418.friendsmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mFriendRecyclerView;
    private FriendAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFriendRecyclerView = findViewById(R.id.friend_recycler_view);
        mFriendRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        updateUI();
        getSupportActionBar().setSubtitle(String.format("共有 %d 位好友",FriendsLab.get(MainActivity.this).getFriends().size()));

        mFriendRecyclerView.setLongClickable(true);


    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = AddActivity.newIntent(MainActivity.this,null);
        startActivity(intent);

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,1,0,"修改");
        menu.add(0,2,0,"删除");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Intent intent = AddActivity.newIntent(MainActivity.this,FriendsLab.get(MainActivity.this).getFriends().get(mAdapter.mPosition).getId());
                startActivity(intent);
                break;
            case 2:
                FriendsLab.get(MainActivity.this).getFriends().remove(mAdapter.mPosition);
                mAdapter.notifyItemRemoved(mAdapter.mPosition);
                break;

        }
        return super.onContextItemSelected(item);
    }

    private void updateUI() {
        FriendsLab friendsLab = FriendsLab.get(MainActivity.this);
        List<FriendInfo> Friends = friendsLab.getFriends();

        if (mAdapter == null) {
            mAdapter = new FriendAdapter(Friends);
            mFriendRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }


    private class FriendHolder extends RecyclerView.ViewHolder {

        private static final String TAG = "MainActivity";
        private FriendInfo mFriendInfo;
        private TextView mTitleTextView;
        private TextView mTagTextView;
        private TextView mHobbyTextView;


        public FriendHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_friend, parent, false));

            mTitleTextView = itemView.findViewById(R.id.friend_name);
            mTagTextView = itemView.findViewById(R.id.friend_tag);
            mHobbyTextView = itemView.findViewById(R.id.friend_hobby);

            registerForContextMenu(itemView);

        }

        @SuppressLint("SetTextI18n")
        public void bind(FriendInfo friendInfo) {
            int mYear,
                    mAge;
            String sex,
                    constellations;
            mFriendInfo = friendInfo;
            mTitleTextView.setText(mFriendInfo.getName());

            sex = mFriendInfo.getSex() == 1 ? "男" : "女";

            Calendar fromCalendar = Calendar.getInstance();
            fromCalendar.setTime(new Date());
            // 获取当前的年份
            mYear = fromCalendar.get(Calendar.YEAR);
            // 获取年龄
            fromCalendar.setTime(mFriendInfo.getDate());
            mAge = mYear - fromCalendar.get(Calendar.YEAR);
            // 获取星座
            constellations = mFriendInfo.getConstellation(fromCalendar.get(Calendar.MONTH) + 1,fromCalendar.get(Calendar.DAY_OF_MONTH));

            mTagTextView.setText(sex + " " + String.valueOf(mAge) + "岁" + constellations);

            mHobbyTextView.setText(mFriendInfo.getHobby());

        }



    }

    private class FriendAdapter extends RecyclerView.Adapter<FriendHolder> {

        private List<FriendInfo> mFriends;
        private int mPosition;

        public FriendAdapter(List<FriendInfo> Friends) {
            mFriends = Friends;
        }


        @NonNull
        @Override
        public FriendHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
            return new FriendHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull final FriendHolder holder, int position) {
            final FriendInfo friendInfo = mFriends.get(position);
            holder.bind(friendInfo);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = AddActivity.newIntent(MainActivity.this,friendInfo.getId());
                    startActivity(intent);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mPosition = holder.getAdapterPosition();
                    return false;
                }
            });
        }

        @Override
        public int getItemCount() {
            return mFriends.size();
        }
    }

}


