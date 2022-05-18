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

public class dependability_security extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_d_s;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependability_security);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_d_s= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_d_s);
        currentPos= random.nextInt(quizmodel_d_s.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_d_s.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_d_s.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_d_s.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_d_s.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_d_s.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_d_s.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_d_s.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_d_s.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(dependability_security.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_d_s.size());
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
            questionTV.setText(quizmodel_d_s.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_d_s.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_d_s.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_d_s.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_d_s.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_d_s) {
        quizmodel_d_s.add(new quizmodel("A characteristic of a software system that can lead to a system error is known as?","Human error or mistake","System fault","System error","System failure","System fault"));
        quizmodel_d_s.add(new quizmodel("An erroneous system state that can lead to system behavior that is unexpected by system users is known as?","Human error or mistake","System fault","System error","System failure","System error"));
        quizmodel_d_s.add(new quizmodel("An event that occurs at some point in time when the system does not deliver a service as expected by its users is called _____________","Human error or mistake","System fault","System error","System failure","System failure"));
        quizmodel_d_s.add(new quizmodel(" A chemical plant system may detect excessive pressure and open a relief valve to reduce these pressures before an explosion occurs. What kind of dependability and security issue the example states?","Hazard avoidance","Damage limitation","Hazard detection","Hazard detection and removal","Hazard detection and removal"));
        quizmodel_d_s.add(new quizmodel("An aircraft engine normally includes automatic fire extinguishers.What kind of dependability and security issue the example states?","Hazard avoidance","Damage limitation","Hazard detection","Hazard detection and removal","Damage limitation"));
        quizmodel_d_s.add(new quizmodel("An assessment of the worst possible damage that could result from a particular hazard is known as","Risk","Hazard probability","Hazard severity","Mishap","Hazard severity"));
        quizmodel_d_s.add(new quizmodel("which of the following terms is a measure of the probability that the system will cause an accident?","Risk","Hazard probability","Hazard severity","Mishap","Risk"));
        quizmodel_d_s.add(new quizmodel("A weakness in a computer-based system that may be exploited to cause loss or harm is known as?","Vulnerability","Attack","Threat","Exposure","Vulnerability"));
        quizmodel_d_s.add(new quizmodel("A password checking system that disallows user passwords that are proper names or words that are normally included in a dictionary is an example of ___________ with respect to security systems.","risk","control","attack","addet","control"));
        quizmodel_d_s.add(new quizmodel("The safety of a system is a system attribute that reflects the system’s ability to operate, normally or abnormally, without injury to people or damage to the environment.","True","False","Cannot determined","None of These","true"));


    }

}