package com.example.ntu.trannhuttrung_63135935;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    Button btn9, btn0, btn00, btnCong, btnTru, btnNhan;
    Button btnChia, btnCham, btnXoa, btnC, btnPhanTram, btnBang;

    float sohang1 = 0;

    TextView txtResult, txtCongthuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        khoiTao();


        ArrayList<Button> ds_btnValue = new ArrayList<Button>();
        ds_btnValue.add(btn1);
        ds_btnValue.add(btn2);
        ds_btnValue.add(btn3);
        ds_btnValue.add(btn4);
        ds_btnValue.add(btn5);
        ds_btnValue.add(btn6);
        ds_btnValue.add(btn7);
        ds_btnValue.add(btn8);
        ds_btnValue.add(btn9);

        for(Button b:ds_btnValue){
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(txtResult.getText().toString().isEmpty()){
                        int so = Integer.parseInt(((Button) v).getText().toString());
                        txtResult.setText(String.valueOf(so));
                    } else {
                        if(txtResult.getText().toString().contains(".")){
                            String c = txtResult.getText().toString();
                            String them = ((Button) v).getText().toString();
                            c += them;
                            txtResult.setText(c);
                        } else {
                            int so = Integer.parseInt(txtResult.getText().toString());
                            int phanthem = Integer.parseInt(((Button) v).getText().toString());
                            txtResult.setText(String.valueOf(so * 10 + phanthem));
                        }
                    }
                }
            });
        }

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtResult.getText().toString().isEmpty()){
                    if(txtCongthuc.getText().toString().isEmpty()){
                        float so = Float.parseFloat(txtResult.getText().toString());
                        sohang1 = so;
                        String value = String.valueOf(so) + " + ";
                        txtCongthuc.setText(value);
                    }
                    txtResult.setText("");
                }
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtResult.getText().toString().isEmpty()){
                    if(txtCongthuc.getText().toString().isEmpty()){
                        float so = Float.parseFloat(txtResult.getText().toString());
                        sohang1 = so;
                        String value = String.valueOf(so) + " - ";
                        txtCongthuc.setText(value);
                    }
                    txtResult.setText("");
                }
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtResult.getText().toString().isEmpty()){
                    if(txtCongthuc.getText().toString().isEmpty()){
                        float so = Float.parseFloat(txtResult.getText().toString());
                        sohang1 = so;
                        String value = String.valueOf(so) + " x ";
                        txtCongthuc.setText(value);
                    }
                    txtResult.setText("");
                }
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtResult.getText().toString().isEmpty()){
                    if(txtCongthuc.getText().toString().isEmpty()){
                        float so = Float.parseFloat(txtResult.getText().toString());
                        String value = String.valueOf(so) + " / ";
                        sohang1 = so;
                        txtCongthuc.setText(value);
                    }
                    txtResult.setText("");
                }
            }
        });

        btnPhanTram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtResult.getText().toString().isEmpty()){
                    if(txtCongthuc.getText().toString().isEmpty()){
                        float so = Float.parseFloat(txtResult.getText().toString());
                        String value = String.valueOf(so) + " % ";
                        sohang1 = so;
                        txtCongthuc.setText(value);
                    }
                    txtResult.setText("");
                }
            }
        });

        btnBang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtResult.getText().toString().isEmpty() && !txtCongthuc.getText().toString().isEmpty()){
                    float sohang2 = Float.parseFloat(txtResult.getText().toString());
                    if(txtCongthuc.getText().toString().contains("+")) {
                        float sum = sohang1 + sohang2;
                        txtResult.setText(String.valueOf(sum));
                    }
                    else if(txtCongthuc.getText().toString().contains("-")) {
                        float sum = sohang1 - sohang2;
                        txtResult.setText(String.valueOf(sum));
                    }
                    else if(txtCongthuc.getText().toString().contains("x")) {
                        float sum = sohang1 * sohang2;
                        txtResult.setText(String.valueOf(sum));
                    }
                    else if(txtCongthuc.getText().toString().contains("/")) {
                        float sum = sohang1 / sohang2;
                        txtResult.setText(String.valueOf(sum));
                    }
                    else{
                        float sum = sohang1 % sohang2;
                        txtResult.setText(String.valueOf(sum));
                    }
                    txtCongthuc.setText("");
                }
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtResult.getText().toString().isEmpty()){
                    txtResult.setText("");
                    txtCongthuc.setText("");
                }
            }
        });

        btn00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtResult.getText().toString().isEmpty()){
                    int so = Integer.parseInt(txtResult.getText().toString());
                    txtResult.setText(String.valueOf(so * 100));
                }
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtResult.getText().toString().isEmpty()){
                    int so = Integer.parseInt(txtResult.getText().toString());
                    txtResult.setText(String.valueOf(so * 10));
                }
            }
        });

        btnCham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtResult.getText().toString().isEmpty() && !txtResult.getText().toString().contains(".")){
                    String so = txtResult.getText().toString();
                    so += ".";
                    txtResult.setText(so);
                }
            }
        });
    }

    public void khoiTao(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 =  findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 =  findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        btn00 =  findViewById(R.id.btn00);
        btnCham = findViewById(R.id.btnCham);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        btnXoa = (Button) findViewById(R.id.btnXoa);
        btnC =  findViewById(R.id.btnC);
        btnBang = findViewById(R.id.btnBang);
        btnPhanTram =  findViewById(R.id.btnPhanTram);

        txtCongthuc = findViewById(R.id.textView2);
        txtResult = findViewById(R.id.textView3);
    }
}