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

public class access_network extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_an;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_network);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_an= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_an);
        currentPos= random.nextInt(quizmodel_an.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_an.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_an.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_an.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_an.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_an.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_an.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_an.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_an.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(access_network.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_an.size());
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
            questionTV.setText(quizmodel_an.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_an.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_an.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_an.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_an.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_an) {
        quizmodel_an.add(new quizmodel("Which of this is not a constituent of residential telephone line?","A high-speed downstream channel","A medium-speed downstream channel","A low-speed downstream channel","An ultra-high speed downstream channel","A low-speed downstream channel"));
        quizmodel_an.add(new quizmodel("DSL telcos provide which of the following services?","Wired phone access","ISP","Wired phone access and ISP","Network routing and ISP","Wired phone access and ISP"));
        quizmodel_an.add(new quizmodel("The function of DSLAM is to __________","Convert analog signals into digital signals","Convert digital signals into analog signals","Amplify digital signals","De-amplify digital signals","Convert analog signals into digital signals"));
        quizmodel_an.add(new quizmodel("Which of the following terms is not associated with DSL?","DSLAM","CO","Splitter","CMTS","CMTS"));
        quizmodel_an.add(new quizmodel("HFC contains _______","Fibre cable","Coaxial cable","A combination of Fibre cable and Coaxial cable","Twisted Pair Cable","A combination of Fibre cable and Coaxial cable"));
        quizmodel_an.add(new quizmodel("Which of the following statements is not applicable for cable internet access?","It is a shared broadcast medium","It includes HFCs","Cable modem connects home PC to Ethernet port","Analog signal is converted to digital signal in DSLAM","Analog signal is converted to digital signal in DSLAM"));
        quizmodel_an.add(new quizmodel("Among the optical-distribution architectures that are essentially switched ethernet is __________","AOM","PON","NON","MON","AON"));
        quizmodel_an.add(new quizmodel("StarBand provides __________","FTTH internet access","Cable access","Telephone access","Satellite access","Satellite access"));
        quizmodel_an.add(new quizmodel("Home Access is provided by __________","DSL","FTTP","Cable","All of the mentioned","All of the mentioned"));
        quizmodel_an.add(new quizmodel("ONT is connected to splitter using _________","High speed fibre cable","HFC","Optical cable","Twisted pair cable","Optical cable"));

    }
}