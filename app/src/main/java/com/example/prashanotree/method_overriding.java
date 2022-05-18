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

public class method_overriding extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_MO;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_method_overriding);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_MO= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_MO);
        currentPos= random.nextInt(quizmodel_MO.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_MO.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_MO.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_MO.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_MO.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_MO.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_MO.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_MO.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_MO.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(method_overriding.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_MO.size());
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
            questionTV.setText(quizmodel_MO.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_MO.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_MO.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_MO.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_MO.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_MO) {
        quizmodel_MO.add(new quizmodel("Which of this keyword can be used in a subclass to call the constructor of superclass?","super","this","extent","extends","super"));
        quizmodel_MO.add(new quizmodel("What is the process of defining a method in a subclass having same name & type signature as a method in its superclass?","Method overloading","Method overriding","Method hiding","None of the mentioned","Method overriding"));
        quizmodel_MO.add(new quizmodel("Which of these keywords can be used to prevent Method overriding?","static","constant","protected","final","final"));
        quizmodel_MO.add(new quizmodel("Which of these is correct way of calling a constructor having no parameters, of superclass A by subclass B?","super(void);","superclass.();","super.A();","super();","super();"));
        quizmodel_MO.add(new quizmodel("At line number 2 in the following code, choose 3 valid data-type attributes/qualifiers among “final, static, native, public, private, abstract, protected”\n{   /* insert qualifier here */ int MY_VALUE = 10;\n   }","final, native, private","final, static, protected","final, private, abstract","final, static, public","final, static, public"));
        quizmodel_MO.add(new quizmodel("Which of these is supported by method overriding in Java?","Abstraction","Encapsulation","Polymorphism","None of the mentioned","Polymorphism"));
        quizmodel_MO.add(new quizmodel("What will be the output of the following Java program?\n\n class Alligator \n {\n  public static void main(String[] args) \n   {\n   int []x[] = {{1,2}, {3,4,5}, {6,7,8,9}};\n   int [][]y = x;\n   System.out.println(y[2][1]);\n   }\n }","2","3","7","Complilation Error","7"));
        quizmodel_MO.add(new quizmodel("What will be the output of the following Java program?\n\n   final class A \n    {\n         int i;\n    }    \n    class B extends A \n    {\n        int j;\n        System.out.println(j + \" \" + i);  \n    }    \n    class inheritance \n    {\n        public static void main(String args[])\n        {\n            B obj = new B();\n            obj.display();     \n        }\n   }","2 2","3 3","Runtime Error","Compilation Error","Compilation Error"));
        quizmodel_MO.add(new quizmodel("What will be the output of the following Java program?\n\n  class Abc\n  {\n      public static void main(String[]args)\n      {\n          String[] elements = { \"for\", \"tea\", \"too\" };\n          String first = (elements.length > 0) ? elements[0]: null;\n      }\n  }","Compilation error","An exception is thrown at run time","The variable first is set to null","The variable first is set to elements[0]","The variable first is set to elements[0]"));
        quizmodel_MO.add(new quizmodel("What will be the output of the following Java program?\n\n    class A \n    {\n        int i;\n        public void display() \n        {\n            System.out.println(i);\n        }    \n    }    \n    class B extends A \n   {\n        int j;\n        public void display() \n        {\n            System.out.println(j);\n        } \n    }    \n    class Dynamic_dispatch \n   {\n        public static void main(String args[])\n        {\n            B obj2 = new B();\n            obj2.i = 1;\n            obj2.j = 2;\n            A r;\n            r = obj2;\n            r.display();     \n        }\n   }","1","2","3","4","2"));
    }
}