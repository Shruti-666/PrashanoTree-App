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

public class congestion extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_c;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congestion);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_c= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_c);
        currentPos= random.nextInt(quizmodel_c.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_c.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_c.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_c.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_c.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_c.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_c.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_c.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_c.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(congestion.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_c.size());
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
            questionTV.setText(quizmodel_c.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_c.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_c.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_c.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_c.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_c) {
        quizmodel_c.add(new quizmodel("Two broad categories of congestion control are","Open-loop and Closed-loop","Open-control and Closed-control","Active control and Passive control","Active loop and Passive loop","Open-loop and Closed-loop"));
        quizmodel_c.add(new quizmodel("In open-loop control, policies are applied to __________","Remove after congestion occurs","Remove after sometime","Prevent before congestion occurs","Prevent before sending packets","Prevent before congestion occurs"));
        quizmodel_c.add(new quizmodel("Retransmission of packets must not be done when _______","Packet is lost","Packet is corrupted","Packet is needed","Packet is error-free","Packet is error-free"));
        quizmodel_c.add(new quizmodel("In Go-Back-N window, when the timer of the packet times out, several packets have to be resent even some may have arrived safe. Whereas in Selective Repeat window, the sender resends ___________","Packet which are not lost","Only those packets which are lost or corrupted","Packet from starting","All the packets","Only those packets which are lost or corrupted"));
        quizmodel_c.add(new quizmodel("Discarding policy is mainly done by _______","Sender","Receiver","Router","Switch","Router"));
        quizmodel_c.add(new quizmodel("Closed-Loop control mechanisms try to _________","Remove after congestion occurs","Remove after sometime","Prevent before congestion occurs","Prevent before sending packets","Remove after congestion occurs"));
        quizmodel_c.add(new quizmodel("The technique in which a congested node stops receiving data from the immediate upstream node or nodes is called as _______","Admission policy","Backpressure","Forward signaling","Backward signaling","Backpressure"));
        quizmodel_c.add(new quizmodel("Backpressure technique can be applied only to _______","Congestion networks","Closed circuit networks","Open circuit networks","Virtual circuit networks","Virtual circuit networks"));
        quizmodel_c.add(new quizmodel("The packet sent by a node to the source to inform it of congestion is called _______","Explicit","Discard","Choke","Backpressure","Choke"));
        quizmodel_c.add(new quizmodel("In the slow-start algorithm, the size of the congestion window increases __________ until it reaches a threshold.","exponentially","additively","multiplicatively","suddenly","exponentially"));

    }
}