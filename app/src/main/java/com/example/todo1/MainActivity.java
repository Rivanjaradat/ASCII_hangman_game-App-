package com.example.todo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText id =(EditText) findViewById(R.id.id);
        EditText fName =(EditText) findViewById(R.id.fName);
        EditText LName=(EditText) findViewById(R.id.lName);

        Button start = (Button) findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                           Intent intent=new Intent(MainActivity.this,Hangman_activity.class);
                    intent.putExtra("playerId", id.getText().toString());
                    intent.putExtra("firstName", fName.getText().toString());
                    intent.putExtra("lastName", LName.getText().toString());
                MainActivity.this.startActivity(intent);
                finish();

            }
        });

    }
}