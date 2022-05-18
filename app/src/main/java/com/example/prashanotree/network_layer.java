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

public class network_layer extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_nl;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_layer);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_nl= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_nl);
        currentPos= random.nextInt(quizmodel_nl.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_nl.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_nl.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_nl.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_nl.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_nl.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_nl.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_nl.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_nl.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(network_layer.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_nl.size());
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
            questionTV.setText(quizmodel_nl.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_nl.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_nl.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_nl.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_nl.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_nl) {
        quizmodel_nl.add(new quizmodel("The network layer is concerned with __________ of data.","bits","frames","packets","bytes","bytes"));
        quizmodel_nl.add(new quizmodel("Which one of the following is not a function of network layer?","routing","inter-networking","congestion control","error control","error control"));
        quizmodel_nl.add(new quizmodel("A 4 byte IP address consists of __________","only network address","only host address","network address & host address","network address & MAC address","network address & host address"));
        quizmodel_nl.add(new quizmodel("In virtual circuit network each packet contains ___________","full source and destination address","a short VC number","only source address","only destination address","a short VC number"));
        quizmodel_nl.add(new quizmodel("Which of the following routing algorithms can be used for network layer design?","shortest path algorithm","distance vector routing","link state routing","all of the mentioned","all of the mentioned"));
        quizmodel_nl.add(new quizmodel("Which of the following is not correct in relation to multi-destination routing?","is same as broadcast routing","contains the list of all destinations","data is not sent by packets","there are multiple receivers","data is not sent by packets"));
        quizmodel_nl.add(new quizmodel("A subset of a network that includes all the routers but contains no loops is called ________","spanning tree","spider structure","spider tree","special tree","spanning tree"));
        quizmodel_nl.add(new quizmodel("Which one of the following algorithm is not used for congestion control?","traffic aware routing","admission control","load shedding","routing information protocol","routing information protocol"));
        quizmodel_nl.add(new quizmodel("The network layer protocol for internet is __________","ethernet","internet protocol","hypertext transfer protocol","file transfer protocol","internet protocol"));
        quizmodel_nl.add(new quizmodel("ICMP is primarily used for __________","error and diagnostic functions","addressing","forwarding","routing","error and diagnostic functions"));
    }
}