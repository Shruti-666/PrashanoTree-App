package com.example.prashanotree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class wireless extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_w;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wireless);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_w= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_w);
        currentPos= random.nextInt(quizmodel_w.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_w.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_w.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_w.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_w.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_w.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_w.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_w.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_w.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(wireless.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_w.size());
                setDatatoViews(currentPos);
                questionAttempted = 0;
                currentScore = 0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }
    private void setDatatoViews(int currentPos){
        if(questionAttempted==10){
            showBottomSheet();
        }
        else{
            questionNumberTV.setText("Questions Attempted : "+questionAttempted+"/10");
            questionTV.setText(quizmodel_w.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_w.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_w.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_w.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_w.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_w) {
        quizmodel_w.add(new quizmodel("What is the access point (AP) in a wireless LAN?","device that allows wireless devices to connect to a wired network","wireless devices itself","both device that allows wireless devices to connect to a wired network and wireless devices itself","all the nodes in the network","device that allows wireless devices to connect to a wired network"));
        quizmodel_w.add(new quizmodel("In wireless ad-hoc network _________","access point is not required","access point is must","nodes are not required","all nodes are access points","access point is not required"));
        quizmodel_w.add(new quizmodel("Which multiple access technique is used by IEEE 802.11 standard for wireless LAN?","CDMA","CSMA/CA","ALOHA","CSMA/CD","CSMA/CA"));
        quizmodel_w.add(new quizmodel("In wireless distribution system __________","multiple access point are inter-connected with each other","there is no access point","only one access point exists","access points are not required","multiple access point are inter-connected with each other"));
        quizmodel_w.add(new quizmodel("A wireless network interface controller can work in _______","infrastructure mode","ad-hoc mode","both infrastructure mode and ad-hoc mode","WDS mode","both infrastructure mode and ad-hoc mode"));
        quizmodel_w.add(new quizmodel("In wireless network an extended service set is a set of ________","connected basic service sets","all stations","all access points","connected access points","connected basic service sets"));
        quizmodel_w.add(new quizmodel("Mostly ________ is used in wireless LAN.","time division multiplexing","orthogonal frequency division multiplexing","space division multiplexing","channel division multiplexing","orthogonal frequency division multiplexing"));
        quizmodel_w.add(new quizmodel("Which one of the following event is not possible in wireless LAN?","collision detection","acknowledgement of data frames","multi-mode data transmission","connection to wired networks","collision detection"));
        quizmodel_w.add(new quizmodel("What is Wired Equivalent Privacy (WEP)?","security algorithm for ethernet","security algorithm for wireless networks","security algorithm for usb communication","security algorithm for emails","security algorithm for wireless networks"));
        quizmodel_w.add(new quizmodel("What is WPA?","wi-fi protected access","wired protected access","wired process access","wi-fi process access","wi-fi protected access"));

    }
}