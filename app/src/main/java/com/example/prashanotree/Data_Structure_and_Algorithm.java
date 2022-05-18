package com.example.prashanotree;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Data_Structure_and_Algorithm extends AppCompatActivity {
    private Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_structure_and_algorithm);

        button1 = findViewById(R.id.dsaTopic1);
        button2 = findViewById(R.id.dsaTopic2);
        button3 = findViewById(R.id.dsaTopic3);
        button4 = findViewById(R.id.dsaTopic4);
        button5 = findViewById(R.id.dsaTopic5);
        button6 = findViewById(R.id.dsaTopic6);
        button7 = findViewById(R.id.dsaTopic7);
        button8 = findViewById(R.id.dsaTopic8);
        button9 = findViewById(R.id.dsaTopic9);
        button10 = findViewById(R.id.dsaTopic10);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAAP();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQ();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openS();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSLL();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDLL();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openIP();
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDA();
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBA();
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openH();
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openG();
            }
        });

    }
    public void openAAP(){
        Intent intent = new Intent(this,ArrayandArrayOperation.class);
        startActivity(intent);
    }
    public void openQ(){
        Intent intent1 = new Intent(this,queue.class);
        startActivity(intent1);
    }
    public void openS(){
        Intent intent2 = new Intent(this,stack_operation.class);
        startActivity(intent2);
    }
    public void openSLL(){
        Intent intent3 = new Intent(this,singly_linked_list.class);
        startActivity(intent3);
    }
    public void openDLL(){
        Intent intent4 = new Intent(this,double_linked_list.class);
        startActivity(intent4);
    }
    public void openIP(){
        Intent intent5 = new Intent(this,infix_and_postfix.class);
        startActivity(intent5);
    }
    public void openDA(){
        Intent intent6 = new Intent(this,dynamic_array.class);
        startActivity(intent6);
    }
    public void openBA(){
        Intent intent7 = new Intent(this,binaryarray.class);
        startActivity(intent7);
    }
    public void openH(){
        Intent intent8 = new Intent(this,heap.class);
        startActivity(intent8);
    }
    public void openG(){
        Intent intent9 = new Intent(this,graph.class);
        startActivity(intent9);
    }

}