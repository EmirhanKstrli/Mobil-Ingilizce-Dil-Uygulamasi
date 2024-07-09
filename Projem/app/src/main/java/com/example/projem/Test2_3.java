package com.example.projem;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Test2_3 extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView7;
    TextView questionTextView7;
    Button ansA7, ansB7, ansC7, ansD7;
    Button submitBtn7;

    int score7 = 0;
    int totalQuestion = QuestionAnswer2_3.question7.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2_3);

        totalQuestionsTextView7 = findViewById(R.id.total_question7);
        questionTextView7 = findViewById(R.id.question7);
        ansA7 = findViewById(R.id.ans_A7);
        ansB7 = findViewById(R.id.ans_B7);
        ansC7 = findViewById(R.id.ans_C7);
        ansD7 = findViewById(R.id.ans_D7);
        submitBtn7 = findViewById(R.id.submit_btn7);

        ansA7.setOnClickListener(this);
        ansB7.setOnClickListener(this);
        ansC7.setOnClickListener(this);
        ansD7.setOnClickListener(this);
        submitBtn7.setOnClickListener(this);

        totalQuestionsTextView7.setText("Toplam Soru: " + totalQuestion);

        loadNewQuestion();

    }

    @Override
    public void onClick(View v) {

        ansA7.setBackgroundColor(Color.rgb(234, 134, 11));
        ansB7.setBackgroundColor(Color.rgb(234, 134, 11));
        ansC7.setBackgroundColor(Color.rgb(234, 134, 11));
        ansD7.setBackgroundColor(Color.rgb(234, 134, 11));

        Button clickedButton = (Button) v;
        if (clickedButton.getId()==R.id.submit_btn7) {

            if (selectedAnswer.equals(QuestionAnswer2_3.correctAnswer7[currentQuestionIndex])) {
                score7++;
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

        questionTextView7.setText(QuestionAnswer2_3.question7[currentQuestionIndex]);
        ansA7.setText(QuestionAnswer2_3.choices7[currentQuestionIndex][0]);
        ansB7.setText(QuestionAnswer2_3.choices7[currentQuestionIndex][1]);
        ansC7.setText(QuestionAnswer2_3.choices7[currentQuestionIndex][2]);
        ansD7.setText(QuestionAnswer2_3.choices7[currentQuestionIndex][3]);

    }

    void finishQuiz() {

        String passStatus = "";
        if (score7 > totalQuestion*0.60) {
            passStatus = "Başarılı";
        }else {
            passStatus = "Başarısız";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage(totalQuestion + " sorunun " + score7 + " tanesi doğru!")
                .setNegativeButton("Kapat", (dialogInterface, i) -> quitQuiz())
                .setPositiveButton("Yeniden Dene", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();

    }

    void restartQuiz() {
        score7 = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

    void quitQuiz() {
        Intent intent = new Intent(Test2_3.this, MainActivity.class);
        startActivity(intent);
    }

}