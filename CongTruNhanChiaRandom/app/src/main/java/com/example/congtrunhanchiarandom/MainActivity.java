package com.example.congtrunhanchiarandom;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnCreateData;
    ImageButton btnCong, btnTru, btnChia, btnNhan;
    EditText editSo1, editSo2, editKq;


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
        btnCreateData.setOnClickListener(xuLyTaoDuLieu);
        btnCong.setOnClickListener(xuLyCong);
        btnTru.setOnClickListener(xuLyTru);
        btnNhan.setOnClickListener(xuLyNhan);
        btnChia.setOnClickListener(xuLyChia);
    }

    // ham tao du lieu cho so 1 va 2 (voi gia tri ngau nhien tu 1 -> 10)
    View.OnClickListener xuLyTaoDuLieu = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Random random = new Random();
            editSo1.setText(String.valueOf(random.nextInt(10)));
            editSo2.setText(String.valueOf(random.nextInt(10)));
            editKq.setText("");
        }
    };

    View.OnClickListener xuLyCong = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!editSo1.getText().toString().isEmpty() && !editSo2.getText().toString().isEmpty()){
                float so1 = Float.parseFloat(editSo1.getText().toString());
                float so2 = Float.parseFloat(editSo2.getText().toString());
                float kq = so1 + so2;
                editKq.setText(String.valueOf(kq));
            }
        }
    };

    View.OnClickListener xuLyTru = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!editSo1.getText().toString().isEmpty() && !editSo2.getText().toString().isEmpty()){
                float so1 = Float.parseFloat(editSo1.getText().toString());
                float so2 = Float.parseFloat(editSo2.getText().toString());
                float kq = so1 - so2;
                editKq.setText(String.valueOf(kq));
            }
        }
    };


    View.OnClickListener xuLyNhan = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!editSo1.getText().toString().isEmpty() && !editSo2.getText().toString().isEmpty()){
                float so1 = Float.parseFloat(editSo1.getText().toString());
                float so2 = Float.parseFloat(editSo2.getText().toString());
                float kq = so1 * so2;
                editKq.setText(String.valueOf(kq));
            }
        }
    };

    View.OnClickListener xuLyChia = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!editSo1.getText().toString().isEmpty() && !editSo2.getText().toString().isEmpty()){
                float so1 = Float.parseFloat(editSo1.getText().toString());
                float so2 = Float.parseFloat(editSo2.getText().toString());
                if(so2 != 0){
                    float kq = so1 / so2;
                    editKq.setText(String.valueOf(kq));
                }
                editKq.setText("NaN");
            }
        }
    };

    public void khoiTao(){
        btnCreateData = (Button) findViewById(R.id.button);
        btnCong = (ImageButton) findViewById(R.id.btnCong);
        btnTru = (ImageButton) findViewById(R.id.btnTru);
        btnNhan = (ImageButton) findViewById(R.id.btnNhan);
        btnChia = (ImageButton) findViewById(R.id.btnChia);
        editSo1 = (EditText) findViewById(R.id.editSo1);
        editSo2 = (EditText) findViewById(R.id.editSo2);
        editKq = (EditText) findViewById(R.id.editKq);
    }
}