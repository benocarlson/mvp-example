package edu.byu.cs.mvpexample.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.byu.cs.mvpexample.R;

public class MainActivity extends AppCompatActivity {


    private EditText textInput;
    private TextView lastWord;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textInput = findViewById(R.id.inputText);
        this.lastWord = findViewById(R.id.lastWord);
        this.submitButton = findViewById(R.id.submitButton);
    }
}