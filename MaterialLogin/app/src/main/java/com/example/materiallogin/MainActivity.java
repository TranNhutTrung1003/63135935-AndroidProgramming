package com.example.materiallogin;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button btn_signin;
    TextInputEditText email;
    TextInputEditText password;

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
        btn_signin.setOnClickListener(xuLySignIn);
    }

    View.OnClickListener xuLySignIn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String textEmail = email.getText().toString();

            if(isValidEmail(textEmail)){
                String textPassword = password.getText().toString();
                if(textPassword.equals("trung123") && compareEmails(textEmail, "trung123@gmail.com")){
                    Toast.makeText(MainActivity.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(MainActivity.this, "Email cua ban khong hop le", Toast.LENGTH_SHORT).show();
            }
        }
    };

    private static boolean compareEmails(String email1, String email2) {
        String regex = "^[a-zA-Z0-9._%+-]+@gmail.com$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher1 = pattern.matcher(email1.toLowerCase());
        Matcher matcher2 = pattern.matcher(email2.toLowerCase());

        return matcher1.matches() && matcher2.matches();
    }

    public boolean isValidEmail(String sampleEmail){
        return Patterns.EMAIL_ADDRESS.matcher(sampleEmail).matches();
    }

    public void khoiTao(){
        btn_signin = (Button) findViewById(R.id.button);
        email = (TextInputEditText) findViewById(R.id.editEmail);
        password = (TextInputEditText) findViewById(R.id.editPassword);
    }
}