package com.example.prashanotree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class computer_networks extends AppCompatActivity {
    private Button button1,button2,button3,button4,button5,button6,button7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_networks);
        button1 = findViewById(R.id.cnTopic1);
        button2 = findViewById(R.id.cnTopic2);
        button3 = findViewById(R.id.cnTopic3);
        button4 = findViewById(R.id.cnTopic4);
        button5 = findViewById(R.id.cnTopic5);
        button6 = findViewById(R.id.cnTopic6);
        button7 = findViewById(R.id.cnTopic7);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openA();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPL();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNL();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDL();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHF();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCC();
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWL();
            }
        });
    }
    public void openA(){
        Intent intent = new Intent(this,access_network.class);
        startActivity(intent);
    }
    public void openPL(){
        Intent intent1 = new Intent(this, physical_layer.class);
        startActivity(intent1);
    }
    public void openNL(){
        Intent intent2 = new Intent(this, network_layer.class);
        startActivity(intent2);
    }
    public void openDL(){
        Intent intent3 = new Intent(this, delay_loss.class);
        startActivity(intent3);
    }
    public void openHF(){
        Intent intent4 = new Intent(this, http_ftp.class);
        startActivity(intent4);
    }
    public void openCC(){
        Intent intent5 = new Intent(this, congestion.class);
        startActivity(intent5);
    }
    public void openWL(){
        Intent intent6 = new Intent(this, wireless.class);
        startActivity(intent6);
    }
}