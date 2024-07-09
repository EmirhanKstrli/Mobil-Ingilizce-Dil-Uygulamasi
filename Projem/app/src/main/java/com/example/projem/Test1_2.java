package com.example.projem;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Test1_2 extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView2;
    TextView questionTextView2;
    Button ansA2, ansB2, ansC2, ansD2;
    Button submitBtn2;

    int score2 = 0;
    int totalQuestion = QuestionAnswer1_2.question2.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test1_2);

        totalQuestionsTextView2 = findViewById(R.id.total_question2);
        questionTextView2 = findViewById(R.id.question2);
        ansA2 = findViewById(R.id.ans_A2);
        ansB2 = findViewById(R.id.ans_B2);
        ansC2 = findViewById(R.id.ans_C2);
        ansD2 = findViewById(R.id.ans_D2);
        submitBtn2 = findViewById(R.id.submit_btn2);

        ansA2.setOnClickListener(this);
        ansB2.setOnClickListener(this);
        ansC2.setOnClickListener(this);
        ansD2.setOnClickListener(this);
        submitBtn2.setOnClickListener(this);

        totalQuestionsTextView2.setText("Toplam Soru: " + totalQuestion);

        loadNewQuestion();

    }

    @Override
    public void onClick(View v) {

        ansA2.setBackgroundColor(Color.rgb(76, 175, 80));
        ansB2.setBackgroundColor(Color.rgb(76, 175, 80));
        ansC2.setBackgroundColor(Color.rgb(76, 175, 80));
        ansD2.setBackgroundColor(Color.rgb(76, 175, 80));

        Button clickedButton = (Button) v;
        if (clickedButton.getId()==R.id.submit_btn2) {

            if (selectedAnswer.equals(QuestionAnswer1_2.correctAnswer2[currentQuestionIndex])) {
                score2++;
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

        questionTextView2.setText(QuestionAnswer1_2.question2[currentQuestionIndex]);
        ansA2.setText(QuestionAnswer1_2.choices2[currentQuestionIndex][0]);
        ansB2.setText(QuestionAnswer1_2.choices2[currentQuestionIndex][1]);
        ansC2.setText(QuestionAnswer1_2.choices2[currentQuestionIndex][2]);
        ansD2.setText(QuestionAnswer1_2.choices2[currentQuestionIndex][3]);

    }

    void finishQuiz() {

        String passStatus = "";
        if (score2 > totalQuestion*0.60) {
            passStatus = "Başarılı";
        }else {
            passStatus = "Başarısız";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage(totalQuestion + " sorunun " + score2 + " tanesi doğru!")
                .setNegativeButton("Kapat", (dialogInterface, i) -> quitQuiz())
                .setPositiveButton("Yeniden Dene", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();

    }

    void restartQuiz() {
        score2 = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

    void quitQuiz() {
        Intent intent = new Intent(Test1_2.this, MainActivity.class);
        startActivity(intent);
    }

}