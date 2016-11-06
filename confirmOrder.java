package com.example.chiwaura.blesscoffee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by  Engineer CHIWAURA on 10/29/2016.
 */
public class confirmOrder extends Activity {
    Button confirmYes, confirmNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderconfirm);


         confirmYes = (Button)findViewById(R.id.Yes);
         confirmNo = (Button)findViewById(R.id.No);

        confirmYes.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intentPayment = new Intent(getApplicationContext(), Payment.class);
                startActivity(intentPayment);
                finish();
            }

        });

        confirmNo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intentOrder = new Intent(getApplicationContext(), Order.class);
                startActivity(intentOrder);
                finish();
            }

        });


    }
}
