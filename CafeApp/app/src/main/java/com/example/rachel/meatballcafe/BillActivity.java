package com.example.rachel.meatballcafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BillActivity extends AppCompatActivity {

    float subtotal;
    int tip;
    double tipDouble;
    double preTipTotal;
    double postTipTotal;
    float entreeTotal;
    float drinkTotal;
    float sidesTotal;
    float dessertTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        final android.content.SharedPreferences sharedPref = android.preference.PreferenceManager.getDefaultSharedPreferences(this);

        final TextView tvSubtotal = (TextView)findViewById(R.id.txtSubtotal);
        final android.widget.EditText tvTip = (android.widget.EditText)findViewById(R.id.txtTip);
        final TextView tvTotal = (TextView)findViewById(R.id.txtTotal);
        android.widget.Button btnCalc = (android.widget.Button)findViewById(R.id.btnCalculate);

         entreeTotal = sharedPref.getFloat("entreeTotal",0);
         drinkTotal = sharedPref.getFloat("drinkTotal",0);
         sidesTotal = sharedPref.getFloat("sidesTotal",0);
         dessertTotal = sharedPref.getFloat("dessertTotal",0);
         subtotal = (entreeTotal + sidesTotal + dessertTotal + drinkTotal);
         preTipTotal = Double.parseDouble(Float.toString(subtotal));
         final DecimalFormat currency = new DecimalFormat("#.##");
         tvSubtotal.setText("Subtotal: $" + currency.format(subtotal) + ".00");


        btnCalc.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                //tip = Integer.parseInt(tvTip.getText().toString()); This throws a NumberFormat exception, but it's identical to the book.
                tipDouble = Double.parseDouble(Double.toString(tip));
                postTipTotal = (tipDouble * 0.01) + preTipTotal;
                tvTotal.setText("Total: $" + currency.format(postTipTotal));
            }
        });

    }
}
