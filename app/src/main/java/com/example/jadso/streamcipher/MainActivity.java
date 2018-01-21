package com.example.jadso.streamcipher;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jadso.streamcipher.Snow.SnowFunc;
import com.example.jadso.streamcipher.Snow.SnowMain;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    Button btnEncrypt;
    TextView tv, TextView_key;
    EditText message;
    StringBuilder sb;
    static int MainEncryptFlag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message = (EditText) findViewById(R.id.message);
        btn = (Button) findViewById(R.id.settings);
        btnEncrypt = (Button) findViewById(R.id.encrypt);
        btn.setOnClickListener(this);
        btnEncrypt.setOnClickListener(this);
        tv = (TextView) findViewById(R.id.encryptedMsg);
        TextView_key = (TextView) findViewById(R.id.TextView_key);

    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        sb = new StringBuilder();
        switch (v.getId()) {
            case R.id.settings:
                Intent intent = new Intent(this, activity_settings.class);
                startActivity(intent);
                break;
            case R.id.encrypt:
                if (MainEncryptFlag == 0) {
                    Error1();
                } else {
                    if (MainEncryptFlag == 1) {
                        encryptSnow128();
                    } else if (MainEncryptFlag == 2) {
                        encryptTrivium();
                    } else if (MainEncryptFlag == 3) {
                        encryptSnow256();
                    } else if (MainEncryptFlag == 4) {
                        encryptMickey();
                    }
                }
            default:
                break;
        }
    }

    public void Error1() {
        AlertDialog.Builder AlertDialog = new AlertDialog.Builder(this);
        AlertDialog.setTitle("Error 1!").setMessage("Please choose stream cipher in settings");
        AlertDialog.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface AlertDialog, int i) {
                AlertDialog.cancel();
            }
        });
        AlertDialog alert = AlertDialog.create();
        alert.show();
    }

    public void encryptSnow128() {
        SnowMain.genKey128();
        SnowMain.genVector();
        SnowMain.Streamlet128();

        sb = new StringBuilder();
        EditText edt = (EditText) findViewById(R.id.message);
        String msg = edt.getText().toString();
        for (int i = 0; i < msg.length(); i++) {
            SnowFunc.Next();
            char m = msg.charAt(i);
            String st = Integer.toBinaryString(m);
            long result = SnowFunc.Strm() ^ m;
            sb.append(result);
        }
        tv.setText(sb.toString());
        sb.setLength(0);
        for (int i = 0; i < SnowMain.key_arr_sml.length; i++) {
            sb.append(SnowMain.key_arr_sml[i]);
        }
        TextView_key.setText(sb.toString());
    }

    public void encryptTrivium() {
        Trivium.genKeyV();
        Trivium.createKey();
        EditText edt = (EditText) findViewById(R.id.message);
        String msg = edt.getText().toString();
        for (int i = 0; i < msg.length(); i++) {
            char m = msg.charAt(i);
            String st = Integer.toBinaryString(m);
            for (int j = 0; j < st.length(); j++) {
                char n = st.charAt(j);
                Trivium.generateCiper1();
                char result = (char) (n ^ Trivium.z);
                sb.append(result);
            }
        }
        tv.setText(sb.toString());
        sb.setLength(0);
        for (int i = 0; i < Trivium.key.length; i++) {
            sb.append(Trivium.key[i]);
        }
        TextView_key.setText(sb.toString());
    }

    public void encryptSnow256() {
        SnowMain.genKey256();
        SnowMain.genVector();
        SnowMain.Streamlet256();

        sb = new StringBuilder();
        EditText edt = (EditText) findViewById(R.id.message);
        String msg = edt.getText().toString();
        for (int i = 0; i < msg.length(); i++) {
            SnowFunc.Next();
            char m = msg.charAt(i);
            String st = Integer.toBinaryString(m);
            long result = SnowFunc.Strm() ^ m;
            sb.append(result);
        }
        tv.setText(sb.toString());
        sb.setLength(0);
        for (int i = 0; i < SnowMain.key_arr.length; i++) {
            sb.append(SnowMain.key_arr[i]);
        }
        TextView_key.setText(sb.toString());
    }

    public void encryptMickey() {
        Mickey.genKey();
        Mickey.keyInit(Mickey.vector, Mickey.key);
        EditText edt = (EditText) findViewById(R.id.message);
        String msg = edt.getText().toString();
        for (int i = 0; i < msg.length(); i++) {
            char m = msg.charAt(i);
            String st = Integer.toBinaryString(m);
            for (int j = 0; j < st.length(); j++) {
                char n = st.charAt(j);
                char result = (char) (n ^ Mickey.genKeyStream());
                sb.append(result);
            }

        }
        tv.setText(sb.toString());
        sb.setLength(0);
        for (int i = 0; i < Mickey.key.length; i++) {
            sb.append(Mickey.key[i]);
        }
        TextView_key.setText(sb.toString());
    }

    }