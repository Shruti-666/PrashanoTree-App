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

public class singly_linked_list extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_sll;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singly_linked_list);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_sll= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_sll);
        currentPos= random.nextInt(quizmodel_sll.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_sll.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_sll.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_sll.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_sll.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_sll.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_sll.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_sll.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_sll.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(singly_linked_list.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_sll.size());
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
            questionTV.setText(quizmodel_sll.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_sll.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_sll.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_sll.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_sll.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_sll) {
        quizmodel_sll.add(new quizmodel(" A linear collection of data elements where the linear node is given by means of pointer is called?","Linked list","Node list","Primitive list","Unordered list","Linked list"));
        quizmodel_sll.add(new quizmodel("Consider an implementation of unsorted singly linked list. Suppose it has its representation with a head pointer only. Given the representation, which of the following operation can be implemented in O(1) time?","Pointer to character","Pointer to integer","Pointer to node","Node","Pointer to node"));
        quizmodel_sll.add(new quizmodel("What would be the asymptotic time complexity to add a node at the end of singly linked list, if the pointer is initially pointing to the head of the list?","O(1)","O(n)","θ(n)","θ(1)","θ(n)"));
        quizmodel_sll.add(new quizmodel("What would be the asymptotic time complexity to insert an element at the front of the linked list (head is known)?","O(1)","O(n)","O(n1)","O(N3)","O(1)"));
        quizmodel_sll.add(new quizmodel("What would be the asymptotic time complexity to find an element in the linked list?","O(1)","O(n)","O(n2)","O(n4)","O(n)"));
        quizmodel_sll.add(new quizmodel("What would be the asymptotic time complexity to insert an element at the second position in the linked list?","O(1)","O(n)","O(n2)","O(n3)","O(1)"));
        quizmodel_sll.add(new quizmodel("The concatenation of two lists can be performed in O(1) time. Which of the following variation of the linked list can be used?","Singly linked list","Doubly linked list","Circular doubly linked list","Array implementation of list","Circular doubly linked list"));
        quizmodel_sll.add(new quizmodel("What kind of linked list is best to answer questions like “What is the item at position n?”","Singly linked list","Doubly linked list","Circular linked list","Array implementation of linked list","Array implementation of linked list"));
        quizmodel_sll.add(new quizmodel("Linked lists are not suitable for the implementation of ___________","Insertion sort","Radix sort","Polynomial manipulation","Binary search","Binary search"));
        quizmodel_sll.add(new quizmodel("Linked list is considered as an example of ___________ type of memory allocation.","Dynamic","Static","Compile time","Heap","Dynamic"));


    }
}