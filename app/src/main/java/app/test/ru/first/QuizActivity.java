package app.test.ru.first;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private Button[] mAnswerViews = new Button[3];

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mScoreView;
    private ImageButton quiz;
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quiz = (ImageButton) findViewById(R.id.header);
        mScoreView = (TextView) findViewById(R.id.score);
        mAnswerViews[0] = (Button) findViewById(R.id.choice1);
        mAnswerViews[1] = (Button) findViewById(R.id.choice2);
        mAnswerViews[2] = (Button) findViewById(R.id.choice3);

        updateQuestion();

        for (View view : mAnswerViews) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //My logic for Button goes in here
                    Button button = (Button) view;
                    if (button.getText() == mAnswer) {
                        mScore = mScore + 1;
                        updateScore(mScore, button);
                        updateQuestion();
                        //This line of code is optiona
                        Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                        updateQuestion();
                    }
                }
            });
        }
    }

    private void updateQuestion() {
        quiz.setImageResource(R.drawable.dratyti);

        int size = mAnswerViews.length;
        for (int i = 0; i < size; i++) {
            Button button = mAnswerViews[i];
            button.setText(mQuestionLibrary.getChoice(mQuestionNumber, i));
        }

        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
        mQuestionNumber++;
    }


    private void updateScore(int point, View buttonToChangeColor) {
        mScoreView.setText("" + mScore);
        buttonToChangeColor.setBackgroundColor(Color.GREEN);
    }
}