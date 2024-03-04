package com.example.ex3_simplesumapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
    }

    public void XuLyTong(View view){
        EditText editA = findViewById(R.id.editA);
        EditText editB = findViewById(R.id.editB);
        EditText editkq = findViewById(R.id.editTextText4);

        if(!editA.getText().toString().isEmpty() && !editB.getText().toString().isEmpty()){
            int a = Integer.parseInt(editA.getText().toString());
            int b = Integer.parseInt(editB.getText().toString());
            int tong;

            tong = a + b;
            String strtong = Integer.toString(tong);
            editkq.setText(strtong);
        }
    }
}