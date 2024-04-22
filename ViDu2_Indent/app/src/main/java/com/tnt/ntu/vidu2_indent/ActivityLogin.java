package com.tnt.ntu.vidu2_indent;

import android.content.Intent;
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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivityLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnXacNhan = findViewById(R.id.btnXacNhan);
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = findViewById(R.id.editName);
                EditText password = findViewById(R.id.editPass);
                EditText email = findViewById(R.id.editEmail);
                TextView txterror = findViewById(R.id.txtError);

                if(name.getText().toString().equals("TranNhutTrung") && password.getText().toString().equals("trung123")){
                    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

                    Pattern pattern = Pattern.compile(emailRegex);
                    Matcher matcher = pattern.matcher(email.getText().toString());
                    if(matcher.matches()){
                        Intent iManHinhHome = new Intent(ActivityLogin.this, HomeActivity.class);
                        iManHinhHome.putExtra("Username", name.getText().toString());
                        startActivity(iManHinhHome);
                    } else {
                        txterror.setText("Email của bạn không chính xác!");
                    }
                } else {
                    txterror.setText("Thông tin Username hoặc password đã sai!");
                }
            }
        });
    }
}