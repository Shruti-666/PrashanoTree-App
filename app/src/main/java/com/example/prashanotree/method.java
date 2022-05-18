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

public class method extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_method;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_method);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_method= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_method);
        currentPos= random.nextInt(quizmodel_method.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_method.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_method.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_method.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_method.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_method.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_method.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_method.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_method.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(method.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_method.size());
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
            questionTV.setText(quizmodel_method.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_method.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_method.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_method.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_method.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_method) {
        quizmodel_method.add(new quizmodel("What is the return type of a method that does not return any value?","int","float","void","double","void"));
        quizmodel_method.add(new quizmodel("What is the process of defining more than one method in a class differentiated by method signature?","Function overriding","Function overriding","Function doubling","None of the mentioned","Function overloading"));
        quizmodel_method.add(new quizmodel("Which of the following is a method having same name as that of it’s class?","finalize","delete","class","constructor","constructor"));
        quizmodel_method.add(new quizmodel("Which method can be defined only once in a program?","main method","finalize method","static method","private method","main method"));
        quizmodel_method.add(new quizmodel("Which of this statement is incorrect?","All object of a class are allotted memory for the all the variables defined in the class","If a function is defined public it can be accessed by object of other class by inheritation","main() method must be made public","All object of a class are allotted memory for the methods defined in the class","All object of a class are allotted memory for the methods defined in the class"));
        quizmodel_method.add(new quizmodel("What will be the output of the following Java program?\n\n    class box \n    {\n        int width;\n        int height;\n        int length;\n        int volume;\n        void volume(int height, int length, int width) \n        {\n             volume = width*height*length;\n        } \n    }    \n    class Prameterized_method\n    {\n        public static void main(String args[])\n        {\n            box obj = new box();\n            obj.height = 1;\n            obj.length = 5;\n            obj.width = 5;\n            obj.volume(3,2,1);\n            System.out.println(obj.volume);        \n        } \n     }","0","1","6","25","6"));
        quizmodel_method.add(new quizmodel("What will be the output of the following Java program?\n\n    class equality \n    {\n        int x;\n        int y;\n        boolean isequal()\n        {\n            return(x == y);  \n        } \n    }    \n    class Output \n    {\n        public static void main(String args[])\n        {\n            equality obj = new equality();\n            obj.x = 5;\n            obj.y = 5;\n            System.out.println(obj.isequal());\n        } \n    }","false","true","0","1","true"));
        quizmodel_method.add(new quizmodel("What will be the output of the following Java program?\n\n    class box \n    {\n        int width;\n        int height;\n        int length;\n        int volume;\n        void volume() \n        {\n             volume = width*height*length;\n        } \n    }    \n    class Output \n    { \n        public static void main(String args[])\n        {\n            box obj = new box();\n            obj.height = 1;\n            obj.length = 5;\n            obj.width = 5;\n            obj.volume();\n            System.out.println(obj.volume);        \n        } \n    }","0","1","25","26","25"));
        quizmodel_method.add(new quizmodel("In the following Java code, which call to sum() method is appropriate?\n\nclass Output \n{\n \n        public static int sum(int ...x)\n        {\n             return; \n        }\n        static void main(String args[]) \n        {    \n             sum(10);\n             sum(10,20);\n             sum(10,20,30);\n             sum(10,20,30,40);\n        } \n}","only sum(10)","only sum(10,20)","only sum(10) & sum(10,20)","all of the mentioned","all of the mentioned"));
        quizmodel_method.add(new quizmodel("What will be the output of the following Java program?\n\n    class area \n    {\n        int width;\n        int length;\n        int volume;\n        area() \n        {\n           width=5;\n           length=6;\n        }\n        void volume() \n        {\n             volume = width*length*height;\n        } \n    }    \n    class cons_method \n    {\n        public static void main(String args[])\n        {\n            area obj = new area();\n            obj.volume();\n            System.out.println(obj.volume);        \n        } \n    }","0","1","30","error","error"));

    }
}