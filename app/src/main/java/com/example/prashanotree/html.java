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

public class html extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_html;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_html= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_html);
        currentPos= random.nextInt(quizmodel_html.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_html.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_html.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_html.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_html.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_html.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_html.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_html.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_html.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(html.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_html.size());
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
            questionTV.setText(quizmodel_html.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_html.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_html.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_html.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_html.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_html) {
        quizmodel_html.add(new quizmodel("What is HTML?","HTML describes the structure of a webpage","HTML is the standard markup language mainly used to create web pages","HTML consists of a set of elements that helps the browser how to view the content","All of the mentioned","All of the mentioned"));
        quizmodel_html.add(new quizmodel("Who is the father of HTML?","Rasmus Lerdorf","Tim Berners-Lee","Brendan Eich","Sergey Brin","Tim Berners-Lee"));
        quizmodel_html.add(new quizmodel("HTML stands for __________","HyperText Markup Language","HyperText Machine Language","HyperText Marking Language","HighText Marking Language","HyperText Markup Language"));
        quizmodel_html.add(new quizmodel("What is the correct syntax of doctype in HTML5?","</doctype html>","<doctype html>","<doctype html!>","<!doctype html>","<!doctype html>"));
        quizmodel_html.add(new quizmodel("Which of the following is used to read an HTML page and render it?","Web server","Web network","Web browser","Web matrix","Web browser"));
        quizmodel_html.add(new quizmodel("Which of the following is not a difference between HTML and XHTML?","Charset in both html and xhtml is “text/html”","Tags and attributes are case-insensitive in HTML but not in XHTML","Special characters must be escaped using character entities in XHTML unlike HTML","Charset in html is “text/html” where as in xhtml it is “application/xml+xhtml”","Charset in both html and xhtml is “text/html”"));
        quizmodel_html.add(new quizmodel("Which of the following tag is used for inserting the largest heading in HTML?","head","<h1>","<h6>","heading","<h1>"));
        quizmodel_html.add(new quizmodel("What is DOM in HTML?","Language dependent application programming","Hierarchy of objects in ASP.NET","Application programming interface","Convention for representing and interacting with objects in html documents","Convention for representing and interacting with objects in html documents"));
        quizmodel_html.add(new quizmodel("In which part of the HTML metadata is contained?","head tag","title tag","html tag","body tag","head tag"));
        quizmodel_html.add(new quizmodel("Which element is used to get highlighted text in HTML5?","<u>","<mark>","<highlight>","<b>","<mark>"));
        quizmodel_html.add(new quizmodel(" Which of the following is not a HTML5 tag?","<track>","<video>","<slider>","<source>","<slider>"));
        quizmodel_html.add(new quizmodel(" How do we write comments in HTML?","</…….>","<!……>","</……/>","<…….!>","<!……>"));
        quizmodel_html.add(new quizmodel("Which of the following elements in HTML5 defines video or movie content?","<video>","<movie>","<audio>","<media>","<video>"));
        quizmodel_html.add(new quizmodel("Which of the following is not the element associated with the HTML table layout?","alignment","color","size","spanning","color"));
        quizmodel_html.add(new quizmodel("Which element is used for or styling HTML5 layout?","CSS","jQuery","JavaScript","PHP","CSS"));
        quizmodel_html.add(new quizmodel("Which HTML tag is used for making character appearance bold?","<u>content</u>","<b>content</b>","<br>content</br>","<i>content</i>","<b>content</b>"));
        quizmodel_html.add(new quizmodel("Which HTML tag is used to insert an image?","<img url=”htmllogo.jpg” />","<img alt=”htmllogo.jpg” />","<img src=”htmllogo.jpg” />","<img link=”htmllogo.jpg” />","<img src=”htmllogo.jpg” />"));
        quizmodel_html.add(new quizmodel("HTML is a subset of ___________","SGMT","SGML","SGME","XHTML","SGML"));
        quizmodel_html.add(new quizmodel("Which character is used to represent when a tag is closed in HTML?","#","!","/","none","/"));
        quizmodel_html.add(new quizmodel("Which of the following HTML code will make an image clickable?","<a href=\"https://www.sanfoundry.com/\">Sanfoundry Home Page</a>","<img src=\"https://www.sanfoundry.com/sanfoundry-logo\">\n<a href=\"https://www.sanfoundry.com/\">Sanfoundry  Home Page</a>\n</img>","<a href=\"https://www.sanfoundry.com/\">Sanfoundry Home Page</a>\n<img src=\"https://www.sanfoundry.com/sanfoundry-logo\" />","<a href=\"https://www.sanfoundry.com/\"><img src=\"https://www.sanfoundry.com/sanfoundry-logo\" /></a>","<a href=\"https://www.sanfoundry.com/\"><img src=\"https://www.sanfoundry.com/sanfoundry-logo\" /></a>"));
        quizmodel_html.add(new quizmodel("Among the following, which is the HTML paragraph tag?","<p>","<pre>","<hr>","<a>","<p>"));
        quizmodel_html.add(new quizmodel("In HTML, which attribute is used to create a link that opens in a new window tab?","src=”_blank”","alt=”_blank”","target=”_self”","target=”_blank”","target=”_blank”"));

    }
}