package com.example.projem;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Test3_1 extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView9;
    TextView questionTextView9;
    Button ansA9, ansB9, ansC9, ansD9;
    Button submitBtn9;

    int score9 = 0;
    int totalQuestion = QuestionAnswer3_1.question9.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test3_1);

        totalQuestionsTextView9 = findViewById(R.id.total_question9);
        questionTextView9 = findViewById(R.id.question9);
        ansA9 = findViewById(R.id.ans_A9);
        ansB9 = findViewById(R.id.ans_B9);
        ansC9 = findViewById(R.id.ans_C9);
        ansD9 = findViewById(R.id.ans_D9);
        submitBtn9 = findViewById(R.id.submit_btn9);

        ansA9.setOnClickListener(this);
        ansB9.setOnClickListener(this);
        ansC9.setOnClickListener(this);
        ansD9.setOnClickListener(this);
        submitBtn9.setOnClickListener(this);

        totalQuestionsTextView9.setText("Toplam Soru: " + totalQuestion);

        loadNewQuestion();

    }

    @Override
    public void onClick(View v) {

        ansA9.setBackgroundColor(Color.rgb(234, 11, 11));
        ansB9.setBackgroundColor(Color.rgb(234, 11, 11));
        ansC9.setBackgroundColor(Color.rgb(234, 11, 11));
        ansD9.setBackgroundColor(Color.rgb(234, 11, 11));

        Button clickedButton = (Button) v;
        if (clickedButton.getId()==R.id.submit_btn9) {

            if (selectedAnswer.equals(QuestionAnswer3_1.correctAnswer9[currentQuestionIndex])) {
                score9++;
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

        questionTextView9.setText(QuestionAnswer3_1.question9[currentQuestionIndex]);
        ansA9.setText(QuestionAnswer3_1.choices9[currentQuestionIndex][0]);
        ansB9.setText(QuestionAnswer3_1.choices9[currentQuestionIndex][1]);
        ansC9.setText(QuestionAnswer3_1.choices9[currentQuestionIndex][2]);
        ansD9.setText(QuestionAnswer3_1.choices9[currentQuestionIndex][3]);

    }

    void finishQuiz() {

        String passStatus = "";
        if (score9 > totalQuestion*0.60) {
            passStatus = "Başarılı";
        }else {
            passStatus = "Başarısız";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage(totalQuestion + " sorunun " + score9 + " tanesi doğru!")
                .setNegativeButton("Kapat", (dialogInterface, i) -> quitQuiz())
                .setPositiveButton("Yeniden Dene", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();

    }

    void restartQuiz() {
        score9 = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

    void quitQuiz() {
        Intent intent = new Intent(Test3_1.this, MainActivity.class);
        startActivity(intent);
    }

}