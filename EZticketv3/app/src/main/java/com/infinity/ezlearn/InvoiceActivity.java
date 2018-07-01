package com.infinity.ezlearn;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Infinity on 14/12/2017.
 */

public class InvoiceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invoice);
        setTitle("Invoice");

        TextView tvFN = (TextView) findViewById(R.id.tvFullName);
        tvFN.setText(Customer.fullName.getText().toString());
        TextView tvIN = (TextView) findViewById(R.id.tvIDN);
        tvIN.setText(Customer.idNumber.getText().toString());
        TextView tvAD = (TextView) findViewById(R.id.tvAddress);
        tvAD.setText(Customer.address.getText().toString());
        TextView tvPH = (TextView) findViewById(R.id.tvPhone);
        tvPH.setText(Customer.phone.getText().toString());
        TextView tvTC = (TextView) findViewById(R.id.tvCatTicket);
        tvTC.setText(Customer.ticketCategory.getSelectedItem().toString());
        TextView tvTT = (TextView) findViewById(R.id.tvTTicket);
        tvTT.setText(Customer.totalTicket.getText().toString());
        TextView tvM = (TextView) findViewById(R.id.tvMatch);
        tvM.setText(Customer.match.getSelectedItem().toString());

        int category = 0;
        if(Customer.ticketCategory.getSelectedItem().toString().equalsIgnoreCase("VVIP")){
            category = 100;
        }else if(Customer.ticketCategory.getSelectedItem().toString().equalsIgnoreCase("VIP")){
            category = 50;
        }else if(Customer.ticketCategory.getSelectedItem().toString().equalsIgnoreCase("Regular")){
            category = 25;
        }

        int tticket = Integer.parseInt(Customer.totalTicket.getText().toString());

        int bigmatch = 0;
        if(Customer.match.getSelectedItem().toString().toLowerCase().contains("Everton".toLowerCase())
                || Customer.match.getSelectedItem().toString().toLowerCase().contains("Arsenal".toLowerCase())
                || Customer.match.getSelectedItem().toString().toLowerCase().contains("Man Utd".toLowerCase())
                || Customer.match.getSelectedItem().toString().toLowerCase().contains("Barcelona".toLowerCase())){
            bigmatch = 20;
        }

        int price = (category + bigmatch) * tticket;
        String price2 = price + " USD";

        TextView tvP = (TextView) findViewById(R.id.tvPrice);
        tvP.setText(price2);
    }
}
