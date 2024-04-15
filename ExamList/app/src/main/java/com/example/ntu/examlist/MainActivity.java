package com.example.ntu.examlist;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Exam> lsData;
    RecyclerView recyclerView_exam;
    ExamAdapter examAdapter;

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

        lsData = new ArrayList<Exam>();
        lsData.add(new Exam("Best Of Luck", "May 23, 2015", "First Exam"));
        lsData.add(new Exam("Good Luck", "June 09, 2015", "Second Exam"));
        lsData.add(new Exam("This is testing exam", "April 27, 2015", "Third Exam"));
        lsData.add(new Exam("Good", "May 20, 2015", "fourth Exam"));

        examAdapter = new ExamAdapter(this, lsData);

        recyclerView_exam = findViewById(R.id.recyclerViewExam);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView_exam.setLayoutManager(layoutManager);
        recyclerView_exam.setAdapter(examAdapter);
    }
}