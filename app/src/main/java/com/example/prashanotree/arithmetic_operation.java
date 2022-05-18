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

public class arithmetic_operation extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_ao;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arithmetic_operation);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_ao= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_ao);
        currentPos= random.nextInt(quizmodel_ao.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_ao.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_ao.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_ao.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_ao.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_ao.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_ao.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_ao.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_ao.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(arithmetic_operation.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_ao.size());
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
            questionTV.setText(quizmodel_ao.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_ao.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_ao.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_ao.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_ao.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_ao) {
        quizmodel_ao.add(new quizmodel("Which of the following can be operands of arithmetic operators?","Numeric","Boolean","Characters","Both Numeric & Characters","Both Numeric & Characters"));
        quizmodel_ao.add(new quizmodel("Modulus operator, %, can be applied to which of these?","Integers","Floating – point numbers","Both Integers and floating – point numbers","None of the mentioned","Both Integers and floating – point numbers"));
        quizmodel_ao.add(new quizmodel("With x = 0, which of the following are legal lines of Java code for changing the value of x to 1?\n1. x++;\n   2. x = x + 1;\n   3. x += 1;\n   4. x =+ 1;","1, 2 & 3","1 & 4","1, 2, 3 & 4","3 & 2","1, 2, 3 & 4"));
        quizmodel_ao.add(new quizmodel("Decrement operator, −−, decreases the value of variable by what number?","1","2","3","4","1"));
        quizmodel_ao.add(new quizmodel("Which of these statements are incorrect?","Assignment operators are more efficiently implemented by Java run-time system than their equivalent long forms","Assignment operators run faster than their equivalent long forms","Assignment operators can be used only with numeric and character data type","None of the mentioned","None of the mentioned"));
        quizmodel_ao.add(new quizmodel("What will be the output of the following Java program?\n\n    class increment \n    {\n        public static void main(String args[])\n        {\n            double var1 = 1 + 5; \n            double var2 = var1 / 4;\n            int var3 = 1 + 5;\n            int var4 = var3 / 4;\n            System.out.print(var2 + \" \" + var4);\n \n        } \n    }","1 1","0 1","1.5 1","1.5 1.0","1.5 1"));
        quizmodel_ao.add(new quizmodel("What will be the output of the following Java program?\n\n    class Modulus \n    {\n        public static void main(String args[]) \n        {    \n             double a = 25.64;\n             int  b = 25;\n             a = a % 10;\n             b = b % 10;\n             System.out.println(a + \" \"  + b);\n        } \n    }","5.640000000000001 5","5.640000000000001 5.0","5 5","5 5.640000000000001","5.640000000000001 5"));
        quizmodel_ao.add(new quizmodel("What will be the output of the following Java program?\n\n    class increment \n    {\n        public static void main(String args[]) \n        {        \n             int g = 3;\n             System.out.print(++g * 8);\n        } \n    }","25","24","32","34","32"));
        quizmodel_ao.add(new quizmodel("Can 8 byte long data type be automatically type cast to 4 byte float data type?","True","False","Cannot be determined","none of these","True"));
        quizmodel_ao.add(new quizmodel("What will be the output of the following Java program?\n\n    class Output \n    {\n        public static void main(String args[]) \n        {    \n             int a = 1;\n             int b = 2;\n             int c;\n             int d;\n             c = ++b;\n             d = a++;\n             c++;\n             b++;\n             ++a;\n             System.out.println(a + \" \" + b + \" \" + c);\n        } \n    }","3 2 4","3 2 3","2 3 4","3 4 4","3 4 4"));

    }
}