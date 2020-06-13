package com.sonderliu199050418.personalfinancialassistant;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sonderliu199050418.personalfinancialassistant.Database.UserSearch;
import com.sonderliu199050418.personalfinancialassistant.Model.User;

import java.util.ArrayList;
import java.util.List;

public class InformationAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    private Context mContext;
    private UserSearch mUserSearch;
    private LinearLayout GlobalLinearLayout;
    private Button button_Back;
    private TextView information_number_textView;

    public InformationAdapter(Context context, @Nullable List<String> data) {
        super(R.layout.data_income_fragment, data);
        mContext = context;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void convert(BaseViewHolder helper, String item) {


        mUserSearch = new UserSearch(mContext);
        button_Back = helper.getView(R.id.back);
        GlobalLinearLayout = helper.getView(R.id.ShowInfo);

        information_number_textView = helper.getView(R.id.information_number);

        if (item.equals("0") ){
            //* 支出
            //* 支出信息展示

            //* 总数量
            int OutcomeUserSize = mUserSearch.getAmountsOfOutcome();

            String income_values = "[支出表共有" + OutcomeUserSize + "条支付信息！]";
            information_number_textView.setText(income_values);

            if (OutcomeUserSize > 0) {
                //* 有数据

                ArrayList<User> userList = mUserSearch.queryAllOutcome();
                TableLayout DataPresentationTableLayout = new TableLayout(mContext);
                DataPresentationTableLayout.setStretchAllColumns(true);

                String[] TableHeadTitle = {"金额", "类型", "地点", "年/月/日", "备注", "操作"};

                //* 表格首行
                TableRow tableRow = new TableRow(mContext);

                for (String headTitle : TableHeadTitle) {
                    TextView textView = new TextView(mContext);
                    textView.setTextSize(20);
                    textView.setText(headTitle);
                    textView.setTextColor(R.color.black_800);
                    tableRow.addView(textView);
                }

                DataPresentationTableLayout.addView(tableRow,
                        new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));


                //* 将数据打印
                for (int i = 0; i < OutcomeUserSize; i++) {
                    User user = userList.get(i);

                    tableRow = new TableRow(mContext);

                    TextView textView = new TextView(mContext);
                    textView.setTextSize(18);
                    textView.setText(user.getExpendituresMoney());
                    textView.setTextColor(R.color.black_800);
                    tableRow.addView(textView);

                    textView = new TextView(mContext);
                    textView.setTextSize(18);
                    textView.setText(user.getExpendituresType());
                    textView.setTextColor(R.color.black_800);
                    tableRow.addView(textView);

                    textView = new TextView(mContext);
                    textView.setTextSize(18);
                    textView.setText(user.getPlaceName());
                    textView.setTextColor(R.color.black_800);
                    tableRow.addView(textView);


                    textView = new TextView(mContext);
                    textView.setTextSize(18);
                    String time = user.getExpendituresTimeYear() + "/" + user.getExpendituresTimeMonth() + "/" + user.getExpendituresTimeDay();
                    textView.setText(time);
                    textView.setTextColor(R.color.black_800);
                    tableRow.addView(textView);


                    textView = new TextView(mContext);
                    textView.setTextSize(18);
                    textView.setText(user.getExpendituresNote());
                    textView.setTextColor(R.color.black_800);
                    tableRow.addView(textView);

                    Button button = new Button(mContext);
                    button.setText("删除");
                    button.setTextSize(18);
                    //* 按钮的 ID 即是用户的 ID
                    button.setId(user.getExpenditures_ID());
                    button.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {

                            mUserSearch.deleteOutcomeUser(view.getId());
                            //todo: deleted successfully

                            Intent intent = new Intent(mContext,
                                    InformationSummary.class);
//                        startActivity(intent);

                            Toast.makeText(mContext, "删除成功！",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });

                    tableRow.addView(button);


                    // 新建的TableRow添加到TableLayout
                    DataPresentationTableLayout.addView(tableRow, new TableLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT));

                }
                GlobalLinearLayout.addView(DataPresentationTableLayout, 1);

            }
        }else {
            //* 收入
            //* 收入信息
            int IncomeUserSize = mUserSearch.getAmountsOfIncome();

            String outcome_info = "[收入表共有" + IncomeUserSize + "条收入信息！]";
            information_number_textView.setText(outcome_info);

            if (IncomeUserSize > 0) {

                ArrayList<User> userList = mUserSearch.queryAllIncome();

                TableLayout DataPresentationTableLayout = new TableLayout(mContext);
                DataPresentationTableLayout.setStretchAllColumns(true);
                TableRow tableRow = new TableRow(mContext);

                String[] tableHead = {"金额", "类型", "付款人", "时间", "备注", "操作"};

                for (String headTitle : tableHead) {
                    TextView textView = new TextView(mContext);
                    textView.setTextSize(20);
                    textView.setText(headTitle);
                    tableRow.addView(textView);
                }


                DataPresentationTableLayout.addView(tableRow,
                        new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));

                for (int i = 0; i < IncomeUserSize; i++) {
                    User user = userList.get(i);

                    tableRow = new TableRow(mContext);

                    TextView textView = new TextView(mContext);
                    textView.setTextSize(18);
                    textView.setText(user.getIncome_Money());
                    textView.setTextColor(R.color.black_800);
                    tableRow.addView(textView);

                    textView = new TextView(mContext);
                    textView.setTextSize(18);
                    textView.setText(user.getIncome_Type());
                    textView.setTextColor(R.color.black_800);
                    tableRow.addView(textView);

                    textView = new TextView(mContext);
                    textView.setTextSize(18);
                    textView.setText(user.getPayer());
                    textView.setTextColor(R.color.black_800);
                    tableRow.addView(textView);

                    textView = new TextView(mContext);
                    textView.setTextSize(18);
                    String income_time = user.getIncome_Time_Year() + "/" + user.getIncome_Money() + "/" + user.getIncome_Time_Day();
                    textView.setText(income_time);
                    textView.setTextColor(R.color.black_800);
                    tableRow.addView(textView);


                    textView = new TextView(mContext);
                    textView.setTextSize(18);
                    textView.setText(user.getIncome_Note());
                    textView.setTextColor(R.color.black_800);
                    tableRow.addView(textView);

                    Button button = new Button(mContext);
                    button.setText("删除");
                    button.setTextSize(18);
                    //! ID设置
                    button.setId(user.getIncome_ID());
                    button.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            mUserSearch.deleteIncomeUser(v.getId());

                            Toast.makeText(mContext, "删除成功！",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });

                    tableRow.addView(button);
                    // 新建的TableRow添加到TableLayout
                    DataPresentationTableLayout.addView(tableRow, new TableLayout.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.MATCH_PARENT));

                }
                GlobalLinearLayout.addView(DataPresentationTableLayout, 1);
            }
        }




    }
}
