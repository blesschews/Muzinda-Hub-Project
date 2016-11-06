package com.example.chiwaura.blesscoffee;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class Order extends Activity {
    CheckBox CoffeeDrink, CoffeeCapsules, Burger, beansTopping, IcedTea, MilkGlass, Pastry;
    Button OrderBtn, ConfirmOrderBtn;

    public static int totalamount;
    public static StringBuilder result = new StringBuilder();

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle  on) {
        super.onCreate(null);
        setContentView(R.layout.order);
        addListenerOnButtonClick();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void addListenerOnButtonClick() {
        //Getting instance of CheckBoxes and Button
        CoffeeDrink = (CheckBox) findViewById(R.id.coffeeDrink);
        CoffeeCapsules = (CheckBox) findViewById(R.id.CoffeeCapsules);
        Burger = (CheckBox) findViewById(R.id.Burger);
        beansTopping = (CheckBox) findViewById(R.id.beansTopping);
        IcedTea = (CheckBox) findViewById(R.id.IcedTea);
        Pastry = (CheckBox) findViewById(R.id.Pastry);
        OrderBtn = (Button) findViewById(R.id.OrderBtn);
        ConfirmOrderBtn = (Button) findViewById(R.id.ConfirmBtn);
        MilkGlass = (CheckBox) findViewById(R.id.MilkGlass);


        //Applying the Listener on the Button click

        // Set OnClick Listener on Order textView
        ConfirmOrderBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
// TODO Auto-generated method stub

/// Create Intent for Confirm Order Activity and Start The Activity
                Intent intentConfirmOrder = new Intent(getApplicationContext(), confirmOrder.class);
                startActivity(intentConfirmOrder);
                finish();
            }
        });


        OrderBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                 totalamount = 0;
                //StringBuilder result = new StringBuilder();
                result.append("Selected Items:");
                if (CoffeeDrink.isChecked()) {
                    result.append("\nCoffee Drink $1");
                    totalamount += 1;
                }
                if (CoffeeCapsules.isChecked()) {
                    result.append("\nCoffee Capsules $2");
                    totalamount += 2;
                }
                if (Burger.isChecked()) {
                    result.append("\nBurger $1");
                    totalamount += 1;
                }

                if (beansTopping.isChecked()) {
                    result.append("\nBeans Topping $1");
                    totalamount += 1;
                }

                if (IcedTea.isChecked()) {
                    result.append("\nIced Tea $1");
                    totalamount += 1;
                }

                if (MilkGlass.isChecked()) {
                    result.append("\nMilk Glass $1");
                    totalamount += 1;
                }

                if (Pastry.isChecked()) {
                    result.append("\nPastry $2");
                    totalamount += 2;
                }
                result.append("\nTotal: " + "$" + totalamount);
                //Displaying the message on the toast
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();

            }


        });


    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Order Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.chiwaura.blesscoffee/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Order Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.chiwaura.blesscoffee/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
*/
}