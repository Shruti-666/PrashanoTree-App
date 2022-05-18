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

public class infix_and_postfix extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_infpos;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infix_and_postfix);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_infpos= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_infpos);
        currentPos= random.nextInt(quizmodel_infpos.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_infpos.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_infpos.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_infpos.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_infpos.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_infpos.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_infpos.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_infpos.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_infpos.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(infix_and_postfix.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_infpos.size());
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
            questionTV.setText(quizmodel_infpos.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_infpos.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_infpos.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_infpos.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_infpos.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_infpos) {
        quizmodel_infpos.add(new quizmodel("What data structure is used when converting an infix notation to prefix notation?","Stack","Queue","B-Trees","Linked-list","Stack"));
        quizmodel_infpos.add(new quizmodel("What would be the Prefix notation for the given equation?\n A+(B*C)","+A*CB+A*CB","*B+AC","+A*BC","*A+CB","+A*BC"));
        quizmodel_infpos.add(new quizmodel("What would be the Prefix notation for the given equation?\n (A*B)+(C*D)","+*AB*CD","*+AB*CD","**AB+CD","+*BA*CD","+*AB*CD"));
        quizmodel_infpos.add(new quizmodel("What would be the Prefix notation for the given equation?\n A+B*C^D","+A*B^CD","+A^B*CD","*A+B^CD","^A*B+CD","+A*B^CD"));
        quizmodel_infpos.add(new quizmodel("Out of the following operators (^, *, +, &, $), the one having highest priority is _________","+","$","^","&","^"));
        quizmodel_infpos.add(new quizmodel("Out of the following operators (|, *, +, &, $), the one having lowest priority is ________","+","$","|","&","|"));
        quizmodel_infpos.add(new quizmodel("What would be the Prefix notation for the given equation?\n A^B^C^D","^^^ABCD","^A^B^CD","ABCD^^^","AB^C^D","^^^ABCD"));
        quizmodel_infpos.add(new quizmodel("What would be the Prefix notation for the given equation?\na+b-c/d&e|f","|&-+ab/cdef","&|-+ab/cdef","|&-ab+/cdef","|&-+/abcdef","|&-+ab/cdef"));
        quizmodel_infpos.add(new quizmodel("What would be the Prefix notation for the given equation?\n(a+(b/c)*(d^e)-f)","-+a*/^bcdef","-+a*/bc^def","-+a*b/c^def","-a+*/bc^def","-+a*/bc^def"));
        quizmodel_infpos.add(new quizmodel("What would be the Prefix notation for the given equation?\na|b&c","a|&bc","&|abc","|a&bc","ab&|c","|a&bc"));


    }
}