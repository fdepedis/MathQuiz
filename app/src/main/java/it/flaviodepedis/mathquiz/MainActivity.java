package it.flaviodepedis.mathquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

    private final int answer1 = 18;
    private final int answer2 = 1;
    private final int answer3 = 114;
    private final int answer4 = 9;
    private final int answer5 = 625;
    private final boolean answer6 = true;

    // Declare view
    private TextView tvQuestion;
    private TextView idQuestion;
    private EditText etAnswer;
    private Button btnDisable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayQuestion(countQuestion);
    }

    /**
     * Method called from onClick properties and handle the click event button.
     */
    public void submitAnswer(View view){

        etAnswer = (EditText) findViewById(R.id.idAnswer);

        // verify if EditText is Empty and the question is <=5 (number of questions)
        if (!etAnswer.getText().toString().isEmpty() && countQuestion <= NUM_OF_QUESTIONS) {
            status = verifyAnswer(countQuestion);
            if (status) {
                okAnswer();
                //updateScore();
            }
            else {
                Toast.makeText(getApplicationContext(),R.string.incorrectAnswer, Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(getApplicationContext(),R.string.emptyAnswer, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Method called to display message for correct answer
     * and increase the counter of next question.
     *
     */
    public void okAnswer(){
        countQuestion ++;
        Toast.makeText(getApplicationContext(),R.string.correctAnswer, Toast.LENGTH_SHORT).show();
        displayQuestion(countQuestion);
    }

    /**
     * Method called to diplay the sequence question.
     *
     * @param countQuestion identify the actual question
     */
    public void displayQuestion(int countQuestion){

        tvQuestion = (TextView) findViewById(R.id.textQuestion);
        idQuestion = (TextView) findViewById(R.id.idQuestion);
        etAnswer = (EditText) findViewById(R.id.idAnswer);
        btnDisable = (Button) findViewById(R.id.btnSubmit);

        // find which question need to show
        if (countQuestion == 1) {
            //question = question1;
            tvQuestion.setText(R.string.question1);
            idQuestion.setText(Integer.toString(countQuestion));
        }
        else if (countQuestion == 2) {
            //question = question2;
            tvQuestion.setText(R.string.question2);
            idQuestion.setText(Integer.toString(countQuestion));
        }
        else if (countQuestion == 3) {
            //question = question3;
            tvQuestion.setText(R.string.question3);
            idQuestion.setText(Integer.toString(countQuestion));
        }
        else if (countQuestion == 4) {
            //question = question4;
            tvQuestion.setText(R.string.question4);
            idQuestion.setText(Integer.toString(countQuestion));
        }
        else if (countQuestion == 5) {
            //question = question5;
            tvQuestion.setText(R.string.question5);
            idQuestion.setText(Integer.toString(countQuestion));
        }
        /*
        else if (countQuestion == 6) {
            //question = question6;
            tvQuestion.setText(R.string.question6);
            idQuestion.setText(Integer.toString(countQuestion));
        }
        */
        else{
            tvQuestion.setText(R.string.completedQuiz);
            idQuestion.setText(R.string.resetQuestions);
            etAnswer.setEnabled(false);
            etAnswer.setHint(R.string.resetQuestions);
            btnDisable.setEnabled(false);
        }
    }

    /**
     * Method to verify if the answer is correct or not
     *
     * @param countQuestion identify the actual question
     */
    public boolean verifyAnswer(int countQuestion){

        etAnswer = (EditText) findViewById(R.id.idAnswer);

        if (countQuestion == 1 && Integer.parseInt(etAnswer.getText().toString()) == answer1) {
            etAnswer.setText(R.string.resetQuestions);
            return true;
        }
        else if (countQuestion == 2 && Integer.parseInt(etAnswer.getText().toString()) == answer2) {
            etAnswer.setText(R.string.resetQuestions);
            return true;
        }
        else if (countQuestion == 3 && Integer.parseInt(etAnswer.getText().toString()) == answer3) {
            etAnswer.setText(R.string.resetQuestions);
            return true;
        }
        else if (countQuestion == 4 && Integer.parseInt(etAnswer.getText().toString()) == answer4) {
            etAnswer.setText(R.string.resetQuestions);
            return true;
        }
        else if (countQuestion == 5 && Integer.parseInt(etAnswer.getText().toString()) == answer5) {
            etAnswer.setText(R.string.resetQuestions);
            return true;
        }
        /*
        else if (countQuestion == 6 && Integer.parseInt(etAnswer.getText().toString()) == answer6) {
            etAnswer.setText(R.string.resetQuestions);
            return true;
        }
        */
        else{
            return false;
        }
    }
}
