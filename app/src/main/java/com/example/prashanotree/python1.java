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

public class python1 extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_python;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python1);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_python= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_python);
        currentPos= random.nextInt(quizmodel_python.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_python.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_python.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_python.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_python.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_python.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_python.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_python.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_python.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(python1.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_python.size());
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
            questionTV.setText(quizmodel_python.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_python.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_python.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_python.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_python.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_python) {
        quizmodel_python.add(new quizmodel("Who developed Python Programming Language?","Wick van Rossum","Rasmus Lerdorf","Guido van Rossum","Niene Stom","Guido van Rossum"));
        quizmodel_python.add(new quizmodel("Which type of Programming does Python support?","object-oriented programming","structured programming","functional programming","all of the mentioned","all of the mentioned"));
        quizmodel_python.add(new quizmodel("Is Python case sensitive when dealing with identifiers?","no","yes","machine dependent","none of the mentioned","no"));
        quizmodel_python.add(new quizmodel("Which of the following is the correct extension of the Python file?",".python",".pl",".py",".p",".py"));
        quizmodel_python.add(new quizmodel("Is Python code compiled or interpreted?","Python code is both compiled and interpreted","Python code is neither compiled nor interpreted","Python code is only compiled","Python code is only interpreted","Python code is neither compiled nor interpreted"));
        quizmodel_python.add(new quizmodel("All keywords in Python are in _________","Capitalized","lower case","UPPER CASE","None of the mentioned","None of the mentioned"));
        quizmodel_python.add(new quizmodel("What will be the value of the following Python expression?\n4 + 3 % 5","7","2","4","1","7"));
        quizmodel_python.add(new quizmodel("Which of the following is used to define a block of code in Python language?","Indentation","Key","Brackets","All of the mentioned","Indentation"));
        quizmodel_python.add(new quizmodel("Which keyword is used for function in Python language?","Function","Def","Fun","Define","Def"));
        quizmodel_python.add(new quizmodel("Which of the following character is used to give single-line comments in Python?","//","#","!","/*","#"));
        quizmodel_python.add(new quizmodel("Which of the following functions can help us to find the version of python that we are currently working on?","sys.version(1)","sys.version(0)","sys.version()","sys.version","sys.version(1)"));
        quizmodel_python.add(new quizmodel("Python supports the creation of anonymous functions at runtime, using a construct called __________","pi","anonymous","lambda","None","lambda"));
        quizmodel_python.add(new quizmodel(" What is the order of precedence in python?","Exponential, Parentheses, Multiplication, Division, Addition, Subtraction","Exponential, Parentheses, Division, Multiplication, Addition, Subtraction","Parentheses, Exponential, Multiplication, Division, Subtraction, Addition","Parentheses, Exponential, Multiplication, Division, Addition, Subtraction","Parentheses, Exponential, Multiplication, Division, Addition, Subtraction"));
        quizmodel_python.add(new quizmodel("What will be the output of the following Python code snippet if x=1?\nx<<2","4","2","1","8","4"));
        quizmodel_python.add(new quizmodel("What does pip stand for python?","unlimited length","all private members must have leading and trailing underscores","Preferred Installer Program","none of the mentioned","Preferred Installer Program"));
        quizmodel_python.add(new quizmodel("Which of the following is true for variable names in Python?","underscore and ampersand are the only two special characters allowed","unlimited length","all private members must have leading and trailing underscores","none of the mentioned","unlimited length"));
        quizmodel_python.add(new quizmodel("Which of the following is the truncation division operator in Python?","|","//","/","%","//"));
        quizmodel_python.add(new quizmodel("Which of the following functions is a built-in function in python?","factorial()","print()","seed()","sqrt()","print()"));

    }
}