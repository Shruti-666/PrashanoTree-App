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

public class physical_layer extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_pl;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical_layer);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_pl= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_pl);
        currentPos= random.nextInt(quizmodel_pl.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_pl.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_pl.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_pl.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_pl.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_pl.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_pl.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_pl.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_pl.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(physical_layer.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_pl.size());
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
            questionTV.setText(quizmodel_pl.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_pl.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_pl.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_pl.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_pl.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_pl) {
        quizmodel_pl.add(new quizmodel("The physical layer is concerned with ___________","bit-by-bit delivery","process to process delivery","application to application delivery","port to port delivery","bit-by-bit delivery"));
        quizmodel_pl.add(new quizmodel("Which transmission media provides the highest transmission speed in a network?","coaxial cable","twisted pair cable","optical fiber","electrical cable","optical fiber"));
        quizmodel_pl.add(new quizmodel("Bits can be sent over guided and unguided media as analog signal by ___________","digital modulation","amplitude modulation","frequency modulation","phase modulation","digital modulation"));
        quizmodel_pl.add(new quizmodel("The portion of physical layer that interfaces with the media access control sublayer is called ___________","physical signalling sublayer","physical data sublayer","physical address sublayer","physical transport sublayer","physical signalling sublayer"));
        quizmodel_pl.add(new quizmodel("The physical layer provides __________","mechanical specifications of electrical connectors and cables","electrical specification of transmission line signal level","specification for IR over optical fiber","all of the mentioned","all of the mentioned"));
        quizmodel_pl.add(new quizmodel("In asynchronous serial communication the physical layer provides ___________","start and stop signalling","flow control","both start & stop signalling and flow control","only start signalling","both start & stop signalling and flow control"));
        quizmodel_pl.add(new quizmodel("The physical layer is responsible for __________","line coding","channel coding","modulation","all of the mentioned","all of the mentioned"));
        quizmodel_pl.add(new quizmodel("The physical layer translates logical communication requests from the ______ into hardware specific operations.","data link layer","network layer","trasnport layer","application layer","data link layer"));
        quizmodel_pl.add(new quizmodel("A single channel is shared by multiple signals by ____________","analog modulation","digital modulation","multiplexing","phase modulation","multiplexing"));
        quizmodel_pl.add(new quizmodel("Wireless transmission of signals can be done via ___________","radio waves","microwaves","infrared","all of the mentioned","all of the mentioned"));

    }
}