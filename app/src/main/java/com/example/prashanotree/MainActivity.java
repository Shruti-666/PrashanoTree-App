package com.example.prashanotree;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button button,button1,button2,button3,button4,button5,button6,button7,button8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button= findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });

        button1= findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        button2 = findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
        button3 = findViewById(R.id.button4);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });
        button4 = findViewById(R.id.button5);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();
            }
        });
        button5 = findViewById(R.id.button6);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity6();
            }
        });
        button6 = findViewById(R.id.button7);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity7();
            }
        });
        button7 = findViewById(R.id.button8);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity8();
            }
        });
        button8 = findViewById(R.id.button9);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity9();
            }
        });

    }
    public void openActivity1(){
        Intent intent = new Intent(this,Data_Structure_and_Algorithm.class);
        startActivity(intent);
    }

    public void openActivity2(){
        Intent intent1= new Intent(this,java.class);
        startActivity(intent1);
    }
    public void openActivity3(){
        Intent intent2 = new Intent(this,computer_networks.class);
        startActivity(intent2);
    }
    public void openActivity4(){
        Intent intent3 = new Intent(this,software_engineering.class);
        startActivity(intent3);
    }
    public void openActivity5(){
        Intent intent4 = new Intent(this, c_language.class);
        startActivity(intent4);
    }
    public void openActivity6(){
        Intent intent5 = new Intent(this, html.class);
        startActivity(intent5);
    }
    public void openActivity7(){
        Intent intent6 = new Intent(this,python1.class);
        startActivity(intent6);
    }
    public void openActivity8(){
        Intent intent7 = new Intent(this,sql.class);
        startActivity(intent7);
    }
    public void openActivity9(){
        Intent intent8 = new Intent(this,css.class);
        startActivity(intent8);
    }
}