package com.example.medic.controllers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.medic.R;
import com.example.medic.data.ApiClient;
import com.example.medic.data.CatalogAdapter;
import com.example.medic.models.Catalog;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Glavnay extends AppCompatActivity {
    List<Catalog> catalogs;
    public CatalogAdapter catalogAdapter;
    BottomNavigationView bottomNavigationView;
    ListView  listik;
    Button all, popular, covid, onko, zoch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glavnay);
        bottomNavigationView = findViewById(R.id.nav_bot);
        bottomNavigationView.setSelectedItemId(R.id.Analizi);
        all=findViewById(R.id.button14);
        popular=findViewById(R.id.button16);
        covid=findViewById(R.id.button17);
        onko=findViewById(R.id.button18);
        zoch=findViewById(R.id.button19);
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Category.category="all";
                clear();
                startAdapter();
            }
        });
        popular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Category.category="Популярные";
                clear();
                startAdapter();
            }
        });
        covid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Category.category="COVID";
                clear();
                startAdapter();;
            }
        });
        onko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Category.category="Онкогенетиеские";
                clear();
                startAdapter();
            }
        });
        zoch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Category.category="all";
                clear();
                startAdapter();
            }
        });



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.Analizi:
                        return true;
                    case R.id.Result:
                        startActivity(new Intent(Glavnay.this, Result.class));
                        return true;
                    case R.id.Support:
                        startActivity(new Intent(Glavnay.this, Supporting.class));
                        return true;
                    case R.id.Profilee:
                        startActivity(new Intent(Glavnay.this, Profile_check.class));
                        return true;
                }
                return false;
            }
        });
        ApiClient apiClient = new ApiClient();
        apiClient.getApiService(this).getCatalog()
                .enqueue(new Callback<List<Catalog>>() {
                    @Override
                    public void onResponse(Call<List<Catalog>> call, Response<List<Catalog>> response) {
                        if(!response.isSuccessful())
                        {
                            return;
                        }
                        catalogs=response.body();
                        startAdapter();
                        Category.category="all";
                    }

                    @Override
                    public void onFailure(Call<List<Catalog>> call, Throwable t) {
                        return;
                    }
                });
    }
    public void startAdapter()
    {
        listik=findViewById(R.id.list);
        CatalogAdapter catalogAdapter1 = new CatalogAdapter(Glavnay.this, catalogs);
        listik.setAdapter(catalogAdapter1);
    }
    public void clear()
    {
        listik=findViewById(R.id.list);
        listik.setAdapter(null);
    }


}