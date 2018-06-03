package com.example.rachel.meatballcafe;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.preference.PreferenceManager.getDefaultSharedPreferences(getBaseContext()).
        edit().clear().apply();
        String[] menu = {"Entrees", "Sides", "Desserts", "Drinks"};
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, R.id.select, menu));

    }
    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch (position) {
            case 0:
                startActivity(new Intent(MainActivity.this, EntreeActivity.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, SidesActivity.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity.this, DessertActivity.class));
                break;
            case 3:
                startActivity(new Intent(MainActivity.this, DrinkActivity.class));
                break;
        }
    }
}
