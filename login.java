package com.example.chiwaura.blesscoffee;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by  Engineer CHIWAURA on 10/23/2016.
 */
public class login extends Activity
{

    Button btnSignIn;
    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

// create a instance of SQLite Database
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();



        final Dialog dialog = new Dialog(login.this);
        dialog.setContentView(R.layout.login);
        dialog.setTitle("Login");

// get the Refferences of views
        final EditText editTextUserName=(EditText)findViewById(R.id.editTextUserNameToLogin);
        final EditText editTextPassword=(EditText)findViewById(R.id.editTextPasswordToLogin);

         btnSignIn=(Button)findViewById(R.id.buttonSignIn);

// Set On ClickListener
        btnSignIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
// get The User name and Password
                String userName=editTextUserName.getText().toString();
                String password=editTextPassword.getText().toString();


// fetch the Password form database for respective user name
                String storedPassword=loginDataBaseAdapter.getSinlgeEntry(userName);

// check if the Stored password matches with Password entered by user
                if(password.equals(storedPassword)){

                    Toast.makeText(login.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                    //dialog.dismiss();
                    Intent intentLoggedin =new Intent(getApplicationContext(),loggedin.class);
                    startActivity(intentLoggedin);
                }
                else  {

                    Toast.makeText(login.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }
            }
        });

        dialog.show();

    }
    // Methos to handleClick Event of Sign In Button
   /* public void signIn(View V)
    {

    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
// Close The Database
        loginDataBaseAdapter.close();
    }
}
