package com.example.prashanotree;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class java extends AppCompatActivity {
    private Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        button1 = findViewById(R.id.javaTopic1);
        button2 = findViewById(R.id.javaTopic2);
        button3 = findViewById(R.id.javaTopic3);
        button4 = findViewById(R.id.javaTopic4);
        button5 = findViewById(R.id.javaTopic5);
        button6 = findViewById(R.id.javaTopic6);
        button7 = findViewById(R.id.javaTopic7);
        button8 = findViewById(R.id.javaTopic8);
        button9 = findViewById(R.id.javaTopic9);
        button10 = findViewById(R.id.javaTopic10);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openIIFD();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openA();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAO();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBO();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOOP();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openM();
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMO();
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openO();
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openACS();
            }
        });


    }
    public void openIIFD(){
        Intent intent= new Intent(this,integer_and_floating_data_type.class);
        startActivity(intent);
    }
    public void openA(){
        Intent intent1 = new Intent(this,arrays.class);
        startActivity(intent1);
    }
    public void openAO(){
        Intent intent2 = new Intent(this,arithmetic_operation.class);
        startActivity(intent2);
    }
    public void openBO(){
        Intent intent3 = new Intent(this,bitwise_operator.class);
        startActivity(intent3);
    }
    public void openOOP(){
        Intent intent4 = new Intent(this,oops.class);
        startActivity(intent4);
    }
    public void openM(){
        Intent intent5 = new Intent(this, method.class);
        startActivity(intent5);
    }
    public void openMO(){
        Intent intent6 = new Intent(this,method_overriding.class);
        startActivity(intent6);
    }
    public void openO(){
        Intent intent7 = new Intent(this,object.class);
        startActivity(intent7);
    }
    public void openACS(){
        Intent intent8 = new Intent(this,abstract_class_and_super.class);
        startActivity(intent8);
    }
}