package com.example.rachel.meatballcafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DrinkActivity extends AppCompatActivity {
    float drinkTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        final android.widget.RadioButton rbtnSoftdrinks = (android.widget.RadioButton)findViewById(R.id.rbSoftdrinks);
        final android.widget.RadioButton rbtnTea = (android.widget.RadioButton)findViewById(R.id.rbTea);
        final android.widget.RadioButton rbtnSmoothies = (android.widget.RadioButton)findViewById(R.id.rbSmoothies);
        final android.widget.RadioButton rbtnWater = (android.widget.RadioButton)findViewById(R.id.rbWater);
        android.widget.Button btnOrder = (android.widget.Button)findViewById(R.id.order);
        android.widget.Button btnBill = (android.widget.Button)findViewById(R.id.bill);

        final android.content.SharedPreferences sharedPref = android.preference.PreferenceManager.getDefaultSharedPreferences(this);

        btnOrder.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                if(rbtnSoftdrinks.isChecked()) {
                    drinkTotal = 1;
                    sharedPref.edit().putFloat("drinkTotal", drinkTotal).commit();

                } else if(rbtnTea.isChecked()) {
                    drinkTotal = 1;
                    sharedPref.edit().putFloat("drinkTotal", drinkTotal).commit();

                } else if(rbtnSmoothies.isChecked()) {
                    drinkTotal = 3;
                    sharedPref.edit().putFloat("drinkTotal", drinkTotal).commit();

                } else if(rbtnWater.isChecked()){
                    drinkTotal = 0;
                    sharedPref.edit().putFloat("drinkTotal", drinkTotal).commit();

                }
                android.widget.Toast.makeText(DrinkActivity.this, "$" + drinkTotal + "0 added to subtotal", android.widget.Toast.LENGTH_SHORT).show();
            }
        });
        btnBill.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                startActivity(new android.content.Intent(DrinkActivity.this, BillActivity.class));
            }
        });
    }
}
