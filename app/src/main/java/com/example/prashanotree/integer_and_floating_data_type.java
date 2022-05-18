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

public class integer_and_floating_data_type extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_ifdt;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integer_and_floating_data_type);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_ifdt= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_ifdt);
        currentPos= random.nextInt(quizmodel_ifdt.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_ifdt.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_ifdt.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_ifdt.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_ifdt.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_ifdt.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_ifdt.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_ifdt.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_ifdt.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(integer_and_floating_data_type.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_ifdt.size());
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
            questionTV.setText(quizmodel_ifdt.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_ifdt.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_ifdt.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_ifdt.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_ifdt.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_ifdt) {
        quizmodel_ifdt.add(new quizmodel("What is the range of short data type in Java?","-128 to 127","-32768 to 32767","-2147483648 to 2147483647","None of the mentioned","-32768 to 32767"));
        quizmodel_ifdt.add(new quizmodel("What is the range of byte data type in Java?","-128 to 127","-32768 to 32767","-2147483648 to 2147483647","None of the mentioned","-128 to 127"));
        quizmodel_ifdt.add(new quizmodel("Which of the following are legal lines of Java code? 1. int w = (int)888.8;\n2. byte x = (byte)100L;\n3. long y = (byte)100;\n4. byte z = (byte)100L;","1 and 2","2 and 3","3 and 4","All statements are correct","All statements are correct"));
        quizmodel_ifdt.add(new quizmodel("An expression involving byte, int, and literal numbers is promoted to which of these?","int","long","byte","float","int"));
        quizmodel_ifdt.add(new quizmodel("Which of these literals can be contained in float data type variable?","-1.7e+308","-3.4e+038","+1.7e+308","-3.4e+050","-3.4e+038"));
        quizmodel_ifdt.add(new quizmodel("Which data type value is returned by all transcendental math functions?","int","float","double","long","double"));
        quizmodel_ifdt.add(new quizmodel("What will be the output of the following Java code?\n\n    class average {\n        public static void main(String args[])\n        {\n            double num[] = {5.5, 10.1, 11, 12.8, 56.9, 2.5};\n            double result;\n            result = 0;\n            for (int i = 0; i < 6; ++i) \n                result = result + num[i];\n\t    System.out.print(result/6);\n \n        } \n    }","16.34","16.566666644","16.46666666666667","16.46666666666666","16.46666666666667"));
        quizmodel_ifdt.add(new quizmodel("What will be the output of the following Java statement?\nclass output {\n        public static void main(String args[]) \n        {\n            double a, b,c;\n            a = 3.0/0;\n            b = 0/4.0;\n            c=0/0.0;\n \n\t    System.out.println(a);\n           System.out.println(b);\n           System.out.println(c);\n       } \n    }","Infinity","0.0","NaN","all of the mentioned","all of the mentioned"));
        quizmodel_ifdt.add(new quizmodel("What will be the output of the following Java code?\n\n    class increment {\n        public static void main(String args[]) \n        {        \n             int g = 3;\n             System.out.print(++g * 8);\n        } \n    }","25","24","32","33","32"));
        quizmodel_ifdt.add(new quizmodel("What will be the output of the following Java code?\n\n    class area {\n       public static void main(String args[]) \n        {    \n            double r, pi, a;\n             r = 9.8;\n             pi = 3.14;\n             a = pi * r * r;\n             System.out.println(a);\n       } \n    }","301.5656","301","301.56","301.56560000","301.5656"));

    }
}