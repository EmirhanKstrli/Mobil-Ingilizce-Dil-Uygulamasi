package com.example.projem;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Test1_1 extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;
    int score = 0;
    int totalQuestion = QuestionAnswer1_1.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test1_1);
        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);
        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);
        totalQuestionsTextView.setText("Toplam Soru: " + totalQuestion);
        loadNewQuestion();
    }
    @Override
    public void onClick(View v) {
        ansA.setBackgroundColor(Color.rgb(76, 175, 80));
        ansB.setBackgroundColor(Color.rgb(76, 175, 80));
        ansC.setBackgroundColor(Color.rgb(76, 175, 80));
        ansD.setBackgroundColor(Color.rgb(76, 175, 80));
        Button clickedButton = (Button) v;
        if (clickedButton.getId() == R.id.submit_btn) {
            if (selectedAnswer.equals(QuestionAnswer1_1.correctAnswer[currentQuestionIndex])) {
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();
        }else{
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.rgb(51,78,53));
        }
    }
    void loadNewQuestion() {
        if (currentQuestionIndex == totalQuestion) {
            finishQuiz();
            return;
        }
        questionTextView.setText(QuestionAnswer1_1.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer1_1.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer1_1.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer1_1.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer1_1.choices[currentQuestionIndex][3]);
    }
    void finishQuiz() {
        String passStatus = "";
        if (score > totalQuestion*0.60) {
            passStatus = "Başarılı";
        }else {
            passStatus = "Başarısız";
        }
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage(totalQuestion + " sorunun " + score + " tanesi doğru!")
                .setNegativeButton("Kapat", (dialogInterface, i) -> quitQuiz())
                .setPositiveButton("Yeniden Dene", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();
    }
    void restartQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }
    void quitQuiz() {
        Intent intent = new Intent(Test1_1.this, MainActivity.class);
        startActivity(intent);
    }
}