package com.infinity.ezlearn;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OrderCallActivity extends AppCompatActivity {
    Button btn;
    String sNum = "085784272424";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_by_call);
        setTitle("Order By Call");
        btn = (Button) findViewById(R.id.idbtnCall);
    }

    public void btnClick(View v){
        Intent i = new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel: "+sNum));
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "Please grant the permission to call", Toast.LENGTH_SHORT).show();
            requestPermission();
        }else{
            startActivity(i);
        }
    }

    private void requestPermission(){
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},1);
    }
}
