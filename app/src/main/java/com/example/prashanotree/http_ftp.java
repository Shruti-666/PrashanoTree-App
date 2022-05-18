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

public class http_ftp extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_hf;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_ftp);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_hf= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_hf);
        currentPos= random.nextInt(quizmodel_hf.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_hf.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_hf.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_hf.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_hf.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_hf.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_hf.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_hf.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_hf.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(http_ftp.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_hf.size());
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
            questionTV.setText(quizmodel_hf.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_hf.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_hf.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_hf.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_hf.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_hf) {
        quizmodel_hf.add(new quizmodel("Multiple objects can be sent over a TCP connection between client and server in a persistent HTTP connection.","True","False","Cannot be determined","None of these","True"));
        quizmodel_hf.add(new quizmodel("HTTP is ________ protocol.","application layer","transport layer","network layer","data link layer","application layer"));
        quizmodel_hf.add(new quizmodel("In the network HTTP resources are located by","uniform resource identifier","unique resource locator","unique resource identifier","union resource locator","uniform resource identifier"));
        quizmodel_hf.add(new quizmodel("HTTP client requests by establishing a __________","user datagram protocol","transmission control protocol","border gateway protocol","domain host control protocol","transmission control protocol"));
        quizmodel_hf.add(new quizmodel("In HTTP pipelining ________________","multiple HTTP requests are sent on a single TCP connection without waiting for the corresponding responses","multiple HTTP requests can not be sent on a single TCP connection","multiple HTTP requests are sent in a queue on a single TCP connection","multiple HTTP requests are sent at random on a single TCP connection","multiple HTTP requests are sent on a single TCP connection without waiting for the corresponding responses"));
        quizmodel_hf.add(new quizmodel("FTP server listens for connection on port number ____________","20","21","22","23","21"));
        quizmodel_hf.add(new quizmodel("In FTP protocol, client contacts server using ____ as the transport protocol.","transmission control protocol","user datagram protocol","datagram congestion control protocol","stream control transmission protocol","transmission control protocol"));
        quizmodel_hf.add(new quizmodel("In Active mode FTP, the client initiates both the control and data connections.","True","False","Cannot be determined","None of these","False"));
        quizmodel_hf.add(new quizmodel("The File Transfer Protocol is built on ______________","data centric architecture","service oriented architecture","client server architecture","connection oriented architecture","client server architecture"));
        quizmodel_hf.add(new quizmodel("In File Transfer Protocol, data transfer cannot be done in ___________","stream mode","block mode","compressed mode","message mode","message mode"));

    }
}