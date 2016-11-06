package com.example.chiwaura.blesscoffee;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    LoginDataBaseAdapter loginDataBaseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewMenu = (TextView) findViewById(R.id.Menu);
        TextView textViewReachUs = (TextView) findViewById(R.id.ReachUs);
        TextView link_to_login = (TextView) findViewById(R.id.link_to_login);
        TextView link_to_register = (TextView) findViewById(R.id.link_to_register);


        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();



       // Set OnClick Listener on Menu TextView
        textViewMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
// TODO Auto-generated method stub

/// Create Intent for Menu Activity and Start The Activity
                Intent intentMenu=new Intent(getApplicationContext(),Menu.class);
                startActivity(intentMenu);
            }
        });




        // Set OnClick Listener on ReachUs textView
        textViewReachUs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
// TODO Auto-generated method stub

/// Create Intent for reachUs Activity and Start The Activity
                Intent intentReachUs=new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intentReachUs);
            }
        });


        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.login);
        dialog.setTitle("Login");
        // Set OnClick Listener on login textView
        link_to_login.setOnClickListener(new View.OnClickListener() {




            // get the Refferences of views
            final  EditText editTextUserName=(EditText)dialog.findViewById(R.id.editTextUserNameToLogin);
            final  EditText editTextPassword=(EditText)dialog.findViewById(R.id.editTextPasswordToLogin);


            public void onClick(View v) {
                dialog.show();
         // TODO Auto-generated method stub


            Button btnSignIn=(Button)dialog.findViewById(R.id.buttonSignIn);

            btnSignIn.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    // TODO Auto-generated method stub
// get The User name and Password
                    String userName = editTextUserName.getText().toString();
                    String password = editTextPassword.getText().toString();


// fetch the Password form database for respective user name

                    String storedPassword = loginDataBaseAdapter.getSinlgeEntry(userName);


// check if the Stored password matches with Password entered by user
                    if (password.equals(storedPassword)) {
                        Toast.makeText(MainActivity.this, "Congrats :Login Successfull", Toast.LENGTH_LONG).show();
                        //dialog.dismiss();
                        Intent intentLoggedin = new Intent(getApplicationContext(), loggedin.class);
                        startActivity(intentLoggedin);
                    } else {
                        Toast.makeText(MainActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                    }

                    dialog.dismiss();
                    finish();
                }
            });
            }
        });






        // Set OnClick Listener on link to  register
        link_to_register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
// TODO Auto-generated method stub

/// Create Intent for SignUpActivity and Start The Activity
                Intent intentRegister=new Intent(getApplicationContext(),signUp.class);
                startActivity(intentRegister);
            }
        });

       // if (getIntent().getBooleanExtra("EXIT", false)) {
         //   finish();
        //}



    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        // Close The Database
        loginDataBaseAdapter.close();
    }
}
