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
    private int mQuestionIndex;
    private int mScore = 0;
    private boolean canClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quiz = (ImageButton) findViewById(R.id.header);
        mScoreView = (TextView) findViewById(R.id.score);
        mAnswerViews[0] = (Button) findViewById(R.id.choice1);
        mAnswerViews[1] = (Button) findViewById(R.id.choice2);
        mAnswerViews[2] = (Button) findViewById(R.id.choice3);
        mQuestionIndex = -1;
        canClick = true;
        nextQuestion();

        int size = mAnswerViews.length;
        for (int i = 0; i < size; i++) {
            View view = mAnswerViews[i];
            final int currentButtonIndex = i;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!canClick) {
                        return;
                    }
                    int correctAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionIndex);
                    boolean isCorrect = correctAnswer == currentButtonIndex;
                    if (isCorrect) {
                        updateScoreView(mScore + 1);
                        //This line of code is optiona
                        Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    }
                    changeButtonColor(view, isCorrect);
                    canClick = false;
                    view.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            clearButtons();
                            nextQuestion();
                            canClick = true;
                        }
                    }, 1000);
                }
            });
        }
    }

    private void clearButtons() {
        for (View view : mAnswerViews) {
            view.setBackgroundColor(Color.BLUE);
        }
    }

    private void changeButtonColor(View view, boolean correct) {
        int color;
        if (correct) {
            color = Color.GREEN;
        } else {
            color = Color.RED;
        }
        view.setBackgroundColor(color);
    }

    private void nextQuestion() {
        int questionsCount = mQuestionLibrary.getQuestionsCount();
        mQuestionIndex++;
        if (mQuestionIndex < questionsCount) {
            int imageId = mQuestionLibrary.getQuestionImageId(mQuestionIndex);
            quiz.setImageResource(imageId);

            int size = mAnswerViews.length;
            for (int i = 0; i < size; i++) {
                Button button = mAnswerViews[i];
                button.setText(mQuestionLibrary.getChoice(mQuestionIndex, i));
            }
        } else {
            setResult(mScore);
            finish();
        }
    }


    private void updateScoreView(int score) {
        mScore = score;
        mScoreView.setText("" + score);
    }
}