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

public class css extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_css;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_css);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_css
                = new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_css
        );
        currentPos= random.nextInt(quizmodel_css
                .size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_css
                        .get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_css
                        .size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_css
                        .get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_css
                        .size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_css
                        .get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_css
                        .size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_css
                        .get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_css
                        .size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(css.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_css
                        .size());
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
            questionTV.setText(quizmodel_css
                    .get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_css
                    .get(currentPos).getOption1());
            option2Btn.setText(quizmodel_css
                    .get(currentPos).getOption2());
            option3Btn.setText(quizmodel_css
                    .get(currentPos).getOption3());
            option4Btn.setText(quizmodel_css
                    .get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_css) {
        quizmodel_css.add(new quizmodel("What is CSS?","CSS is a style sheet language","CSS is designed to separate the presentation and content, including layout, colors, and fonts","CSS is the language used to style the HTML documents","All of the mentioned","All of the mentioned"));
        quizmodel_css.add(new quizmodel("Which of the following tag is used to embed css in html page?","<css>","<!DOCTYPE html>","<script>","<style>","<style>"));
        quizmodel_css.add(new quizmodel("Which of the following CSS selectors are used to specify a group of elements?","tag","id","class","both class and tag","class"));
        quizmodel_css.add(new quizmodel("Which of the following has introduced text, list, box, margin, border, color, and background properties?","HTML","PHP","CSS","Ajax","CSS"));
        quizmodel_css.add(new quizmodel("Which of the following CSS framework is used to create a responsive design?","django","rails","larawell","bootstrap","bootstrap"));
        quizmodel_css.add(new quizmodel("Which of the following CSS selector is used to specify a rule to bind a particular unique element?","tag","id","class","both class and tag","id"));
        quizmodel_css.add(new quizmodel("Which of the following type of HTML tag is used to define an internal style sheet?","<script>","<link>","<class>","<style>","<style>"));
        quizmodel_css.add(new quizmodel("Which of the following CSS property is used to make the text bold?","text-decoration: bold","font-weight: bold","font-style: bold","text-align: bold","font-weight: bold"));
        quizmodel_css.add(new quizmodel("What will be the output of following CSS code snippet?\nh1 {color: \"green\";}","nothings happen","error occurs","heading becomes dark-green","heading becomes green","nothings happen"));
        quizmodel_css.add(new quizmodel("Which of the following CSS style property is used to specify an italic text?","style","font","font-style","@font-face","font-style"));
        quizmodel_css.add(new quizmodel("What will be the output of following CSS code snippet?\nh1 {color: red text-decoration: underline; font-style: italic;}","color: red, text-decoration: underline works","only font-style: italic works","color: red, text-decoration: underline and font-style: italic all works","text-decoration: underline and font-style: italic works","only font-style: italic works"));
        quizmodel_css.add(new quizmodel("Which of the following are the CSS Extension Prefixes for Webkit?","-chrome","-web","-o-","-webkit","-webkit"));
        quizmodel_css.add(new quizmodel("Which of the following is the correct syntax to link an external style sheet in the HTML file?","<link rel=”stylesheet” href=”style.css” />","<link rel=”stylesheet” src=”style.css” />","<style rel=”stylesheet” src=”style.css” />","<style rel=”stylesheet” link=”style.css” />","<link rel=”stylesheet” href=”style.css” />"));
        quizmodel_css.add(new quizmodel("Which of the following is the first CSS specification to become an official W3C Recommendation?","CSS level 2","(X)HTML CSS","CSS level 1","CSS level 2.1","CSS level 1"));
        quizmodel_css.add(new quizmodel("Which of the following function defines a linear gradient as a CSS image?","gradient()","linear-gradient()","grayscale()","image()","linear-gradient()"));
        quizmodel_css.add(new quizmodel("Which of the following CSS property can be used to set the image as a border instead of the border style?","background-image-source","background-image","border-image-source","border-image","border-image-source"));
        quizmodel_css.add(new quizmodel("Which of the following CSS property defines the different properties of all four sides of an element’s border in a single declaration?","border-collapse","border-width","padding","border","border-width"));
        quizmodel_css.add(new quizmodel("Which of the following is the correct way to apply CSS Styles?","in an external CSS file","inside an HTML element","inside the <head> section of an HTML page","all of the mentioned","all of the mentioned"));
        quizmodel_css.add(new quizmodel("Which of the following CSS property sets the font size of text?","font-size","text-size","text","size","font-size"));
        quizmodel_css.add(new quizmodel("Which of the following is not the property of the CSS box model?","margin","color","width","height","color"));
        quizmodel_css.add(new quizmodel("Which of the following CSS property sets what kind of line decorations are added to an element, such as underlines, overlines, etc?","text-decoration","text-style","text-decoration-line","text-line","text-decoration-line"));
    }
}