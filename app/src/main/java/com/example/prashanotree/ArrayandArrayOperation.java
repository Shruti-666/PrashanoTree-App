package com.example.prashanotree;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

//import com.google.android.material.bottomsheet.BottomSheetDialog;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class ArrayandArrayOperation extends AppCompatActivity {
    private  TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_aapArrayList;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrayand_array_operation);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_aapArrayList= new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_aapArrayList);
        currentPos= random.nextInt(quizmodel_aapArrayList.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_aapArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_aapArrayList.size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_aapArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_aapArrayList.size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_aapArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_aapArrayList.size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_aapArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_aapArrayList.size());
                setDatatoViews(currentPos);
            }
        });

    }

    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(ArrayandArrayOperation.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_aapArrayList.size());
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
            questionTV.setText(quizmodel_aapArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_aapArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizmodel_aapArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizmodel_aapArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizmodel_aapArrayList.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_aapArrayList) {
        quizmodel_aapArrayList.add(new quizmodel("Which of these best describes an array?","A data structure that shows a hierarchical behavior","Container of objects of similar types","Arrays are immutable once initialised","Array is not a data structure","Container of objects of similar types"));
        quizmodel_aapArrayList.add(new quizmodel("How do you initialize an array in C?","int arr[3] = (1,2,3);","int arr(3) = {1,2,3};","int arr[3] = {1,2,3};","int arr(3) = (1,2,3);","int arr[3] = {1,2,3};"));
        quizmodel_aapArrayList.add(new quizmodel("Which of the following is the correct way to declare a multidimensional array in Java?","int[] arr;","int arr[[]];","int[][]arr;","int[[]] arr;","int[][]arr;"));
        quizmodel_aapArrayList.add(new quizmodel("When does the ArrayIndexOutOfBoundsException occur?","Compile-time","Run-time","Not an error","Not an exception at all","Run-time"));
        quizmodel_aapArrayList.add(new quizmodel("Assuming int is of 4bytes, what is the size of int arr[15];?","15","19","11","60","60"));
        quizmodel_aapArrayList.add(new quizmodel("How do you instantiate an array in Java?","int arr[] = new int(3);","int arr[];","int arr[] = new int[3];","int arr() = new int(3);","int arr[] = new int[3];"));
        quizmodel_aapArrayList.add(new quizmodel("What is the output of the following Java code?\npublic class array\n{\n" + "\tpublic static void main(String args[])\n \t{\n \t\tint []arr = {1,2,3,4,5};\n\t\tSystem.out.println(arr[2]);\n\t\tSystem.out.println(arr[4]);\n\t}\n }","3 and 5","5 and 3","2 and 4","4 and 2","3 and 5"));
        quizmodel_aapArrayList.add(new quizmodel("Which of the following concepts make extensive use of arrays?","Binary trees","Scheduling of processes","Caching","Spatial locality","Spatial locality"));
        quizmodel_aapArrayList.add(new quizmodel("What are the advantages of arrays?","Objects of mixed data types can be stored","Elements in an array cannot be sorted","Index of first element of an array is 1","Easier to store elements of same data type","Easier to store elements of same data type"));
        quizmodel_aapArrayList.add(new quizmodel("What are the disadvantages of arrays?","Data structure like queue or stack cannot be implemented","There are chances of wastage of memory space if elements inserted in an array are lesser than the allocated size","Index value of an array can be negative","Elements are sequentially accessed","There are chances of wastage of memory space if elements inserted in an array are lesser than the allocated size"));
    }
}