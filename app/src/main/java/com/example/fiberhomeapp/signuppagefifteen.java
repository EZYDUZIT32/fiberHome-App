package com.example.fiberhomeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class signuppagefifteen extends AppCompatActivity
{
    public Button SUBMITER;
    public EditText FIRSTNAMER,SECONDNAMER,PHONENUMBERER,EMAILER,LOCATIONER,RESIDENCER;
    public TextView MBPSER;
    public ProgressDialog loadingBar;
    private TextView GETTY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppagefifteen);

        SUBMITER= (Button) findViewById(R.id.submitbtn);
        FIRSTNAMER=(EditText) findViewById(R.id.signup_firstname);
        SECONDNAMER=(EditText) findViewById(R.id.signup_secondname);
        PHONENUMBERER=(EditText) findViewById(R.id.signup_phone);
        EMAILER=(EditText) findViewById(R.id.signup_email);
        LOCATIONER=(EditText) findViewById(R.id.signup_location);
        MBPSER = (TextView) findViewById(R.id.signup_mbps);
        RESIDENCER=(EditText) findViewById(R.id.signup_residence);
        loadingBar= new ProgressDialog(this);

        SUBMITER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                CreateAccount();

            }
        });
        GETTY=(TextView) findViewById(R.id.getty);
        GETTY.setPaintFlags(GETTY.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }

    private void CreateAccount()
    {
        String firstname = FIRSTNAMER.getText().toString();
        String secondname = SECONDNAMER.getText().toString();
        String phone = PHONENUMBERER.getText().toString();
        String email = EMAILER.getText().toString();
        String location = LOCATIONER.getText().toString();
        String mbps = MBPSER.getText().toString();
        String residence = RESIDENCER.getText().toString();

        if(TextUtils.isEmpty(firstname))
        {
            Toast.makeText(this, "Please Enter Your FIrst Name", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(secondname))
        {
            Toast.makeText(this, "Please Enter Your Second Name", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(phone))
        {
            Toast.makeText(this, "Please Enter Your Phone Number", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(email))
        {
            Toast.makeText(this, "Please Enter Your Email Address", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(location))
        {
            Toast.makeText(this, "Please Enter Your Location", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(mbps))
        {
            Toast.makeText(this, "Please Enter Which Package you want", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(residence))
        {
            Toast.makeText(this, "Do You Stay In Your Own Home or Apartment", Toast.LENGTH_LONG).show();
        }
        else
        {
            loadingBar.setTitle("Submitting Request");
            loadingBar.setTitle("Please wait while we are uploading your credentials");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            validateAccount(firstname, secondname, phone, email, location, mbps, residence);
        }
    }

    private void validateAccount(String firstname, String secondname, String phone, String email, String location, String mbps, String residence)
    {
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if(!(dataSnapshot.child("Clients").child(phone).exists()))
                {
                    HashMap<String, Object> clientsdataMap = new HashMap<>();
                    clientsdataMap.put("phone",phone);
                    clientsdataMap.put("firstname",firstname);
                    clientsdataMap.put("secondname",secondname);
                    clientsdataMap.put("email",email);
                    clientsdataMap.put("location",location);
                    clientsdataMap.put("mbps",mbps);
                    clientsdataMap.put("residence",residence);

                    RootRef.child("Clients").child(phone).updateChildren(clientsdataMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task)
                                {
                                    if(task.isSuccessful())
                                    {
                                        Toast.makeText(signuppagefifteen.this, "Congratulations Your Information Has been Submitted Successfully", Toast.LENGTH_SHORT).show();
                                        loadingBar.dismiss();
                                        Intent intent = new Intent(signuppagefifteen.this, Waitingpage.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
                                        loadingBar.dismiss();
                                        Toast.makeText(signuppagefifteen.this, "Network Error Please try Again...", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                }
                else
                {
                    Toast.makeText(signuppagefifteen.this, "This"+phone+"already exists", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                    Toast.makeText(signuppagefifteen.this, "Please try again using another phone number ", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}