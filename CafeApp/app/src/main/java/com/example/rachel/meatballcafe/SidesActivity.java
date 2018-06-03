package com.example.rachel.meatballcafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SidesActivity extends AppCompatActivity {
    float sidesTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sides);

        final android.widget.RadioButton rbtnSoup = (android.widget.RadioButton)findViewById(R.id.rbSoup);
        final android.widget.RadioButton rbtnMozzarella = (android.widget.RadioButton)findViewById(R.id.rbMozzarella);
        final android.widget.RadioButton rbtnBreadsticks = (android.widget.RadioButton)findViewById(R.id.rbBreadsticks);
        final android.widget.RadioButton rbtnRings = (android.widget.RadioButton)findViewById(R.id.rbRings);
        final android.widget.RadioButton rbtnSalad = (android.widget.RadioButton)findViewById(R.id.rbSalad);
        android.widget.Button btnOrder = (android.widget.Button)findViewById(R.id.order);
        android.widget.Button btnBill = (android.widget.Button)findViewById(R.id.bill);

        final android.content.SharedPreferences sharedPref = android.preference.PreferenceManager.getDefaultSharedPreferences(this);

        btnOrder.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                if(rbtnSoup.isChecked()) {
                    sidesTotal = 3;
                    sharedPref.edit().putFloat("sidesTotal", sidesTotal).commit();

                } else if(rbtnMozzarella.isChecked()) {
                    sidesTotal = 4;
                    sharedPref.edit().putFloat("sidesTotal", sidesTotal).commit();

                } else if(rbtnBreadsticks.isChecked()) {
                    sidesTotal = 2;
                    sharedPref.edit().putFloat("sidesTotal", sidesTotal).commit();

                } else if(rbtnRings.isChecked()){
                    sidesTotal = 3;
                    sharedPref.edit().putFloat("sidesTotal", sidesTotal).commit();

                } else if(rbtnSalad.isChecked()) {
                    sidesTotal = 2;
                    sharedPref.edit().putFloat("sidesTotal", sidesTotal).commit();
                }
                android.widget.Toast.makeText(SidesActivity.this, "$" + sidesTotal + "0 added to subtotal", android.widget.Toast.LENGTH_SHORT).show();
            }
        });
        btnBill.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                startActivity(new android.content.Intent(SidesActivity.this, BillActivity.class));
            }
        });
    }
}