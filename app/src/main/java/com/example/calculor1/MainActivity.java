package com.example.calculor1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView text;
    long toanHang1 = 0, toanHang2 = 0, ketQua = 0;
    int toanTu = 0;
    boolean toanTuCuoi = false, bangCuoi = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.MC).setOnClickListener(this);
        findViewById(R.id.MR).setOnClickListener(this);
        findViewById(R.id.Mplus).setOnClickListener(this);
        findViewById(R.id.Msub).setOnClickListener(this);
        findViewById(R.id.MS).setOnClickListener(this);
        findViewById(R.id.M).setOnClickListener(this);

        findViewById(R.id.percent).setOnClickListener(this);
        findViewById(R.id.CE).setOnClickListener(this);
        findViewById(R.id.C).setOnClickListener(this);
        findViewById(R.id.backspace).setOnClickListener(this);

        findViewById(R.id.phan_so).setOnClickListener(this);
        findViewById(R.id.pow2).setOnClickListener(this);
        findViewById(R.id.sqrt).setOnClickListener(this);
        findViewById(R.id.chia).setOnClickListener(this);

        findViewById(R.id.n7).setOnClickListener(this);
        findViewById(R.id.n8).setOnClickListener(this);
        findViewById(R.id.n9).setOnClickListener(this);
        findViewById(R.id.nhan).setOnClickListener(this);

        findViewById(R.id.n4).setOnClickListener(this);
        findViewById(R.id.n5).setOnClickListener(this);
        findViewById(R.id.n6).setOnClickListener(this);
        findViewById(R.id.tru).setOnClickListener(this);

        findViewById(R.id.n1).setOnClickListener(this);
        findViewById(R.id.n2).setOnClickListener(this);
        findViewById(R.id.n3).setOnClickListener(this);
        findViewById(R.id.cong).setOnClickListener(this);

        findViewById(R.id.am).setOnClickListener(this);
        findViewById(R.id.n0).setOnClickListener(this);
        findViewById(R.id.cham).setOnClickListener(this);
        findViewById(R.id.bang).setOnClickListener(this);


        text = findViewById(R.id.values);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


            case R.id.CE:
                ce(v);
                break;
            case R.id.C:
                c(v);
                break;
            case R.id.backspace:
                backspace(v);
                break;
            case R.id.n0:
                number(v,0);
                break;
            case R.id.n1:
                number(v,1);
                break;
            case R.id.n2:
                number(v,2);
                break;
            case R.id.n3:
                number(v,3);
                break;
            case R.id.n4:
                number(v,4);
                break;
            case R.id.n5:
                number(v,5);
                break;
            case R.id.n6:
                number(v,6);
                break;
            case R.id.n7:
                number(v,7);
                break;
            case R.id.n8:
                number(v,8);
                break;
            case R.id.n9:
                number(v,9);
                break;
            case R.id.cong:
                toanTu(v, 1);
                break;
            case R.id.tru:
                toanTu(v, 2);
                break;
            case R.id.nhan:
                toanTu(v, 3);
                break;
            case R.id.chia:
                toanTu(v, 4);
                break;
            case R.id.bang:
                bang(v);


        }
    }

//______________________________________________________________
    void ce(View v){
        if(toanTu == 0){
            toanHang1 = 0;
            text.setText(Long.toString(toanHang1));
        }
        else {
            toanHang2 = 0;
            text.setText(Long.toString(toanHang2));
        }
    }


    void c(View v){
        toanHang1 = 0;
        toanHang2 = 0;
        toanTu = 0;
        toanTuCuoi = false;
        bangCuoi = false;
        text.setText(Long.toString(toanHang1));
    }


    void number(View v, int n){
        toanTuCuoi = false;
        bangCuoi = false;
        if(toanTu == 0){
            toanHang1 = toanHang1 *10+n;
            text.setText(Long.toString(toanHang1));
        }
        else {
            toanHang2 = toanHang2 *10+n;
            text.setText(Long.toString(toanHang2));
        }
    }


    void bang(View v){
        if(toanTu == 0){
            ketQua = toanHang1;
        }
        else {
            if(toanTuCuoi == true){
                ketQua = tinh(toanHang1, toanHang1, toanTu);
            }
            else {
                ketQua = tinh(toanHang1, toanHang2, toanTu);
            }
        }
        toanHang2 = 0;
        if(bangCuoi == true){
            toanHang1 = Long.parseLong(text.getText().toString());
        }
        else toanHang1 = 0;
        toanTu = 0;
        toanTuCuoi = false;
        text.setText(Long.toString(ketQua));
        bangCuoi = true;
    }


    void toanTu(View v, int tTu){
        if(bangCuoi == true){
            toanHang1 = Long.parseLong(text.getText().toString());
            toanTu = tTu;
        }
        else {
            if(toanTu == 0){
                toanTu = tTu;
            }
            else {
                if(toanTuCuoi == true){
                    toanTu = tTu;
                }
                else {
                    toanHang1 = tinh(toanHang1, toanHang2, toanTu);
                    toanTu = tTu;
                }
            }
        }
        bangCuoi = false;
        toanTuCuoi = true;
        toanHang2 = 0;
        text.setText(Long.toString(toanHang1));
    }


    long tinh(long n1, long n2, int tTu){
        if(tTu == 1) return n1+n2;
        else if(tTu == 2) return n1 - n2;
        else if(tTu == 3) return n1*n2;
        else return n1/n2;
    }


    void backspace(View v){
        if(toanTu != 0){
            toanHang2 /=10;
            text.setText(Long.toString(toanHang2));
        }
        else {
            toanHang1 /= 10;
            text.setText(Long.toString(toanHang1));
        }
    }
}
