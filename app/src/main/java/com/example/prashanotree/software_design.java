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

public class software_design extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_design;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_software_design);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_design= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_design);
        currentPos= random.nextInt(quizmodel_design.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_design.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_design.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_design.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_design.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_design.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_design.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_design.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_design.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(software_design.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_design.size());
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
            questionTV.setText(quizmodel_design.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_design.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_design.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_design.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_design.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_design) {
        quizmodel_design.add(new quizmodel("Which is the first step in the software development life cycle ?","Analysis","Design","Problem/Opportunity Identification","Development and Documentation","Problem/Opportunity Identification"));
        quizmodel_design.add(new quizmodel("Which tool is use for structured designing ?","Program flowchart","Structure chart","Data-flow diagram","Module","Structure chart"));
        quizmodel_design.add(new quizmodel(" A step by step instruction used to solve a problem is known as","Sequential structure" , "A List","A plan","An Algorithm","An Algorithm"));
        quizmodel_design.add(new quizmodel("In the Analysis phase, the development of the ____________ occurs, which is a clear statement of the goals and objectives of the project.","documentation","flowchart" , "program specification" , "design","program specification"));
        quizmodel_design.add(new quizmodel("Actual programming of software code is done during the ____________ step in the SDLC.","Maintenance and Evaluation","Design","Analysis","Development and Documentation","Development and Documentation"));
        quizmodel_design.add(new quizmodel("Who designs and implement database structures.","Programmers","Project managers","Technical writers","Database administrators","Database administrators"));
        quizmodel_design.add(new quizmodel(" ____________ is the process of translating a task into a series of commands that a computer will use to perform that task.","Project design","Installation","Systems analysis","Programming","Programming"));
        quizmodel_design.add(new quizmodel("Debugging is:","creating program code","finding and correcting errors in the program code","identifying the task to be computerized","creating the algorithm","finding and correcting errors in the program code"));
        quizmodel_design.add(new quizmodel("In Design phase, which is the primary area of concern ?","Architecture","Data","Interface","All of the mentioned","All of the mentioned"));
        quizmodel_design.add(new quizmodel("The importance of software design can be summarized in a single word which is:","Efficiency","Accuracy","Quality","Complexity","Quality"));


    }
}