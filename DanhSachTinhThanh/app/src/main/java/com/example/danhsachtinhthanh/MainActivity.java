package com.example.danhsachtinhthanh;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> dstt;

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

        dstt = new ArrayList<String>();
        dstt.add("Hà Nội");
        dstt.add("Thành Phố HCM");
        dstt.add("Đồng Nai");
        dstt.add("Bình Thuận");
        dstt.add("Nha Trang");
        dstt.add("Ninh Thuận");
        dstt.add("Tiền Giang");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                dstt
        );

        ListView listView = (ListView) findViewById(R.id.listTinhThanh);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(xuLySuKien);
    }

    AdapterView.OnItemClickListener xuLySuKien = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String thanhphoduocchon = dstt.get(position);
            Toast.makeText(MainActivity.this, thanhphoduocchon, Toast.LENGTH_SHORT).show();
        }
    };
}