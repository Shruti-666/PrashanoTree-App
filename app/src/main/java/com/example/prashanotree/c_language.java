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

public class c_language extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_cl;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clanguage);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_cl= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_cl);
        currentPos= random.nextInt(quizmodel_cl.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_cl.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_cl.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_cl.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_cl.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_cl.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_cl.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_cl.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_cl.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(c_language.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_cl.size());
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
            questionTV.setText(quizmodel_cl.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_cl.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_cl.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_cl.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_cl.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_cl) {
       quizmodel_cl.add(new quizmodel("Who is the father of C language?","Steve Jobs","James Gosling","Dennis Ritchie","Rasmus Lerdorf","Dennis Ritchie"));
       quizmodel_cl.add(new quizmodel("Which of the following is not a valid C variable name?","int number;","float rate;","int variable_count;","int $main;","int $main;"));
       quizmodel_cl.add(new quizmodel("All keywords in C are in ____________","LowerCase letters","UpperCase letters","CamelCase letters","None of the mentioned","LowerCase letters"));
       quizmodel_cl.add(new quizmodel("Which of the following is true for variable names in C?","They can contain alphanumeric characters as well as special characters","It is not an error to declare a variable to be one of the keywords(like goto, static)","Variable names cannot start with a digit","Variable can be of any length","Variable names cannot start with a digit"));
       quizmodel_cl.add(new quizmodel("Which is valid C expression?","int my_num = 100,000;","int my_num = 100000;","int my num = 1000;","int $my_num = 10000;","int my_num = 100000;"));
       quizmodel_cl.add(new quizmodel("Which of the following cannot be a variable name in C?","volatile","true","friend","export","volatile"));
       quizmodel_cl.add(new quizmodel("What is short int in C programming?","The basic data type of C","Qualifier","Short is the qualifier and int is the basic data type","All of the mentioned","Short is the qualifier and int is the basic data type"));
       quizmodel_cl.add(new quizmodel("Which of the following declaration is not supported by C language?","String str;","char *str;","float str = 3e2;","Both String str; & float str = 3e2;","String str;"));
       quizmodel_cl.add(new quizmodel("Which keyword is used to prevent any changes in the variable within a C program?","immutable","mutable","const","volatile","const"));
       quizmodel_cl.add(new quizmodel("What is the result of logical or relational expression in C?","True or False","0 or 1","0 if an expression is false and any positive number if an expression is true","None of the mentioned","0 or 1"));
       quizmodel_cl.add(new quizmodel("Which of the following typecasting is accepted by C language?","Widening conversions","Narrowing conversions","Widening & Narrowing conversions","None of the mentioned","Widening & Narrowing conversions"));
       quizmodel_cl.add(new quizmodel("Where in C the order of precedence of operators do not exist?","Within conditional statements, if, else","Within while, do-while","Within a macro definition","None of the mentioned","None of the mentioned"));
       quizmodel_cl.add(new quizmodel("Which of the following is NOT possible with any 2 operators in C?","Different precedence, same associativity","Different precedence, different associativity","Same precedence, different associativity","All of the mentioned","Same precedence, different associativity"));
       quizmodel_cl.add(new quizmodel("What is an example of iteration in C?","for","while","do-while","all of the mentioned","all of the mentioned"));
       quizmodel_cl.add(new quizmodel("Functions can return enumeration constants in C?","true","false","depends on the compiler","depends on the standard","true"));
       quizmodel_cl.add(new quizmodel("Functions in C Language are always _________","Internal","External","Both Internal and External","External and Internal are not valid terms for","External"));
       quizmodel_cl.add(new quizmodel("Which of following is not accepted in C?","static a = 10; //static as","static int func (int); //parameter as static","static static int a; //a static variable prefixed with static","all of the mentioned","static static int a; //a static variable prefixed with static"));
       quizmodel_cl.add(new quizmodel("Property which allows to produce different executable for different platforms in C is called?","File inclusion","Selective inclusion","Conditional compilation","Recursive macros","Conditional compilation"));
       quizmodel_cl.add(new quizmodel("What is #include <stdio.h>?","Preprocessor directive","Inclusion directive","File inclusion directive","None of the mentioned","Preprocessor directive"));
       quizmodel_cl.add(new quizmodel("C preprocessors can have compiler specific features.","True","False","Depends on the standard","Depends on the platform","True"));
       quizmodel_cl.add(new quizmodel("Which of the following are C preprocessors?","#ifdef","#define","#endif","all of the mentioned","all of the mentioned"));
       quizmodel_cl.add(new quizmodel("The C-preprocessors are specified with _________ symbol.","#","$","” ”","&","#"));
       quizmodel_cl.add(new quizmodel("How is search done in #include and #include “somelibrary.h” according to C standard?","When former is used, current directory is searched and when latter is used, standard directory is searched","When former is used, standard directory is searched and when latter is used, current directory is searched","When former is used, search is done in implementation defined manner and when latter is used, current directory is searched","For both, search for ‘somelibrary’ is done in implementation-defined places","For both, search for ‘somelibrary’ is done in implementation-defined places"));
       quizmodel_cl.add(new quizmodel("How many number of pointer (*) does C have against a pointer variable declaration?","7","127","255","No limits","No limits"));
       quizmodel_cl.add(new quizmodel("Which of the following is not possible statically in C language?","Jagged Array","Rectangular Array","Cuboidal Array","Multidimensional Array","Jagged Array"));
       quizmodel_cl.add(new quizmodel("Which of the following return-type cannot be used for a function in C?","char *","struct","void","none of the mentioned","none of the mentioned"));
       quizmodel_cl.add(new quizmodel("The standard header _______ is used for variable list arguments (…) in C.","<stdio.h >","<stdlib.h>","<math.h>","<stdarg.h>","<stdarg.h>"));
       quizmodel_cl.add(new quizmodel("When a C program is started, O.S environment is responsible for opening file and providing pointer for that file?","Standard input","Standard output","Standard error","All of the mentioned","All of the mentioned"));
       quizmodel_cl.add(new quizmodel("In C language, FILE is of which data type?","int","char *","struct","None of the mentioned","struct"));
       quizmodel_cl.add(new quizmodel("What is the sizeof(char) in a 32-bit C compiler?","1 bit","2 bits","1 Bytes","2 Bytes","1 Bytes"));


    }
}