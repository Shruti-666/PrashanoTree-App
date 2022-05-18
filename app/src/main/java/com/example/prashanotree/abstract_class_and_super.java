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

public class abstract_class_and_super extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_acs;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abstract_class_and_super);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_acs= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_acs);
        currentPos= random.nextInt(quizmodel_acs.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_acs.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_acs.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_acs.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_acs.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_acs.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_acs.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_acs.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_acs.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(abstract_class_and_super.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_acs.size());
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
            questionTV.setText(quizmodel_acs.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_acs.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_acs.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_acs.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_acs.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_acs) {
        quizmodel_acs.add(new quizmodel("Which of these keywords are used to define an abstract class?","abst","abstract","Abstract","abstract class","abstract"));
        quizmodel_acs.add(new quizmodel("Which of these is not abstract?","Thread","AbstractList","List","None of the Mentioned","Thread"));
        quizmodel_acs.add(new quizmodel("If a class inheriting an abstract class does not define all of its function then it will be known as?","Abstract","A simple class","Static class","None of the mentioned","Abstract"));
        quizmodel_acs.add(new quizmodel("Which of these is not a correct statement?","Every class containing abstract method must be declared abstract","Abstract class defines only the structure of the class not its implementation","Abstract class can be initiated by new operator","Abstract class can be inherited","Abstract class can be initiated by new operator"));
        quizmodel_acs.add(new quizmodel("Which of these packages contains abstract keyword?","java.lang","java.util","java.io","java.system","java.lang"));
        quizmodel_acs.add(new quizmodel("What will be the output of the following Java code?\n\n    class A \n    {\n        public int i;\n        private int j;\n    }    \n    class B extends A \n    {\n        void display() \n        {\n            super.j = super.i + 1;\n            System.out.println(super.i + \" \" + super.j);\n        }\n    }    \n    class inheritance \n   {\n        public static void main(String args[])\n        {\n            B obj = new B();\n            obj.i=1;\n            obj.j=2;   \n            obj.display();     \n        }\n   }","2 2","3 3","Runtime Error","Compilation Error","Compilation Error"));

    }
}