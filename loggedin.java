package com.example.chiwaura.blesscoffee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by  Engineer CHIWAURA on 10/24/2016.
 */
public class loggedin extends Activity {
    TextView textViewMenu, textViewPlaceAnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loggedin);

        textViewMenu = (TextView) findViewById(R.id.Menu);
       // textViewPayment = (TextView) findViewById(R.id.Payment);
        textViewPlaceAnOrder = (TextView) findViewById(R.id.Order);

        textViewMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
// TODO Auto-generated method stub

/// Create Intent for SignUpActivity and Start The Activity
                Intent intentMenu = new Intent(getApplicationContext(), Menu.class);
                startActivity(intentMenu);
            }
        });


        /*textViewPayment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
// TODO Auto-generated method stub

/// Create Intent for SignUpActivity and Start The Activity
                Intent intentPayment = new Intent(getApplicationContext(), Payment.class);
                startActivity(intentPayment);
            }
        });*/


        textViewPlaceAnOrder.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
// TODO Auto-generated method stub

/// Create Intent for SignUpActivity and Start The Activity
                Intent intentPlaceAnOrder = new Intent(getApplicationContext(), Order.class);
                startActivity(intentPlaceAnOrder);
                intentPlaceAnOrder.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intentPlaceAnOrder.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                finish();
            }
        });
    }
}

