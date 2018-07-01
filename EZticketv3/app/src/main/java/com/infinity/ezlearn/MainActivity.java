package com.infinity.ezlearn;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.setMatchData();

        Button bOrderTicket = (Button)findViewById(R.id.button1);
        bOrderTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, OrderTicketActivity.class);
                startActivity(intent);
            }
        });

        Button bOrderCall = (Button)findViewById(R.id.button2);
        bOrderCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OrderCallActivity.class);
                startActivity(intent);
            }
        });

        Button bSchedule = (Button)findViewById(R.id.button3);
        bSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScheduleActivity.class);
                startActivity(intent);
            }
        });

        Button bInvoice = (Button)findViewById(R.id.button4);

            bInvoice.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (checkOrdered()) {
                        Intent intent = new Intent(MainActivity.this, InvoiceActivity.class);
                        startActivity(intent);
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setCancelable(false);
                        builder.setTitle("Alert!");
                        builder.setMessage("You must order your ticket first!");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                //
                            }
                        });
                    builder.create().show();
                    }
                }
            });

        Button bSuggest = (Button)findViewById(R.id.button5);
        bSuggest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SuggestionActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean checkOrdered(){
        if (Customer.fullName != null && Customer.idNumber != null && Customer.address != null
                && Customer.phone != null && Customer.ticketCategory != null &&
                Customer.totalTicket != null && Customer.match != null) {
            return true;
        }else {
            return false;
        }
    }

    private static void setMatchData(){
        MatchData.addMatchData("Chelsea vs Southampton", false, "Premier League", "16/12/17",0);
        MatchData.addMatchData("Chelsea vs Bournemouth", false, "League Cup", "21/12/17", 1);
        MatchData.addMatchData("Chelsea vs Everton", true, "Premier League", "23/12/17", 2);
        MatchData.addMatchData("Chelsea vs Brighton", false, "Premier League", "26/12/17", 3);
        MatchData.addMatchData("Chelsea vs Stoke City", false, "Premier League", "30/12/17", 4);
        MatchData.addMatchData("Arsenal vs Chelsea", true, "Premier League", "4/1/18", 5);
        MatchData.addMatchData("Norwich vs Chelsea", false, "FA Cup", "7/1/18", 6);
        MatchData.addMatchData("Chelsea vs Leicester", false, "Premier League", "13/1/18", 7);
        MatchData.addMatchData("Brighton vs Chelsea", false, "Premier League", "20/1/18", 8);
        MatchData.addMatchData("Chelsea vs Bournemouth", false, "Premier League", "1/2/18", 9);
        MatchData.addMatchData("Watford vs Chelsea", false, "Premier League", "3/1/18", 10);
        MatchData.addMatchData("Chelsea vs West Brom", false, "Premier League", "10/2/18", 11);
        MatchData.addMatchData("Chelsea vs Barcelona", true, "Champions League", "21/2/18", 12);
        MatchData.addMatchData("Man Utd vs Chelsea", true, "Premier League", "24/2/18", 13);
    }
}
