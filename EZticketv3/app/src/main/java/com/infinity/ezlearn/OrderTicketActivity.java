package com.infinity.ezlearn;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.infinity.ezlearn.MainActivity;
import com.infinity.ezlearn.Customer;

/**
 * Created by Infinity on 13/12/2017.
 */

public class OrderTicketActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_ticket);
        setTitle("Order Ticket");

        Spinner spCategory = (Spinner) findViewById(R.id.spCatTicket);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
        R.array.ticket_categories, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategory.setAdapter(adapter1);

        Spinner spMatch = (Spinner) findViewById(R.id.spMatch);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                    R.array.match, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spMatch.setAdapter(adapter2);

        Customer.fullName = (EditText) findViewById(R.id.etFullName);
        Customer.idNumber = (EditText) findViewById(R.id.etIDN);
        Customer.address = (EditText) findViewById(R.id.etAddress);
        Customer.phone = (EditText) findViewById(R.id.etPhone);
        Customer.ticketCategory = (Spinner) findViewById(R.id.spCatTicket);
        Customer.totalTicket = (EditText) findViewById(R.id.etTTicket);
        Customer.match = (Spinner) findViewById(R.id.spMatch);
    }

    public void ShowDialog(View view){
        if (checkOrdered()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setTitle("SUCCESS");
            builder.setMessage("You are successfully order your ticket!");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    Toast.makeText(getApplicationContext(), "Successfully Ordered!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
            builder.create().show();
        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setTitle("NOT COMPLETED");
            builder.setMessage("You must fill all input!");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    //
                }
            });
            builder.create().show();
        }

    }

    private boolean checkOrdered(){
        if (!Customer.fullName.getText().toString().isEmpty() && !Customer.idNumber.getText().toString().isEmpty()
                && !Customer.address.getText().toString().isEmpty() && !Customer.phone.getText().toString().isEmpty() &&
                !Customer.ticketCategory.getSelectedItem().toString().isEmpty() && !Customer.totalTicket.getText().toString().isEmpty()
                && !Customer.match.getSelectedItem().toString().isEmpty()
                && !Customer.ticketCategory.getSelectedItem().toString().equalsIgnoreCase("Choose one")
                && !Customer.match.getSelectedItem().toString().equalsIgnoreCase("Choose one")) {
            return true;
        }else {
            return false;
        }
    }
}
