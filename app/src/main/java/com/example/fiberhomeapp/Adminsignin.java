package com.example.fiberhomeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Adminsignin extends AppCompatActivity {
    private Button SIGNINADMIN;
    private EditText FIRSTNAME, PASSWORD;
    private String parentDbName = "Admins";
    private ProgressDialog loadingBar;
    private String firstname;
    private String secondname;
    private String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminsignin);

        SIGNINADMIN = (Button) findViewById(R.id.signin_admin);
        FIRSTNAME = (EditText) findViewById(R.id.adminsignin_firstname);
        PASSWORD = (EditText) findViewById(R.id.adminsignin_password);
        loadingBar = new ProgressDialog(this);


        SIGNINADMIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LoginAdmin();
                parentDbName = "Admins";
            }
        });
    }
    private void LoginAdmin() {
        String firstname = FIRSTNAME.getText().toString();
        String password = PASSWORD.getText().toString();

        if (FIRSTNAME.getText().toString().equals("Dmachuki") && PASSWORD.getText().toString().equals("machuki123")) {
            {
                loadingBar.setTitle("Login Account");
                loadingBar.setMessage("Please wait, while we are checking the credentials.");
                loadingBar.setCanceledOnTouchOutside(true);
                loadingBar.show();
            }
            Intent intent = new Intent(Adminsignin.this, AdminManagement.class);
            startActivity(intent);
        } else if (TextUtils.isEmpty(firstname)) {
            Toast.makeText(this, "Please Enter Your First Name...", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please Enter your password...", Toast.LENGTH_SHORT).show();
        } else
        {
            Toast.makeText(getApplicationContext(), "Sign in Error! Please enter the correct details", Toast.LENGTH_SHORT).show();
        }
    }
}