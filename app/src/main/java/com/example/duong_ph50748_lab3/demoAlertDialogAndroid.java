package com.example.duong_ph50748_lab3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class demoAlertDialogAndroid extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo31_main);
       init();
        //1. Alert Dialog
        btn1.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Cảnh báo");
            builder.setMessage("Bạn có chấp nhận rủi ro không");
            builder.setIcon(R.drawable.warrning);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int index) {
                    showToast("Bạn đã đồng í");
                }
            });
            //cancel
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    showToast("Bạn đã cancel");
                }
            });
            builder.show();
        });
        //---------
        //Single Choice
        btn2.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            String[] list = {"Xanh", "Do", "Tim", "Vang"};
            builder.setTitle("Tieu de");
            builder.setSingleChoiceItems(list, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "Ban chon: " + list[which], Toast.LENGTH_LONG).show();
                }
            });
            builder.show();
        });
        //Multiple choice
        btn3.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            String[] list = {"Xanh", "Do", "Tim", "Vang"};
            builder.setTitle("Tieu de");
            builder.setMultiChoiceItems(list, null, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int index, boolean isChecked) {
                    Toast.makeText(getApplicationContext(), "Ban chon: " + list[index], Toast.LENGTH_SHORT).show();
                }
            });
            builder.show();
        });
        //Dang nhap bang dialog
        btn4.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater inflater = getLayoutInflater();
            View view1 = inflater.inflate(R.layout.demo31_login_form, null);
            builder.setView(view1);//dua view vao builder
            final EditText txtUser = view1.findViewById(R.id.demo31_login_form_txtU);
            //b4. Them cac thanh phan khac cho form: title, ok, cancel
            builder.setTitle("Login form");
            builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    showToast("xin chao: " + txtUser.getText().toString());
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    showToast("Logout");
                }
            });
            builder.show();
        });
    }

    public void showToast(String v) {
        Toast.makeText(demoAlertDialogAndroid.this, v, Toast.LENGTH_LONG).show();
    }
    public void init(){
        btn1 = findViewById(R.id.demo31Btn1);
        btn2 = findViewById(R.id.demo31Btn2);
        btn3 = findViewById(R.id.demo31Btn3);
        btn4 = findViewById(R.id.demo31Btn4);
    }
}