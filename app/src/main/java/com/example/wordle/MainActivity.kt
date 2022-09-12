package com.example.wordle

//import android.R
import FourLetterWordList.getRandomFourLetterWord
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    val wordToGuess = getRandomFourLetterWord();
    var guesses=0;
    //private EditText inputWord;
    //private Button guessButton;
    //private TextView guessOne
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.guessButton);
        button.setOnClickListener {
            val simpleEditText =  findViewById<EditText>(R.id.guessWord);
            val strValue = simpleEditText.getText().toString();
            val res = checkGuess(strValue);
            if(guesses==1){
                val text1= findViewById<TextView>(R.id.guessOne);
                val check = findViewById<TextView>(R.id.guessOneCheck);
                text1.text = "Guess #1    " + strValue;
                check.text = "Guess # 1 Check   " + res;
            }
            else if(guesses==2){
                val text1= findViewById<TextView>(R.id.guessTwo);
                val check = findViewById<TextView>(R.id.guessTwoCheck);
                text1.text = "Guess #2    " + strValue;
                check.text = "Guess # 2 Check   " + res;
            }
            else if(guesses==3){
                val text1= findViewById<TextView>(R.id.guessThree);
                val check = findViewById<TextView>(R.id.guessThreeCheck);
                text1.text = "Guess #3    " + strValue;
                check.text = "Guess # 3 Check   " + res;
                button.setClickable(false);
                val answer = findViewById<TextView>(R.id.Word);
                answer.text = "The word is " + wordToGuess;
            }

        }
    }

    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
    private fun checkGuess(guess: String) : String {

        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        guesses++;
        return result
    }
}