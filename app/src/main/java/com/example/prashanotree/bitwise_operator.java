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

public class bitwise_operator extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_bo;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitwise_operator);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_bo= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_bo);
        currentPos= random.nextInt(quizmodel_bo.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_bo.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_bo.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_bo.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_bo.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_bo.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_bo.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_bo.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_bo.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(bitwise_operator.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_bo.size());
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
            questionTV.setText(quizmodel_bo.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_bo.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_bo.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_bo.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_bo.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_bo) {
        quizmodel_bo.add(new quizmodel("Which of these is not a bitwise operator?","&","&=","|=","<=","<="));
        quizmodel_bo.add(new quizmodel("Which operator is used to invert all the digits in a binary representation of a number?","~","<<<",">>>","^","~"));
        quizmodel_bo.add(new quizmodel("On applying Left shift operator, <<, on integer bits are lost one they are shifted past which position bit?","1","32","33","31","31"));
        quizmodel_bo.add(new quizmodel("Which right shift operator preserves the sign of the value?","<<",">>","<<=",">>=",">>"));
        quizmodel_bo.add(new quizmodel("Which of these statements are incorrect?","The left shift operator, <<, shifts all of the bits in a value to the left specified number of times","The right shift operator, >>, shifts all of the bits in a value to the right specified number of times","The left shift operator can be used as an alternative to multiplying by 2","The right shift operator automatically fills the higher order bits with 0","The right shift operator automatically fills the higher order bits with 0"));
        quizmodel_bo.add(new quizmodel("What will be the output of the following Java program?\n\n    class bitwise_operator \n    {\n        public static void main(String args[])\n        {\n            int var1 = 42;\n            int var2 = ~var1;\n            System.out.print(var1 + \" \" + var2);     \t\n        } \n    }","42 42","43 43","42 -43","42 43","42 -43"));
        quizmodel_bo.add(new quizmodel("What will be the output of the following Java program?\n\n    class bitwise_operator \n    {\n        public static void main(String args[]) \n        {    \n             int a = 3;\n             int b = 6;\n \t     int c = a | b;\n             int d = a & b;             \n             System.out.println(c + \" \"  + d);\n        } \n    }","7 2","7 7","7 5","5 2","7 2"));
        quizmodel_bo.add(new quizmodel("What will be the output of the following Java program?\n\n    class leftshift_operator \n    {\n        public static void main(String args[]) \n        {        \n             byte x = 64;\n             int i;\n             byte y; \n             i = x << 2;\n             y = (byte) (x << 2)\n             System.out.print(i + \" \" + y);\n        } \n    }","0 64","64 0","0 256","256 0","256 0"));
        quizmodel_bo.add(new quizmodel("What will be the output of the following Java program?\n\n    class rightshift_operator \n    {\n        public static void main(String args[]) \n        {    \n             int x; \n             x = 10;\n             x = x >> 1;\n             System.out.println(x);\n        } \n    }","10","5","2","20","5"));
        quizmodel_bo.add(new quizmodel("What will be the output of the following Java program?\n\n    class Output \n    {\n        public static void main(String args[]) \n        {    \n             int a = 1;\n             int b = 2;\n             int c = 3;\n             a |= 4;\n             b >>= 1;\n             c <<= 1;\n             a ^= c;\n             System.out.println(a + \" \" + b + \" \" + c);\n        } \n    }","3 1 6","2 2 3","2 3 4","3 3 6","3 1 6"));

    }
}