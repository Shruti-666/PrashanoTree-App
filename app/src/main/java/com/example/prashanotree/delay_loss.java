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

public class delay_loss extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_dl;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delay_loss);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_dl= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_dl);
        currentPos= random.nextInt(quizmodel_dl.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_dl.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_dl.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_dl.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_dl.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_dl.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_dl.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_dl.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_dl.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(delay_loss.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_dl.size());
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
            questionTV.setText(quizmodel_dl.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_dl.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_dl.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_dl.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_dl.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_dl) {
        quizmodel_dl.add(new quizmodel("Which of the following delay is faced by the packet in travelling from one end system to another?","Propagation delay","Queuing delay","Transmission delay","All of the mentioned","All of the mentioned"));
        quizmodel_dl.add(new quizmodel("For a 10Mbps Ethernet link, if the length of the packet is 32bits, the transmission delay is ____________ (in microseconds)","3.2","32","0.32","320","3.2"));
        quizmodel_dl.add(new quizmodel("The time required to examine the packet’s header and determine where to direct the packet is part of __________","Processing delay","Queuing delay","Transmission delay","Propagation delay","Processing delay"));
        quizmodel_dl.add(new quizmodel("Given L = number of bits in the packet, a = average rate and R = transmission rate. The Traffic intensity in the network is given by ____________","La/R","LR/a","R/La","Ra/L","La/R"));
        quizmodel_dl.add(new quizmodel("In the transfer of file between server and client, if the transmission rates along the path is 10Mbps, 20Mbps, 30Mbps, 40Mbps. The throughput is usually ___________","20Mbps","10Mbps","40Mbps","50Mbps","10Mbps"));
        quizmodel_dl.add(new quizmodel("If end to end delay is given by dend-end = N(dproc + dtrans + dprop) is a non congested network. The number of routers between source and destination is?","N/2","N","N-1","2N","N-1"));
        quizmodel_dl.add(new quizmodel("The total nodal delay is given by ____________","dnodal = dproc – dqueue + dtrans + dprop","dnodal = dproc + dtrans – dqueue","dnodal = dproc + dqueue + dtrans + dprop","dnodal = dproc + dqueue – dtrans – dprop","dnodal = dproc + dqueue + dtrans + dprop"));
        quizmodel_dl.add(new quizmodel("In a network, If P is the only packet being transmitted and there was no earlier transmission, which of the following delays could be zero?","Propagation delay","Queuing delay","Transmission delay","Processing delay","Queuing delay"));
        quizmodel_dl.add(new quizmodel("Transmission delay does not depend on _____________","Packet length","Distance between the routers","Transmission rate","Bandwidth of medium","Distance between the routers"));
        quizmodel_dl.add(new quizmodel("Propagation delay depends on ___________","Packet length","Transmission rate","Distance between the routers","Speed of the CPU","Distance between the routers"));

    }
}