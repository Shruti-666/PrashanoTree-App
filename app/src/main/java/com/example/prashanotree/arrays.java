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

public class arrays extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_array;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrays);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_array= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_array);
        currentPos= random.nextInt(quizmodel_array.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_array.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_array.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_array.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_array.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_array.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_array.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_array.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_array.size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(arrays.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_array.size());
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
            questionTV.setText(quizmodel_array.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_array.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_array.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_array.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_array.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_array) {
        quizmodel_array.add(new quizmodel("Which of these operators is used to allocate memory to array variable in Java?","malloc","alloc","new","new malloc","new"));
        quizmodel_array.add(new quizmodel("Which of these is an incorrect array declaration?","int arr[] = new int[5]","int [] arr = new int[5]","int arr[] = new int[5]","int arr[] = int [5] new","int arr[] = int [5] new"));
        quizmodel_array.add(new quizmodel("What will be the output of the following Java code?\nint arr[] = new int [5];\nSystem.out.print(arr);","0","value stored in arr[0]","00000","Class name@ hashcode in hexadecimal form","Class name@ hashcode in hexadecimal form"));
        quizmodel_array.add(new quizmodel("Which of these is an incorrect Statement?","It is necessary to use new operator to initialize an array","Array can be initialized using comma separated expressions surrounded by curly braces","Array can be initialized when they are declared","None of the mentioned","It is necessary to use new operator to initialize an array"));
        quizmodel_array.add(new quizmodel("Which of these is necessary to specify at time of array initialization?","Row","Column","Both Row and Column","None of the mentioned","Row"));
        quizmodel_array.add(new quizmodel("What will be the output of the following Java code?\n\n   class array_output \n    {\n        public static void main(String args[]) \n        {\n            int array_variable [] = new int[10];\n\t    for (int i = 0; i < 10; ++i) \n            {\n                array_variable[i] = i;\n                System.out.print(array_variable[i] + \" \");\n                i++;\n            }\n        } \n    }","0 2 4 6 8","1 3 5 7 9","0 1 2 3 4 5 6 7 8 9","1 2 3 4 5 6 7 8 9 10","0 2 4 6 8"));
        quizmodel_array.add(new quizmodel("What will be the output of the following Java code?\n\n    class evaluate \n    {\n        public static void main(String args[]) \n            {\n\t        int arr[] = new int[] {0 , 1, 2, 3, 4, 5, 6, 7, 8, 9};\n\t        int n = 6;\n                n = arr[arr[n] / 2];\n\t        System.out.println(arr[n] / 2);\n            } \n    }","3","0","6","1","1"));
        quizmodel_array.add(new quizmodel("What will be the output of the following Java code?\n\n    class array_output \n    {\n        public static void main(String args[]) \n        {\n            char array_variable [] = new char[10];\n\t    for (int i = 0; i < 10; ++i) \n            {\n                array_variable[i] = 'i';\n                System.out.print(array_variable[i] + \"\");\n            }\n        } \n    }","1 2 3 4 5 6 7 8 9 10","0 1 2 3 4 5 6 7 8 9 10","i j k l m n o p q r","i i i i i i i i i i","i i i i i i i i i i"));
        quizmodel_array.add(new quizmodel("What will be the output of the following Java code?\n\n    class array_output \n    {\n        public static void main(String args[]) \n        {\n            int array_variable[][] = {{ 1, 2, 3}, { 4 , 5, 6}, { 7, 8, 9}};\n            int sum = 0;\n            for (int i = 0; i < 3; ++i)\n                for (int j = 0; j <  3 ; ++j)\n                    sum = sum + array_variable[i][j];\n            System.out.print(sum / 5);\n        } \n    }","8","9","10","11","9"));

    }
}