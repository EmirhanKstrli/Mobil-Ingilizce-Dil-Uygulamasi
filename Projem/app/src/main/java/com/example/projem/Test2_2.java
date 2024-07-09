package com.example.projem;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Test2_2 extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView6;
    TextView questionTextView6;
    Button ansA6, ansB6, ansC6, ansD6;
    Button submitBtn6;

    int score6 = 0;
    int totalQuestion = QuestionAnswer2_2.question6.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2_2);

        totalQuestionsTextView6 = findViewById(R.id.total_question6);
        questionTextView6 = findViewById(R.id.question6);
        ansA6 = findViewById(R.id.ans_A6);
        ansB6 = findViewById(R.id.ans_B6);
        ansC6 = findViewById(R.id.ans_C6);
        ansD6 = findViewById(R.id.ans_D6);
        submitBtn6 = findViewById(R.id.submit_btn6);

        ansA6.setOnClickListener(this);
        ansB6.setOnClickListener(this);
        ansC6.setOnClickListener(this);
        ansD6.setOnClickListener(this);
        submitBtn6.setOnClickListener(this);

        totalQuestionsTextView6.setText("Toplam Soru: " + totalQuestion);

        loadNewQuestion();

    }

    @Override
    public void onClick(View v) {

        ansA6.setBackgroundColor(Color.rgb(234, 134, 11));
        ansB6.setBackgroundColor(Color.rgb(234, 134, 11));
        ansC6.setBackgroundColor(Color.rgb(234, 134, 11));
        ansD6.setBackgroundColor(Color.rgb(234, 134, 11));

        Button clickedButton = (Button) v;
        if (clickedButton.getId()==R.id.submit_btn6) {

            if (selectedAnswer.equals(QuestionAnswer2_2.correctAnswer6[currentQuestionIndex])) {
                score6++;
            }

            currentQuestionIndex++;
            loadNewQuestion();

        }else {
            // choices button clicked
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.rgb(92,66,34));
        }

    }

    void loadNewQuestion() {

        if (currentQuestionIndex == totalQuestion) {
            finishQuiz();
            return;
        }

        questionTextView6.setText(QuestionAnswer2_2.question6[currentQuestionIndex]);
        ansA6.setText(QuestionAnswer2_2.choices6[currentQuestionIndex][0]);
        ansB6.setText(QuestionAnswer2_2.choices6[currentQuestionIndex][1]);
        ansC6.setText(QuestionAnswer2_2.choices6[currentQuestionIndex][2]);
        ansD6.setText(QuestionAnswer2_2.choices6[currentQuestionIndex][3]);

    }

    void finishQuiz() {

        String passStatus = "";
        if (score6 > totalQuestion*0.60) {
            passStatus = "Başarılı";
        }else {
            passStatus = "Başarısız";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage(totalQuestion + " sorunun " + score6 + " tanesi doğru!")
                .setNegativeButton("Kapat", (dialogInterface, i) -> quitQuiz())
                .setPositiveButton("Yeniden Dene", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();

    }

    void restartQuiz() {
        score6 = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

    void quitQuiz() {
        Intent intent = new Intent(Test2_2.this, MainActivity.class);
        startActivity(intent);
    }

}