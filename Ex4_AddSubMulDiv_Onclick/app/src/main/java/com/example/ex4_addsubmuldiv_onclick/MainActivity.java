package com.example.ex4_addsubmuldiv_onclick;

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

    public void xuLiCong(View v){
        EditText editA = (EditText) findViewById(R.id.editA);
        EditText editB = (EditText) findViewById(R.id.editB);

        String a = editA.getText().toString();
        String b = editB.getText().toString();

        if(!a.isEmpty() && !b.isEmpty()){
            EditText editKq = (EditText) findViewById(R.id.editKq);

            float soA = Float.parseFloat(a);
            float soB = Float.parseFloat(b);
            float kq = soA + soB;
            editKq.setText(String.valueOf(kq));
        }
    }

    public void xuLiTru(View v){
        EditText editA = (EditText) findViewById(R.id.editA);
        EditText editB = (EditText) findViewById(R.id.editB);

        String a = editA.getText().toString();
        String b = editB.getText().toString();

        if(!a.isEmpty() && !b.isEmpty()){
            EditText editKq = (EditText) findViewById(R.id.editKq);

            float soA = Float.parseFloat(a);
            float soB = Float.parseFloat(b);
            float kq = soA - soB;
            editKq.setText(String.valueOf(kq));
        }
    }

    public void xuLiNhan(View v){
        EditText editA = (EditText) findViewById(R.id.editA);
        EditText editB = (EditText) findViewById(R.id.editB);

        String a = editA.getText().toString();
        String b = editB.getText().toString();

        if(!a.isEmpty() && !b.isEmpty()){
            EditText editKq = (EditText) findViewById(R.id.editKq);

            float soA = Float.parseFloat(a);
            float soB = Float.parseFloat(b);
            float kq = soA * soB;
            editKq.setText(String.valueOf(kq));
        }
    }

    public void xuLiChia(View v){
        EditText editA = (EditText) findViewById(R.id.editA);
        EditText editB = (EditText) findViewById(R.id.editB);

        String a = editA.getText().toString();
        String b = editB.getText().toString();

        if(!a.isEmpty() && !b.isEmpty()){
            EditText editKq = (EditText) findViewById(R.id.editKq);

            float soA = Float.parseFloat(a);
            float soB = Float.parseFloat(b);
            float kq = soA / soB;
            editKq.setText(String.valueOf(kq));
        }
    }
}