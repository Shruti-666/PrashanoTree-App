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

public class evolution extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_e;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evolution);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_e= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_e);
        currentPos= random.nextInt(quizmodel_e.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_e.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_e.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_e.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_e.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_e.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_e.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_e.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_e.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(evolution.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_e.size());
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
            questionTV.setText(quizmodel_e.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_e.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_e.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_e.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_e.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_e) {
        quizmodel_e.add(new quizmodel("The two dimensions of spiral model are","diagonal, angular","radial, perpendicular","radial, angular","diagonal, perpendicular","radial, angular"));
        quizmodel_e.add(new quizmodel("The Incremental Model is combination of elements of","Build & FIX Model & Waterfall Model","Linear Model & RAD Model","Linear Model & Prototyping Model","Waterfall Model & RAD Model","Linear Model & Prototyping Model"));
        quizmodel_e.add(new quizmodel("Model preferred to create client/server applications is","WINWIN Spiral Model","Spiral Model","Concurrent Model","Incremental Model","Concurrent Model"));
        quizmodel_e.add(new quizmodel("Identify the correct statement with respect to Evolutionary development:","Evolutionary development usually has two flavors; exploratory development, and throw-away prototyping","Very large projects are usually done using evolutionary development based approach","It facilitates easy project management, through the high volume of documentation it generates","Sometimes the construction of a throw-away prototype is not followed by a re- implementation of the software system using a more structured approach","Evolutionary development usually has two flavors; exploratory development, and throw-away prototyping"));
        quizmodel_e.add(new quizmodel("Spiral model was developed by","Victor Bisili","Berry Boehm","Bev Littlewood","Roger Pressman","Berry Boehm"));
        quizmodel_e.add(new quizmodel("Software evolution does not comprises:","Development activities","Negotiating with client","Maintenance activities","Re-engineering activities","Negotiating with client"));
        quizmodel_e.add(new quizmodel("Processes for evolving a software product depend on:","Type of software to be maintained","Development processes used","Skills and experience of the people involved","All of the mentioned","All of the mentioned"));
        quizmodel_e.add(new quizmodel("Which technique is applied to ensure the continued evolution of legacy systems ?","Forward engineering","Reverse Engineering","Reengineering","Reverse Engineering and Reengineering","Reverse Engineering and Reengineering"));
        quizmodel_e.add(new quizmodel("Program modularization and Source code translation are the activities of_____________","Forward engineering","Reverse Engineering","Reengineering","Reverse Engineering and Reengineering","Reengineering"));

    }
}