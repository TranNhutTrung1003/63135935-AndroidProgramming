package com.example.ex5_addsubmuldiv_var;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
        Timkiem();

        btnCong.setOnClickListener(xuLyCong);
        btnTru.setOnClickListener(xuLyTru);
        btnNhan.setOnClickListener(xuLyNhan);
        btnChia.setOnClickListener(xuLyChia);
    }

    View.OnClickListener xuLyCong = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double soA = Double.parseDouble(editSoA.getText().toString());
            double soB = Double.parseDouble(editSoB.getText().toString());

            double tong = soA + soB;

            tvKetQua = (TextView) findViewById(R.id.textView4);
            tvKetQua.setText(String.valueOf(tong));
        }
    };

    View.OnClickListener xuLyTru = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double soA = Double.parseDouble(editSoA.getText().toString());
            double soB = Double.parseDouble(editSoB.getText().toString());

            double hieu = soA - soB;

            tvKetQua = (TextView) findViewById(R.id.textView4);
            tvKetQua.setText(String.valueOf(hieu));
        }
    };

    View.OnClickListener xuLyNhan = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double soA = Double.parseDouble(editSoA.getText().toString());
            double soB = Double.parseDouble(editSoB.getText().toString());

            double tich = soA * soB;

            tvKetQua = (TextView) findViewById(R.id.textView4);
            tvKetQua.setText(String.valueOf(tich));
        }
    };

    View.OnClickListener xuLyChia = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double soA = Double.parseDouble(editSoA.getText().toString());
            double soB = Double.parseDouble(editSoB.getText().toString());

            double thuong = soA / soB;

            tvKetQua = (TextView) findViewById(R.id.textView4);
            tvKetQua.setText(String.valueOf(thuong));
        }
    };

    void Timkiem(){
        editSoA = (EditText) findViewById(R.id.editA);
        editSoB = (EditText) findViewById(R.id.editB);
        btnCong = (Button) findViewById(R.id.button);
        btnTru = (Button) findViewById(R.id.button2);
        btnNhan = (Button) findViewById(R.id.button3);
        btnChia = (Button) findViewById(R.id.button4);
    }

    EditText editSoA;
    EditText editSoB;
    Button btnCong, btnTru, btnNhan, btnChia;
    TextView tvKetQua;
}