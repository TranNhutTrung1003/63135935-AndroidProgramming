package com.tnt.ntu.viewmenu_bottomnavigation;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

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
        bottomNavigationView = findViewById(R.id.bottom_menu);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_tag, new HotelFragment()).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if(id == R.id.user){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_tag, new CustomerFragment()).commit();
                    return true;
                }
                if(id == R.id.home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_tag, new HotelFragment()).commit();
                    return true;
                }
                if(id == R.id.apartment){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_tag, new InformationFragment()).commit();
                    return true;
                }
                return false;
            }
        });
    }
}