package com.example.projem;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Test2_4 extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView8;
    TextView questionTextView8;
    Button ansA8, ansB8, ansC8, ansD8;
    Button submitBtn8;

    int score8 = 0;
    int totalQuestion = QuestionAnswer2_4.question8.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2_4);

        totalQuestionsTextView8 = findViewById(R.id.total_question8);
        questionTextView8 = findViewById(R.id.question8);
        ansA8 = findViewById(R.id.ans_A8);
        ansB8 = findViewById(R.id.ans_B8);
        ansC8 = findViewById(R.id.ans_C8);
        ansD8 = findViewById(R.id.ans_D8);
        submitBtn8 = findViewById(R.id.submit_btn8);

        ansA8.setOnClickListener(this);
        ansB8.setOnClickListener(this);
        ansC8.setOnClickListener(this);
        ansD8.setOnClickListener(this);
        submitBtn8.setOnClickListener(this);

        totalQuestionsTextView8.setText("Toplam Soru: " + totalQuestion);

        loadNewQuestion();

    }

    @Override
    public void onClick(View v) {

        ansA8.setBackgroundColor(Color.rgb(234, 134, 11));
        ansB8.setBackgroundColor(Color.rgb(234, 134, 11));
        ansC8.setBackgroundColor(Color.rgb(234, 134, 11));
        ansD8.setBackgroundColor(Color.rgb(234, 134, 11));

        Button clickedButton = (Button) v;
        if (clickedButton.getId()==R.id.submit_btn8) {

            if (selectedAnswer.equals(QuestionAnswer2_4.correctAnswer8[currentQuestionIndex])) {
                score8++;
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

        questionTextView8.setText(QuestionAnswer2_4.question8[currentQuestionIndex]);
        ansA8.setText(QuestionAnswer2_4.choices8[currentQuestionIndex][0]);
        ansB8.setText(QuestionAnswer2_4.choices8[currentQuestionIndex][1]);
        ansC8.setText(QuestionAnswer2_4.choices8[currentQuestionIndex][2]);
        ansD8.setText(QuestionAnswer2_4.choices8[currentQuestionIndex][3]);

    }

    void finishQuiz() {

        String passStatus = "";
        if (score8 > totalQuestion*0.60) {
            passStatus = "Başarılı";
        }else {
            passStatus = "Başarısız";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage(totalQuestion + " sorunun " + score8 + " tanesi doğru!")
                .setNegativeButton("Kapat", (dialogInterface, i) -> quitQuiz())
                .setPositiveButton("Yeniden Dene", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();

    }

    void restartQuiz() {
        score8 = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

    void quitQuiz() {
        Intent intent = new Intent(Test2_4.this, MainActivity.class);
        startActivity(intent);
    }

}