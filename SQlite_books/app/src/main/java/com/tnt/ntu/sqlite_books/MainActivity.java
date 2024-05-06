package com.tnt.ntu.sqlite_books;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    ArrayList<Book> lsData_Book;
    ArrayList<String> lsData_Name;

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

//        CreateDatabase();

        lsData_Book = getData();
        lsData_Name = getTenSachForRY(lsData_Book);

        bottomNavigationView = findViewById(R.id.bnv_book);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new RecycleBook_Fragment(lsData_Book)).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if(id == R.id.InformationBooks){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new RecycleBook_Fragment(lsData_Book)).commit();
                    return true;
                }
                if(id == R.id.Books){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new ListBook_Fragment(lsData_Name)).commit();
                    return true;
                }
                return false;
            }
        });
    }

    public void CreateDatabase(){
        SQLiteDatabase db = openOrCreateDatabase("QLSach.db",
                                                    MODE_PRIVATE,
                                                     null
                                                 );

        String sqlXoaBangNeuDaCo="DROP TABLE IF EXISTS Books;";

        String sqlTaoBang = "CREATE TABLE Books( BookID integer PRIMARY KEY, " +
                                                "BookName text, " +
                                                "Page integer, " +
                                                "Price Float, " +
                                                "Description text);";

        db.execSQL(sqlXoaBangNeuDaCo);
        db.execSQL(sqlTaoBang);

        String sqlThem1 = "INSERT INTO Books VALUES(1, 'Java', 100, 9.99, 'sách về java');";
        String sqlThem2 = "INSERT INTO Books VALUES(2, 'Android', 320, 19.00, 'Android cơ bản');";
        String sqlThem3 = "INSERT INTO Books VALUES(3, 'Học làm giàu', 120, 0.99, 'sách đọc cho vui');";
        String sqlThem4 = "INSERT INTO Books VALUES(4, 'Tử điển Anh-Việt', 1000, 29.50, 'Từ điển 100.000 từ');";
        String sqlThem5 = "INSERT INTO Books VALUES(5, 'CNXH', 1, 1, 'chuyện cổ tích');";
        db.execSQL(sqlThem1);
        db.execSQL(sqlThem2);
        db.execSQL(sqlThem3);
        db.execSQL(sqlThem4);
        db.execSQL(sqlThem5);

        db.close();
    }

    public ArrayList<Book> getData(){
        SQLiteDatabase db = openOrCreateDatabase("QLSach.db", MODE_PRIVATE, null);
        String sqlSelect ="SELECT * FROM Books;";
        Cursor cs = db.rawQuery(sqlSelect,null);
        ArrayList<Book> dsSach = new ArrayList<Book>();
        if (cs.moveToFirst()) {
            do {
                int idSach = cs.getInt(0);
                String tenSach = cs.getString(1);
                int soTrang = cs.getInt(2);
                float gia = cs.getFloat(3);
                String mota = cs.getString(4);
                Book b = new Book(idSach, tenSach, soTrang, gia, mota);
                dsSach.add(b);
            } while (cs.moveToNext());
        }
        cs.close();
        db.close();
        return dsSach;
    }

    public ArrayList<String> getTenSachForRY(ArrayList<Book> dsSach) {
        ArrayList<String> dsTenSach = new ArrayList<String>();
        for (int i=0; i<dsSach.size(); i++ )
            dsTenSach.add(dsSach.get(i).getBookName());
        return dsTenSach;
    }
}