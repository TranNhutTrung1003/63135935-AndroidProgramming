package com.example.ex_6cong_listviewthemxoasua;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> dstt;
    Button btnAdd;
    Button btnRemove;
    Button btnEdit;
    TextView txtPos;
    EditText txtValue;
    ArrayAdapter<String> adapter;

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
        dstt.add("Hai Noi");
        dstt.add("Thanh pho HCM");
        dstt.add("Dong Nai");
        dstt.add("Ninh thuan");
        dstt.add("Binh Thuan");

        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                dstt
        );

        ListView listView = (ListView) findViewById(R.id.listDS);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(xuLiSuKien);

        khoiTao();
        btnAdd.setOnClickListener(xuLiThem);
        btnRemove.setOnClickListener(xuLiXoa);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valueItem = txtValue.getText().toString();
                int pos = Integer.parseInt(txtPos.getText().toString());

                dstt.set(pos, valueItem);
                adapter.notifyDataSetChanged();
            }
        });
    }

    View.OnClickListener xuLiThem = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String valueItem = txtValue.getText().toString();
            for(String va:dstt)
                if(va.equals(valueItem))
                    return;
            dstt.add(valueItem);
            adapter.notifyDataSetChanged();
        }
    };

    View.OnClickListener xuLiXoa = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String valueItem = txtValue.getText().toString();
            dstt.remove(valueItem);
            adapter.notifyDataSetChanged();
        }
    };

    void khoiTao(){
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnRemove = (Button) findViewById(R.id.btnRemove);
        btnEdit = (Button) findViewById(R.id.btnEdit);
        txtPos = (TextView) findViewById(R.id.textView3);
        txtValue = (EditText) findViewById(R.id.editTP);

        // gan gia tri mac dinh cho khung ten thanh pho va vi tri
        txtValue.setText(dstt.get(0));
        txtPos.setText("0");
    }

    AdapterView.OnItemClickListener xuLiSuKien = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String value = dstt.get(position);
            Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            txtValue.setText(value);
            txtPos.setText(String.valueOf(position));
        }
    };
}