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

public class constructor extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_constructor;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constructor);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_constructor= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_constructor);
        currentPos= random.nextInt(quizmodel_constructor.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_constructor.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_constructor.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_constructor.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_constructor.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_constructor.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_constructor.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_constructor.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_constructor.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(constructor.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_constructor.size());
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
            questionTV.setText(quizmodel_constructor.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_constructor.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_constructor.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_constructor.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_constructor.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_constructor) {
        quizmodel_constructor.add(new quizmodel("What is true about private constructor?","Private constructor ensures only one instance of a class exist at any point of time","Private constructor ensures multiple instances of a class exist at any point of time","Private constructor eases the instantiation of a class","Private constructor allows creating objects in other classes","Private constructor ensures only one instance of a class exist at any point of time"));
        quizmodel_constructor.add(new quizmodel("What would be the behaviour if this() and super() used in a method?","Runtime error","Throws exception","compile time error","Runs successfully","compile time error"));
        quizmodel_constructor.add(new quizmodel("What is false about constructor?","Constructors cannot be synchronized in Java","Java does not provide default copy constructor","Constructor can have a return type","“this” and “super” can be used in a constructor","Constructor can have a return type"));
        quizmodel_constructor.add(new quizmodel("What is true about Class.getInstance()?","Class.getInstance calls the constructor","Class.getInstance is same as new operator","Class.getInstance needs to have matching constructor","Class.getInstance creates object if class does not have any constructor","Class.getInstance creates object if class does not have any constructor"));
        quizmodel_constructor.add(new quizmodel("What is true about constructor?","It can contain return type","It can take any number of parameters","It can have any non access modifiers","Constructor cannot throw an exception","It can take any number of parameters"));
        quizmodel_constructor.add(new quizmodel("Abstract class cannot have a constructor.","True","False","Cannot be determined","None of these","False"));
        quizmodel_constructor.add(new quizmodel("What is true about protected constructor?","Protected constructor can be called directly","Protected constructor can only be called using super()","Protected constructor can be used outside package","protected constructor can be instantiated even if child is in a different package","Protected constructor can only be called using super()"));
        quizmodel_constructor.add(new quizmodel("What is not the use of “this” keyword in Java?","Passing itself to another method","Calling another constructor in constructor chaining","Referring to the instance variable when local variable has the same name","Passing itself to method of the same class","Passing itself to method of the same class"));
        quizmodel_constructor.add(new quizmodel("What would be the behaviour if one parameterized constructor is explicitly defined?","Compilation error","Compilation succeeds","Runtime error","Compilation succeeds but at the time of creating object using default constructor, it throws compilation error","Compilation succeeds but at the time of creating object using default constructor, it throws compilation error"));
        quizmodel_constructor.add(new quizmodel("What would be behaviour if the constructor has a return type?","Compilation error","Runtime error","Compilation and runs successfully","Only String return type is allowed","Compilation error"));

    }
}