package com.example.todo1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Hangman_activity extends AppCompatActivity {
    public  static  int counter=0;
    public TextView head, rArm, lArm, body, rLeg, lLeg ,feedback;
    public EditText L1,L2,L3,L4,L5,L6,L7;
    public String firstName,lastName;
    boolean correct;
    public    void shape(){
        switch (counter){
            case 1:

                head.setVisibility(View.VISIBLE);
                break;
            case 2:
                body.setVisibility(View.VISIBLE);
                break;
            case 3:
                rArm  .setVisibility(View.VISIBLE);
                break;
            case 4:
                lArm  .setVisibility(View.VISIBLE);
                break;
            case 5:
                rLeg  .setVisibility(View.VISIBLE);
                break;
            case 6:
                lLeg  .setVisibility(View.VISIBLE);
                break;

        }
    }
    //check the final result for the game
    public void result(int Counter){
        if ((L1.getText().toString()+ L2.getText().toString()+L3.getText().toString()+L4.getText().toString()+L5.getText().toString()+L6.getText().toString()+L7.getText().toString()).equalsIgnoreCase("birzeit")){
            feedback.setText("Congratulations "+ firstName+" "+ lastName+"!"+" You won the game");
        }
        else if (Counter>6||counter==6){
            feedback.setText("  Sorry "+ firstName+" "+ lastName+"!"+ "You lost the game");
        }


    }
    public  void Check_correctness_letters(){
        if (correct){
            feedback.setText("WOW..thats correct");
        }
        else {
            feedback.setText("ohhh..thats Incorrect");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);

        // Get player info from the intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            String playerId = extras.getString("playerId");
            firstName = extras.getString("firstName");
            lastName = extras.getString("lastName");


            TextView playername = findViewById(R.id.playername);
            TextView id=findViewById(R.id.playerId);
            id.setText(playerId);
            playername.setText( firstName +" "+ lastName);
            L1 = findViewById(R.id.L1);
            L2 = findViewById(R.id.L2);
            L3 = findViewById(R.id.L3);
            L4 = findViewById(R.id.L4);
            L5 = findViewById(R.id.L5);
            L6 = findViewById(R.id.L6);
            L7 = findViewById(R.id.L7);

            head=findViewById(R.id.head);
            body = findViewById(R.id.neck);
            rArm = findViewById(R.id.right_arm);
            lArm = findViewById(R.id.left_arm);
            rLeg = findViewById(R.id.right_leg);
            lLeg = findViewById(R.id.left_leg);
            feedback=findViewById(R.id.Feedback);
            Button submit =(Button) findViewById(R.id.button_submit_guess);
            Button restart =(Button) findViewById(R.id.button_restart);

            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    correct = true;

                    // Check if each letter is correct, and increment the counter for wrong guesses only once
                    if (!L1.getText().toString().equalsIgnoreCase("B") && !L1.getText().toString().trim().isEmpty()&&L1.isEnabled()) {
                        correct = false;
                        L1.setEnabled(false);
                        counter++;

                        shape();

                    }
                    if (!L2.getText().toString().equalsIgnoreCase("I") && !L2.getText().toString().trim().isEmpty()&&L2.isEnabled()) {
                        correct = false;
                        L2.setEnabled(false);
                        counter++;

                        shape();
                    }
                    if (!L3.getText().toString().equalsIgnoreCase("R") && !L3.getText().toString().trim().isEmpty()&&L3.isEnabled()) {
                        correct = false;
                        L3.setEnabled(false);
                        counter++;
                        shape();
                    }
                    if (!L4.getText().toString().equalsIgnoreCase("Z") && !L4.getText().toString().trim().isEmpty()&&L4.isEnabled()) {
                        correct = false;
                        L4.setEnabled(false);
                        counter++;

                        shape();
                    }
                    if (!L5.getText().toString().equalsIgnoreCase("E") && !L5.getText().toString().trim().isEmpty()&&L5.isEnabled()) {
                        correct = false;
                        L5.setEnabled(false);
                        counter++;

                        shape();
                    }
                    if (!L6.getText().toString().equalsIgnoreCase("I") && !L6.getText().toString().trim().isEmpty()&&L6.isEnabled()) {
                        correct = false;
                        L6.setEnabled(false);
                        counter++;

                        shape();
                    }
                    if (!L7.getText().toString().equalsIgnoreCase("T") && !L7.getText().toString().trim().isEmpty()&&L7.isEnabled()) {
                        correct = false;
                        L7.setEnabled(false);
                        counter++;

                        shape();
                    }





                    Check_correctness_letters();
                    // Check if the player has won or lost
                    result(counter);
                }
            });


            restart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    L1.setText("");
                    L2.setText("");
                    L3.setText("");
                    L4.setText("");
                    L5.setText("");
                    L6.setText("");
                    L7.setText("");
                    feedback.setText("");
                    head.setVisibility(View.INVISIBLE);
                    body.setVisibility(View.INVISIBLE);
                    rArm.setVisibility(View.INVISIBLE);
                    lArm.setVisibility(View.INVISIBLE);
                    rLeg.setVisibility(View.INVISIBLE);
                    lLeg.setVisibility(View.INVISIBLE);
                    L1.setEnabled(true);
                    L2.setEnabled(true);
                    L3.setEnabled(true);
                    L4.setEnabled(true);
                    L5.setEnabled(true);
                    L6.setEnabled(true);
                    L7.setEnabled(true);
                    counter=0;
                }
            });

        }
    }
}