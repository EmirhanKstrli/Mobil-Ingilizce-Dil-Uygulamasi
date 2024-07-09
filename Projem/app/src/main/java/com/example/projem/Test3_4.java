package com.example.projem;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Test3_4 extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView12;
    TextView questionTextView12;
    Button ansA12, ansB12, ansC12, ansD12;
    Button submitBtn12;

    int score12 = 0;
    int totalQuestion = QuestionAnswer3_4.question12.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test3_4);

        totalQuestionsTextView12 = findViewById(R.id.total_question12);
        questionTextView12 = findViewById(R.id.question12);
        ansA12 = findViewById(R.id.ans_A12);
        ansB12 = findViewById(R.id.ans_B12);
        ansC12 = findViewById(R.id.ans_C12);
        ansD12 = findViewById(R.id.ans_D12);
        submitBtn12 = findViewById(R.id.submit_btn12);

        ansA12.setOnClickListener(this);
        ansB12.setOnClickListener(this);
        ansC12.setOnClickListener(this);
        ansD12.setOnClickListener(this);
        submitBtn12.setOnClickListener(this);

        totalQuestionsTextView12.setText("Toplam Soru: " + totalQuestion);

        loadNewQuestion();

    }

    @Override
    public void onClick(View v) {

        ansA12.setBackgroundColor(Color.rgb(234, 11, 11));
        ansB12.setBackgroundColor(Color.rgb(234, 11, 11));
        ansC12.setBackgroundColor(Color.rgb(234, 11, 11));
        ansD12.setBackgroundColor(Color.rgb(234, 11, 11));

        Button clickedButton = (Button) v;
        if (clickedButton.getId()==R.id.submit_btn12) {

            if (selectedAnswer.equals(QuestionAnswer3_4.correctAnswer12[currentQuestionIndex])) {
                score12++;
            }

            currentQuestionIndex++;
            loadNewQuestion();

        }else {
            // choices button clicked
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.rgb(92,34,34));
        }

    }

    void loadNewQuestion() {

        if (currentQuestionIndex == totalQuestion) {
            finishQuiz();
            return;
        }

        questionTextView12.setText(QuestionAnswer3_4.question12[currentQuestionIndex]);
        ansA12.setText(QuestionAnswer3_4.choices12[currentQuestionIndex][0]);
        ansB12.setText(QuestionAnswer3_4.choices12[currentQuestionIndex][1]);
        ansC12.setText(QuestionAnswer3_4.choices12[currentQuestionIndex][2]);
        ansD12.setText(QuestionAnswer3_4.choices12[currentQuestionIndex][3]);

    }

    void finishQuiz() {

        String passStatus = "";
        if (score12 > totalQuestion*0.60) {
            passStatus = "Başarılı";
        }else {
            passStatus = "Başarısız";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage(totalQuestion + " sorunun " + score12 + " tanesi doğru!")
                .setNegativeButton("Kapat", (dialogInterface, i) -> quitQuiz())
                .setPositiveButton("Yeniden Dene", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();

    }

    void restartQuiz() {
        score12 = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

    void quitQuiz() {
        Intent intent = new Intent(Test3_4.this, MainActivity.class);
        startActivity(intent);
    }

}