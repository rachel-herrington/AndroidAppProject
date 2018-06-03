package com.example.rachel.meatballcafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EntreeActivity extends AppCompatActivity {
    float entreeTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entree);

        final RadioButton rbtnPastrami = (RadioButton)findViewById(R.id.rbPastrami);
        final RadioButton rbtnWrap = (RadioButton)findViewById(R.id.rbLettuceWrap);
        final RadioButton rbtnSpaghetti = (RadioButton)findViewById(R.id.rbSpaghetti);
        final RadioButton rbtnGyro = (RadioButton)findViewById(R.id.rbGyro);
        final RadioButton rbtnHotdog = (RadioButton)findViewById(R.id.rbHotdog);
        Button btnOrder = (Button)findViewById(R.id.order);
        Button btnBill = (Button)findViewById(R.id.bill);

        final android.content.SharedPreferences sharedPref = android.preference.PreferenceManager.getDefaultSharedPreferences(this);

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rbtnPastrami.isChecked()) {
                    entreeTotal = 8;
                    sharedPref.edit().putFloat("entreeTotal", entreeTotal).commit();

                } else if(rbtnWrap.isChecked()) {
                    entreeTotal = 6;
                    sharedPref.edit().putFloat("entreeTotal", entreeTotal).commit();

                } else if(rbtnSpaghetti.isChecked()) {
                    entreeTotal = 8;
                    sharedPref.edit().putFloat("entreeTotal", entreeTotal).commit();

                } else if(rbtnGyro.isChecked()){
                    entreeTotal = 9;
                    sharedPref.edit().putFloat("entreeTotal", entreeTotal).commit();

                } else if(rbtnHotdog.isChecked()) {
                    entreeTotal = 7;
                    sharedPref.edit().putFloat("entreeTotal", entreeTotal).commit();
                }
                Toast.makeText(EntreeActivity.this, "$" + entreeTotal + "0 added to subtotal", Toast.LENGTH_SHORT).show();
            }
        });
        btnBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EntreeActivity.this, BillActivity.class));
            }
        });
    }
}
