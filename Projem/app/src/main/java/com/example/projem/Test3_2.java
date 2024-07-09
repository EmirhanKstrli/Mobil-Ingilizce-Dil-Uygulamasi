package com.example.projem;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Test3_2 extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView10;
    TextView questionTextView10;
    Button ansA10, ansB10, ansC10, ansD10;
    Button submitBtn10;

    int score10 = 0;
    int totalQuestion = QuestionAnswer3_2.question10.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test3_2);

        totalQuestionsTextView10 = findViewById(R.id.total_question10);
        questionTextView10 = findViewById(R.id.question10);
        ansA10 = findViewById(R.id.ans_A10);
        ansB10 = findViewById(R.id.ans_B10);
        ansC10 = findViewById(R.id.ans_C10);
        ansD10 = findViewById(R.id.ans_D10);
        submitBtn10 = findViewById(R.id.submit_btn10);

        ansA10.setOnClickListener(this);
        ansB10.setOnClickListener(this);
        ansC10.setOnClickListener(this);
        ansD10.setOnClickListener(this);
        submitBtn10.setOnClickListener(this);

        totalQuestionsTextView10.setText("Toplam Soru: " + totalQuestion);

        loadNewQuestion();

    }

    @Override
    public void onClick(View v) {

        ansA10.setBackgroundColor(Color.rgb(234, 11, 11));
        ansB10.setBackgroundColor(Color.rgb(234, 11, 11));
        ansC10.setBackgroundColor(Color.rgb(234, 11, 11));
        ansD10.setBackgroundColor(Color.rgb(234, 11, 11));

        Button clickedButton = (Button) v;
        if (clickedButton.getId()==R.id.submit_btn10) {

            if (selectedAnswer.equals(QuestionAnswer3_2.correctAnswer10[currentQuestionIndex])) {
                score10++;
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

        questionTextView10.setText(QuestionAnswer3_2.question10[currentQuestionIndex]);
        ansA10.setText(QuestionAnswer3_2.choices10[currentQuestionIndex][0]);
        ansB10.setText(QuestionAnswer3_2.choices10[currentQuestionIndex][1]);
        ansC10.setText(QuestionAnswer3_2.choices10[currentQuestionIndex][2]);
        ansD10.setText(QuestionAnswer3_2.choices10[currentQuestionIndex][3]);

    }

    void finishQuiz() {

        String passStatus = "";
        if (score10 > totalQuestion*0.60) {
            passStatus = "Başarılı";
        }else {
            passStatus = "Başarısız";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage(totalQuestion + " sorunun " + score10 + " tanesi doğru!")
                .setNegativeButton("Kapat", (dialogInterface, i) -> quitQuiz())
                .setPositiveButton("Yeniden Dene", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();

    }

    void restartQuiz() {
        score10 = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

    void quitQuiz() {
        Intent intent = new Intent(Test3_2.this, MainActivity.class);
        startActivity(intent);
    }

}