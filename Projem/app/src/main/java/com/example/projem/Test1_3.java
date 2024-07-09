package com.example.projem;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Test1_3 extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView3;
    TextView questionTextView3;
    Button ansA3, ansB3, ansC3, ansD3;
    Button submitBtn3;

    int score3 = 0;
    int totalQuestion = QuestionAnswer1_3.question3.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test1_3);

        totalQuestionsTextView3 = findViewById(R.id.total_question3);
        questionTextView3 = findViewById(R.id.question3);
        ansA3 = findViewById(R.id.ans_A3);
        ansB3 = findViewById(R.id.ans_B3);
        ansC3 = findViewById(R.id.ans_C3);
        ansD3 = findViewById(R.id.ans_D3);
        submitBtn3 = findViewById(R.id.submit_btn3);

        ansA3.setOnClickListener(this);
        ansB3.setOnClickListener(this);
        ansC3.setOnClickListener(this);
        ansD3.setOnClickListener(this);
        submitBtn3.setOnClickListener(this);

        totalQuestionsTextView3.setText("Toplam Soru: " + totalQuestion);

        loadNewQuestion();

    }

    @Override
    public void onClick(View v) {

        ansA3.setBackgroundColor(Color.rgb(76, 175, 80));
        ansB3.setBackgroundColor(Color.rgb(76, 175, 80));
        ansC3.setBackgroundColor(Color.rgb(76, 175, 80));
        ansD3.setBackgroundColor(Color.rgb(76, 175, 80));

        Button clickedButton = (Button) v;
        if (clickedButton.getId()==R.id.submit_btn3) {

            if (selectedAnswer.equals(QuestionAnswer1_3.correctAnswer3[currentQuestionIndex])) {
                score3++;
            }

            currentQuestionIndex++;
            loadNewQuestion();

        }else {
            // choices button clicked
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.rgb(51,78,53));
        }

    }

    void loadNewQuestion() {

        if (currentQuestionIndex == totalQuestion) {
            finishQuiz();
            return;
        }

        questionTextView3.setText(QuestionAnswer1_3.question3[currentQuestionIndex]);
        ansA3.setText(QuestionAnswer1_3.choices3[currentQuestionIndex][0]);
        ansB3.setText(QuestionAnswer1_3.choices3[currentQuestionIndex][1]);
        ansC3.setText(QuestionAnswer1_3.choices3[currentQuestionIndex][2]);
        ansD3.setText(QuestionAnswer1_3.choices3[currentQuestionIndex][3]);

    }

    void finishQuiz() {

        String passStatus = "";
        if (score3 > totalQuestion*0.60) {
            passStatus = "Başarılı";
        }else {
            passStatus = "Başarısız";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage(totalQuestion + " sorunun " + score3 + " tanesi doğru!")
                .setNegativeButton("Kapat", (dialogInterface, i) -> quitQuiz())
                .setPositiveButton("Yeniden Dene", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();

    }

    void restartQuiz() {
        score3 = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

    void quitQuiz() {
        Intent intent = new Intent(Test1_3.this, MainActivity.class);
        startActivity(intent);
    }

}