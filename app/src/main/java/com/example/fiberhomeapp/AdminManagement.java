package com.example.fiberhomeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import Model.AdminOrders;

public class AdminManagement extends AppCompatActivity {
    private RecyclerView clientsList;
    private DatabaseReference clientsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_management);

        Toast.makeText(this, "Welcome Back Admin", Toast.LENGTH_SHORT).show();

        clientsRef = FirebaseDatabase.getInstance().getReference().child("Clients");

        clientsList = findViewById(R.id.clients_list);
        clientsList.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart()
    {
        super.onStart();

        FirebaseRecyclerOptions<AdminOrders> options =
                new FirebaseRecyclerOptions.Builder<AdminOrders>()
                        .setQuery(clientsRef, AdminOrders.class)
                        .build();
        FirebaseRecyclerAdapter<AdminOrders, AdminOrdersViewHolder> adapter =
                new FirebaseRecyclerAdapter<AdminOrders, AdminOrdersViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull AdminOrdersViewHolder holder, @SuppressLint("RecyclerView") int position, @NonNull AdminOrders model)
                    {
                        holder.Firstname.setText("FirstName: "+ model.getFirstname());
                        holder.Secondname.setText("SecondName: "+ model.getSecondname());
                        holder.Phonenumber.setText("PhoneNumber: "+ model.getPhone());
                        holder.Emailaddress.setText("Email: "+ model.getEmail());
                        holder.Loccation.setText("Location: "+ model.getLocation());
                        holder.Residence.setText("Residence: "+ model.getResidence());
                        holder.Mbps.setText("Mbps: "+ model.getMbps());
                        holder.userDateTime.setText("Order at: " + model.getDate() + "  " + model.getTime());

                        holder.itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view)
                            {
                                CharSequence options[] = new CharSequence[]
                                        {
                                                "Yes",
                                                "No"
                                        };

                                AlertDialog.Builder builder = new AlertDialog.Builder(AdminManagement.this);
                                builder.setTitle("Have you booked this client?");

                                builder.setItems(options, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i)
                                    {
                                        if (i == 0)
                                        {
                                            String uID = getRef(position).getKey();

                                            RemoverOrder(uID);
                                        }
                                        else
                                        {

                                        }
                                    }
                                });
                                builder.show();
                            }
                        });
                    }


                    @NonNull
                    @Override
                    public AdminOrdersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orders_layout, parent, false);
                        return new AdminOrdersViewHolder(view);
                    }
                };
        clientsList.setAdapter(adapter);
        adapter.startListening();
    }

    public static class AdminOrdersViewHolder extends RecyclerView.ViewHolder
    {
        public TextView Firstname, Secondname, Phonenumber, Emailaddress, Loccation, Residence, Mbps,userDateTime;

        public AdminOrdersViewHolder(@NonNull View itemView) {
            super(itemView);

            Firstname = itemView.findViewById(R.id.order_first_name);
            Secondname = itemView.findViewById(R.id.order_second_name);
            Phonenumber = itemView.findViewById(R.id.order_phone_number);
            Emailaddress = itemView.findViewById(R.id.order_email_address);
            Loccation = itemView.findViewById(R.id.order_location);
            Residence = itemView.findViewById(R.id.order_residence);
            Mbps = itemView.findViewById(R.id.order_mbps);
            userDateTime = itemView.findViewById(R.id.order_date_time);

        }
    }
    private void RemoverOrder(String uID)
    {
        clientsRef.child(uID).removeValue();
    }
}