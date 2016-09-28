package com.lab.colour.Activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.lab.colour.R;

import java.util.Calendar;

/**
 * Created by SeoHyeonBae on 2016-09-19.
 */
public class JoinActivity extends Activity implements View.OnClickListener {

    final CharSequence[] bigResidence = { "서울시", "경기도", "부산시", "제주" };
    final CharSequence[] smallResidence = { "은평구", "광진구", "동작구" };



    Button btn_birth, btn_residence, btn_prefer_residence, btn_join;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        initComponent();
    }

    private void initComponent() {
        btn_birth = (Button) findViewById(R.id.bt_join_birth);
        btn_residence = (Button) findViewById(R.id.bt_join_residence);
        btn_prefer_residence = (Button) findViewById(R.id.bt_join_prefer_residence);
        btn_join = (Button) findViewById(R.id.bt_join_join);

        btn_birth.setOnClickListener(this);
        btn_residence.setOnClickListener(this);
        btn_prefer_residence.setOnClickListener(this);
        btn_join.setOnClickListener(this);
    }

    private void showDialouge() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                JoinActivity.this);

        // 제목셋팅
        alertDialogBuilder.setTitle("선택 목록 대화 상자");
        alertDialogBuilder.setItems(bigResidence,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int id) {
                        Toast.makeText(getApplicationContext(),
                                bigResidence[id] + " 선택했습니다.",
                                Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

        // 다이얼로그 생성
        AlertDialog alertDialog = alertDialogBuilder.create();

        // 다이얼로그 보여주기
        alertDialog.show();
    }

    private void DialogDatePicker(){
        Calendar c = Calendar.getInstance();
        int cyear = c.get(Calendar.YEAR);
        int cmonth = c.get(Calendar.MONTH);
        int cday = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            // onDateSet method
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String date_selected = String.valueOf(monthOfYear+1)+
                        " /"+String.valueOf(dayOfMonth)+" /"+String.valueOf(year);
                Toast.makeText( JoinActivity.this,
                        "Selected Date is ="+date_selected, Toast.LENGTH_SHORT).show();
            }
        };
        DatePickerDialog alert = new DatePickerDialog(this,  mDateSetListener,
                cyear, cmonth, cday);
        alert.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_join_birth:
                DialogDatePicker();
                break;
            case R.id.bt_join_residence:
                showDialouge();
                break;
            case R.id.bt_join_prefer_residence:
                showDialouge();
                break;
            case R.id.bt_join_join:
                finish();
                break;
        }
    }
}
