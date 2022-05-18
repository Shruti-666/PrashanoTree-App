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

public class stack_operation extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_queue;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_operation);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_queue= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_queue);
        currentPos= random.nextInt(quizmodel_queue.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_queue.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_queue.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_queue.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_queue.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_queue.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_queue.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_queue.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_queue.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(stack_operation.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_queue.size());
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
            questionTV.setText(quizmodel_queue.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_queue.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_queue.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_queue.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_queue.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_queue) {
        quizmodel_queue.add(new quizmodel("Process of inserting an element in stack is called ____________","Create","Push","Evaluation","Pop","Push"));
        quizmodel_queue.add(new quizmodel("Process of removing an element from stack is called __________","Create","Push","Evaluation","Pop","Pop"));
        quizmodel_queue.add(new quizmodel("In a stack, if a user tries to remove an element from an empty stack it is called _________","Underflow","Empty collection","Overflow","Garbage Collection","Underflow"));
        quizmodel_queue.add(new quizmodel("Pushing an element into stack already having five elements and stack size of 5, then stack becomes ___________","Overflow","Crash","Underflow","User flow","Overflow"));
        quizmodel_queue.add(new quizmodel("Entries in a stack are “ordered”. What is the meaning of this statement?","A collection of stacks is sortable","Stack entries may be compared with the ‘<‘ operation","The entries are stored in a linked list","There is a Sequential entry that is one by one","There is a Sequential entry that is one by one"));
        quizmodel_queue.add(new quizmodel("Which of the following is not the application of stack?","A parentheses balancing program","Tracking of local variables at run time","Compiler Syntax Analyzer","Data Transfer between two asynchronous process","Data Transfer between two asynchronous process"));
        quizmodel_queue.add(new quizmodel("Consider the usual algorithm for determining whether a sequence of parentheses is balanced. The maximum number of parentheses that appear on the stack AT ANY ONE TIME when the algorithm analyzes: (()(())(()))?","1","2","3","4 or more","3"));
        quizmodel_queue.add(new quizmodel("Consider the usual algorithm for determining whether a sequence of parentheses is balanced. Suppose that you run the algorithm on a sequence that contains 2 left parentheses and 3 right parentheses (in some order). The maximum number of parentheses that appear on the stack AT ANY ONE TIME during the computation?","1","2","3","4 or more","2"));
        quizmodel_queue.add(new quizmodel("What is the value of the postfix expression 6 3 2 4 + – *?","1","40","74","-18","-18"));
        quizmodel_queue.add(new quizmodel("Here is an infix expression: 4 + 3*(6*3-12). Suppose that we are using the usual stack algorithm to convert the expression from infix to postfix notation. The maximum number of symbols that will appear on the stack AT ONE TIME during the conversion of this expression?","1","2","3","4","4"));


    }
}