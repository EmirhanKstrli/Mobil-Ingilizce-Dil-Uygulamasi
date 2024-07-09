package com.example.projem;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Test1_4 extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView4;
    TextView questionTextView4;
    Button ansA4, ansB4, ansC4, ansD4;
    Button submitBtn4;

    int score4 = 0;
    int totalQuestion = QuestionAnswer1_4.question4.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test1_4);

        totalQuestionsTextView4 = findViewById(R.id.total_question4);
        questionTextView4 = findViewById(R.id.question4);
        ansA4 = findViewById(R.id.ans_A4);
        ansB4 = findViewById(R.id.ans_B4);
        ansC4 = findViewById(R.id.ans_C4);
        ansD4 = findViewById(R.id.ans_D4);
        submitBtn4 = findViewById(R.id.submit_btn4);

        ansA4.setOnClickListener(this);
        ansB4.setOnClickListener(this);
        ansC4.setOnClickListener(this);
        ansD4.setOnClickListener(this);
        submitBtn4.setOnClickListener(this);

        totalQuestionsTextView4.setText("Toplam Soru: " + totalQuestion);

        loadNewQuestion();

    }

    @Override
    public void onClick(View v) {

        ansA4.setBackgroundColor(Color.rgb(76, 175, 80));
        ansB4.setBackgroundColor(Color.rgb(76, 175, 80));
        ansC4.setBackgroundColor(Color.rgb(76, 175, 80));
        ansD4.setBackgroundColor(Color.rgb(76, 175, 80));

        Button clickedButton = (Button) v;
        if (clickedButton.getId()==R.id.submit_btn4) {

            if (selectedAnswer.equals(QuestionAnswer1_4.correctAnswer4[currentQuestionIndex])) {
                score4++;
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

        questionTextView4.setText(QuestionAnswer1_4.question4[currentQuestionIndex]);
        ansA4.setText(QuestionAnswer1_4.choices4[currentQuestionIndex][0]);
        ansB4.setText(QuestionAnswer1_4.choices4[currentQuestionIndex][1]);
        ansC4.setText(QuestionAnswer1_4.choices4[currentQuestionIndex][2]);
        ansD4.setText(QuestionAnswer1_4.choices4[currentQuestionIndex][3]);

    }

    void finishQuiz() {

        String passStatus = "";
        if (score4 > totalQuestion*0.60) {
            passStatus = "Başarılı";
        }else {
            passStatus = "Başarısız";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage(totalQuestion + " sorunun " + score4 + " tanesi doğru!")
                .setNegativeButton("Kapat", (dialogInterface, i) -> quitQuiz())
                .setPositiveButton("Yeniden Dene", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();

    }

    void restartQuiz() {
        score4 = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

    void quitQuiz() {
        Intent intent = new Intent(Test1_4.this, MainActivity.class);
        startActivity(intent);
    }

}