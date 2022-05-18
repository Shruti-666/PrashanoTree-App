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

public class queue extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_queue;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue);
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
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(queue.this);
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

        quizmodel_queue.add(new quizmodel("A linear list of elements in which deletion can be done from one end (front) and insertion can take place only at the other end (rear) is known as _____________","Queue","Stack","Tree","Linked list","Queue"));
        quizmodel_queue.add(new quizmodel("The data structure required for Breadth First Traversal on a graph is?","Stack","Array","Queue","Tree","Queue"));
        quizmodel_queue.add(new quizmodel("A queue follows __________","FIFO (First In First Out) principle","LIFO (Last In First Out) principle","Ordered array","Linear tree","FIFO (First In First Out) principle"));
        quizmodel_queue.add(new quizmodel("Circular Queue is also known as ________","Ring Buffer","Square Buffer","Rectangle Buffer","Curve Buffer","Ring Buffer"));
        quizmodel_queue.add(new quizmodel("If the elements “A”, “B”, “C” and “D” are placed in a queue and are deleted one at a time, in what order will they be removed?","ABCD","DCBA","DCAB","ABDC","ABCD"));
        quizmodel_queue.add(new quizmodel("A data structure in which elements can be inserted or deleted at/from both ends but not in the middle is?","Queue","Circular queue","Dequeue","Priority queue","Dequeue"));
        quizmodel_queue.add(new quizmodel("A normal queue, if implemented using an array of size MAX_SIZE, gets full when?","Rear = MAX_SIZE – 1","Front = (rear + 1)mod MAX_SIZE","Front = rear + 1","Rear = front","Rear = MAX_SIZE – 1"));
        quizmodel_queue.add(new quizmodel("Queues serve major role in ______________","Simulation of recursion","Simulation of arbitrary linked list","Simulation of limited resource allocation","Simulation of heap sort","Simulation of limited resource allocation"));
        quizmodel_queue.add(new quizmodel("Which of the following is not the type of queue?","Ordinary queue","Single ended queue","Circular queue","Priority queue","Single ended queue"));

    }
}
