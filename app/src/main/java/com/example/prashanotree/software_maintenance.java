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

public class software_maintenance extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_sm;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_software_maintenance);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_sm= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_sm);
        currentPos= random.nextInt(quizmodel_sm.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_sm.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_sm.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_sm.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_sm.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_sm.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_sm.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_sm.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_sm.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(software_maintenance.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_sm.size());
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
            questionTV.setText(quizmodel_sm.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_sm.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_sm.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_sm.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_sm.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_sm) {
        quizmodel_sm.add(new quizmodel("Software Maintenance includes","Error corrections","Enhancements of capabilities","Deletion of obsolete capabilities","All of the mentioned","All of the mentioned"));
        quizmodel_sm.add(new quizmodel("Maintenance is classified into how many categories ?","2","3","4","5","4"));
        quizmodel_sm.add(new quizmodel("The modification of the software to match changes in the ever changing environment, falls under which category of software maintenance?","Corrective","Adaptive","Perfective","Preventive","Adaptive"));
        quizmodel_sm.add(new quizmodel("How many phases are there in Taute Maintenance Model?","6","7","8","9","8"));
        quizmodel_sm.add(new quizmodel("What type of software testing is generally used in Software Maintenance?","Regression Testing","System Testing","Integration Testing","Unit Testing","Regression Testing"));
        quizmodel_sm.add(new quizmodel("Regression testing is a very expensive activity.","True","False","Cannot be Determine","None of these","True"));
        quizmodel_sm.add(new quizmodel("Selective retest techniques may be more economical than the “retest-all”technique.How many selective retest techniques are there?","2","3","4","5","3"));
        quizmodel_sm.add(new quizmodel("Which selective retest technique selects every test case that causes a modified program to produce a different output than its original version?","Coverage","Minimization","Safe","Maximization","Safe"));


    }
}