package com.example.projem;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Test3_3 extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView11;
    TextView questionTextView11;
    Button ansA11, ansB11, ansC11, ansD11;
    Button submitBtn11;

    int score11 = 0;
    int totalQuestion = QuestionAnswer3_3.question11.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test3_3);

        totalQuestionsTextView11 = findViewById(R.id.total_question11);
        questionTextView11 = findViewById(R.id.question11);
        ansA11 = findViewById(R.id.ans_A11);
        ansB11 = findViewById(R.id.ans_B11);
        ansC11 = findViewById(R.id.ans_C11);
        ansD11 = findViewById(R.id.ans_D11);
        submitBtn11 = findViewById(R.id.submit_btn11);

        ansA11.setOnClickListener(this);
        ansB11.setOnClickListener(this);
        ansC11.setOnClickListener(this);
        ansD11.setOnClickListener(this);
        submitBtn11.setOnClickListener(this);

        totalQuestionsTextView11.setText("Toplam Soru: " + totalQuestion);

        loadNewQuestion();

    }

    @Override
    public void onClick(View v) {

        ansA11.setBackgroundColor(Color.rgb(234, 11, 11));
        ansB11.setBackgroundColor(Color.rgb(234, 11, 11));
        ansC11.setBackgroundColor(Color.rgb(234, 11, 11));
        ansD11.setBackgroundColor(Color.rgb(234, 11, 11));

        Button clickedButton = (Button) v;
        if (clickedButton.getId()==R.id.submit_btn11) {

            if (selectedAnswer.equals(QuestionAnswer3_3.correctAnswer11[currentQuestionIndex])) {
                score11++;
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

        questionTextView11.setText(QuestionAnswer3_3.question11[currentQuestionIndex]);
        ansA11.setText(QuestionAnswer3_3.choices11[currentQuestionIndex][0]);
        ansB11.setText(QuestionAnswer3_3.choices11[currentQuestionIndex][1]);
        ansC11.setText(QuestionAnswer3_3.choices11[currentQuestionIndex][2]);
        ansD11.setText(QuestionAnswer3_3.choices11[currentQuestionIndex][3]);

    }

    void finishQuiz() {

        String passStatus = "";
        if (score11 > totalQuestion*0.60) {
            passStatus = "Başarılı";
        }else {
            passStatus = "Başarısız";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage(totalQuestion + " sorunun " + score11 + " tanesi doğru!")
                .setNegativeButton("Kapat", (dialogInterface, i) -> quitQuiz())
                .setPositiveButton("Yeniden Dene", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();

    }

    void restartQuiz() {
        score11 = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

    void quitQuiz() {
        Intent intent = new Intent(Test3_3.this, MainActivity.class);
        startActivity(intent);
    }
}