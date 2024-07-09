package com.example.projem;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Test2_1 extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView5;
    TextView questionTextView5;
    Button ansA5, ansB5, ansC5, ansD5;
    Button submitBtn5;

    int score5 = 0;
    int totalQuestion = QuestionAnswer2_1.question5.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2_1);

        totalQuestionsTextView5 = findViewById(R.id.total_question5);
        questionTextView5 = findViewById(R.id.question5);
        ansA5 = findViewById(R.id.ans_A5);
        ansB5 = findViewById(R.id.ans_B5);
        ansC5 = findViewById(R.id.ans_C5);
        ansD5 = findViewById(R.id.ans_D5);
        submitBtn5 = findViewById(R.id.submit_btn5);

        ansA5.setOnClickListener(this);
        ansB5.setOnClickListener(this);
        ansC5.setOnClickListener(this);
        ansD5.setOnClickListener(this);
        submitBtn5.setOnClickListener(this);

        totalQuestionsTextView5.setText("Toplam Soru: " + totalQuestion);

        loadNewQuestion();

    }

    @Override
    public void onClick(View v) {

        ansA5.setBackgroundColor(Color.rgb(234, 134, 11));
        ansB5.setBackgroundColor(Color.rgb(234, 134, 11));
        ansC5.setBackgroundColor(Color.rgb(234, 134, 11));
        ansD5.setBackgroundColor(Color.rgb(234, 134, 11));

        Button clickedButton = (Button) v;
        if (clickedButton.getId()==R.id.submit_btn5) {

            if (selectedAnswer.equals(QuestionAnswer2_1.correctAnswer5[currentQuestionIndex])) {
                score5++;
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

        questionTextView5.setText(QuestionAnswer2_1.question5[currentQuestionIndex]);
        ansA5.setText(QuestionAnswer2_1.choices5[currentQuestionIndex][0]);
        ansB5.setText(QuestionAnswer2_1.choices5[currentQuestionIndex][1]);
        ansC5.setText(QuestionAnswer2_1.choices5[currentQuestionIndex][2]);
        ansD5.setText(QuestionAnswer2_1.choices5[currentQuestionIndex][3]);

    }

    void finishQuiz() {

        String passStatus = "";
        if (score5 > totalQuestion*0.60) {
            passStatus = "Başarılı";
        }else {
            passStatus = "Başarısız";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage(totalQuestion + " sorunun " + score5 + " tanesi doğru!")
                .setNegativeButton("Kapat", (dialogInterface, i) -> quitQuiz())
                .setPositiveButton("Yeniden Dene", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();

    }

    void restartQuiz() {
        score5 = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

    void quitQuiz() {
        Intent intent = new Intent(Test2_1.this, MainActivity.class);
        startActivity(intent);
    }

}