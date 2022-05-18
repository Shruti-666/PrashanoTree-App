package com.example.prashanotree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class software_engineering extends AppCompatActivity {
    private Button button1,button2,button3,button4,button5,button6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_software_engineering);
        button1 = findViewById(R.id.cnTopic1);
        button2 = findViewById(R.id.cnTopic2);
        button3 = findViewById(R.id.cnTopic3);
        button4 = findViewById(R.id.cnTopic4);
        button5 = findViewById(R.id.cnTopic5);
        button6 = findViewById(R.id.cnTopic6);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSM();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSE();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDS();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSD();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPM();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSm();
            }
        });

    }
    private void openSM(){
        Intent intent= new Intent(this,modelling.class);
        startActivity(intent);
    }
    private void openSE(){
        Intent intent1= new Intent(this,evolution.class);
        startActivity(intent1);
    }
    private void openDS(){
        Intent intent2= new Intent(this,dependability_security.class);
        startActivity(intent2);
    }
    private void openSD(){
        Intent intent3= new Intent(this,software_design.class);
        startActivity(intent3);
    }
    private void openPM(){
        Intent intent4= new Intent(this,projct_management.class);
        startActivity(intent4);
    }
    private void openSm(){
        Intent intent5= new Intent(this,software_maintenance.class);
        startActivity(intent5);
    }
}