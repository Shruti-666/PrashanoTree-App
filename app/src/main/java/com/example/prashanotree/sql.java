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

public class sql extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<quizmodel> quizmodel_sql;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV= findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizmodel_sql
                = new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizmodel_sql
        );
        currentPos= random.nextInt(quizmodel_sql
                .size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_sql
                        .get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_sql
                        .size());
                setDatatoViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_sql
                        .get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_sql
                        .size());
                setDatatoViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_sql
                        .get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_sql
                        .size());
                setDatatoViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodel_sql
                        .get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos= random.nextInt(quizmodel_sql
                        .size());
                setDatatoViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(sql.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is : \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizmodel_sql
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
            questionTV.setText(quizmodel_sql
                    .get(currentPos).getQuestion());
            option1Btn.setText(quizmodel_sql
                    .get(currentPos).getOption1());
            option2Btn.setText(quizmodel_sql
                    .get(currentPos).getOption2());
            option3Btn.setText(quizmodel_sql
                    .get(currentPos).getOption3());
            option4Btn.setText(quizmodel_sql
                    .get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<quizmodel>quizmodel_sql
    ) {
        quizmodel_sql.add(new quizmodel("What is SQL Server?","SQL Server is a relational database management system","SQL Server is a software whose main purpose is to store and retrieve data","SQL Server is a highly secure server and does not allow any database file manipulation during execution","All of the mentioned","SQL Server is a relational database management system"));
        quizmodel_sql.add(new quizmodel("When was the first version of Microsoft SQL Server released?","1991","1990","1988","1983","1988"));
        quizmodel_sql.add(new quizmodel("Which of the following is a free database software running free SQL Server technology?","SQL Server Web","SQL Server Enterprise","SQL Server Workgroup","SQL Server Express","SQL Server Express"));
        quizmodel_sql.add(new quizmodel("Which of the following companies originally worked together to create and market the first version of SQL Server?","Sybase","Ashton-Tate","Microsoft","All of the Mentioned","All of the Mentioned"));
        quizmodel_sql.add(new quizmodel("What is the Codename for SQL Server 2012?","Katmai","Denali","Hekaton","Kilimanjaro","Denali"));
        quizmodel_sql.add(new quizmodel("Which was the first version of SQL Server to introduce in-memory capability?","SQL Server 2005","SQL Server 2008","SQL Server 2012","SQL Server 2014","SQL Server 2014"));
        quizmodel_sql.add(new quizmodel("Which of the following data type is not present in SQL Server?","geography","hierarchyid","boolean","bit","boolean"));
        quizmodel_sql.add(new quizmodel("Which database is used by SQL Server Agent for scheduling alerts and jobs, and recording operators?","temp","model","msdb","master","msdb"));
        quizmodel_sql.add(new quizmodel("SQL Server has mainly how many types of views?","4","3","1","2","2"));
        quizmodel_sql.add(new quizmodel("Which of the following is not a SQL Server INFORMATION_SCHEMA view?","sys.dm_exec_connections","INFORMATION_SCHEMA.KEY_COLUMN_USAGE","INFORMATION_SCHEMA.DOMAIN_CONSTRAINTS","INFORMATION_SCHEMA.CONSTRAINT_TABLE_USAGE","sys.dm_exec_connections"));
        quizmodel_sql.add(new quizmodel("Which of the following joins are SQL server default?","Inner","Equil","Outer","None of the mentioned","Inner"));
        quizmodel_sql.add(new quizmodel("Which of the following is not a class of constraint in SQL Server?","UNIQUE","NOT NULL","CHECK","NULL","NULL"));
        quizmodel_sql.add(new quizmodel("Which of the reasons will force you to use the XML data model in SQL Server?","Order is inherent in your data","Your data is sparse or you do not know the structure of the data","Your data represents containment hierarchy","All of the Mentioned","All of the Mentioned"));
        quizmodel_sql.add(new quizmodel("What is the hybrid model in SQL Server?","Using XML with views","Using XML with triggers","Combination of relational and XML data type columns","Combination of relational and non relational data type columns","Combination of relational and XML data type columns"));
        quizmodel_sql.add(new quizmodel("Which of the following feature of SQL Server was used before XML technology for semi structured data?","In memory database","Stored Procedure","Dynamic management views","None of the mentioned","Stored Procedure"));
        quizmodel_sql.add(new quizmodel("Which of the following language is used for procedural flow in SQL Server?","Control-of-flow language","Flow language","Control language","None of the mentioned","Control-of-flow language"));
        quizmodel_sql.add(new quizmodel("Exception handling is possible in SQL Server using _____________","FINAL","FINALLY","THROW","All of the mentioned","THROW"));
        quizmodel_sql.add(new quizmodel("Which of the following stored procedure is already defined in SQL Server?","System defined Procedure","CLR Stored Procedure","Extended Procedure","User Defined Stored Procedure","System defined Procedure"));
        quizmodel_sql.add(new quizmodel("DML triggers in SQL Server is applicable to _____________","Update","Delete","Insert","All of the mentioned","All of the mentioned"));
        quizmodel_sql.add(new quizmodel("User defined function in SQL Server can return ____________","Result set","Scalar value","Set of values","All of the mentioned","All of the mentioned"));
        quizmodel_sql.add(new quizmodel("Here which of the following displays the unique values of the column?\nSELECT ________ dept_name \nFROM instructor;","All","From","Distinct","Name","Distinct"));
        quizmodel_sql.add(new quizmodel("The ______ clause allows us to select only those rows in the result relation of the ____ clause that satisfy a specified predicate.","Where, from","From, select","Select, from","From, where","Where, from"));
        quizmodel_sql.add(new quizmodel("he ________ clause is used to list the attributes desired in the result of a query.","Where","Select","From","Distinct","Select"));

    }
}