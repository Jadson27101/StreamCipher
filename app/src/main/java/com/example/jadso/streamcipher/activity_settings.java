package com.example.jadso.streamcipher;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class activity_settings extends AppCompatActivity implements  View.OnClickListener{
    RadioGroup rg;
    Button save;
    RadioButton rb;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    TextView textSuccess;
    int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        rg = (RadioGroup) findViewById(R.id.radiogr);
        save = (Button) findViewById(R.id.save);
        textSuccess = (TextView) findViewById(R.id.textView_success);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radio1:
                        flag = 1;
                        break;
                    case R.id.radio2:
                        flag = 2;
                        break;
                    case R.id.radio3:
                        flag = 3;
                        break;
                    case R.id.radio4:
                        flag = 4;
                        break;
                    default:
                        break;
                }
            }
        });

        save.setOnClickListener(this);
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.save:
                if(flag == 0){
                    Error2();
                }else{
                    MainActivity.MainEncryptFlag = flag;
                    textSuccess.setText("Success");

                }
                break;
            default:
                break;
        }
    }
    public void Error2(){
        AlertDialog.Builder AlertDialog = new AlertDialog.Builder(this);
        AlertDialog.setTitle("Error 2!").setMessage("Please choose stream cipher!");
        AlertDialog.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface AlertDialog, int i) {
                AlertDialog.cancel();
            }
        });
        AlertDialog alert = AlertDialog.create();
        alert.show();
    }
}
