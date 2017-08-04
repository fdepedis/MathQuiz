package it.flaviodepedis.mathquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int countAnswer = 1;
    private String question = "";
    private final String question1 = "Quanto fa 3 x 2 ?";
    private final String question2 = "Calcola il risultato di: (10 - 8)/2";
    private final String question3 = "Calcola il doppio di 57";
    private final String question4 = "Trova la radice quadrata di 81";
    private final String question5 = "Calcola il quadrato di 25";

    private final int answer1 = 6;
    private final int answer2 = 1;
    private final int answer3 = 114;
    private final int answer4 = 9;
    private final int answer5 = 625;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayQuestion(countAnswer);
    }

    public void submitAnswer(View view){

        boolean status = false;

        if (countAnswer <= 5) {
            status = verifyAnswer(countAnswer);
            if (status) {
                okAnswer();
            }
            else {
                Toast.makeText(getApplicationContext(),"Risposta errata! Ritenta...", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void okAnswer(){
        countAnswer ++;
        Toast.makeText(getApplicationContext(),"Risposta corretta!", Toast.LENGTH_SHORT).show();
        displayQuestion(countAnswer);
    }


    public void displayQuestion(int countAnswer){

        TextView tvQuestion = (TextView) findViewById(R.id.textQuestion);
        TextView idQuestion = (TextView) findViewById(R.id.idQuestion);

        if (countAnswer == 1) {
            question = question1;
            tvQuestion.setText(question);
            idQuestion.setText(Integer.toString(countAnswer));
        }
        else if (countAnswer == 2) {
            question = question2;
            tvQuestion.setText(question);
            idQuestion.setText(Integer.toString(countAnswer));
        }
        else if (countAnswer == 3) {
            question = question3;
            tvQuestion.setText(question);
            idQuestion.setText(Integer.toString(countAnswer));
        }
        else if (countAnswer == 4) {
            question = question4;
            tvQuestion.setText(question);
            idQuestion.setText(Integer.toString(countAnswer));
        }
        else if (countAnswer == 5) {
            question = question5;
            tvQuestion.setText(question);
            idQuestion.setText(Integer.toString(countAnswer));
        }
        else{
            tvQuestion.setText("Math Quiz completato!!!");
            idQuestion.setText("");
            EditText etDisable = (EditText) findViewById(R.id.idAnswer);
            Button btnDisable = (Button) findViewById(R.id.btnSubmit);
            etDisable.setEnabled(false);
            etDisable.setHint("");
            btnDisable.setEnabled(false);
        }
    }


    public boolean verifyAnswer(int countAnswer){

        EditText etAnswer = (EditText) findViewById(R.id.idAnswer);

        if (countAnswer == 1 && Integer.parseInt(etAnswer.getText().toString()) == answer1) {
            etAnswer.setText("");
            return true;
        }
        else if (countAnswer == 2 && Integer.parseInt(etAnswer.getText().toString()) == answer2) {
            etAnswer.setText("");
            return true;
        }
        else if (countAnswer == 3 && Integer.parseInt(etAnswer.getText().toString()) == answer3) {
            etAnswer.setText("");
            return true;
        }
        else if (countAnswer == 4 && Integer.parseInt(etAnswer.getText().toString()) == answer4) {
            etAnswer.setText("");
            return true;
        }
        else if (countAnswer == 5 && Integer.parseInt(etAnswer.getText().toString()) == answer5) {
            etAnswer.setText("");
            return true;
        }
        else{
            return false;
        }
    }
}
