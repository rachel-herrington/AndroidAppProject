package com.example.rachel.meatballcafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DessertActivity extends AppCompatActivity {
    float dessertTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert);

        final android.widget.RadioButton rbtnBrownies = (android.widget.RadioButton)findViewById(R.id.rbBrownies);
        final android.widget.RadioButton rbtnCake = (android.widget.RadioButton)findViewById(R.id.rbCake);
        final android.widget.RadioButton rbtnIceCream = (android.widget.RadioButton)findViewById(R.id.rbIceCream);
        android.widget.Button btnOrder = (android.widget.Button)findViewById(R.id.order);
        android.widget.Button btnBill = (android.widget.Button)findViewById(R.id.bill);

        final android.content.SharedPreferences sharedPref = android.preference.PreferenceManager.getDefaultSharedPreferences(this);

        btnOrder.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                if(rbtnBrownies.isChecked()) {
                    dessertTotal = 5;
                    sharedPref.edit().putFloat("dessertTotal", dessertTotal).commit();

                } else if(rbtnCake.isChecked()) {
                    dessertTotal = 5;
                    sharedPref.edit().putFloat("dessertTotal", dessertTotal).commit();

                } else if(rbtnIceCream.isChecked()) {
                    dessertTotal = 4;
                    sharedPref.edit().putFloat("dessertTotal", dessertTotal).commit();

                }
                android.widget.Toast.makeText(DessertActivity.this, "$" + dessertTotal + "0 added to subtotal", android.widget.Toast.LENGTH_SHORT).show();
            }
        });
        btnBill.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                startActivity(new android.content.Intent(DessertActivity.this, BillActivity.class));
            }
        });
    }
}
