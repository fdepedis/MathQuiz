package it.flaviodepedis.mathquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // number of total questions
    private static final int NUM_OF_QUESTIONS = 6;

    // Tracks the counter of question
    private int countQuestion = 1;

    // Tracks the score of the quiz
    private int score = 0;

    // Tracks the status of the answer
    private boolean status;

    // Declare view
    private TextView tvQuestion;
    private TextView idQuestion;
    private Button btnSubmit;
    private FrameLayout frameQ1;
    private FrameLayout frameQ2;
    private FrameLayout frameQ3;
    private FrameLayout frameQ4;
    private FrameLayout frameQ5;
    private FrameLayout frameQ6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the view
        frameQ1 = (FrameLayout) findViewById(R.id.question1);
        frameQ2 = (FrameLayout) findViewById(R.id.question2);
        frameQ3 = (FrameLayout) findViewById(R.id.question3);
        frameQ4 = (FrameLayout) findViewById(R.id.question4);
        frameQ5 = (FrameLayout) findViewById(R.id.question5);
        frameQ6 = (FrameLayout) findViewById(R.id.question6);

        // setup all FrameLayout to INVISIBLE
        setupViewInvisible();

        // method to display the current question
        displayQuestion(countQuestion);
    }

    /**
     * Method called from onClick properties and handle the click event button.
     */
    public void submitAnswer(View view) {

        // verify if EditText is Empty and the question is <=5 (number of questions)
        if (countQuestion <= NUM_OF_QUESTIONS) {
            status = verifyAnswer(countQuestion);
            if (status) {
                okAnswer();
            } else {
                koAnswer();
            }
        }
    }

    /**
     * Method called from onClick properties and handle the click event button.
     */
    public void submitReset(View view) {
        countQuestion = 1;
        score = 0;
        setupViewInvisible();
        displayQuestion(countQuestion);
        btnSubmit.setEnabled(true);
    }

    /**
     * Method called to display message for correct answer
     * and increase the counter of next question.
     */
    public void okAnswer() {
        countQuestion++;
        Toast.makeText(getApplicationContext(), R.string.correctAnswer, Toast.LENGTH_SHORT).show();
        displayQuestion(countQuestion);
    }

    /**
     * Method called to display message for incorrect answer
     * and increase the counter of next question.
     */
    public void koAnswer() {
        countQuestion++;
        Toast.makeText(getApplicationContext(), R.string.incorrectAnswer, Toast.LENGTH_SHORT).show();
        displayQuestion(countQuestion);
    }

    /**
     * Method for count score.
     */
    public void updateScore() {
        score = score + 20;
    }

    /**
     * Method to setup all FrameLayout to INVISIBLE.
     */
    public void setupViewInvisible() {
        frameQ1.setVisibility(View.INVISIBLE);
        frameQ2.setVisibility(View.INVISIBLE);
        frameQ3.setVisibility(View.INVISIBLE);
        frameQ4.setVisibility(View.INVISIBLE);
        frameQ5.setVisibility(View.INVISIBLE);
        frameQ6.setVisibility(View.INVISIBLE);
    }

    /**
     * Method called to diplay the sequence question.
     *
     * @param countQuestion identify the actual question
     */
    public void displayQuestion(int countQuestion) {

        // create view reference
        tvQuestion = (TextView) findViewById(R.id.textQuestion);
        idQuestion = (TextView) findViewById(R.id.idQuestion);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        // find which question need to show
        switch (countQuestion) {
            case 1:
                tvQuestion.setText(R.string.question1);
                idQuestion.setText(Integer.toString(countQuestion));
                frameQ1.setVisibility(View.VISIBLE);
                break;
            case 2:
                tvQuestion.setText(R.string.question2);
                idQuestion.setText(Integer.toString(countQuestion));
                frameQ1.setVisibility(View.INVISIBLE);
                frameQ2.setVisibility(View.VISIBLE);
                break;
            case 3:
                tvQuestion.setText(R.string.question3);
                idQuestion.setText(Integer.toString(countQuestion));
                frameQ2.setVisibility(View.INVISIBLE);
                frameQ3.setVisibility(View.VISIBLE);
                break;
            case 4:
                tvQuestion.setText(R.string.question4);
                idQuestion.setText(Integer.toString(countQuestion));
                frameQ3.setVisibility(View.INVISIBLE);
                frameQ4.setVisibility(View.VISIBLE);
                break;
            case 5:
                tvQuestion.setText(R.string.question5);
                idQuestion.setText(Integer.toString(countQuestion));
                frameQ4.setVisibility(View.INVISIBLE);
                frameQ5.setVisibility(View.VISIBLE);
                break;
            case 6:
                tvQuestion.setText(R.string.question6);
                idQuestion.setText(Integer.toString(countQuestion));
                frameQ5.setVisibility(View.INVISIBLE);
                frameQ6.setVisibility(View.VISIBLE);
                break;
            default:
                tvQuestion.setText(R.string.completedQuiz);
                idQuestion.setText(R.string.resetQuestions);
                setupViewInvisible();
                btnSubmit.setEnabled(false);

                // Show Toast message for score
                Toast.makeText(getApplicationContext(), getString(R.string.score) + " " + String.valueOf(score), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * Method to verify if the answer is correct or not
     *
     * @param countQuestion identify the actual question
     */
    public boolean verifyAnswer(int countQuestion) {

        if (countQuestion == 1) {
            RadioButton hasBtn1_2 = (RadioButton) findViewById(R.id.radioBtn1_2);
            if (hasBtn1_2.isChecked()) {
                updateScore();
                return true;
            }
        } else if (countQuestion == 2) {
            EditText etAnswer = (EditText) findViewById(R.id.textAnswer);
            if (!etAnswer.getText().toString().isEmpty() && etAnswer.getText().toString().equals("1")) {
                updateScore();
                return true;
            }
        } else if (countQuestion == 3) {
            RadioButton hasBtn3_2 = (RadioButton) findViewById(R.id.radioBtn3_2);
            if (hasBtn3_2.isChecked()) {
                updateScore();
                return true;
            }
        } else if (countQuestion == 4) {
            CheckBox hasCheckBox4_1 = (CheckBox) findViewById(R.id.checkbox4_1);
            CheckBox hasCheckBox4_2 = (CheckBox) findViewById(R.id.checkbox4_2);
            CheckBox hasCheckBox4_3 = (CheckBox) findViewById(R.id.checkbox4_3);
            CheckBox hasCheckBox4_4 = (CheckBox) findViewById(R.id.checkbox4_4);
            if (!hasCheckBox4_1.isChecked() && !hasCheckBox4_2.isChecked() && hasCheckBox4_3.isChecked() && hasCheckBox4_4.isChecked() ) {
                updateScore();
                return true;
            }
        } else if (countQuestion == 5) {
            CheckBox hasCheckBox5_1 = (CheckBox) findViewById(R.id.checkbox5_1);
            CheckBox hasCheckBox5_2 = (CheckBox) findViewById(R.id.checkbox5_2);
            CheckBox hasCheckBox5_3 = (CheckBox) findViewById(R.id.checkbox5_3);
            CheckBox hasCheckBox5_4 = (CheckBox) findViewById(R.id.checkbox5_4);
            if (hasCheckBox5_1.isChecked() && !hasCheckBox5_2.isChecked() && hasCheckBox5_3.isChecked() && !hasCheckBox5_4.isChecked()) {
                updateScore();
                return true;
            }
        } else if (countQuestion == 6) {
            RadioButton hasBtn6_1 = (RadioButton) findViewById(R.id.radioBtn6_1);
            if (hasBtn6_1.isChecked()) {
                updateScore();
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

}
