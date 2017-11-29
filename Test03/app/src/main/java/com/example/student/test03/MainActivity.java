package com.example.student.test03;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDialog = (Button) findViewById(R.id.btn_dialog);
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBasicDilog();

            }
        });
        Button btnDAteDialog = (Button)
                findViewById(R.id.btn_date_dialog);
        btnDAteDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });
        Button btnTimeDialong = (Button)findViewById(R.id.btn_time_dialog);
        btnTimeDialong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimeDialog();
            }
        });
        Button btnCustomDialog = (Button)findViewById(R.id.btn_custom_dialog);
        btnCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });

    }
    public void showBasicDilog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("종료확인 대화상자")
                .setMessage("어플리케이션을 종료 하기겠습니까?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();//앱종료!!

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .create()//지금까지 설정이 반영된 dialog 생성
                .show();//화면에 보여주기!!
    }

    public void showDateDialog(){
        int nowYear = 2017;
        int nowMonth = 7;
        int nowDay = 3;

        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //날짜 선택이 완료됐을 때 실행할 문장들
                String msg = "선택된 날짜:"+year+"-"+(month+1)+"-"+dayOfMonth;
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        };

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, listener, nowYear, nowMonth, nowDay);
        datePickerDialog.show();


    }

    public  void showTimeDialog(){
        int nowHour;
        int nowMinute;

        Calendar now = Calendar.getInstance();

        nowHour=now.get(Calendar.HOUR_OF_DAY);
        nowMinute=now.get(Calendar.MINUTE);

        TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String timeMsg = "선택시간:"+hourOfDay+":"+minute;
                Toast.makeText(getApplicationContext(),timeMsg,Toast.LENGTH_SHORT).show();;

            }
        };
        TimePickerDialog timeDialog = new TimePickerDialog(this,listener,nowHour,nowMinute,true);
        timeDialog.show();
    }

    public  void showCustomDialog(){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.my_dialog);//팽창!!

        Button btnOk = (Button)dialog.findViewById(R.id.btn_yes);
        Button btnNo = (Button)dialog.findViewById(R.id.btn_no);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"다행이네요",Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"뭘 드셨길래....",Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        dialog.show();
    }
}

