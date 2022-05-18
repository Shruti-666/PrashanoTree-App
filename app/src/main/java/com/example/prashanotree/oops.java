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

public class oops extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_oops;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oops);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_oops= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_oops);
        currentPos= random.nextInt(quizmodel_oops.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_oops.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_oops.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_oops.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_oops.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_oops.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_oops.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_oops.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_oops.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(oops.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_oops.size());
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
            questionTV.setText(quizmodel_oops.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_oops.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_oops.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_oops.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_oops.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_oops) {
        quizmodel_oops.add(new quizmodel("Which of the following is not OOPS concept in Java?","Inheritance","Encapsulation","Polymorphism","Compilation","Compilation"));
        quizmodel_oops.add(new quizmodel("Which of the following is a type of polymorphism in Java?","Compile time polymorphism","Execution time polymorphism","Multiple polymorphism","Multilevel polymorphism","Compile time polymorphism"));
        quizmodel_oops.add(new quizmodel("When does method overloading is determined?","At run time","At compile time","At coding time","At execution time","At compile time"));
        quizmodel_oops.add(new quizmodel("When Overloading does not occur?","More than one method with same name but different method signature and different number or type of parameters","More than one method with same name, same signature but different number of signature","More than one method with same name, same signature, same number of parameters but different type","More than one method with same name, same number of parameters and type but different signature","More than one method with same name, same number of parameters and type but different signature"));
        quizmodel_oops.add(new quizmodel("Which concept of Java is a way of converting real world objects in terms of class?","Polymorphism","Encapsulation","Abstraction","Inheritance","Abstraction"));
        quizmodel_oops.add(new quizmodel("Which concept of Java is achieved by combining methods and attribute into a class?","Encapsulation","Inheritance","Polymorphism","Abstraction","Encapsulation"));
        quizmodel_oops.add(new quizmodel("What is it called if an object has its own lifecycle and there is no owner?","Aggregation","Composition","Encapsulation","Association","Association"));
        quizmodel_oops.add(new quizmodel("What is it called where child object gets killed if parent object is killed?","Aggregation","Composition","Encapsulation","Association","Composition"));
        quizmodel_oops.add(new quizmodel("What is it called where object has its own lifecycle and child object cannot belong to another parent object?","Aggregation","Composition","Encapsulation","Association","Aggregation"));
        quizmodel_oops.add(new quizmodel("Method overriding is combination of inheritance and polymorphism?","True","False","Cannot be determined","None of these","True"));

    }
}