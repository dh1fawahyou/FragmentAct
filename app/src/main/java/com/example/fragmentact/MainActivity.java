package com.example.fragmentact;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView botnav; //mendeklarasikan BottomNavigationView dengan variabel botnav
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botnav = findViewById(R.id.botnav); //mendeklarasikan isi variable botnav yang diambil dari id

        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new GamesFragment()).commit(); //menetapkan class GamesFragment untuk ditampilkan ketika aplikasi dijalankan

        botnav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null; //mendeklarasikan Fragment dengan variabel selectedFragment yang bernilai null

                switch(item.getItemId()){ //membuat percabangan switch case dengan acuan item id.
                    case R.id.nav_games: //kasus apabila memilih id nav_games
                        selectedFragment = new GamesFragment(); //akan membuat class GamesFragment yang dideklarasikan didalam variable selectedFragment
                        break;
                    case R.id.nav_category: //kasus apabila memilih id nav_category
                        selectedFragment = new CategoryFragment(); //akan membuat class CategoryFragment yang dideklarasikan didalam variable selectedFragment
                        break;
                    case R.id.nav_settings: //kasus apabila memilih id nav_settings
                        selectedFragment = new OptionsFragment(); //akan membuat class OptionsFragment yang dideklarasikan didalam variable selectedFragment
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, selectedFragment).commit(); //menetapkan isi dari variable selectedFragment yaitu class yang dipilih pada switch case yang akan ditampilkan di layar

                return true;
            }
        });

    }
}