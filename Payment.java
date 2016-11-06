package com.example.chiwaura.blesscoffee;

/**
 * Created by  Engineer CHIWAURA on 10/23/2016.
 */

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Payment extends Activity {

    private Button ecocash, telecash, DoneBtn, Logout;
    int totalamount = Order.totalamount;
    String hash = Uri.encode("#");
    StringBuilder result = Order.result;
    LoginDataBaseAdapter loginDataBaseAdapter;


    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);



        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();
        // final String Name=loginDataBaseAdapter.getName(name);
        //final String Address =loginDataBaseAdapter.getAddress(fulladdess);
        //final String PhoneNumber =loginDataBaseAdapter.getPhonenumber(phoneNumber);

        Toast.makeText(getApplicationContext(), " Make sure you have sufficient balance. " +
                "click done when finished", Toast.LENGTH_LONG).show();

        ecocash = (Button) findViewById(R.id.ecocash);

        // add button listener
        ecocash.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Toast.makeText(getApplicationContext(), "Ecocash transfer taking place", Toast.LENGTH_LONG).show();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + "*151*1*1*0774608254* " + totalamount + hash));
                if (ActivityCompat.checkSelfPermission(Payment.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(callIntent);

            }

        });

        telecash = (Button) findViewById(R.id.telecash);

        // add button listener
        telecash.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(), "Telecash transfer taking place", Toast.LENGTH_LONG).show();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:*188*3*2*0774608254*" + totalamount + hash));
                if (ActivityCompat.checkSelfPermission(Payment.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(callIntent);

            }

        });

        final Dialog dialog = new Dialog(Payment.this);
        dialog.setContentView(R.layout.done);
        dialog.setTitle("Confirm Details");
        // Set OnClick Listener on login textView
        DoneBtn = (Button) findViewById(R.id.DoneBtn);
        DoneBtn.setOnClickListener(new View.OnClickListener() {


            // get the Refferences of views
            final EditText editTextName = (EditText) dialog.findViewById(R.id.editTextName);
            final EditText editTextAddress = (EditText) dialog.findViewById(R.id.editTextAddress);
            final EditText editTextPhone = (EditText) dialog.findViewById(R.id.editTextPhoneNumber);


            public void onClick(View v) {
                dialog.show();
                // TODO Auto-generated method stub


                Button confirmBtn = (Button) dialog.findViewById(R.id.ConfirmDetails);

                confirmBtn.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        // TODO Auto-generated method stub
// get The User name and Password
                        String Name = editTextName.getText().toString();
                        String Address = editTextAddress.getText().toString();
                        String PhoneNumber = editTextPhone.getText().toString();


                        Toast.makeText(getApplicationContext(), "Thank you  " + Name + "  for choosing us. We will call you shortly ",
                                Toast.LENGTH_LONG).show();
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage("+263774608254", null, Name + "  of" + Address + "  cell number " + PhoneNumber +
                                " placed  an order of  " + result, null, null);

                        dialog.dismiss();
                        //finish();
                    }

                });


            }

   /* @Override
    protected void onDestroy() {
        super.onDestroy();
// Close The Database
        loginDataBaseAdapter.close();
    }*/

        });

        Logout = (Button) findViewById(R.id.Logout);

        // add button listener
        Logout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Logout successful", Toast.LENGTH_LONG).show();



            }

        });

    }



}


