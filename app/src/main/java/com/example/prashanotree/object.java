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

public class object extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_O;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_O= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_O);
        currentPos= random.nextInt(quizmodel_O.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_O.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_O.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_O.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_O.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_O.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_O.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_O.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_O.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(object.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_O.size());
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
            questionTV.setText(quizmodel_O.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_O.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_O.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_O.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_O.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_O) {
        quizmodel_O.add(new quizmodel("Which of these class is superclass of every class in Java?","String class","Object class","Abstract class","ArrayList class","Object class"));
        quizmodel_O.add(new quizmodel("Which of these method of Object class can clone an object?","Objectcopy()","copy()","Object clone()","clone()","Object clone()"));
        quizmodel_O.add(new quizmodel("Which of these method of Object class is used to obtain class of an object at run time?","get()", "void getclass()","Class getclass()" ,"d) None of the mentioned","Class getclass()"));
        quizmodel_O.add(new quizmodel("Which of these keywords can be used to prevent inheritance of a class?","super","constant","class","final","final"));
        quizmodel_O.add(new quizmodel("Which of these keywords cannot be used for a class which has been declared final?","abstract","extends","abstract and extends","none of the mentioned","abstract"));
        quizmodel_O.add(new quizmodel("Which of these class relies upon its subclasses for complete implementation of its methods?","Object class","abstract class","ArrayList class","None of the mentioned","abstract class"));
        quizmodel_O.add(new quizmodel("What will be the output of the following Java program?\n" + "\n   abstract class A \n   {\n       int i;\n       abstract void display();\n   }    \n   class B extends A \n   {\n       int j;\n       void display() \n       {\n           System.out.println(j);\n       }\n   }    \n   class Abstract_demo \n   {\n       public static void main(String args[])\n       {\n           B obj = new B();\n           obj.j=2;\n           obj.display();    \n       }\n   }","0","2","Runtime Error","Compilation Error","2"));
        quizmodel_O.add(new quizmodel("What will be the output of the following Java program?\n" + "\n  class A \n  {\n" + "\tint i;\n" + "\tint j;\n       A() \n       {\n           i = 1;\n           j = 2;\n       }\n  }\n  class Output \n  {\n       public static void main(String args[])\n       {\n            A obj1 = new A();\n            A obj2 = new A();\n" + "\t     System.out.print(obj1.equals(obj2));\n       }\n  }","false","true","1","Compilation Error","false"));
        quizmodel_O.add(new quizmodel("What will be the output of the following Java code?\n" + "\n   class Output \n   {\n       public static void main(String args[])\n       {\n            Object obj = new Object();\n" + "\t     System.out.print(obj.getclass());\n       }\n   }","Object","class Object","class java.lang.Object","Compilation Error","class java.lang.Object"));
        quizmodel_O.add(new quizmodel("What will be the output of the following Java code?\n" + "\n  class A \n  {\n       int i;\n" + "\tint j;\n       A() \n       {\n           i = 1;\n           j = 2;\n       }\n  }\n  class Output \n  {\n       public static void main(String args[])\n       {\n            A obj1 = new A();\n" + "\t     System.out.print(obj1.toString());\n       }\n  }","true","false","String associated with obj1","Compilation Error","String associated with obj1"));


    }
}